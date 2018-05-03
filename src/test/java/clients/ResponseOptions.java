package clients;

import com.google.api.client.http.HttpResponse;
import com.jayway.jsonpath.JsonPath;
import org.testng.Assert;

import java.io.*;

public class ResponseOptions {
    private HttpResponse response;
    private String responseBody;

    private String getResponseAsString(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String contentString = "";
        while (true) {
            String line = br.readLine();
            if (line != null)
                contentString = contentString + line;
            else
                break;
        }
        return contentString;
    }

    public ResponseOptions(HttpResponse response) throws IOException {
        this.response = response;
        this.responseBody = getResponseAsString(response.getContent());
    }

    public ResponseOptions statusCode(int expectedCode) {
        Assert.assertEquals(response.getStatusCode(), expectedCode);
        return this;
    }

    public ResponseOptions matches(String jsonPath, String expectedValue) throws IOException {
        String actualValue = JsonPath.parse(responseBody).read(jsonPath);
        Assert.assertEquals(actualValue, expectedValue);
        return this;
    }

    public ResponseOptions matches(String jsonPath, int expectedValue) throws IOException {
        int actualValue = JsonPath.parse(responseBody).read(jsonPath);
        Assert.assertEquals(actualValue, expectedValue);
        return this;
    }

}
