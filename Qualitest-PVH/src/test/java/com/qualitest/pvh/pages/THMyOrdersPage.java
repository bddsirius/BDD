package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THMyOrdersPage extends MyOrdersPage {

	@FindBy(id = "OrderStatusDetailsDisplayExt_accordionControlLink_1")
	private BaseElement firstDropDown;
	
	
	@FindBy(id = "WC_MyAccountSidebarDisplayf_links_2")
	private BaseElement myOrdersLink;
	
	@FindBy(xpath = "//*[@id='footerTop']/div/div[1]/a[2]")
	private BaseElement trackOrderFooter;

	@Override
	public void clickGuestOrderStatus()
	{
		if(myOrdersLink.exists())
		{
			myOrdersLink.click();	
		}
		else
		{
			trackOrderFooter.click();	
		}
		
	}

}
