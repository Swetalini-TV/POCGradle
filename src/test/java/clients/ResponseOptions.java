package clients;

import com.google.api.client.http.HttpResponse;
import com.jayway.jsonpath.JsonPath;
import org.testng.Assert;

import java.io.*;

public class ResponseOptions {
    private HttpResponse response;

    public ResponseOptions(HttpResponse response) throws IOException {
        this.response = response;
    }

    public ResponseOptions statusCode(int expectedCode) {
        Assert.assertEquals(response.getStatusCode(), expectedCode);
        return this;
    }

    public ResponseOptions matches(String jsonPath, String expectedValue) throws IOException {
        String actualValue = JsonPath.parse(response.getContent()).read(jsonPath);
        Assert.assertEquals(actualValue, expectedValue);
        return this;
    }

}
