package clients;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import factory.URLFactory;

import java.io.IOException;
import java.util.Map;

public class Client {
    private static GenericUrl genericUrl;
    private JsonFactory jsonFactory;
    private HttpTransport httpTransport;
    private HttpRequestFactory requestFactory;
    private HttpRequest request;
    private HttpResponse response;

    public Client(String url) {
        URLFactory urlFactory = new URLFactory(url);
        genericUrl = urlFactory.getURL();
        httpTransport = new NetHttpTransport();
        jsonFactory = new JacksonFactory();
        requestFactory =
                getRequestFactory();
    }

    private HttpRequestFactory getRequestFactory() {
        return httpTransport.createRequestFactory(new HttpRequestInitializer() {

            public void initialize(HttpRequest request) {
                request.setParser(new JsonObjectParser(jsonFactory));
            }
        });
    }

    public void setRequestParameters(Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            genericUrl.put(entry.getKey(), entry.getValue());
        }
    }

    public void buildGetRequest() throws IOException {
        request = requestFactory.buildGetRequest(genericUrl);
    }

    public void executeRequest() throws IOException {
        response = request.execute();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }
}
