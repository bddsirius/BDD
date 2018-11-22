package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public abstract class CheckoutPage extends BasePage {
	private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutPage.class);

	@FindBy(xpath = "//*[@id = 'SaveShopCartAddressButtonWrapper']/a[1]") 
	private BaseElement addAndShipToThisAddress;

	@FindBy(xpath = "//*[@class='gift-card-applied clearfix']")
	private BaseElement appliedGiftCard;

	@FindBy(xpath = "//*[@class=\"secondary gift-card-apply-button\"]")
	private BaseElement applyGiftCard;

	@FindBy(xpath = "//*[@id = 'billingAddressDisplayArea_1']")
	private BaseElement billingAddress;

	// @FindBy(id="account1_1")
	// private BaseElement cardNumber;

	@FindBy(id = "payMethodId_1")
	private BaseElement cardType;

	@FindBy(id = "WC_ShippingAddressSelectSingle_link_1")
	private BaseElement changeAddress;

	@FindBy(xpath = "//*[@id = 'billingAddressWrapper']/div[@id = 'editBillingAddressLink_1']/a")
	private BaseElement changeBillingAddress;

	@FindBy(xpath = "//*[@id='order_details']/div/div[2]/div[1]/div[1]/div[2]")
	public BaseElement colorItem1;

	@FindBy(xpath = "//*[@id = 'billingAddressList']//a[contains( text(), 'EDIT')]")
	private List<WebElement> editBillingAddressList;

	@FindBy(id = "expire_month_1")
	private BaseElement expMonth;

	@FindBy(id = "expire_year_1")
	private BaseElement expYear;

	@FindBy(id = "GiftCard_Payment_Details")
	private BaseElement giftCard;

	@FindBy(id = "giftCardNumber")
	private BaseElement giftCardNumber;

	@FindBy(id = "giftCardPin")
	private BaseElement giftCardPin;

	@FindBy(xpath = "//*[@class = 'product_title']")
	private List<WebElement> listOfItems;

	@FindBy(id = "checkout-open-payment")
	private BaseElement nextShipping;
	
	@FindBy(id = "singleShipmentShippingMode3")
	private BaseElement overnight;

	@FindBy(id="payWithPayPal")
	private BaseElement payWithPayPal; 
	
	@FindBy(id = "qty_")
	public BaseElement quantItem1;
	
	@FindBy(id="qty_")
	private List <WebElement> quantities;
	
	@FindBy(id = "shippingBillingPageNext")
	private BaseElement reviewOrder;

	protected SoftAssertions SA = new SoftAssertions();
	
	@FindBy(xpath = "//*[contains( text(), 'Same as Shipping Address')]")
	private BaseElement sameAsShipping;
	
	@FindBy(id = "singleShipmentShippingMode2")
	private BaseElement secondDayShipping;
	
	@FindBy(id = "cc_cvc_1")
	private BaseElement securityCode;
	
	@FindBy(xpath = "//*[@id = 'shippingAddressDisplayArea']")
	protected BaseElement shippingAddress;
	
	@FindBy(xpath = "//*[@id = 'WC_EmptyShopCartDisplayf_div_1']")
	private BaseElement shoppingBagEmpty;
	
	
	@FindBy(xpath = "//*[@id = 'sr_signin_email']")
	private BaseElement shopRunnerEmail;
	
	@FindBy(xpath = "//*[@id = 'sr_signin_password']")
	private BaseElement shopRunnerPassword;
	
	
	@FindBy(xpath = "sr_sign_in_button")
	private BaseElement shopRunnerSubmit;
	
	@FindBy(xpath = "//*[@class = 'srd_a'][2]")
	private BaseElement signInShopRunner;

	@FindBy(xpath = "//*[@class='price']")
	private List<WebElement> totals;
	
	@FindBy(xpath = "//*[@id='WC_OrderItemDetailsf_links_1__']/span")
	protected BaseElement editButton;
	
	@FindBy(xpath = "//*[@id='WC_OrderItemDetailsf_links_2_']/span")
	protected BaseElement removeButton;
	
	@FindBy(xpath = "//*[@id='order_details']/div/div[2]/div[1]/div[1]/div[3]")
	public BaseElement sizeItem1;
	
	@FindBy(id = "singleShipmentShippingMode1")
    private BaseElement standardShipping;
	
	@FindBy(xpath = "//*[id = 'order_details']/[@class = 'styleNo']")
	protected List<WebElement> styleNumber;
	

	public void adjustQuantityWithoutCheckStock(String name, String quant) {
		getDriver().navigate().refresh();
		int iteration = -1;
		LOGGER.info("The list of items is size: " + listOfItems.size());
		for(int i = 0; i<listOfItems.size(); i++) {
			String s = listOfItems.get(i).getText();
			if(s.equalsIgnoreCase(name)) {
				LOGGER.info("The name found here: " + s);
				iteration = i;
			}
		}
		if(iteration < 0) {
			LOGGER.info("The name of the item is not in the cart");
		}else {
			LOGGER.info("Found the name in the cart, selecting quantity");
			WebElement w = quantities.get(iteration);
			LOGGER.info("Selecting "+quant+ " in the dropdown");
			Select roledropdown = new Select(w);
			roledropdown.selectByVisibleText(quant);
		}
		}
	/**
	 * Method to click apply gift card button
	 */
	private void applyGiftCard() {
		LOGGER.info("Clicking gift card apply button");
		applyGiftCard.click();
	}
	
	public void checkColorSizeQuant(String color, String size, String quant) {
		// TODO Auto-generated method stub
		SA.assertThat(colorItem1.getText().toLowerCase().contains(color.toLowerCase()));
		SA.assertThat(sizeItem1.getText().toLowerCase().contains(size.toLowerCase()));
		SA.assertThat(quantItem1.getSelectedValue().toLowerCase().contains(quant.toLowerCase()));
		String colorpre = Serenity.sessionVariableCalled("item1Color");
		String sizepre = Serenity.sessionVariableCalled("item1Size");
		String quantpre = Serenity.sessionVariableCalled("item1Quant");
		LOGGER.info("Asserting Item was Edited From  : " + colorItem1.getText() + " " + sizeItem1.getText() + " " + quantItem1.getSelectedValue());
		LOGGER.info("Asserting Item was Edited to : " + colorpre + " " + sizepre + " " + quantpre);
		SA.assertAll();
	}

	public void checkForShoppingBagEmpty() {
		// TODO Auto-generated method stub
		SA.assertThat(shoppingBagEmpty.isCurrentlyVisible()).isTrue();
		SA.assertAll();
	}

	public void checkItemListNumbers(int initItems, int finalItems) {
		// TODO Auto-generated method stub
		SA.assertThat(finalItems < initItems).isTrue();
		SA.assertAll();
	}

	/**
	 * Method to click change address link
	 */
	public void clickChangeAddress() {
		try {
			LOGGER.info("Clicking the change address button");
			changeAddress.click();
		} catch (Exception e) {
			LOGGER.info("Cannot find the change address button, so refreshing page");
			pageRefresh();
			pageRefresh();
			changeAddress.click();
		}
	} 
	/**
	 * Method to click change billing address link
	 */
	public void clickChangeBillingAddress() {
		try {
			LOGGER.info("Clicking the change billing address button");
			changeBillingAddress.click();
		} catch (Exception e) {
			LOGGER.info("Cannot find the change billing address button, so refreshing page");
			pageRefresh();
			pageRefresh();
			changeBillingAddress.click();
		}
	}

	public void clickEditButton()
	{
		try {
			LOGGER.info("Clicking the edit item button");
			editButton.click();
		} catch (Exception e) {
			LOGGER.info("Cannot find edit item button refreshing");
			pageRefresh();
			pageRefresh();
			editButton.click();
		}
		
	}
	
	/**
	 * Method to click next button on the shipping method section
	 */
	public void clickNext() {
		if (nextShipping.exists()) {
			LOGGER.info("Clicking next on Shipping Address");
			nextShipping.click();
		}
	}
	/**
	 * Method to click review order on checkout page
	 */
	public void clickReviewOrder() {
		LOGGER.info("Clicking Review Order");
		reviewOrder.click();
	}

	private void clickShopRunnerSubmit() {
		LOGGER.info("Clicking shoprunner submit");
		shopRunnerSubmit.click();
	}

	   public void clickSignInShopRunner() {
		LOGGER.info("Clicking sign in to shop runner");
		signInShopRunner.click();
	}
 
    /**
	 * Method to enter credit card number
	 * 
	 * @param number - CC Number
	 */
	private void enterCardNumber(String number) {
		LOGGER.info("Entering Credit Card Number: " + number);
		for (int i = 0; i <= 2; i++) {
			try {
				WebElementFacade cardNumber = find(By.xpath("//input[@name='account1']"));
				cardNumber.clear();
				cardNumber.type(number);
				break;
			} catch (StaleElementReferenceException e) {
				continue;
			}
		}
	}

	/**
	 * Method to enter gift card information during checkout
	 * 
	 * @param number - Gift Card Number
	 * @param pin    - Gift Card Pin
	 */
	public void enterGiftCardFields(String number, String pin) {
		openGiftCard();
		enterGiftCardNumber(number);
		enterGiftCardPin(pin);
		applyGiftCard();
		try{
		    Thread.sleep(4000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}

	/**
	 * Method to enter gift card number
	 * 
	 * @param number - Gift Card Number
	 */
	private void enterGiftCardNumber(String number) {
		LOGGER.info("Entering gift card number: " + number);
		giftCardNumber.clear();
		giftCardNumber.sendKeys(number);
	}
	

	/**
	 * Method to enter gift card pin
	 * 
	 * @param pin - Gift Card Pin
	 */
	private void enterGiftCardPin(String pin) {
		LOGGER.info("Entering gift card pin: " + pin);
		giftCardPin.clear();
		giftCardPin.sendKeys(pin);
	}

	/**
	 * Method to enter credit cart payment details
	 * 
	 * @param type     - Credit Card Type
	 * @param number   - Credit Cart Number
	 * @param code     - CCV Code
	 * @param expMonth - Expiration Month
	 * @param expYear  - Expiration Year
	 */
	public void enterPaymentFields(String type, String number, String code, String expMonth, String expYear) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!cardType.isCurrentlyVisible())
		{
			nextShipping.click();
		}
		selectCardType(type);
		waitFor(1000);
		enterCardNumber(number);
		
		enterSecurityCode(code);
		selectExpMonth(expMonth);
		selectExpYear(expYear);
		clickReviewOrder();
	}
	

	public void enterPaymentFieldsWithNoSubmit(String type, String number, String code, String expMonth, String expYear) {
		
		try {
			clickNext();
		}catch(Exception e) {
			
		} 
		
		selectCardType(type);
		sleep(3000);
		enterCardNumber(number);
		enterSecurityCode(code);
		selectExpMonth(expMonth);
		selectExpYear(expYear);
	}

	
	/**
	 * Method to enter credit card ccv code
	 * 
	 * @param code - CCV Code
	 */
	private void enterSecurityCode(String code) {
		LOGGER.info("Entering credit card secuitry code: " + code);
		securityCode.type(code);
	}
	
	public void enterShopRunnerInfo(String email, String password) {
		clickSignInShopRunner();
		shopRunnerEmailInput(email);
		shopRunnerPasswordInput(password);
		clickShopRunnerSubmit();
	}
	
	private String getBillingAddress() { 
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,-1000)");
		waitFor(3000);
		if (!billingAddress.exists()) {
			pageRefresh();
		}
		String text = billingAddress.getText();
		LOGGER.info("Getting the text from billing address as: " + text);
		return text;
	}
	
	public String getColorText() {
		// TODO Auto-generated method stub
		return colorItem1.getText();
	}

	private String getModdedBillingAddress() {
		String text = getBillingAddress();
		text = text.replace("\n", " ").replace("\r", " ");
		LOGGER.info("Getting modded string as: " + text);
		return text;
	}

	public String getModdedRemoveAllSpaces(String s) {  
		s = s.replaceAll("\\s+","");  
		LOGGER.info("Returning a no space String of: "+s);  
		return s;  
	}

	public String getModdedRemoveAllSpacesAddress() {
		String text = getModdedShippingAddress();
		text = text.replaceAll("\\s+", "");
		LOGGER.info("Returning a no space String of: " + text);
		return text;
	}

	public String getModdedRemoveAllSpacesBillingAddress() {
		String text = getModdedBillingAddress();
		text = text.replaceAll("\\s+", "");
		LOGGER.info("Returning a no space String of: " + text);
		return text;
	}

	private String getModdedShippingAddress() {
		String text = getShippingAddress();
		text = text.replace("\n", " ").replace("\r", " ");
		LOGGER.info("Getting modded string as: " + text);
		return text;
	}

	public String getNameOfProduct(int i) {
		String s = listOfItems.get(i).getText();
		LOGGER.info("Returning a cart item of: "+s);
		return s;
	}

	public int getNumOfCheckoutItems()
	{
		return listOfItems.size();
	} 
	

	public float getQuantity(int iteration) {
		getDriver().navigate().refresh();
		WebElement w = quantities.get(iteration);
		List<WebElement> list = w.findElements(By.xpath("//option"));
		for(WebElement l: list) {
			
			try {
				if(l.getAttribute("selected").equals("true")){
				String s = l.getText();
				LOGGER.info("Getting the quantity of the first item in the checkout cart as: "+s);
				float i = Float.parseFloat(s);
				return i;
				}
			}catch(Exception E) {
			}
			
		}
		LOGGER.info("There is not selected number");
		return 0;
	} 
	 
	public String getQuantText() {
		// TODO Auto-generated method stub
		return quantItem1.getSelectedValue().toString();
	} 
	
	protected String getSameAsShippingText() {
		String text = sameAsShipping.getText();
		LOGGER.info("Same as shipping text says: " + text);
		return text;
	}
	
	private String getShippingAddress() {
		pageRefresh();
		if (!shippingAddress.exists()) {
			LOGGER.info("Not able to find the shipping address, so we will refresh twice");
			pageRefresh();
			pageRefresh();
		}
		String text = shippingAddress.getText();
		LOGGER.info("Getting the text from the shipping address as: " + text);
		return text;
	}  

	public String getSizeText() {
		// TODO Auto-generated method stub
		return sizeItem1.getText();
	}
	 
	public String moddedPhone(String phone) {
		String text = "(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6);
		LOGGER.info("Returning a modded phone of: " + text);
		return text;
	} 
	 
	/**
	 * Method to enable / disable gift card section during checkout
	 */
	private void openGiftCard() {
		LOGGER.info("Expand/Collapse Gift Card Section");
		giftCard.click();
	} 
	
	public void payWithPayPal() {
		LOGGER.info("Selecting PayPal checkout...");
		sleep(2000);
		clickNext();
		sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,-1000)");
		payWithPayPal.click();
		reviewOrder.click();
	} 
	public void removeCheckoutItem1() {
		// TODO Auto-generated method stub
		removeButton.click();
	}
	/**
	 * Selecting credit card type
	 * 
	 * @param type - CC Type e.g.: VISA / MasterCard / Discover
	 */
	private void selectCardType(String type) {
		LOGGER.info("Selecting card type: " + type);
		Select roledropdown = new Select(cardType);
		roledropdown.selectByVisibleText(type);
	}
	/**
     * Method to select credit card expiry month
     * 
     * @param month - Expiry Month
     */
    private void selectExpMonth(String month) {
        LOGGER.info("Selecting credit card expiry month: " + month);
        Select roledropdown = new Select(expMonth);
        roledropdown.selectByVisibleText(month);
    }
	/**
     * Method to select credit card expiry year
     * 
     * @param year - Expiry Year
     */
    private void selectExpYear(String year) {
        LOGGER.info("Selecting credit card expiry year: " + year);
        Select roledropdown = new Select(expYear);
        roledropdown.selectByVisibleText(year);
    }

	/**
	 * Clicking overnight shipping
	 */
	private void selectOvernight() {
		LOGGER.info("Selecting overnight shipping");
		overnight.click();
	}
	
	
	/**
	 * Method to select second day shipping
	 */
	private void selectSecondDay() {
		LOGGER.info("Selecting second day shipping");
		secondDayShipping.click();
	}
	
	
	/**
	 * Method to select shipping method
	 * @param shippingMethod - Shipping method e.g.: STANDARD / SECOND DAY / OVERNIGHT
	 */
	public void selectShippinhMethod(String shippingMethod) {
		switch(shippingMethod.toUpperCase()) {
		case "OVERNIGHT":
			selectOvernight();
			break;
		case "SECOND DAY":
			selectSecondDay();
			break;
		case "STANDARD":
			selectStandard();
			break;
		}
	}
	
	
	public float getProductTotal(int num) {
        WebElement w = totals.get(num);
        List<WebElement> l = w.findElements(By.tagName("span"));
        String s = "";
        if(l.size() == 1) {
            s = l.get(0).getText();
        }else {
            s = l.get(1).getText();
        }
        LOGGER.info("Returning a total in the cart page of: "+s);
        s = s.replace("$", "");
        s = s.replace(",", "");
        LOGGER.info("Modded string value is: "+s);
        float f = Float.parseFloat(s);
        return f;
    }
	
	
	/**
	 * Method to select standard shipping
	 */
	private void selectStandard() {
		LOGGER.info("Selecting standard shipping");
		standardShipping.click();
	}
	private void shopRunnerEmailInput(String email) {
		LOGGER.info("Entering the email into shop runner as: "+email );
		shopRunnerEmail.type(email);
	}
	
	private void shopRunnerPasswordInput(String password) {
		LOGGER.info("Entering the password into shop runner as: "+password);
		shopRunnerPassword.type(password);
	}

	public void verifyBillingAddress(String firstName, String lastName, String address, String apartment, String city, String state, String country, String zip, String phone, String email) { 
		String text = getBillingAddress(); 
		SA.assertThat(text).as("First Name").contains(firstName); 
		SA.assertThat(text).as("Last Name").contains(lastName); 
		SA.assertThat(text).as("Address").contains(address); 
		if(apartment.equals("")) { 
			SA.assertThat(text).as("Apartment").contains(""); 
		}else { 
			SA.assertThat(text).as("Apartment").contains(apartment); 
		} 
		if(country.equals("")) { 
			SA.assertThat(text).as("Country").contains("United States"); 
		}else { 
			SA.assertThat(text).as("Country").contains(country); 
		} 
		SA.assertThat(text).as("City").contains(city); 
		SA.assertThat(text).as("State").contains(state); 
		SA.assertThat(text).as("Phone").contains(moddedPhone(phone)); 
		SA.assertThat(text).as("email").contains(email); 
		SA.assertAll(); 
		 
	}
	
	public void verifyBillingAddressForEdit(String firstName, String lastName, String address, String apartment, String city, String state, String country, String zip, String phone, String email) { 
		String text = getBillingAddress(); 
		SA.assertThat(text).as("First Name").contains(firstName); 
		SA.assertThat(text).as("Last Name").contains(lastName); 
		SA.assertThat(text).as("Address").contains(address); 
		if(apartment.equals("")) { 
			SA.assertThat(text).as("Apartment").contains(""); 
		}else { 
			SA.assertThat(text).as("Apartment").contains(apartment); 
		} 
		if(country.equals("")) { 
			SA.assertThat(text).as("Country").contains("United States"); 
		}else { 
			SA.assertThat(text).as("Country").contains(country); 
		} 
		SA.assertThat(text).as("City").contains(city); 
		SA.assertThat(text).as("State").contains(state); 
		SA.assertThat(text).as("Phone").contains(moddedPhone(phone)); 
		SA.assertAll(); 
	}

	public void verifyCheckoutNameMatchesItemPage(String name, float price) {
		float i = getQuantity(0);
		price = i * price;
		i = i * getProductTotal(0);
		
		LOGGER.info("this is: " + i);
		SA.assertThat(getNameOfProduct(0)).isEqualToIgnoringCase(name);
		SA.assertThat(i).isEqualTo(price);
		SA.assertAll();
	}
	
	public void verifyGiftCardApplied() {
		SA.assertThat(appliedGiftCard.exists());
		SA.assertAll();
	}

	public void verifyOnPage() {
		// TODO Auto-generated method stub
		SA.assertThat(reviewOrder.exists() && reviewOrder.getText().toLowerCase().contains("review")).isTrue();
		SA.assertAll();
	}
	
	public void verifySelectedBillingAddressIsVisible(String bill) { 
		if(sameAsShipping.exists()) { 
			LOGGER.info("The Shipping and Billing address are the same");  
		}
		String text = getModdedRemoveAllSpaces(getBillingAddress()); 
		assertThat(text).as("Billing address").isEqualTo(bill);  
	}
	
	public void verifySelectedShippingAddressIsVisible(String add) { 
		String text = getModdedRemoveAllSpaces(getShippingAddress()); 
		assertThat(text).as("Shipping Address").isEqualTo(getModdedRemoveAllSpaces(add)); 
	}

	public void verifyShippingAddress(String firstName, String lastName, String address, String apartment, String city, String state, String country, String zip, String phone, String email) { 
		String text = getModdedShippingAddress(); 
		SA.assertThat(text).as("First Name").contains(firstName); 
		SA.assertThat(text).as("Last Name").contains(lastName); 
		SA.assertThat(text).as("Address").contains(address); 
		if(apartment.equals("")) { 
			SA.assertThat(text).as("apartment").contains(""); 
		}else { 
			SA.assertThat(text).as("Apartment").contains(apartment); 
		} 
		if(country.equals("")) { 
			SA.assertThat(text).as("Country").contains("United States"); 
		}else { 
			SA.assertThat(text).as("Country").contains(country); 
		} 
		SA.assertThat(text).as("City").contains(city); 
		SA.assertThat(text).as("State").contains(state); 
		SA.assertThat(text).as("Phone").contains(moddedPhone(phone)); 
		SA.assertAll(); 
		 
	}
	
	public void verifyShippingAddressForEdit(String firstName, String lastName, String address, String apartment, String city, String state, String country, String zip, String phone, String email) { 
		String text = getShippingAddress(); 
		SA.assertThat(text).as("First Name").contains(firstName); 
		SA.assertThat(text).as("Last Name").contains(lastName); 
		SA.assertThat(text).as("Address").contains(address); 
		if(apartment.equals("")) { 
			SA.assertThat(text).as("Apartment").contains(""); 
		}else { 
			SA.assertThat(text).as("Apartment").contains(apartment); 
		} 
		if(country.equals("")) { 
			SA.assertThat(text).as("Country").contains("United States"); 
		}else { 
			SA.assertThat(text).as("Country").contains(country); 
		} 
		SA.assertThat(text).as("City").contains(city); 
		SA.assertThat(text).as("State").contains(state); 
		SA.assertThat(text).as("Phone").contains(moddedPhone(phone)); 
		SA.assertAll(); 
		 
	}

}
