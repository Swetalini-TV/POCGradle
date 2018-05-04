package assertions;

import com.google.api.client.http.HttpResponse;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ThreadAssertions {

    SoftAssert softAssert = new SoftAssert();

    public void assertAllThreadsFoundForChannelID(HttpResponse response) {
        softAssert.assertEquals(200, response.getStatusCode());
    }
}
