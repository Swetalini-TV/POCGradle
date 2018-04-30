package assertions;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import org.testng.Assert;

public class ChannelAssertions {

    public void assertChannelFoundWithID(HttpResponse response) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    public void assertSearchChannelWithoutID(HttpResponseException response) {
        System.out.println("Expected respnse"+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(),400);
    }

    public void assertSearchChannelWithoutIDAndPart(HttpResponseException response) {
        Assert.assertEquals(response.getStatusCode(),400);
    }

    public void assertSearchChannelWithoutKey(HttpResponseException response) {
        Assert.assertEquals(response.getStatusCode(),400);
    }
}
