package tests.smokeTests;

import DBClient.dbReader;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import factory.URLFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestYoutubeSearchAPI {
    private static final String ENCODED_URL = "https://www.googleapis.com/youtube/v3/search";
    private static final String API_KEY = dbReader.getKey();
    private static GenericUrl url;
    private URLFactory urlFactory;
    private HttpTransport httpTransport;
    private JsonFactory jsonFactory;
    private HttpRequestFactory requestFactory;
    private HttpRequest request;
    private HttpResponse response;

    public TestYoutubeSearchAPI() {
        urlFactory = new URLFactory(ENCODED_URL);
        httpTransport = new NetHttpTransport();
        jsonFactory = new JacksonFactory();
        requestFactory =
                httpTransport.createRequestFactory(new HttpRequestInitializer() {

                    public void initialize(HttpRequest request) {
                        request.setParser(new JsonObjectParser(jsonFactory));
                    }
                });
    }

    @Test
    public void testSearchWithGivenQuery() throws IOException {
        url = urlFactory.getURL();
        url.put("key", API_KEY);
        url.put("part", "snippet");
        url.put("type", "video");
        url.put("maxResults", "10");
        url.put("q", "dogs");
        request = requestFactory.buildGetRequest(url);
        response = request.execute();
        Assert.assertEquals(response.getStatusCode(), 200);

    }
}
