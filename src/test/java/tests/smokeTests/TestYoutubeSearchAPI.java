package tests.smokeTests;

import DBClient.dbReader;
import clients.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestYoutubeSearchAPI {
    private static final String ENCODED_URL = "https://www.googleapis.com/youtube/v3/search";
    private static final String API_KEY = dbReader.getKey();
    private Map<String, String> params;
    private Client client;

    @Test
    public void testSearchWithGivenQuery() throws IOException {
        client = new Client(ENCODED_URL);
        params = new HashMap<>();
        params.put("key", API_KEY);
        params.put("part", "snippet");
        params.put("q", "dogs");
        params.put("type", "video");
        params.put("maxResults", "10");

        client.setRequestParameters(params);
        client.buildGetRequest();
        client.executeRequest();
        Assert.assertEquals(client.getStatusCode(), 200);

    }
}
