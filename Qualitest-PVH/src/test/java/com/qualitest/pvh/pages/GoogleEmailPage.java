package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://mail.google.com/mail/#inbox")
public class GoogleEmailPage extends BasePage {
	
	@FindBy(css = "span.bog")
	private List<WebElement> emailAuthors;
	
	@FindBy(xpath = "//*[@class = 'AO']/div/div/div/div/div[3]/div/div/table/tbody/tr")
	private List<WebElement> emails;
	
	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[2]/div[3]")
	private BaseElement delete;
	
	@FindBy(xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div[1]/div/div[1]/div")
	private BaseElement goBack;
	
	@FindBy(xpath = "//a[contains(text(),'Click')]")
	private BaseElement clickHere;
	
	@FindBy(xpath = "//*[@class = 'T-I J-J5-Ji T-Pm T-I-ax7 L3 J-JN-M-I']")
	private BaseElement selectAllEmails;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(GoogleEmailPage.class);
	
	public String getFirstEmailAuthor() {
		String text = emailAuthors.get(1).getText();
		LOGGER.info("First Email Author: "+text);
		return text;
	}
	
	public void clickFirstEmail() {
		LOGGER.info("Clicking on the first email");
		emails.get(0).click();
	}
	
	public void clickDelete() {
		LOGGER.info("Clicking the delete button");
		delete.click();
	}
	
	public void clickGoBack() {
		LOGGER.info("clicking go back button on email page");
		goBack.click();
	}
	
	public void clickClickHere() {
		LOGGER.info("clicking the click here button");
		clickHere.click();
	}
	
	public void clickSelectAllEmails() {
		LOGGER.info("clicking select all emails");
		selectAllEmails.click();
	}
	public void deleteAllEmails() {
		clickSelectAllEmails();
		clickDelete();
	}

}
