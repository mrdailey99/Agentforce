package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="CoralCloudSite"                                
     , summary=""
     , relativeUrl=""
     , connection="CoralCommunityUser"
     )             
public class CoralCloudSite {

	@TextType()
	@FindBy(xpath = "//div[@id='embeddedMessagingIconContainer']")
	public WebElement AgentChat;
			
}
