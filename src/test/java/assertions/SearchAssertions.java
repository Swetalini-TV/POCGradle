package assertions;

import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchAssertions {
    SoftAssert softAssert = new SoftAssert();

    public void assertSearchYoutubeWithPart(HttpResponse response) {
        softAssert.assertEquals(response.getStatusCode(), 200);
    }

    public void assertSearchYoutubeWithPartAndType(HttpResponse response) {
        softAssert.assertEquals(response.getStatusCode(), 200);
    }

    public void assertSearchYoutubeWithPartAndQuery(HttpResponse response) {
        softAssert.assertEquals(response.getStatusCode(), 200);
    }

    public void assertSearchYoutubeWithoutAPIKey(HttpResponseException response) {
        softAssert.assertEquals(response.getStatusCode(), 400);
    }

    public void assertSearchYoutubeWithoutPart(HttpResponseException response) {
        softAssert.assertEquals(response.getStatusCode(), 400);
    }
}
