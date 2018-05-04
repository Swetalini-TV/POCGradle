package assertions;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ChannelAssertions {

    SoftAssert softAssert = new SoftAssert();

    public void assertChannelFoundWithID(HttpResponse response) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    public void assertSearchChannelWithoutID(HttpResponseException response) {
        System.out.println("Expected respnse"+response.getStatusCode());
        softAssert.assertEquals(response.getStatusCode(),400);
    }

    public void assertSearchChannelWithoutIDAndPart(HttpResponseException response) {
        softAssert.assertEquals(response.getStatusCode(),400);
    }

    public void assertSearchChannelWithoutKey(HttpResponseException response) {
        softAssert.assertEquals(response.getStatusCode(),400);
    }
}
