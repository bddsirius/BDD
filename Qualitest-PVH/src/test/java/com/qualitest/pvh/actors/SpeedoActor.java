package com.qualitest.pvh.actors;

import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.actor.BaseActor;
import com.qualitest.core.manager.FileReaderManager;
import com.qualitest.core.util.EnvConfig;
import com.qualitest.pvh.pages.SpeedoAccountSummaryPage;
import com.qualitest.pvh.pages.SpeedoForgotPasswordPage;
import com.qualitest.pvh.pages.SpeedoCartPage;
import com.qualitest.pvh.pages.SpeedoShippingPage;
import com.qualitest.pvh.pages.SpeedoCreateNewPasswordPage;
import com.qualitest.pvh.pages.SpeedoEditCartPage;
import com.qualitest.pvh.pages.SpeedoHomePage;
import com.qualitest.pvh.pages.SpeedoItemPage;
import com.qualitest.pvh.pages.SpeedoMyAddressBookPage;
import com.qualitest.pvh.pages.SpeedoMyOrdersPage;
import com.qualitest.pvh.pages.SpeedoNewAddressPage;
import com.qualitest.pvh.pages.SpeedoOrderSummaryPage;
import com.qualitest.pvh.pages.SpeedoPersonalInformationPage;
import com.qualitest.pvh.pages.SpeedoQuickViewPage;
import com.qualitest.pvh.pages.SpeedoRegisterAtCheckOutPage;
import com.qualitest.pvh.pages.SpeedoRegistrationDetailsPage;
import com.qualitest.pvh.pages.SpeedoReviewOrderPage;
import com.qualitest.pvh.pages.SpeedoSearchResultsPage;
import com.qualitest.pvh.pages.SpeedoCheckoutPage;
import com.qualitest.pvh.pages.SpeedoCheckoutPreferences;
import com.qualitest.pvh.pages.SpeedoSignInPage;
import com.qualitest.pvh.testDataTypes.Account;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import net.serenitybdd.core.Serenity;

public class SpeedoActor extends BaseActor {

