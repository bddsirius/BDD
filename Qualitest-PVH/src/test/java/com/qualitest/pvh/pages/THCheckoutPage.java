package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THCheckoutPage extends CheckoutPage{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THCheckoutPage.class);
	
	@FindBy(xpath = "//*[@id=\"contentWrapper\"]/h1")
	private BaseElement titleOfCheckOutPage;
	
	private String getTitleOfCheckOutPage() {
		String s = titleOfCheckOutPage.getText();
		LOGGER.info("Getting the title of the checkout page as: "+s);
		return s;
	}
	
	public void verifyTitleOfCheckOutPage() {
		assertThat(getTitleOfCheckOutPage()).as("Title of checkout page").isEqualTo("CHECKOUT");
	}
	 
	
}
