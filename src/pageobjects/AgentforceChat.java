package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="AgentforceChat"                                
     , summary=""
     , relativeUrl=""
     , connection="CoralCommunityUser"
     )             
public class AgentforceChat {

	@PageFrame()
	public static class Frame {

		@TextType()
		@FindBy(xpath = "//span[normalize-space(.)=concat('Hi, I',\"'\",'m an AI service assistant. How can I help you?')]")
		public WebElement AgentResponse;
	}

	@FindBy(xpath = "//iframe[contains(@id,'embeddedMessagingFrame')]")
	public Frame frame;
	@TextType()
	@FindBy(xpath = "//input[@id='domain']")
	public WebElement enterYourWorkspaceSSlackURL;
			
}
