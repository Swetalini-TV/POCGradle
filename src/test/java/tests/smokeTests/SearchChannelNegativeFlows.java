package tests.smokeTests;

import assertions.ChannelAssertions;
import com.google.api.client.http.HttpResponseException;
import helpers.ChannelHelper;
import org.testng.annotations.Test;

public class SearchChannelNegativeFlows {

    @Test(groups = { "userJourneys"})
    public void channelNegativeFlows() {
        ChannelHelper channelHelp = new ChannelHelper();
        ChannelAssertions channelAssert = new ChannelAssertions();
        HttpResponseException res = channelHelp.searchChannelWithoutID();
        channelAssert.assertSearchChannelWithoutID(res);
        channelAssert.assertSearchChannelWithoutIDAndPart(channelHelp.searchChannelWithoutIDAndPart());
        channelAssert.assertSearchChannelWithoutKey(channelHelp.searchChannelWithoutKey());
    }
}
