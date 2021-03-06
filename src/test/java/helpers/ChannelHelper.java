package helpers;

import clients.ChannelClient;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;

public class ChannelHelper {

    ChannelClient client;

    public ChannelHelper() {
        client = new ChannelClient();
    }

    public HttpResponse searchChannelWithID(String part, String Channel_ID) {
        client.url.put("part", part);
        client.url.put("id", Channel_ID);
        client.buildRequest(client.url);
        return client.getResponse();
    }

    public HttpResponseException searchChannelWithoutIDAndPart() {
        client.buildRequest(client.url);
        return client.getResponseException();

    }

    public HttpResponseException searchChannelWithoutID() {
        client.buildRequest(client.url);
        return client.getResponseException();
    }

    public HttpResponseException searchChannelWithoutKey() {
        client.url.set("key", "garbage");
        client.buildRequest(client.url);
        return client.getResponseException();
    }

}
