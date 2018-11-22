package com.qualitest.pvh.pages;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

public class MyOrdersPage extends BasePage {
	public static final Logger LOGGER = LoggerFactory.getLogger(MyOrdersPage.class);
	
	@FindBy(xpath = "//*[@id='onlineOrdersPanel']/div/div/div")
	private List<WebElement> orderItems;
	
	@FindBy(id = "OrderStatusDetailsDisplayExt_accordionControlLink_1")
	private BaseElement firstDropDown;
	
	
	@FindBy(id = "WC_MyAccountSidebarDisplayf_links_2")
	private BaseElement myOrdersLink;
	
	@FindBy(id = "continueButton")
	private BaseElement contButton;
	
	@FindBy(xpath = "//*[@id='continueButton']/a")
	private BaseElement contButton2;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[1]/ul/li[2]/a")
	private BaseElement trackOrderFooter;

	@FindBy(id = "orderId")
	private BaseElement orderNumberBox;

	@FindBy(id = "emailAddress")
	private BaseElement emailAddBox;

	@FindBy(id = "orderNumber_1")
	private BaseElement orderNumber;
	
	@FindBy(id = "OrderStatusDetailsDisplayExt_option_1")
	private BaseElement orderStatus;
	
	@FindBy(id="onlineOrdersPanel")
	public BaseElement orderPanel;
	
	
	private SoftAssertions SA = new SoftAssertions();
	
	public void verifyNoOrders() {
		LOGGER.info("Verifying that " + orderPanel.getText());
		SA.assertThat(orderPanel.getText()).containsIgnoringCase("You have no online orders");
		SA.assertAll();
		
	}
	public void verifyExistingOrders() {
		LOGGER.info("Verifying user has existing orders...");
		SA.assertThat(orderStatus.exists()).isEqualTo(true);
		SA.assertAll();
	}
	
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
	
	public void enterOrderInfoAndCont(String ordNum, String email)
	{
		LOGGER.info("Searching for a guest order...");
		
		orderNumberBox.type(ordNum);
		emailAddBox.type(email);
		
		LOGGER.info("clicking cont button...");
		//contButton.waitUntilClickable();
		//contButton.click();
		//contButton.click();
		contButton.click();
		if(contButton2.exists())
		{
			contButton2.click();
		}
		
		LOGGER.info("waiting for response...");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void verifyOrderStatus(String ordNum, String status)
	{
		LOGGER.info("Checking order number and status...");
		SA.assertThat(ordNum.contentEquals(orderNumber.getText()));
		SA.assertThat(status.contentEquals(orderStatus.getText()));
		SA.assertAll();
		
	}
	public void checkItemStatus(String orderNum, String status)
	{
		firstDropDown.click();
		boolean itemNumFound = false;
		LOGGER.info("Checking for order and status...");
		for(int i = 0; i < orderItems.size(); i++)
		{
			LOGGER.info(orderItems.get(i).getText());
			String currentItemLine = orderItems.get(i).getText().toLowerCase();
			if(currentItemLine.contains(orderNum))
			{
				LOGGER.info("recieved Order Num " + orderItems.get(i+1).getText());
				LOGGER.info("given Order Num  " + status);
				currentItemLine = orderItems.get(i+1).getText();
				LOGGER.info("recieved status " + orderItems.get(i+1).getText());
				LOGGER.info("given status " + status);
				SA.assertThat(currentItemLine.contains(status)).isTrue();
				itemNumFound = true;
				i = orderItems.size() +1;
			}
			//LOGGER.info(orderItems.get(i).getAttribute("orderNumber"));
			
		}
		SA.assertThat(itemNumFound).isTrue();
		SA.assertAll();
	}
}
