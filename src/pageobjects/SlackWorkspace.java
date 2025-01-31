package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="SlackWorkspace"                                
     , summary=""
     , relativeUrl=""
     , connection="Slack"
     )             
public class SlackWorkspace {

	@ButtonType()
	@FindBy(xpath = "//button[@id='agents']/span/div/div")
	public WebElement agentforceIcon;
	@ButtonType()
	@FindBy(xpath = "//div[@id='U089U78JL8J']/div/button")
	public WebElement coralCloudServiceAgent;
	@TextType()
	@FindBy(css = "div.ql-editor.ql-blank p")
	public WebElement chatBox;
	@TextType()
	@FindBy(xpath = ".//div[contains(@class,'p-mrkdwn_element') and contains(normalize-space(.),'Sofia')]/span")
	public WebElement AgentMemberLookupResponse;
	@TextType()
	@FindBy(xpath = "//span[@data-qa='bk_markdown_element' and contains(normalize-space(.), 'Could you please provide your email address and membership number?')]")
	public WebElement AgentMemberInquiryResponse;
	@TextType()
	@FindBy(xpath = "//span[@data-qa='bk_markdown_element' and contains(normalize-space(.),'which experience')]")
	public WebElement AgentExperienceInquiry;
	@TextType()
	@FindBy(xpath = "//span[@data-qa='bk_markdown_element' and contains(normalize-space(.),'Canyon Zip Line')]")
	public WebElement AgentExperiencesListResponse;
	@TextType()
	@FindBy(xpath = "//span[@data-qa='bk_markdown_element' and contains(normalize-space(.),'How many guests')]")
	public WebElement AgentExperienceGuestPrompt;
			
}
