package tests.smokeTests;

import DBClient.dbReader;
import clients.Client;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestYoutubeSearchAPI {

    @Test
    public void testSearchWithGivenQuery() throws IOException {

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
                .matches("$.items[0].snippet.title", "Cutes dogs | Cutest dog in the world | Cute dogs clips 2016");
    }
}
