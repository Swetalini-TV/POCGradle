package clients;

import com.google.api.client.http.HttpResponse;
import com.jayway.jsonpath.JsonPath;
import org.testng.Assert;

import java.io.*;

public class ResponseOptions {
    private HttpResponse response;
    private String responseBody;

    private String readStringFromInputStream(InputStream inputStream) throws IOException {
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
        this.responseBody = readStringFromInputStream(response.getContent());
    }

    public ResponseOptions statusCode(int expectedCode) {
        Assert.assertEquals(response.getStatusCode(), expectedCode);
        return this;
    }

    public <T> ResponseOptions matches(String jsonPath, T expectedValue) throws IOException {
        T actualValue = JsonPath.parse(responseBody).read(jsonPath);
        Assert.assertEquals(actualValue, expectedValue);
        return this;
    }

    public RequestBuilder buildNewRequest() {
        return new RequestBuilder(responseBody);
    }
}
