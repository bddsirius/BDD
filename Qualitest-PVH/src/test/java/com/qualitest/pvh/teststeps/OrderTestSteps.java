package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PaypalActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;


public class OrderTestSteps {
	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;

	@Steps
	PaypalActor ppUser;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(OrderTestSteps.class);
	
	
	@Then("^User cancels order and verifys$")
	public void guest_user_cancels_and_verifies_order() {
		LOGGER.info("Verifying order cancellation as guest user...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyOrderCancellation(); 
			break;
		case "CKCA":
			ckUser.verifyOrderCancellation(); 
			break;
		case "TH":
			thUser.verifyOrderCancellation();
			break;
		case "SPEEDO":
			speedoUser.verifyOrderCancellation();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User clicks edit from order summary page$")
	public void user_clicks_edit_from_review_order_page() {
		LOGGER.info("User clicks edit from review order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.clickSubmitOrder();
			ckUser.editOrderFromOrderSummary();
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
		
	}
	
	@When("^User edits from checkout and continues to review order page$")
	public void user_edits_from_checkout_and_continues_to_review_order_page() {
		LOGGER.info("User edits from checkout and continues to review order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.clickEditItemFromCartForFirst();
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies order edit occured in review order page$")
	public void user_verifies_order_edit_occured_in_review_order_page() {
		LOGGER.info("User verifies order edit occured in review order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			
			break;
		case "CKCA":
			
			break;
		case "TH":
			
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
		
	}
	
	
	
	@Then("^User navigates to my orders$")
	public void User_navigates_to_myOrders() {
		LOGGER.info("Verifying order cancellation as guest user...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.navigateToMyOrders(); 
			break;
		case "CKCA":
			//ckUser.verifyOrderPending(); 
			break;
		case "TH":
			thUser.navigateToMyOrders();
			break;
		case "SPEEDO":
			speedoUser.navigateToMyOrders();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
		
	@Then("^User confirms (.*) is there and (.*) is correct$")
	public void User_confirms_order_exists_and_status_correct(String orderNum, String Status) {
		LOGGER.info("Verifying order and status...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyOrderPending(orderNum, Status); 
			break;
		case "CKCA":
			//ckUser.verifyOrderPending(); 
			break;
		case "TH":
			thUser.verifyOrderPending(orderNum, Status);
			break;
		case "SPEEDO":
			speedoUser.verifyOrderPending(orderNum, Status); 
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	@Then("^User navigates to guest orders and searches (.*) (.*)$")
	public void User_navigates_to_guestorder_searches(String orderNum, String email) {
		LOGGER.info("Verifying order and status...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.guestUserGetOrderStatus(orderNum, email); 
			break;
		case "CKCA":
			//ckUser.verifyOrderPending(); 
			break;
		case "TH":
			thUser.guestUserGetOrderStatus(orderNum, email); 
			break;
		case "SPEEDO":
			speedoUser.guestUserGetOrderStatus(orderNum, email); 
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	
	 @Then("^Guest user confirms that (.*) is there and (.*) is correct$")
		public void User_confirms_guest_order_status(String orderNum, String status) {
			LOGGER.info("Verifying order and status...");
			String brand = Serenity.sessionVariableCalled("brand");

			switch (brand.toUpperCase()) {
			case "CKUS":
				ckUser.guestUserVerifyStatus(orderNum, status); 
				break;
			case "CKCA":
				//ckUser.verifyOrderPending(); 
				break;
			case "TH":
				thUser.guestUserVerifyStatus(orderNum, status);
				break;
			case "SPEEDO":
				speedoUser.guestUserVerifyStatus(orderNum, status);
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
			}
		}
}
