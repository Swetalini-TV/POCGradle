package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utilities {
    public static final String readStringFromInputStream(InputStream inputStream) throws IOException {
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

}
