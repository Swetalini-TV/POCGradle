package clients;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

public class RequestBuilder {
    private GenericUrl url;
    private HttpRequestFactory requestFactory;
    private HttpRequest request;

    private HttpRequestFactory getRequestFactory() {
        HttpTransport httpTransport = new NetHttpTransport();
        JsonFactory jsonFactory = new JacksonFactory();
        return httpTransport.createRequestFactory(request -> request.setParser(new JsonObjectParser(jsonFactory)));
    }

    public RequestBuilder given(String url) {
        this.url = new GenericUrl(url);
        return this;
    }

    public RequestBuilder withParam(String key, String value) {
        url.put(key, value);
        return this;
    }

    public RequestBuilder get() throws IOException {
        requestFactory = getRequestFactory();
        request = requestFactory.buildGetRequest(url);
        return this;
    }

    public ResponseOptions then() throws IOException {
        return new ResponseOptions(request.execute());
    }
}
