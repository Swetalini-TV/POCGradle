package factory;


import com.google.api.client.http.GenericUrl;

public class URLFactory extends GenericUrl {

    public static GenericUrl url;

    public URLFactory(String rawUrl) {
        initialize(rawUrl);
    }

    private void initialize(String rawUrl) {
        if (url == null) {
            url = new GenericUrl(rawUrl);
        }
    }

    public GenericUrl getURL() {
        return url;
    }

    public void destroyURL() {
        url.clear();
        url = null;
    }
}