package tests.smokeTests;

import DBClient.dbReader;
import clients.Client;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestYoutubeAPIs {

    @Test
    public void testSearchAPIWithGivenQuery() throws IOException {

        String searchUrl = "https://www.googleapis.com/youtube/v3/search";
        String API_KEY = dbReader.getKey();

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
        String channelUrl = "https://www.googleapis.com/youtube/v3/channels";
        String API_KEY = dbReader.getKey();

        Client.when()
                .given(channelUrl)
                .withParam("key", API_KEY)
                .withParam("part", "id, snippet,statistics")
                .withParam("id","UCV-oV8yecSfMZnzdKAhO_4A")
                .get()
                .then()
                .statusCode(200)
                .matches("$.items[0].snippet.title","Interesting Facts")
                .matches("$.items[0].statistics.viewCount","267490408");
    }
}
