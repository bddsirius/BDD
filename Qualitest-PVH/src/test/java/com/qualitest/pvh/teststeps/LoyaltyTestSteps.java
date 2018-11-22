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

public class LoyaltyTestSteps {

	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordTestStep.class);
	
	@Then("^User verifies the member rewards are available$")
	public void user_verifies_the_member_rewards_are_available() {
		LOGGER.info("User verifies the member rewards are available...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	ckUser.verifyRewardsExist();
                 break;
          case "TH":
              
                 break;
          case "SPEEDO":
        	  	 
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	@And("^User selects two awards$")
	public void user_selects_two_awards(String award) {
		LOGGER.info("User selects two awards...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	ckUser.applyTwoAwards();
                 break;
          case "TH":
              
                 break;
          case "SPEEDO":
        	  	 
        	  	break; 
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	@Then("^User verifies that two awards have been applied$")
	public void user_verifies_that_two_awards_have_been_applied() {
		LOGGER.info("User verifies that two awards have been applied...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
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
	
}
