package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CKOrderSummaryPage extends OrderSummaryPage{
	@FindBy(xpath = "//*[@id=\"shoppingBagColumn2\"]/div[4]")
	private BaseElement cancellationField;

	
}
