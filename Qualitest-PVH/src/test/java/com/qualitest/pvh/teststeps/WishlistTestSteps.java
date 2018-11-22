package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PaypalActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class WishlistTestSteps { 
	
	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	@Steps
	PaypalActor ppUser;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(WishlistTestSteps.class);
	
	@And("^User adds item from cart to wishlist$")
	public void add_item_from_cart_to_wishlist() {
		LOGGER.info("Adding item from cart to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.addCartItemToWishlist();
			break;
		case "TH":
			thUser.addCartItemToWishlist();
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User navigates to wishlist$")
	public void user_navigates_to_wishlist() {
		LOGGER.info("Navigating to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.goToWishlist();
			break;
		case "TH":
			thUser.goToWishlist();
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies wishlist item matches item from cart$")
	public void user_verifies_wishlist_item_matches_cart() {
		LOGGER.info("Verifying wishlist item matches item added from cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyWishlistNameMatchesCart();
			break;
		case "TH":
			thUser.verifyWishlistNameMatchesCart();
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies (.*) item is already in wishlist$")
	public void user_verifies_error_item_already_in_wishlist(String error) {
		LOGGER.info("Verifying error wishlist item already in wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyWishlistError(error);
			break;
		case "TH":
			thUser.verifyWishlistError(error);
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
}