package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THCartPage extends CartPage{
	
	@FindBy(xpath = "//*[@id = 'promotion_1']")
	private BaseElement removePromotion;
	
	private SoftAssertions SA = new SoftAssertions();
	

	@FindBy (xpath = "//*[@id='mini_cart_link']/span")
	private BaseElement ItemsInBag;
	
	public int getNumItemsInBag()
	{
		return Integer.parseInt(ItemsInBag.getText());
	}
	protected String modString(String s) {
		s = s.replaceAll("\\s", "");
		s = s.replace("$", "");
		s = s.replace("-", "");
		LOGGER.info("Returning a modded string of: "+s);
		return s;
	}
	
	public void verifyFirstSize(String size) {
		getDriver().navigate().refresh();
		String pageSize = getFirstSize();
		if(pageSize.equalsIgnoreCase("os")) {
			assertThat(pageSize).as("First Cart Item size").isEqualToIgnoringCase(size);
		}
		else if(pageSize.contains("/")) {
			String[] pageArr = pageSize.split("/");
			String[] savedArr = size.split("/");
			SA.assertThat(pageArr[0]).as("first size").isEqualToIgnoringCase(savedArr[0]);
			SA.assertThat(pageArr[1]).as("second size").isEqualToIgnoringCase(savedArr[1]);
			SA.assertAll();
		}else {
			assertThat(pageSize).as("First Cart item size").isEqualToIgnoringCase(size);
		}
	}
	private String getFirstDiscountedAmount() {
		String s = discountedAmount.get(0).getText();
		LOGGER.info("Returning the first discounted price of: "+s);
		return s;
	}

	private String getTotalPriceOfFinals(double discount) {
		double ret = 0.0;
		for(WebElement w: priceFinal) {
			String price = modString(w.getText());
			double priceDouble = Double.parseDouble(price);
			ret += priceDouble;
		}
		DecimalFormat df = new DecimalFormat(".##");
		ret = ret*discount;
		String s = df.format(ret);
		LOGGER.info("Returning a final price total of: "+s);
		String d = s.substring(s.indexOf('.')+1);
		if(d.equals("0")) {
			s = s+"0";
		}
		return s;
	}
	
	private void clickRemovePromotion() {
		LOGGER.info("Clicking the removal of promotion");
		removePromotion.click();
		try
		{
		    Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	public void verifyRemovalOfPromotion() {
		SA.assertThat(discountedAmount.size()).isGreaterThan(0);
		clickRemovePromotion();
		SA.assertThat(discountedAmount.size()).isEqualTo(0);
		SA.assertAll();
	}
	
	
	private String getTotalDiscountedMoney() {
		double ret = 0.0;
		for(WebElement w: discountedAmount) {
			String price = modString(w.getText());
			double priceDouble = Double.parseDouble(price);
			ret += priceDouble;
		}
		DecimalFormat df = new DecimalFormat(".##");
		String s = df.format(ret);
		LOGGER.info("Returning a discounted total of: "+s);
		String d = s.substring(s.indexOf('.')+1);
		if(d.equals("0")) {
			s = s+"0";
		}
		return s;
	}
	
	public void verifyPromoAppliedForMultiple(String code) {
		for(WebElement w: listOfItems) {
			LOGGER.debug("Verifying: "+w.getText()+" and "+code +" are valid");
		}
		if(code.equalsIgnoreCase("EXTRAEXTRA")) {
			String discount = getTotalDiscountedMoney();
			String price = getTotalPriceOfFinals(.3);
			
			assertThat(discount).as("Discounted Price").isEqualTo(price);
		}
		
	}
	
	public void verifyPromoApplied(String code) {
		String topItemName = getNameOfProduct(0);
		LOGGER.debug("Verifying: "+topItemName+" and "+code +" are valid");
		if(code.equalsIgnoreCase("EXTRAEXTRA")) {
			String price = modString(getFirstPriceFinal());
			double priceDouble = Double.parseDouble(price);
			String discount = modString(getFirstDiscountedAmount());
			double answer = priceDouble*(.3);
			DecimalFormat df = new DecimalFormat(".##");
			String check = df.format(answer);
			LOGGER.info("The discount that was displayed was: "+check);
			String s = check.substring(check.indexOf('.')+1);
			if(s.equals("0")) {
				check = check+"0";
			}
			assertThat(discount).as("Discounted Price").isEqualTo(check);
		}
	}
}
