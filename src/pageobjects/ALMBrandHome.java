package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="ALMBrandHome"                                
     , summary=""
     , relativeUrl=""
     , connection="ALM_Brand"
     )             
public class ALMBrandHome {

	@TextType()
	@FindBy(xpath = "//div[1]/div/div/div/div/picture/img")
	public WebElement Banner;
			
}
