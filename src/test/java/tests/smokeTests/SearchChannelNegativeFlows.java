package tests.smokeTests;

import assertions.ChannelAssertions;
import com.google.api.client.http.HttpResponseException;
import helpers.ChannelHelper;
import org.testng.annotations.Test;

public class SearchChannelNegativeFlows {

    @Test
    public void channelNegativeFlows() {
        ChannelHelper channelHelp = new ChannelHelper();
        ChannelAssertions channelAssert = new ChannelAssertions();
        HttpResponseException res = channelHelp.searchChannelWithoutID();
        if(res != null)
        {
            System.out.println(res.getStatusCode());
        }
        channelAssert.assertSearchChannelWithoutID(res);
        channelAssert.assertSearchChannelWithoutIDAndPart(channelHelp.searchChannelWithoutIDAndPart());
        channelAssert.assertSearchChannelWithoutKey(channelHelp.searchChannelWithoutKey());
    }
}
