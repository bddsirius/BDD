package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.google.com/gmail/about/#")
public class GMailHomePage extends BasePage{
	
	@FindBy(xpath = "//*[@class = 'gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
	private BaseElement signIn;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(GMailHomePage.class);
	
	public void clickSignIn() {
		signIn.click();
	}
	
	
}
