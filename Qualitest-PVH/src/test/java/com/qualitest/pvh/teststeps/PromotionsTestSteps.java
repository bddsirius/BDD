
package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class PromotionsTestSteps {

	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordTestStep.class);
	
	@Then("^User verifies promo should be added (.*)$")
	public void user_navigate_to_forgot_password(String code) {
		LOGGER.info("User verifies promo should be added "+code+"...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	
                 break;
          case "TH":
              thUser.verifyPromoApplied(code);
                 break;
          case "SPEEDO":
        	  	 
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	@Then("^User verifies removal of promo$")
	public void user_verifies_removal_of_promo() {
		LOGGER.info("User verifies removal of promo...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	
                 break;
          case "TH":
        	  	thUser.verifyRemovalOfPromoCodes();
        	  	 break;
          case "SPEEDO":
        	  	 
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	@Then("^User should verify valid promo code is not applicable for item$")
	public void user_should_verify_valid_promo_code_is_not_applicable_for_item() {
		LOGGER.info("Then User should verify valid promo code is not applicable for item...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	ckUser.verifyValidPromoWrongRequirement();
                 break;
          case "TH":
        	  	thUser.verifyValidPromoWrongRequirement();
        	  	 break;
          case "SPEEDO":
        	  	speedoUser.verifyValidPromoWrongRequirement();
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	@Then("^User should verify valid promo code (.*) is applicable for one item$")
	public void user_should_verify_valid_promo_code_is_applicable_for_one_item(String code) {
		LOGGER.info("User should verify valid promo code is applicable for one item...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	ckUser.verifyValidPromoForFirstItem(code);
                 break;
          case "TH":
        	  	thUser.verifyValidPromoForFirstItem(code);
        	  	 break;
          case "SPEEDO":
        	  	speedoUser.verifyValidPromoForFirstItem(code);
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          } 
	}
	
	@And("^User removes promo code$")
	public void user_removes_promo_code() {
		LOGGER.info("User removes promo code...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  ckUser.removePromoCode();
                 break;
          case "TH":
        	  thUser.removePromoCode();
        	  	 break;
          case "SPEEDO":
        	  speedoUser.removePromoCode();
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          } 
	}
	
	@Then("^User verifies promo code added for multiple items (.*)$")
	public void user_verifies_promo_should_be_added_for_multiple_items(String code) {
		LOGGER.info("User verifies promo should be added for multiple items...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  ckUser.verifyValidPromoForMulitpleItems(code);
                 break;
          case "TH":
        	  thUser.verifyValidPromoForMulitpleItems(code);
        	  	 break;
          case "SPEEDO":
        	  speedoUser.verifyValidPromoForMulitpleItems(code);
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          } 
	}
	
	@Then("^User verifies that removing promo code removes discount (.*)$")
	public void user_verifies_that_removing_promo_code_removes_discount(String code) {
		LOGGER.info("User verifies that removing promo code removes discount...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  ckUser.verifyNoPromoApplied(code);
                 break;
          case "TH":
        	  thUser.verifyNoPromoApplied(code);
        	  	 break;
          case "SPEEDO":
        	  speedoUser.verifyNoPromoApplied(code);
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          } 
		
	}
}

	