	private static final EnvConfig ENV = ConfigFactory.create(EnvConfig.class);
	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoActor.class);
	SpeedoMyOrdersPage speedoMOP;
	SpeedoHomePage speedoHP;
	SpeedoSignInPage speedoSIP;
	SpeedoRegistrationDetailsPage speedoRDP;
	SpeedoAccountSummaryPage speedoASP;
	SpeedoCreateNewPasswordPage speedoCNPP;
	SpeedoCheckoutPage speedoCOP;
	SpeedoCartPage speedoCP;
	SpeedoCheckoutPreferences speedoCPP;
	SpeedoEditCartPage speedoECP;
	SpeedoForgotPasswordPage speedoFPP;
	SpeedoItemPage speedoIP;
	SpeedoMyAddressBookPage speedoMABP;
	SpeedoNewAddressPage speedoNAP;
	SpeedoOrderSummaryPage speedoOSP;
	SpeedoPersonalInformationPage speedoPIP;
	SpeedoQuickViewPage speedoQVP;
	SpeedoRegisterAtCheckOutPage speedoRACOP;
	SpeedoReviewOrderPage speedoROP;
	SpeedoShippingPage speedoSP;
	SpeedoSearchResultsPage speedoSRP;

	
	/**
	 * Signs into the account using an email or one generated through
	 * FileReaderManager
	 * 
	 * @param email
	 * @param password
	 */
	public void accountSignIn(String email, String password) {
		Account corectPassword = FileReaderManager.getInstance().getJsonDataReader()
				.getAccountPasswordByBrandAndEmail(Serenity.sessionVariableCalled("brand"), email);
		if (corectPassword != null) {
			password = corectPassword.password;
		}
		speedoSIP.accountSignIn(email, password);
	}
	
	/**
	 * Signs in regularly without using the FileReaderManager
	 * 
	 * @param email
	 * @param password
	 */
	public void accountSignInWithOldPassword(String email, String password) {
		speedoSIP.accountSignIn(email, password);
	}

	public void addAmountOfItems(int x, String itemquant)
	{
		String[] itemNames = new String[16];
		itemNames[0] = "shirt";
		itemNames[1] = "pants";
		itemNames[2] = "team";
		itemNames[3] = "goggles";
		itemNames[4] = "jacket";
		itemNames[5] = "float";
		itemNames[6] = "support";
		itemNames[7] = "gloves";
		itemNames[8] = "activewear";
		itemNames[9] = "jogger";
		itemNames[10] = "footwear";
		itemNames[11] = "men shirt";
		itemNames[12] = "parka";
		itemNames[13] = "coverup";
		itemNames[14] = "girls swim";
		itemNames[15] = "boys swim";
		int num = 1;
		speedoHP.submitSearchFor(itemNames[(num % 16)]);
		speedoSRP.pageRefresh();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoSRP.selectProduct(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoIP.chooseRandomSizeandAddToBag();
		speedoIP.selectQuantity(itemquant);
		Serenity.setSessionVariable("firstItem").to(speedoIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(speedoIP.returnOfferPrice());
		speedoIP.clickHomePage();
		num++;
		int itemOn = 1;
		int currentSect = 15;
		while(speedoCP.getNumItemsInBag() < x)
		{
			if(num > currentSect)
			{
				itemOn++;
				currentSect = currentSect*2;
			}
			
			speedoHP.submitSearchFor(itemNames[(num % 16)]);
			speedoSRP.pageRefresh();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speedoSRP.selectProduct(itemOn);
			
			int temp = itemOn;
			
			while(speedoIP.getPageLevelMessage().toLowerCase().contains("sold out"))
			{
				speedoIP.getDriver().navigate().back();
				speedoSRP.selectProduct(temp++);
			}
			temp = itemOn;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speedoIP.chooseRandomSizeandAddToBag();
			speedoIP.selectQuantity(itemquant);
		
			Serenity.setSessionVariable("firstItem").to(speedoIP.getProductName());
			Serenity.setSessionVariable("firstPrice").to(speedoIP.returnOfferPrice());
			
			//ckIP.getDriver().navigate().to(ckHP.URL);
			speedoIP.clickHomePage();
			//ckSRP.pageRefresh();
			num++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void addBillingAddress(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterBillingAddressFieldsAndSubmit(guestFields);
	}
	
	public void updateBillingAddress(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterUpdateBillingAddressFields(guestFields);
	}
	
	public void addInvalidShippingAddress(String guestFields) {
		// TODO Auto-generated method stub
		speedoASP.navigateToMyAddressBook();
		speedoMABP.addInvalidShippingAddress(guestFields);
	}
	
	public void updateBillingAndShippingAddress(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterUpdateBillingAndShippingAddressFields(guestFields);
	}
	
	public void updateBillingAndShippingAddressThreeTimes(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.updateExisitingShippingAndBillingAddressFieldsAndSubmitThreeTimes(guestFields);
	}
	
	public void enterUpdateShippingAddressFieldsThreeTimes(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.updateShippingAddressFieldsThreeTimes(guestFields);
	}
	
	public void enterBillingAddressFieldsAndSubmitThreeTimes(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterBillingAddressFieldsAndSubmitThreeTimes(guestFields);
	}
	
	public void verifyUpdatedInvalidAddressAddressBook() {
		speedoMABP.verifyUpdatedInvalidAddress();
	}
	
	public void enterUpdateBillingAddressFieldsThreeTimes(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterUpdateBillingAddressFieldsThreeTimes(guestFields);
	}
	
	public void enterShipAndBillAddressFieldsThreeTimes(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterShipAndBillAddressFieldsThreeTimes(guestFields);
	}
	
	public void enterShipAndBillButCancels(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterShipAndBillButCancels(guestFields);
	}
	
	public void verifyCancelAddress() {
		speedoMABP.verifyCancel();
	}

	/**
	 * Adds and item from the quickview
	 */
	public void addItemFromQuickViewPage() {
		speedoHP.clickOffPopUp();
		speedoSRP.goToFirstProductQuickViewPage();
		speedoQVP.chooseRandomSizeWithStock();
		saveQuickViewItemInfo();
		speedoQVP.clickAddToBag();

	}

	public void addItemsForQuantityLess12Check()
	{
		boolean hadLessThan12 = false;
		String[] itemNames = new String[16];
		itemNames[0] = "shirt";
		itemNames[1] = "pants";
		itemNames[2] = "team";
		itemNames[3] = "goggles";
		itemNames[4] = "jacket";
		itemNames[5] = "float";
		itemNames[6] = "support";
		itemNames[7] = "gloves";
		itemNames[8] = "activewear";
		itemNames[9] = "jogger";
		itemNames[10] = "footwear";
		itemNames[11] = "men shirt";
		itemNames[12] = "parka";
		itemNames[13] = "coverup";
		itemNames[14] = "girls swim";
		itemNames[15] = "boys swim";
		int num = 1;
		speedoHP.submitSearchFor(itemNames[(num % 16)]);
		speedoHP.pageRefresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoHP.clickOffPopUp();
		speedoSRP.selectProduct(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoIP.chooseRandomSizeandAddToBag();
		speedoIP.selectQuantity("9");
		try {
			Thread.sleep(1750);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoHP.clickOffPopUp();
		if(speedoIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
		{
			hadLessThan12 = true;
		}
		
		Serenity.setSessionVariable("firstItem").to(speedoIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(speedoIP.returnOfferPrice());
		speedoIP.clickHomePage();
		num++;
		int itemOn = 1;
		int currentSect = 15;
		while(hadLessThan12 == false)
		{
			if(num > currentSect)
			{
				itemOn++;
				currentSect = currentSect*2;
			}
			
			speedoHP.submitSearchFor(itemNames[(num % 16)]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speedoSRP.selectProduct(itemOn);
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speedoIP.chooseRandomSizeandAddToBag();
			speedoHP.clickOffPopUp();
			speedoIP.selectQuantity("9");
			try {
				Thread.sleep(1750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			speedoHP.clickOffPopUp();
			Serenity.setSessionVariable("firstItem").to(speedoIP.getProductName());
			Serenity.setSessionVariable("firstPrice").to(speedoIP.returnOfferPrice());
			if(speedoIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
			{
				hadLessThan12 = true;
			}
			
				//ckIP.getDriver().navigate().to(ckHP.URL);
				speedoIP.clickHomePage();
				//ckSRP.pageRefresh();
				num++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void addItemToCartTwice(String itemName)
	{
		
		//int num = 1;
		speedoHP.submitSearchFor(itemName);
		speedoHP.clickOffPopUp();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoSRP.selectProduct(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoIP.chooseRandomSizeandAddToBag();
		speedoIP.selectQuantity("1");
		speedoIP.clickHomePage();
	}

	public void addShippingAddress(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterShippingAddressFieldsAndSubmit(guestFields);
	}

	public void addShippingAndBillingAddress(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.enterShippingAndBillingAddressFieldsAndSubmit(guestFields);
	}

	/**
	 *Adds object to bag from the item page
	 */
	public void addToBag() {
		speedoHP.clickOffPopUp();
		speedoIP.clickAddToBag();
	}

	/**
	 * Adjusts the quantity of an item on the cart page
	 * @param quant
	 */
	public void adjustQuantity(String quant) {
		speedoCP.adjustQuantity(Serenity.sessionVariableCalled("firstItem"), quant);
	}

	public void adjustQuantityWithoutCheckStock(String quant) {
		speedoCP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}

	/**
	 * Applies the promo code 
	 * @param code
	 */
	public void applyPromoCode(String code) {
		speedoHP.clickOffPopUp();
		speedoCP.applyPromoCode(code);
	}

	/**
	 * Cancels an order on the Order summary page
	 */
	public void cancelOrder() {
		speedoOSP.clickCancelOrder();
	}

	/**
	 * Change and add address from the check out page
	 * and enters a new address on the pop up
	 * @param newAddress
	 */
	public void changeAndAddAddress(String newAddress) { 
		speedoCOP.clickChangeAddress();
		speedoNAP.clickNewAddress();
		speedoNAP.enterNewAddress(newAddress);
	}

	/**
	 * change and add billing address 
	 * @param newBilling
	 */
	public void changeAndAddBillingAddress(String newBilling) { 
		speedoCOP.clickChangeBillingAddress(); 
		speedoNAP.clickNewBillingAddress(); 
		speedoNAP.enterNewBillingAddress(newBilling);
	}

	public void changeAndAddBillingAddressFromReviewOrderPage(String newBilling) {
		speedoROP.clickChangeBillingAddress();
		speedoNAP.clickNewBillingAddress();
		speedoNAP.enterNewBillingAddress(newBilling);
	}

	public void changeAndAddBillingSignedIn(String newBilling) {
		speedoCOP.clickChangeBillingAddress();
		if(speedoNAP.getNumberOfBillingAddresses() > 2) {
			speedoHP.clickOffPopUp();
		}else {
			speedoNAP.clickNewBillingAddress();
			speedoNAP.signedInEnterBillingAddress(newBilling);
		}
	}

	public void changeAndAddressFromReviewOrderPage(String newAddress) {
		speedoROP.clickChangeAddress();
		speedoNAP.clickNewAddress();
		speedoNAP.enterNewAddress(newAddress);
	}

	public void checkColorSizeQuant(String color, String size, String quant) {
		// TODO Auto-generated method stub
		speedoCOP.checkColorSizeQuant(color, size, quant);
	}

	public void checkoutAndAdjustQuantity(String quant) {
		speedoCP.clickProceedCheckOut();
		speedoHP.clickOffPopUp();
		speedoCOP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}
	
	public void checkoutShoprunner() {
		speedoCP.checkoutShoprunner();
	}
	
	/**
	 * Chooses a size through next availability and adds to bag
	 */
	public void chooseRandomSize() {
		speedoIP.closeLimitedTimeOffer();
		speedoIP.chooseRandomSizeandAddToBag();
	}

	/**
	 * Clicks the edit itme from cart for the first edit
	 */
	public void clickEditItemFromCartForFirst() {
		speedoCP.clickFirstEdit();
		speedoECP.chooseNextAvailableSize(Serenity.sessionVariableCalled("size"));
	}

	/**
	 * Step to select first product on the search results page
	 */
	public void clickFirstProduct() {
		speedoSRP.selectFirstProduct();
		speedoHP.clickOffPopUp();
	}

	public void clickNext() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LOGGER.info("Clicking Next To Open Credit Card...");
		speedoCOP.clickNext();
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Clicks on the register button on the signin page
	 */
	public void clickRegister() {
		speedoSIP.clickCreateAccountButton();
	}

	/**
	 * Clicks on the sign in button from the homepage
	 */
	public void clickSignIn() {
		speedoHP.clickSignInRegister();
	}
	
	public void clickSignUpPopUp() {
		speedoHP.capturePopUp();
		speedoHP.clickSignUpPopUp();
	}

	/**
	 * Confirms that the reset email is sent
	 */
	public void confirmResetEmailSent() {
		speedoFPP.confirmResetPasswordEmailSent();
	}

	/**
	 * Creates new password on new page on the new password page
	 * @param password
	 */
	public void createNewPasswordOnNewPage(String password) {
		speedoCNPP.createNewPasswordOnNewPasswordPage(password);
	}

	public void editCheckOutAddress(String editAddress) {
		speedoCP.clickProceedCheckOut();
		speedoCOP.clickChangeAddress();
		speedoNAP.clickFirstShippingAddressEditButton();
		speedoNAP.enterEditedAddress(editAddress);
	}

	public void editCheckOutBillingAddress(String editAddress) {
		speedoCOP.clickChangeBillingAddress();
		speedoNAP.clickSecondBillingAddressEditButton();
		speedoNAP.enterEditedAddress(editAddress);
	}

	public void editCheckoutInformation(String infoFields) {
			speedoASP.navigateToCheckoutPreferences();
			speedoHP.clickOffPopUp();
			speedoCPP.editCheckoutInformation(infoFields);
	}
	
	public void editBillingCheckoutInformation(String infoFields) {
		speedoASP.navigateToCheckoutPreferences();
		speedoHP.clickOffPopUp();
		speedoCPP.clickOffSameAsBilling();
		speedoCPP.editBillingCheckoutInformation(infoFields);
	}

	public void editItemAtCheckout() {
		// TODO Auto-generated method stub
		speedoHP.clickOffPopUp();
		speedoCP.clickProceedCheckOut();
		Serenity.setSessionVariable("item1Color").to(speedoCOP.getColorText());
		Serenity.setSessionVariable("item1Size").to(speedoCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(speedoCOP.getQuantText());
		LOGGER.info(speedoCOP.getColorText() + "   " + speedoCOP.getSizeText() + "  " + speedoCOP.getQuantText()  );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		speedoCOP.clickEditButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoIP.clickLarge();
		speedoIP.clickColorOption(1);
		String color = speedoIP.getColorText();
		speedoIP.selectQuantityInPopup("2");
		speedoCOP.checkColorSizeQuant(color,"L","2");
	}

	public void editPersonalInformation(String infoFields) {
		speedoASP.clickEdit();
		speedoHP.clickOffPopUp();
		speedoPIP.enterFieldsAndSubmit(infoFields);
	}

	public void editPersonalInformationThreeTimes(String infoFields) {
		speedoASP.clickEdit();
		speedoHP.clickOffPopUp();
		speedoPIP.enterAddressAndSubmitThreeTimes(infoFields);
	}
	
	/**
	 * Enter and submit an order for a product. Sends the address details through
	 * the cart details page
	 * 
	 * @param email
	 * @param first
	 * @param last
	 * @param address
	 * @param apartment
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public void enterAndSubmitOrderAddress(String email, String first, String last, String address, String apartment,
			String city, String state, String zip, String phone) {
		speedoHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(speedoCP.getOrderTotal());
		speedoCP.clickProceedCheckOut();
		speedoSP.clickContinueAsGuest();
		speedoSP.enterGuestFieldsAndSubmit(email, first, last, address, apartment, city, state, zip, phone);
	}

	public void enterPaymentInformationButNoSubmit(String type, String number, String code, String expMonth, String expYear) {
		speedoCOP.clickNext();
		speedoCOP.enterPaymentFieldsWithNoSubmit(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(speedoROP.getOrderTotal());
		try
		{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}

	/**
	 * Enters registration details on the registration page. Different from other
	 * because it's less fields
	 * 
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param phone
	 */
	public void enterRegistrationDetails(String email, String password, String firstName, String lastName,
			String phone) {
		Random rand = new Random();
		if (email.contains("@")) {
			email = email.split("@")[0] + "+" + rand.nextInt(999999) + "@" + email.split("@")[1];
		}
		Serenity.setSessionVariable("email").to(email);
		Serenity.setSessionVariable("password").to(password);
		speedoRDP.fillOutRegistration(email, password, firstName, lastName, phone);
	}
	
	/**
	 * Enters registration information on the pop up that appears after the a complete checkout.
	 * Password is the only thing needed because email is carried over from the order
	 * @param password
	 */
	public void enterRegistrationOnCheckOut(String password) {
		speedoRACOP.registerAtCheckOut(password);
	}

	/**
	 * Enters the shipping and billing information
	 */
	public void enterShippingAndBilling() {
		//speedoCOP.clickNext();
		speedoCOP.enterPaymentFields("VISA", "4111111111111111", "321", "08", "2020");
		speedoROP.clickSubmitOrder();
	}
	
	public void enterShopRunnerInfo(String email, String password) {
		speedoCOP.enterShopRunnerInfo(email, password);
	}

	public void getFirstSize() {
		// TODO Auto-generated method stub
		Serenity.setSessionVariable("size").to(speedoCP.getFirstSize());
	}

	/**
	 * gets the product name on the item page and returns it
	 * @return String of product name
	 */
	public String getProductNameOfItemPage() {
		String name = speedoIP.getNameOfProduct();
		return name;
	}

	/**
	 * gets the product price of on the item page and returns it as a String
	 * @return String of price
	 */
	public String getProductPriceOfItemPage() {
		String price = speedoIP.getPrice();
		return price;
	}

	/**
	 * Goes to account from the order summary page
	 */
	public void goToAccount() {
		speedoOSP.clickMyAccount();
	}

	public void verifyAllAddressesRemoved() {
		speedoMABP.verifyAllAddressesRemoved();
	}
	
	public void deleteAllAddresses() {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.deleteAllAddresses();
	}
	
	/**
	 * goes to cart from the cart corner link
	 */
	public void goToCartFromCartCornerLink() {
		speedoIP.clickGoToCart();
		speedoHP.clickOffPopUp();
	}

	/**
	 * Step to navigate to the cart page from the home page
	 */
	public void goToCartFromHome() {
		speedoHP.clickCart();
		speedoHP.clickOffPopUp();
	}

	/**
	 * Go to check out from the cart page
	 */
	public void goToCheckout() {
		speedoCP.clickProceedCheckOut();
	}

	public void goToCheckoutAndApplyPromo(String code) {
		speedoCP.clickProceedCheckOut();
		speedoSP.pageRefresh();
		speedoSP.submitPromoCode(code);
	}

	/**
	 * Goes to the edit button on the cart page 
	 */
	public void goToEdit() {
		speedoHP.clickCart();
		speedoHP.clickOffPopUp();
		speedoCP.editProduct();
	}

	/**
	 * goes to the forgot password link from the sign in page
	 */
	public void goToForgotPassword() {
		speedoSIP.clickForgotPassword();
	}

	public void goToPaypalPayment() {
		speedoCOP.payWithPayPal();
		speedoROP.clickProceedToPaypal();
	}

	public void loginShopRunner(String email,String password) {
		speedoHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(speedoCP.getOrderTotal());
		speedoCP.loginWithShoprunner(email, password);
		speedoHP.clickOffPopUp();
	}

	/**
	 * Clicks log out from the account services page
	 */
	public void logOut() {
		speedoASP.clickLogOut();
	}

	public void navigateBackAndVerify() {
		// TODO Auto-generated method stub
		speedoROP.clickBackButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoCOP.verifyOnPage();
	}

	public void navigateEditAndVerify() {
		// TODO Auto-generated method stub
		speedoROP.clickEditButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		speedoCP.verifyOnPage();
		
	}

	/**
	 * Goes to the Speedo homepage and opens
	 */
	public void navigateTo() {
		speedoHP.navigateTo(ENV.speedoURL());
		speedoHP.clickOffPopUp();
	}

	public void openSite() {
		speedoHP.navigateTo(ENV.speedoURL());
	}

	public void proceedToReviewOrder() {
		// TODO Auto-generated method stub
		LOGGER.info("Procedding to Review Order Page...");
		speedoCOP.clickReviewOrder();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void proceedToSecureCheckout() {
		Serenity.setSessionVariable("orderPrice").to(speedoCP.getOrderTotal());
		speedoCP.clickProceedCheckOut();
	}

	public void removeFirstItemFromCart() {
		speedoHP.clickOffPopUp();
		speedoCP.removeFirstItem();
	}
	
	public void removeItemAtCheckout() {
		// TODO Auto-generated method stub
		speedoHP.clickOffPopUp();
		int initItems = speedoCOP.getNumOfCheckoutItems();
		speedoCOP.removeCheckoutItem1();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(initItems >1)
		{
			int finalItems = speedoCOP.getNumOfCheckoutItems();
			speedoCOP.checkItemListNumbers(initItems,finalItems);
		}
		else
		{
			speedoCOP.checkForShoppingBagEmpty();
		}
	}
	
	public void removePromoCode() {
		speedoCP.removePromoCode();
	}
	
	public void removeSavedAddress() {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.selectExistingAddress();
		speedoMABP.removeAddress();
	} 
	
	/**
	 * removes the secon ditem added from the cart in the cart page
	 */
	public void removeSecondItemFromCart() {
		speedoCP.getDriver().navigate().refresh();
		speedoCP.removeSecondItem();
	} 
	
	/**
	 * Resets password by going through the eidt page on the account services page
	 * 
	 * @param brand
	 * @param email
	 */
	public void resetPassword(String brand, String email) {
		LOGGER.info("Navigating to personal information page and resetting password");
		speedoASP.clickEdit();
		String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
				.getAccountPasswordByBrandAndEmail(brand, email).password;
		Random ra = new Random();
		String newPassword = "Temp" + ra.nextInt(9999);
		speedoPIP.resetPassword(correctPassword, newPassword);
		FileReaderManager.getInstance().getJsonDataWriter().updateAccountPasswordData(brand, email, newPassword);
	}
	
	/**
	 * Saves ethe first item information throught the item page and into the serenity variables
	 */
	public void saveFirstItemInfo() {
		String firstItem = speedoIP.getProductName();
		float firstPrice = speedoIP.returnOfferPrice();
		Serenity.setSessionVariable("firstItem").to(firstItem);
		Serenity.setSessionVariable("firstPrice").to(firstPrice);
	}
	
	/**
	 * Saves the order total that is on the cart page
	 */
	public void saveOrderTotal() {
		float orderPrice = speedoCP.getOrderTotal();
		Serenity.setSessionVariable("orderPrice").to(orderPrice);
	} 
	
	/**
	 * Saves the quickview item information which include the price and item name 
	 */
	public void saveQuickViewItemInfo() {
		String quickViewItem = speedoQVP.getProductName();
		float quickViewPrice = speedoQVP.returnOfferPrice();
		Serenity.setSessionVariable("firstItem").to(quickViewItem);
		Serenity.setSessionVariable("firstPrice").to(quickViewPrice);
	} 
	/**
	 * Saves the second item info that occurs when the user is searching for another object
	 */
	public void saveSecondItemInfo() {
		String secondItem = speedoIP.getProductName();
		float secondPrice = speedoIP.returnOfferPrice();
		Serenity.setSessionVariable("secondItem").to(secondItem);
		Serenity.setSessionVariable("secondPrice").to(secondPrice);
	}
	
	/**
	 * Save the size info on the item page
	 */
	public void saveSizeInfo() {
		String size = speedoIP.getSizesSelected();
		Serenity.setSessionVariable("size").to(size);
	} 
	/**
	 * Step to enter search term in search bar
	 * @param item - Search Term
	 */
	public void search(String item) {
		speedoHP.enterSearchTerm(item);
	}

	/**
	 * Search for products on the home page using provided search term
	 * 
	 * @param item - Search Term
	 */
	public void searchFor(String item) {
		speedoHP.submitSearchFor(item);
	}
	/**
	 * Search for an item in the cart
	 * @param item
	 */
	public void searchForItemInCart(String item) {
		speedoHP.clickOffPopUp();
		speedoCP.searchFor(item);
		clickFirstProduct();
		chooseRandomSize();
	}
	
	/**
	 * searches for a product on the search bar on the Item page
	 * 
	 * @param item
	 */
	public void searchForProductAndAddToCart(String item) {
		speedoHP.clickOffPopUp();
		//speedoHP.pageRefresh();
		speedoHP.submitSearchFor(item);
		speedoHP.clickOffPopUp();
		speedoSRP.selectFirstProduct();
		speedoIP.chooseRandomSizeandAddToBag();
		speedoIP.selectQuantity("1");
		saveFirstItemInfo();
		speedoIP.clickGoToCart();
	}
	
	/**
	 * Steps to select PayPal payment method
	 */
	public void selectPaypalPaymentMethod() {
		speedoCOP.payWithPayPal();
		speedoROP.clickProceedToPaypal();
	}
	/**
	 * Selects the quantity of an item on the item page
	 * @param quant
	 */
	public void selectQuantityItemPage(String quant) {
		speedoIP.closeLimitedTimeOffer();
		speedoIP.selectQuantity(quant);
	}

	/**
	 * Step to select provided shipping method
	 * @param shippingMethod - Shipping method e.g.: STANDARD / SECOND DAY / OVERNIGHT
	 */
	public void selectShippingMethod(String shippingMethod) {
		speedoCOP.selectShippinhMethod(shippingMethod);
		
	}
	/**
	 * Sends an email to the account's email list
	 * 
	 * @param email
	 */
	public void sendResetPasswordEmail(String email) {
		speedoHP.clickOffPopUp();
		speedoFPP.inputResetEmail(email);
		speedoFPP.clickSubmitEmail();
	}
	/**
	 * Signs in with invalid password int many times
	 * 
	 * @param email
	 * @param password
	 * @param numOfTimes
	 */
	public void signInWithInvalidPassword(String email, String password, int numOfTimes) {
		for (int i = 0; i <= numOfTimes; i++) {
			speedoSIP.accountSignIn(email, password);
			speedoHP.clickOffPopUp();
		}
	}

	public void signUpOnPopUp(String email) {
		speedoHP.capturePopUp();
		speedoHP.enterAndSubmitSignUpPopUp(email);
	}

	public void startCheckoutAndSubmitAddress(String guestFields) {
		speedoHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(speedoCP.getOrderTotal());
		speedoCP.clickProceedCheckOut();
		speedoSP.clickContinueAsGuest();
		speedoSP.enterAddressAndSubmit(guestFields);
	}

	/**
	 * Steps to submit order
	 */
	public void submitCheckoutOrder() {
		speedoROP.clickSubmitOrder();
	}
	/**
	 * Step to enter payment information and submitting order
	 * @param type - Credit Card Type
	 * @param number - Credit Card Number
	 * @param code - Credit Card CCV Code
	 * @param expMonth - Expiry Month
	 * @param expYear - Expiry Year
	 */
	public void submitOrderWithCreditCard(String type, String number, String code, String expMonth, String expYear) {
		//speedoCOP.clickNext();
		speedoCOP.enterPaymentFields(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(speedoROP.getOrderTotal());
		speedoROP.clickSubmitOrder();
	}
	
	/**
	 * Submits an invalid address int many times
	 * 
	 * @param noOfTimes
	 */
	public void submittingInvalidAddress(int noOfTimes) {
		for (int i = 1; i <= noOfTimes; i++) {
			speedoRDP.clickSave();
		}
	}
	public void updateSavedAddress(String guestFields) {
		speedoASP.navigateToMyAddressBook();
		speedoMABP.selectExistingAddress();
		speedoMABP.updateExisitingShippingAddressFieldsAndSubmit(guestFields);
		
	}
	/**
	 * Verifying that the account is registered
	 */
	public void verifyAccountIsRegistered() {
		speedoASP.verifyPageTitle();
		FileReaderManager.getInstance().getJsonDataWriter().addAccountPasswordData(
				Serenity.sessionVariableCalled("brand"), Serenity.sessionVariableCalled("email"),
				Serenity.sessionVariableCalled("password"));
	}
	public void verifyAddressAdded() {
		speedoMABP.verifyAddressAdded();
	}

	public void verifyAddressRemoved() {
		speedoMABP.verifyAddressRemoved();
	}
	public void verifyAdjustedQuantityOnCheckout() {
		speedoCOP.verifyCheckoutNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}
	
	public void verifyAllHeaderLinks()
	{
		speedoHP.verifyAllHeaderLinks();
	}
	
	public void verifyCheckoutPreUpdate() {
			speedoCPP.verifyInformationUpdated();
	}
	
	/**
	 * verifies edit address is the current address on the checkout page
	 * @param newAddress
	 */
	public void verifyEditAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		String n = Serenity.sessionVariableCalled("randomAddress");
		String r = Serenity.sessionVariableCalled("randomApartment");
		speedoCOP.verifyShippingAddressForEdit(arr[1], arr[2], n+arr[3], r, arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}
	/**
	 * verifies edit billing address is the current address on the checkout page
	 * @param newAddress
	 */
	public void verifyEditBillingAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		String n = Serenity.sessionVariableCalled("randomAddress");
		String r = Serenity.sessionVariableCalled("randomApartment");
		speedoCOP.verifyBillingAddressForEdit(arr[1], arr[2], n+arr[3], r, arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}
	/**
	 * verify that the cart is empty 
	 */
	public void verifyEmptyCart() {
		speedoCP.verifyEmptyCart();
	}
	
	/**
	 * Verifying an error message on the registration page
	 * 
	 * @param error
	 */
	public void verifyErrorMessageOnRegistration(String error) {
		speedoRDP.verifyError(error);
	}

	/** 
	 * Goes to Speedo Home Page and Checks for Footer Links
	 */
	public void verifyFooter()
	{
		speedoHP.verifyFooterExists();
	}
	
	public void editCheckOutBillingAddressFromReviewOrderPage(String editAddress) {
		speedoROP.clickChangeBillingAddress();
		speedoNAP.clickFirstBillingAddressEdit();
		speedoNAP.enterEditedAddress(editAddress);
	}
	
	public void verifyInvalidAddressAdded() {
		// TODO Auto-generated method stub
		speedoMABP.verifyInvalidAddressAdded();
	}
	
	/**
	 * Verify the item in the cart icon pop up 
	 */
	public void verifyItemInCartMiniDisplay() {
		speedoIP.verifyItemInCartDisplayInCorner();
	}
	
	/**
	 * verify item name in the cart match the serenity stored things
	 */
	public void verifyItemNameMatchesCart() {
		speedoHP.clickCart();
		speedoHP.clickOffPopUp();
		speedoCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}
	
	public void verifySecondItemNameMatchesCart() {
		speedoHP.clickCart();
		speedoHP.clickOffPopUp();
		speedoCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("secondItem"),
				Serenity.sessionVariableCalled("secondPrice"));
	}
	
	
	public void verifyItemWasAdded() {
		// TODO Auto-generated method stub
		speedoCP.verifyItemWasAdded();
	}

	
	
	/**
	 * Verifies a sign in error by asking if a prompt is displayed on the sign in
	 * page
	 * 
	 * @param error
	 */	
	public void verifyLoginError(String error) {
		speedoSIP.verifySignInError(error);
	}
	
	/**
	 * Verifies that the page title of the account services is displayed and thus
	 * the login was successful
	 */
	public void verifyLoginIsSuccessful() {
		speedoASP.verifyPageTitle();
	}
	
	
	
	

	/**
	 * Verifies new address that was added is the current one on the check out page
	 * @param newAddress
	 */
	public void verifyNewAddressCurrent(String newAddress) {
		String arr [] = newAddress.split(";");
		speedoCOP.verifyShippingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]);
	}
	
	/**
	 * Verifies new billing address that was added is the current one on the check out page
	 * @param newBilling
	 */
	public void verifyNewBillingAddressCurrent(String newBilling) { 
		String[] arr = newBilling.split(";");
		speedoCOP.verifyBillingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}
	
	
	
	public void verifyNoEmailErrorPopUp() {
		speedoHP.verifyNoEmailUnSuccessfulPopUp();
	}

	public void verifyNoResults() {
		speedoSRP.verifyNoSearchResultMessage();
	}
	
	public void verifyNumberOfItems(int quantity)
	{
		
		speedoIP.clickGoToCart();
		speedoHP.clickOffPopUp();
		assertThat(speedoCP.getNumItemsInBag() >= quantity);
	}
	

	public void verifyNumItemsInCart(String code) {
		speedoCP.verifyNumItemsInCart(Integer.parseInt(code));
	}
	/**
	 * Step to verify summary of order submitted using credit card
	 * @param creditCardType - Credit Card Type
	 */
	public void verifyOrderSummary(String creditCardType) {
		speedoOSP.verifyOrderDetails(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"), creditCardType);
	}
	
	public void verifyPaypal() {
		speedoHP.clickOffPopUp();
		speedoHP.clickOffPopUp();
		speedoOSP.verifyFinalOrderDetailsWithPaypal(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"));
	}
	
	
	public void verifyPersonalInformationUpdated() {
		speedoPIP.verifyInformationUpdated();
	}
	
	public void verifyPersonalInformationWithoutAddress() {
		speedoRDP.goToAccountSummaryPage();
		speedoASP.verifyNoSavedAddress();
	}
	public void verifyPleaseSelectASize() {
		speedoIP.verifyPleaseSelectSize();
	}

	
	/**
	 * verifies that prohibited characters are not allowed
	 */
	public void verifyProhibitedCharacters() {
		speedoSRP.verifyProhibitedCharacter();
	}

	public void verifyPromoCodeAppliedAndRemovedOnCheckout() {
		speedoSP.verifyPromoCodeAppliedAndRemovedOnCheckout();
	}
	
	public void verifyPromoCodeAppliedOnCheckout() {
		speedoSP.verifyPromoCodeAppliedOnCheckout();
	}
	/**
	 * verifies promo code message error
	 * @param message
	 */
	public void verifyPromoMessage(String message) {
		speedoCP.verifyPromoCodeError(message);
	}
	
	/**
	 * Step to verify search result for provided search term
	 * 
	 * @param searchTerm - Search Term
	 */
	public void verifySearchResults(String searchTerm) {
		speedoHP.clickOffPopUp();
		speedoSRP.verifySearchResult(searchTerm);
	}
	/**
	 * Step to verify search result for provided style number
	 * 
	 * @param styleNum - Style Number of the product
	 */
	public void verifySearchResultsForStyleNumber(String styleNum) {
		speedoHP.clickOffPopUp();
		if(speedoSRP.verifySearchResultHeaderExists()) {
			speedoSRP.verifySearchResult(styleNum);
		} else {
			speedoIP.verifyProductDetailsPageForSpecificStyleNumber(styleNum);
		}
	}
	/**
	 * Step to verify search suggestion displayed matches the provided search term
	 * 
	 * @param text - Search Term
	 */
	public void verifySearchSuggestion(String item) {
		speedoHP.verifySearchSuggestions(item);
	}
	/**
	 * verifies second address address chosen and applied is on the checkout page
	 */
	public void verifySecondAddressApplies() { 
		speedoCOP.pageRefresh(); 
		speedoCOP.clickChangeAddress(); 
		String text = speedoNAP.getModdedRemoveAllSpacesAddress(); 
		speedoNAP.clickSecondAddress(); 
		speedoCOP.verifySelectedShippingAddressIsVisible(text); 
	}
	public void verifySecondBillingAddressApplies(String address) { 
		String[] arr = address.split(";");
		speedoCOP.clickChangeBillingAddress(); 
		String text = speedoNAP.getModdedBillingAddressMatchingName(arr[1], arr[2]); 
		speedoNAP.clickBillingAddressByFirstName(arr[1], arr[2]); 
		speedoCOP.verifySelectedBillingAddressIsVisible(text); 
	}
	public void verifyShopRunner() {
		speedoHP.clickOffPopUp();
		speedoOSP.verifyFinalOrderDetailsWithShopRunner(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"));
	}
	/**
	 * verify that the user is signed in on the cart page
	 */
	public void verifySignedIn() {
		speedoCP.verifySignIn();
	}
	public void verifySignUpOnPop() {
		speedoHP.verifyCongratsPopUpSignUp();
	}
	/**
	 * verifies sizes after an edit
	 */
	public void verifySizesAfterEdit() {
		speedoCP.verifyFirstSize(Serenity.sessionVariableCalled("size"));
	}
	public void verifyPersonalInformationAddress() {
		speedoRDP.goToAccountSummaryPage();
		speedoASP.verifySavedAddress();
	}
	public void verifyQuantityNotAvailableError() {
		speedoCP.verifyQuantityNotAvailableError();
	}
	/**
	 * Step to verify Speedo home page is displayed
	 */
	public void verifySpeedoHomePage() {
		speedoHP.verifyPageTitle();
	}
	
	/**
	 * Verifies that the style id is contained in the style id
	 * @param item
	 */
	public void verifyStyleID(String item) {

		if (speedoSRP.getTitle().contains("Search Results")) {
			speedoSRP.clickOnFirstElement();
		}
		String url = speedoIP.getURL();

		assertTrue("The item name is not on the page where we just searched", url.contains(item));
	}
	
	/**
	 * Verifying that the two items that were added matches the cart
	 */
	public void verifyTwoItemsMatchesCart() {
		speedoHP.clickCart();
		speedoHP.clickOffPopUp();
		speedoCP.verifyMultipleItemsInCart(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("secondItem"), Serenity.sessionVariableCalled("firstPrice"),
				Serenity.sessionVariableCalled("secondPrice"));
	}
	public void verifyUpdateAddress() {
		speedoMABP.verifyUpdateAddress();
	}
	
	public void goToReviewOrderPage() {
		speedoCOP.clickReviewOrder();
	}
	/**
	 * Verifies that the user is not signed in through the homepage
	 */
	public void verifyUserIsNotSignedIn() {
		speedoHP.verifyUserIsNotSignedIn();
	}
	public void verifyValidPromoForFirstItem(String code) {
		speedoCP.verifyValidPromoForFirstItem(code);
	}
	public void verifyValidPromoForMulitpleItems(String code) {
		speedoCP.verifyValidPromoForMulitpleItems(code);
	}
	public void verifyValidPromoWrongRequirement() {
		speedoCP.verifyValidPromoWrongRequirement();
	}
	public void enterNewLetterAndSubmit() {
		String email = Serenity.sessionVariableCalled("email");
		speedoASP.enterNewLetterAndSubmit(email);
	}
	public void enterInvalidEmailInNewsLetterAndSubmit() {
		String email = Serenity.sessionVariableCalled("email");
		String[] arr = email.split("@");
		speedoASP.enterNewLetterAndSubmit(arr[0]);	
	}
	public void verifyNoEmailNewsLetterSignUpOnAccount(String error) {
		speedoASP.verifyNoEmailNewsLetterSignUpOnAccount(error);
	}
	public void verifyEmailNewsLetterSignUpOnAccount() {
		speedoASP.verifyEmailNewsLetterSignUpOnAccount();
	}
	public void verifyNoPromoApplied(String code) {
		speedoCP.verifyNoPromoApplied(code);	
	}
	public void verifyOrderCancellation() {
		// TODO Auto-generated method stub
		speedoOSP.verifyCancellation();
	}
	public void navigateToMyOrders() {
		// TODO Auto-generated method stub
		speedoHP.pageRefresh();
		speedoHP.clickOffPopUp();
		speedoHP.sleep(3000);
		speedoHP.goToMyAccount();
		speedoASP.navigateToMyOrders();
	}
	public void verifyNoOrders() {
		speedoMOP.verifyNoOrders();
	}
	
	public void verifyOrderPending(String orderNum, String status) {
		// TODO Auto-generated method stub
		speedoMOP.checkItemStatus(orderNum, status);
	}
	public void guestUserGetOrderStatus(String orderNum, String email) {
		// TODO Auto-generated method stub
		speedoMOP.clickGuestOrderStatus();
		speedoMOP.enterOrderInfoAndCont(orderNum, email);
		
	}
	public void guestUserVerifyStatus(String orderNum, String status) {
		// TODO Auto-generated method stub
		speedoHP.clickOffPopUp();
		speedoMOP.verifyOrderStatus(orderNum, status);
	}

	
	public void verifyFooter(String names) {
		// TODO Auto-generated method stub
		speedoHP.verifyFooterNamesExists(names);
		
	}

	public void editPaymentOnReviewOrderPage(){
		speedoROP.clickEditPayment();
		
	}
	
	public void editShippingMethodOnReviewOrderPage() {
		speedoROP.clickEditShippingMethod();
	}
	
	public void verifyShippingMethodOnReviewOrderPage(String shippingMethod) {
		speedoROP.verifyShippingMethod(shippingMethod);
	}
	
	public void verifyPaymentInformationUpdated(String type, String cardNumber, String expMonth, String expYear) {
		speedoROP.verifyPaymentInformation(type, cardNumber, expMonth, expYear);
	}
	
	
	public void verifyAllHeaderCategoryLinks(String dept, String links) {
		// TODO Auto-generated method stub
		speedoHP.verifyAllHeaderCategoryLinks(dept, links);
	}
	
	public void verifyDeptBreadCrumbLinks(String dept, String links) {
		// TODO Auto-generated method stub
		speedoHP.verifyAllDeptBreadCrumbLinks( dept,links);
	}
	
	public void verifyCatPageGoToItemPage(String dept, String links) {
		// TODO Auto-generated method stub
		speedoHP.verifyAllCatPageGoToItemPage(dept, links);
		
	}
	public void verifyFooterLinksGoToCorrespondingPage(String category) {
		speedoHP.checkFooterLinkGoesToCorrespondingPage(category);
	}

	public void verifyBagLink() {
		// TODO Auto-generated method stub
		speedoHP.clickCartSimple();
		speedoCP.verifyOnCartPage();
	}

	public void verifyQuantityPageLevelMessage() {
		// TODO Auto-generated method stub
		assertThat(speedoIP.getPageLevelMessage().contentEquals("The quantity you selected exceeds the quantity available. We have adjusted the number of items in your shopping bag."));
	}

	public void verifySignInLink() {
		// TODO Auto-generated method stub
		speedoHP.clickSignInRegister();
		speedoSIP.verifyOnSignInPage();
	}
	
	public void adjustQuantityAddToBag(int quant) {
		// TODO Auto-generated method stub
		speedoIP.adjustQuantityAddToBag(quant);
	}

	public void verifyErrorMessage() {
		// TODO Auto-generated method stub
		speedoCPP.verifyErrorMessage();
	}
	public void verifyCardErrorMessage() {
		// TODO Auto-generated method stub
		speedoCPP.verifyCardErrorMessage();
	}

	public void verifyEmptyErrorMessage() {
		// TODO Auto-generated method stub
		speedoCPP.verifyEmptyErrorMessage();
	}
	public void verifyExistingOrders() {
		speedoMOP.verifyExistingOrders();
	}
	public void verifyPageLevelErrorOnEditAccount(String error) {
		speedoPIP.verifyPageLevelError(error);
	}
	
	public void verifyFieldLevelErrorOnEditAccount(String error) {
		speedoPIP.verifyFieldLevelError(error);
	}
	
	/**
	 * Step to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home
	 */
	public void selectDepartment(String department) {
		speedoSRP.selectDepartmentFromLeftNavigationBar(department);
	}

	/**
	 * Step to verify if provided option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */
	public void verifyOptionIsDisplayed(String option) {
		speedoSRP.verifyOption(option);		
	}

	/**
	 * Step to filter search result using provided price range
	 * @param price - Price Range e.g.: $0 - $25
	 */
	public void filterSearchResultUsingPriceRange(String price) {
		speedoSRP.filterSearchResultUsingPriceRange(price);
		
	}
	
	/**
	 * Step to verify filtered product list price is within provided price range
	 * @param priceRange - Price Range e.g.: $0 - $25
	 */
	public void verifyPriceOfProductsInFilteredList(String priceRange) {
		speedoSRP.verifyFilteredProductPrice(priceRange);
		
	}

	/**
	 * Step to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / red
	 */
	public void filterSearchResultUsingColor(String color) {
		speedoSRP.filterSearchResultUsingColor(color);
		
	}

	/**
	 * Step to verify searched product list is filtered using provided option
	 * @param option - Option e.g.: black / blue / 
	 */
	public void verifyProductsListIsFiltered(String option) {
		speedoSRP.verifyProductListIsFilteredUsing(option);
		
	}

	/**
	 * Step to filter search product list using provided size
	 * @param size - Size e.g.: s / m / xl / 4xl
	 */
	public void filterSearchResultUsingSize(String size) {
		speedoSRP.filterSearchResultUsingSize(size);
		
	}
	
	/**
	 * Step to filter search product list using provided category
	 * @param size - Size e.g.: accessories / apparel / swimwear
	 */
	public void filterSearchResultUsingCategory(String category) {
		speedoSRP.filterSearchResultUsingCategory(category);
		
	}

	/**
	 * Step to sort CKUS search product list using provided price option
	 * @param price - Price e.g.: Low to High / High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		speedoSRP.sortSearchResultUsingPrice(price);
		
	}
	
	/**
	 * Step to verify if product list is sorted based on provided price option
	 * @param priceRange - Price e.g.: Low to High / High to Low
	 */
	public void verifySortedProductList(String priceRange) {
		speedoSRP.verifyProductListIsSorted(priceRange);
		
	}
	
}