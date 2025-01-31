package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="SlackSignIn"                                
     , summary=""
     , relativeUrl=""
     , connection="Slack"
     )             
public class SlackSignIn {

	@TextType()
	@FindBy(xpath = "//input[@id='domain']")
	public WebElement enterYourWorkspaceSSlackURL;
	@TextType()
	@FindBy(xpath = "//input[@id='signup_email']")
	public WebElement enterYourEmailAddress;
			
}
