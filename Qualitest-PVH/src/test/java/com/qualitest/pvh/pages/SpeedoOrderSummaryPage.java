package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoOrderSummaryPage extends OrderSummaryPage{

	@FindBy(xpath = "//*[@id=\"siteMessageBarWrapper\"]/div[1]/a[2]")
	private BaseElement myAccount;
	
	@FindBy(xpath = "//*[@id=\"orderCancelMessage\"]/a")
	private BaseElement cancelOrder;

	@FindBy(xpath = "//*[@id=\"shoppingBagColumn2\"]/div[4]")
	private BaseElement cancellationField;
	
	@FindBy(xpath = "//*[@id='orderCancelSection']/div/a[1]")
	private BaseElement agreeToCancel;
	
	public void clickMyAccount() {
		myAccount.click();
	}
	public void clickCancelOrder() {
		cancelOrder.click();
	}
	
	@Override
	public void verifyCancellation()
	{
		cancelOrder.click();
		agreeToCancel.click();
		SA.assertThat(cancellationField.getText().toUpperCase().contains("THE ORDER HAS BEEN CANCELED SUCCESSFULLY")).isTrue();
		SA.assertAll();
	}
	
}
