package com.qualitest.pvh.pages;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class WishlistPage extends BasePage {
	
	@FindBy(xpath="//*[@class='button_text primary-button']")
	private BaseElement addToBag;
	
	@FindBy(xpath = "//*[@class = 'product_title']")
	private List<WebElement> listOfItems;
	
	@FindBy(xpath = "//*[@class = 'price']")
	private List<WebElement> totals;
	
	@FindBy(xpath = "//*[@id = 'qty_']")
	private List<WebElement> quantities;
	
	@FindBy(id="WC_WishListResultDisplay_div_6")
	private BaseElement noWishlist;
	
	@FindBy(id="WC_WishListDisplay_links_1")
	private BaseElement shareWishlist;
	
	@FindBy(id="SendWishListForm_Recipient_Email")
	private BaseElement recipientEmail;
	
	@FindBy(id="SendWishListForm_Sender_Name")
	private BaseElement senderName;
	
	@FindBy(id="SendWishListForm_Sender_Email")
	private BaseElement senderEmail;
	
	@FindBy(id="wishlist_message")
	private BaseElement wishlistMessage;
	
	@FindBy(id="fieldErrorMessage")
	private BaseElement error;
	
	@FindBy(id="WishListEmailSucMsg_Div")
	private BaseElement successfulShare;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WishlistPage.class);

	
	public void addFirstItemToCart() {
		LOGGER.info("Adding first item from wishlist to cart...");
		getDriver().navigate().refresh();
		addToBag.click();
	}

	private SoftAssertions SA = new SoftAssertions();
	
	public float getProductTotal(int num) {
		
		List<WebElement> checkForRed = totals.get(num).findElements(By.xpath(".//*[@class = 'price offerPrice']"));
		String s = "";
		if(checkForRed.size() > 0) {
			s = totals.get(num).findElement(By.xpath(".//*[@class = 'price offerPrice']")).getText();
		}else {
			s = totals.get(num).getText();
		}
		LOGGER.info("Returning a total in the cart page of: "+s);
		s = s.replace("$", "");
		s = s.replaceAll(",", "");
		s = s.replace("CAD ", "");
		LOGGER.info("Modded string value is: "+s);
		float f = Float.parseFloat(s);
		return f;
	}
	
	public String getNameOfProduct(int i) {
		String s = listOfItems.get(i).getText();
		LOGGER.info("Returning a top cart item of: "+s);
		return s;
	}
	
	
	public void verifyWishlistNameMatchesItemPage(String name, float price) {
		LOGGER.info("The name of product in wishlist is: " + getNameOfProduct(0));
		SA.assertThat(getNameOfProduct(0)).isEqualToIgnoringCase(name);
		LOGGER.info("The price of the product in wishlist is: " + getProductTotal(0));
		SA.assertThat(getProductTotal(0)).isEqualTo(price);
		SA.assertAll();
	}
	
	public void verifyNoWishlistItems() {
		SA.assertThat(noWishlist.getText()).containsIgnoringCase("You currently have no");
		SA.assertAll();
	}
	
	private void clickShareWishlist() {
		LOGGER.info("Sharing wishlist...");
		shareWishlist.click();
	}
	
	public void shareWishlist() {
		clickShareWishlist();
	}
	
	public void enterWishlistFields(String toEmail, String name, String fromEmail, String message) {
		LOGGER.info("Entering share wishlist details...");
		recipientEmail.type(toEmail);
		senderName.type(name);
		senderEmail.type(fromEmail);
		wishlistMessage.type(message);
	}
	
	public void verifyNoDetailsError() {
		SA.assertThat(error.exists()).isEqualTo(true);
		SA.assertAll();
	}
	
	public void verifySharedWishlist() {
		if(Serenity.sessionVariableCalled("brand").equals("TH")) {
			SA.assertThat(successfulShare.getText()).containsIgnoringCase("Your wish list will be sent to");
		}else {
		SA.assertThat(successfulShare.getText()).containsIgnoringCase("Your saved items will be sent to");
		}
		SA.assertAll();
	}
}
