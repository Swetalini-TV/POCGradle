package clients;

import com.google.api.client.http.HttpResponse;
import org.testng.Assert;

public class ResponseOptions {
    private HttpResponse response;

    public ResponseOptions(HttpResponse response) {
        this.response = response;
    }

    public ResponseOptions statusCode(int expectedCode) {
        Assert.assertEquals(response.getStatusCode(),expectedCode);
        return this;
    }
}
