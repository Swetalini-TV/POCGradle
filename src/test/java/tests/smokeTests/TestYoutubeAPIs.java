package tests.smokeTests;

import DBClient.dbReader;
import clients.Client;
import org.testng.annotations.Test;
import utils.PropertyFileReader;

import java.io.IOException;

public class TestYoutubeAPIs {
    private String searchUrl = "";
    private String channelUrl = "";
    private String API_KEY = "";

    public TestYoutubeAPIs() {
        PropertyFileReader propertyFileReader = new PropertyFileReader();
        this.searchUrl = propertyFileReader.getSearchAPI();
        this.channelUrl = propertyFileReader.getChannelAPI();
        this.API_KEY = dbReader.getKey();
    }

    @Test
    public void testSearchAPIWithGivenQuery() throws IOException {

        Client.when()
                .given(searchUrl)
                .withParam("key", API_KEY)
                .withParam("part", "snippet")
                .withParam("q", "dogs")
                .withParam("type", "video")
                .withParam("maxResults", "10")
                .get()
                .then()
                .statusCode(200)
                .matches("$.items[0].snippet.title", "Cutes dogs | Cutest dog in the world | Cute dogs clips 2016")
                .matches("$.items[0].snippet.thumbnails.default.width", 120);
    }

    @Test
    public void testChannelsAPIWithGivenQuery() throws IOException {

        Client.when()
                .given(channelUrl)
                .withParam("key", API_KEY)
                .withParam("part", "id, snippet,statistics")
                .withParam("id", "UCV-oV8yecSfMZnzdKAhO_4A")
                .get()
                .then()
                .statusCode(200)
                .matches("$.items[0].snippet.title", "Interesting Facts")
                .matches("$.items[0].statistics.viewCount", "267579041");
    }

    @Test
    public void testSearchAndChannelAPIChaining() throws IOException {

        Client.when()
                .given(searchUrl)
                .withParam("key", API_KEY)
                .withParam("part", "snippet")
                .withParam("q", "dogs")
                .withParam("type", "video")
                .withParam("maxResults", "5")
                .get()
                .then()
                .statusCode(200)
                .buildNewRequest()
                .given(channelUrl)
                .withExtractedParam("id", "$.items[3].snippet.channelId")
                .withParam("key", API_KEY)
                .withParam("part", "id, snippet,statistics")
                .get()
                .then()
                .statusCode(200)
                .matches("$.items[0].snippet.title", "Interesting Facts");
    }
}
