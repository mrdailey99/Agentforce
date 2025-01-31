package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.provar.core.testapi.annotations.ButtonType;
import com.provar.core.testapi.annotations.Page;
import com.provar.core.testapi.annotations.PageFrame;
import com.provar.core.testapi.annotations.PageWait;
import com.provar.core.testapi.annotations.PageWaitAfter;
import com.provar.core.testapi.annotations.TextType;

@Page( title="ChatAgent"                                
     , summary=""
     , relativeUrl=""
     , connection="CoralCloud"
     )             
public class ChatAgent {

public WebDriver driver;

	public ChatAgent(WebDriver driver) {
		this.driver = driver;
	}

	public String overCapacity(String value){
	int add1 = (int) Double.parseDouble(value)+1;

	//int result = Integer.parseInt(value)+1;
	//Integer.toString(x+y)
	
	return Integer.toString(add1);		
	}
	
	public String newCapacity(String priorCapacity, String guests){
	double currentCapacity = Double.valueOf(priorCapacity) - Double.valueOf(guests);
	

	//Integer.toString(x+y)
	
	return Double.toString(currentCapacity);		
	}
	
		public String test2(String priorCapacity, String guests){
	double currentCapacity = Double.valueOf(priorCapacity) - Double.valueOf(guests);
	

	//Integer.toString(x+y)
	
	return Double.toString(currentCapacity);		
	}

	@PageFrame()
	public static class Frame {

		@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
		@PageWait.BackgroundActivity(timeoutSeconds = 60)
		@TextType()
		@FindBy(xpath = "//span[normalize-space(.)=concat('Hi, I',\"'\",'m an AI service assistant. How can I help you?')]")
		public WebElement IntroChat;
		@PageWait.BackgroundActivity(timeoutSeconds = 60)
		@PageWaitAfter.Timed(durationSeconds = 5)
		@TextType()
		@FindBy(xpath = "//textarea")
		public WebElement typeYourMessage;
		@PageWaitAfter.BackgroundActivity(timeoutSeconds = 60)
		@TextType()
		@PageWait.Field(timeoutSeconds = 60)
		@FindBy(xpath = "//embeddedmessaging-conversation-entry-item[last()]//div[@class='slds-chat-message__text_inbound embedded-messaging-inbound-chat-message']//span")
		public WebElement LatestResponse;
		@ButtonType()
		@FindBy(xpath = "//button[normalize-space(.)='Open messaging menu']")
		public WebElement openMessagingMenu;
		@ButtonType()
		@FindBy(xpath = "//button[normalize-space(.)='End conversation']")
		public WebElement endConversation;
		@ButtonType()
		@FindBy(xpath = "//button[normalize-space(.)='Close the message window']")
		public WebElement closeTheMessageWindow;
	}

	@FindBy(xpath = "//iframe[contains(@id,'embeddedMessagingFrame')]")
	public Frame frame;
	@PageWait.BackgroundActivity(timeoutSeconds = 60)
	@PageWaitAfter.Timed(durationSeconds = 5)
	@TextType()
	@FindBy(xpath = "//div[@id='embeddedMessagingIconContainer']")
	public WebElement StartChat;
	@TextType()
	@FindBy(xpath = "//div/div/div/div/div[normalize-space(.)='Welcome to Coral Cloud Resort, your ultimate tropical escape nestled in the heart of paradise.']")
	public WebElement Image;
			
}
