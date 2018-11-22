package com.qualitest.pvh.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THRegisterAtCheckOutPage extends BasePage{

	private static final Logger LOGGER = LoggerFactory.getLogger(THRegisterAtCheckOutPage.class); 
	
	@FindBy(id = "WC_ShoppingCartAddressEntryFormemailnewletter_default")
	private BaseElement termsAgreement;
	
	@FindBy(id = "WC_GuestUserRegForm_FormInput_email1_In_Register_1")
	private BaseElement emailInput;
	
	@FindBy(id = "WC_GuestUserRegForm_FormInput_logonPassword_In_Register_1")
	private BaseElement passwordInput;
	
	@FindBy(id = "WC_GuestUserRegForm_FormInput_logonPasswordVerify_In_Register_1")
	private BaseElement confirmInput;
	
	@FindBy(id = "WC_GuestUserRegForm_links_1")
	private BaseElement registerButton;
	
	@FindBy(id = "close")
	private BaseElement closeRatingPopUp;
	
	@FindBy(xpath = "//*[@id=\"poll\"]/div[8]/div/div/span/a")
	private BaseElement cancelRatingPopUp;
	
	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]")
	private BaseElement closeCommentBox;
	
	public void enterEmail(String email) {
		LOGGER.info("Entering email: "+email);
		emailInput.type(email);
	}
	public void enterPassword(String password) {
		LOGGER.info("Entering password: "+password);
		passwordInput.type(password);
	}
	public void enterConfirm(String password) {
		LOGGER.info("Entering confirm: "+password);
		confirmInput.type(password);
	}
	public void clickRegister() {
		LOGGER.info("Clicking register");
		registerButton.click();
	}
	public void clickTerms() {
		LOGGER.info("Clicking the terms and conditions");
		termsAgreement.click();
	}
	public void clickCloseRatingPopUp() {
		LOGGER.info("Trying to click the rating pop up");
//		getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
//		getDriver().switchTo().frame(19);
		
		 WebDriverWait wait = new WebDriverWait(getDriver(),30);
		 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@src='https://d6tizftlrpuof.cloudfront.net/live/i/5a67a3106d9fd106d13131a5/04abea47d0c2b783d3ba71f6fc2c93f44b285e37.html?tags=right']")));
		  
		closeRatingPopUp.withTimeoutOf(15, TimeUnit.SECONDS).click();
	}
	public void clickCloseCommentBox() {
		LOGGER.info("Trying to click the review comment box");

		 //WebDriverWait wait = new WebDriverWait(getDriver(),10);
		 //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("easyXDM_TurnTo_ttXDM_default7935_provider")));
		
		List<WebElement> frameList = getDriver().findElements(By.tagName("iframe"));
		LOGGER.info("Total Frames found: " + frameList.size());
		for(WebElement frame: frameList) {
			LOGGER.info("Switching to frame: " + frame.getAttribute("id"));
			try {
				getDriver().switchTo().frame(frame);
				try {
					closeCommentBox.withTimeoutOf(10, TimeUnit.SECONDS).click();
				} catch(Exception e) {
					LOGGER.info("Close comment box link is not found");
					continue;
				}
			} catch(Exception e) {
				LOGGER.info("Comment box frame is not found");
				continue;
			}
		}
		
		//closeCommentBox.withTimeoutOf(10, TimeUnit.SECONDS).click();
		//getDriver().switchTo().alert().dismiss();
		//closeCommentBox.click();		
	}
	public void clickCancelRatingPopUp() {
		LOGGER.info("Trying to cancel ratings pop up");
		try {
			//getDriver().switchTo().alert().dismiss();
			cancelRatingPopUp.withTimeoutOf(10, TimeUnit.SECONDS).click();
		}catch(Exception e) {
			LOGGER.info("Rating Box not found");
		}
	}
	public void registerAtCheckOut(String password) {
		LOGGER.info("Filling out fields and submitting account");
		clickCloseRatingPopUp();
		//clickCancelRatingPopUp();
		clickCloseCommentBox();
		enterPassword(password);
		enterConfirm(password);
		clickTerms();
		clickRegister();
	}
	
	public void switchingFrames() {
		for (String handle : getDriver().getWindowHandles()) {	 
			LOGGER.info("The number of windows is: "+ getDriver().getWindowHandles().size());
			LOGGER.info("Window Handling: "+handle );
			getDriver().switchTo().window(handle);
			if(closeRatingPopUp.exists()) {
				clickCloseRatingPopUp();
			}
		}
		
	}
	
	
}
