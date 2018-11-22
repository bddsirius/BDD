package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class FooterTestSteps {
	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(FooterTestSteps.class);
	
	
	@Then("^User verifies (.*) exists$")
	public void user_verifies_footernames_exists(String names) {
		LOGGER.info("Verifying footer names exists...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.verifyFooter(names);
                 break;
          case "TH":
                 thUser.verifyFooter(names);
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyFooter(names);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	@Then("^User verifies footer exists$")
	public void user_verifies_footer_exists() {
		LOGGER.info("Verifying footer exists...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.verifyFooter();
                 break;
          case "TH":
                 thUser.verifyFooter();
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyFooter();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	
	@Then("^User verifies header links work$")
	public void user_verifies_header_links_work() {
		LOGGER.info("Verifying header links work...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
        	  ckUser.verifyAllHeaderLinks();
              break;
          case "CKCA": 
        	  	 ckUser.verifyAllHeaderLinksCA();
                 break;
          case "TH":
                 thUser.verifyAllHeaderLinks();
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyAllHeaderLinks();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	@Then("^User verifies footer links go to correct page (.*)")
	public void user_verifies_footer_links_go_to_correct_page(String category) {
		LOGGER.info("User verifies footer links go to correct page for category: "+category+"...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
          case "CKUS":
        	  ckUser.verifyFooterLinksGoToCorrespondingPage(category);
              break;
          case "CKCA": 
        	  ckUser.verifyFooterLinksGoToCorrespondingPageCA(category);	 
                 break;
          case "TH":
              thUser.verifyFooterLinksGoToCorrespondingPage(category);  
                 break;
          case "SPEEDO":
        	  speedoUser.verifyFooterLinksGoToCorrespondingPage(category);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	@Then("^User verifies (.*), (.*), go to correct page$")
	public void user_verifies_header_category_links_work(String dept, String links) {
		LOGGER.info("Verifying Category Links work...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
        	  	ckUser.verifyAllHeaderCategoryLinks(dept, links);
              break;
          case "CKCA": 
        	  	 ckUser.verifyAllHeaderCategoryLinks(dept, links);
                 break;
          case "TH":
                 thUser.verifyAllHeaderCategoryLinks(dept, links);
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyAllHeaderCategoryLinks(dept, links);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	@Then("^User verifies (.*), (.*), breadcrumbs go to correct department page$")
	public void user_verifies_dept_breadcrumb_links_work(String dept, String links) {
		LOGGER.info("Verifying dept breadcrumbs work...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
        	  	ckUser.verifyDeptBreadCrumbLinks(dept, links);
              break;
          case "CKCA": 
        	  	 ckUser.verifyDeptBreadCrumbLinks(dept, links);
                 break;
          case "TH":
                 thUser.verifyDeptBreadCrumbLinks(dept, links);
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyDeptBreadCrumbLinks(dept, links);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	@Then("^User verifies (.*), (.*), pages can go to item pages$")
	public void user_catpages_can_go_to_item_page(String dept, String links) {
		LOGGER.info("Verifying category link pages can go to item page...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
        	  	ckUser.verifyCatPageGoToItemPage(dept, links);
              break;
          case "CKCA": 
        	  	 ckUser.verifyCatPageGoToItemPage(dept, links);
                 break;
          case "TH":
                 thUser.verifyCatPageGoToItemPage(dept, links);
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyDeptBreadCrumbLinks(dept, links);
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	
	

	@Then("^User verifies bag link works$")
	public void user_verifies_bag_link_works() {
		LOGGER.info("Verifying footer names exists...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.verifyBagLink();
                 break;
          case "TH":
                 thUser.verifyBagLink();
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifyBagLink();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
	
	
	
	@Then("^User verifies sign in link works$")
	public void user_verifies_sign_in_link_works() {
		LOGGER.info("Verifying footer names exists...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch(brand.toUpperCase()) {
          case "CKUS":
          case "CKCA": 
        	  	 ckUser.verifySignInLink();
                 break;
          case "TH":
                 thUser.verifySignInLink();
                 break;
          case "SPEEDO":
        	  	 speedoUser.verifySignInLink();
        	  	 break;
          default:
                 LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
          }
	}
}
