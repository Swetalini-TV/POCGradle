package tests.smokeTests;

import DBClient.dbReader;
import clients.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestYoutubeSearchAPI {

    @Test
    public void testSearchWithGivenQuery() throws IOException {

        String searchUrl = "https://www.googleapis.com/youtube/v3/search";
        String API_KEY = dbReader.getKey();
        Map<String, String> params = new HashMap<>();
        params.put("key", API_KEY);
        params.put("part", "snippet");
        params.put("q", "dogs");
        params.put("type", "video");
        params.put("maxResults", "10");

        Client client = new Client(searchUrl);

        client.setRequestParameters(params);
        client.buildGetRequest();
        client.executeRequest();

        Assert.assertEquals(client.getStatusCode(), 200);
    }
}
