package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class SearchTestSteps {

	public static final Logger LOGGER = LoggerFactory.getLogger(SearchTestSteps.class);

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;

	@When("^User searches for (.*)$")
	public void user_searches_for(String search) {
		LOGGER.info("Searching product with search keyword: " + search + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.searchFor(search);
			break;
		case "TH":
			thUser.searchFor(search);
			break;
		case "SPEEDO":
			speedoUser.searchFor(search);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@Then("^User should see results for (.*)$")
	public void user_should_see_search_result_for(String searchTerm) {
		LOGGER.info("Verifying search result...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySearchResults(searchTerm);
			break;
		case "TH":
			thUser.verifySearchResults(searchTerm);
			break;
		case "SPEEDO":
			speedoUser.verifySearchResults(searchTerm);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@Then("^User should see (.*) product details")
	public void user_should_see_product_details(String styleNumber) {
		LOGGER.info("Verifying search result for style number: " + styleNumber + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		case "TH":
			thUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		case "SPEEDO":
			speedoUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}
	
	@Then("^User should see no search results message$")
	public void user_should_see_no_search_result_message() {
		LOGGER.info("Verifying no search result message...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyNoResults();
			break;
		case "TH":
			thUser.verifyNoResults();
			break;
		case "SPEEDO":
			speedoUser.verifyNoResults();
		}
	}

	@Then("^User should have items displayed related to item$")
	public void user_should_have_an_item_displayed_related_to() {
		LOGGER.info("User is verifying if items are being displayed related to the query...");
		String brand = Serenity.sessionVariableCalled("brand");
		String search = Serenity.sessionVariableCalled("search");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyStyleID(search);
			break;
		case "CKCA":
			ckUser.verifyStyleID(search);
			break;
		case "TH":
			thUser.verifyStyleID(search);
			break;
		case "SPEEDO":
			speedoUser.verifyStyleID(search);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@Then("^User should remain on home page$")
	public void user_should_remain_on_home_page() {
		LOGGER.info("Verifying search is not initiated and home page is displayed...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyCKUSHomePage();
			break;
		case "CKCA":
			ckUser.verifyCKCAHomePage();
			break;
		case "TH":
			thUser.verifyTHHomePage();
			break;
		case "SPEEDO":
			speedoUser.verifySpeedoHomePage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@When("^User inputs search (.*)$")
	public void user_inputs_search(String text) {
		LOGGER.info("Entering search term...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.search(text);
			break;
		case "TH":
			thUser.search(text);
			break;
		case "SPEEDO":
			speedoUser.search(text);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User should see search suggestions related to (.*)$")
	public void user_should_see_search_suggestions_related_to(String searchTerm) {
		LOGGER.info("Verifying search suggestions...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySearchSuggestion(searchTerm);
			break;
		case "TH":
			thUser.verifySearchSuggestion(searchTerm);
			break;
		case "SPEEDO":
			speedoUser.verifySearchSuggestion(searchTerm);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}

	}

	@And("^User is not signed in$")
	public void user_is_not_signed_in() {
		LOGGER.info("Verifying user is guest user...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyUserIsNotSignedIn();
			break;
		case "TH":
			thUser.verifyUserIsNotSignedIn();
			break;
		case "SPEEDO":
			speedoUser.verifyUserIsNotSignedIn();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User should get prohibited characters error$")
	public void user_gets_prohibited_character_error() {
		LOGGER.info("Verifying prohibited characters message...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyProhibitedCharacters();
			break;
		case "TH":
			thUser.verifyProhibitedCharacters();
			break;
		case "SPEEDO":
			speedoUser.verifyProhibitedCharacters();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User goes to cart$")
	public void user_goes_to_cart() {
		LOGGER.info("Navigating to cart...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.goToCartFromHome();
			break;
		case "TH":
			thUser.goToCartFromHome();
			break;
		case "SPEEDO":
			speedoUser.goToCartFromHome();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User clicks on product$")
	public void user_goes_to_product_details_page() {
		LOGGER.info("Navigating to product details page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.clickFirstProduct();
			break;
		case "TH":
			thUser.clickFirstProduct();
			break;
		case "SPEEDO":
			speedoUser.clickFirstProduct();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User select (.*) from search result")
	public void user_select_department_from_search_result(String department) {
		LOGGER.info("Selecting department " + department + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.selectDepartment(department);
			break;
		case "TH":
			thUser.selectDepartment(department);
			break;
		case "SPEEDO":
			speedoUser.selectDepartment(department);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("User should see option to \"(.*)\" product list")
	public void user_should_see_option_to_filter_product_list(String option) {
		LOGGER.info("Verifying option to " + option + " product list is displayed...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyOptionIsDisplayed(option);
			break;
		case "TH":
			thUser.verifyOptionIsDisplayed(option);
			break;
		case "SPEEDO":
			speedoUser.verifyOptionIsDisplayed(option);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User filter product using price range (.*)")
	public void user_filter_product_using_priceRange(String price) {
		LOGGER.info("Filtering product list using Price Range: " + price + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingPriceRange(price);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingPriceRange(price);
			break;
		case "TH":
			thUser.filterSearchResultUsingPriceRange(price);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingPriceRange(price);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("User should see products within price range (.*)")
	public void user_should_see_product_within_priceRange(String priceRange) {
		LOGGER.info("Verifying filtered product list is within price range: " + priceRange + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		case "CKCA":
			ckUser.verifyCKCAPriceOfProductsInFilteredList(priceRange);
			break;
		case "TH":
			thUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		case "SPEEDO":
			speedoUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("User filter product using color (.*)")
	public void user_filter_product_using_color(String color) {
		LOGGER.info("Filtering product list using Color: " + color + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingColor(color);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingColor(color);
			break;
		case "TH":
			thUser.filterSearchResultUsingColor(color);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingColor(color);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User filter product using size (.*)")
	public void user_filter_product_using_size(String size) {
		LOGGER.info("Filtering product list using Size: " + size + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingSize(size);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingSize(size);
			break;
		case "TH":
			thUser.filterSearchResultUsingSize(size);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingSize(size);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User filter product using category (.*)")
	public void user_filter_product_using_category(String category) {
		LOGGER.info("Filtering product list using Category: " + category + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingCategory(category);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingCategory(category);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingCategory(category);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("User should see products list filtered using (.*)")
	public void user_should_see_product_list_filtered_using(String option) {
		LOGGER.info("Verifying product list is filtered using: " + option + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyProductsListIsFiltered(option);
			break;
		case "TH":
			thUser.verifyProductsListIsFiltered(option);
			break;
		case "SPEEDO":
			speedoUser.verifyProductsListIsFiltered(option);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("User sort product using price (.*)")
	public void user_sort_product_using_price(String price) {
		LOGGER.info("Sorting product list using Price: " + price + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.sortSearchResultUsingPrice(price);
			break;
		case "CKCA":
			ckUser.sortCKCASearchResultUsingPrice(price);
			break;
		case "TH":
			thUser.sortSearchResultUsingPrice(price);
			break;
		case "SPEEDO":
			speedoUser.sortSearchResultUsingPrice(price);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("User should see product list sorted based on (.*)")
	public void user_should_see_product_list_sorted(String priceRange) {
		LOGGER.info("Verifying sorted product list based on: " + priceRange + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifySortedProductList(priceRange);
			break;
		case "CKCA":
			ckUser.verifyCKCASortedProductList(priceRange);
			break;
		case "TH":
			thUser.verifySortedProductList(priceRange);
			break;
		case "SPEEDO":
			speedoUser.verifySortedProductList(priceRange);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
}
