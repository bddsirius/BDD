package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class SearchResultsPage extends BasePage{

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultsPage.class);
	
	protected SoftAssertions SA = new SoftAssertions();
	
	@FindBy(xpath = "//h1[@class='searchTitle']/span[@class='searchCount']")
	private BaseElement searchResultTotalCount;
	
	@FindBy(xpath = "//h1[@class='searchTitle']/span[@class='searchTerm']")
	private BaseElement searchResultTerm;
	
	@FindBy(xpath = "//h1[@class='searchTitle noSearchResults']")
	protected BaseElement noSearchResultMessage;

	@FindBy(xpath = "//*[contains(@class,'column columnLeft')]/div/div/div[contains(@class,'header')]/a/span")
	protected List<WebElement> leftColumnDepartmentList;
	
	@FindBy(xpath = "//div[@class='Search_Result_Summary_Text_Wrapper clearfix']/div[@class='gridTotal']/span[@class='totalCount']")
	private List<WebElement> rightColumnDepartmentTotalList;
	
	@FindBy(xpath = "//*[@class = 'myaccount_header']")
	private BaseElement prohibitedCharacters;
	
	@FindBy(xpath = "//*[@class = 'productImage focusParent']/a")
	protected List<WebElement> productList; 
	
	@FindBy(id="quickView_")
	private List<WebElement> quickViews;
	
	@FindBy(xpath = "//*[@id='navHeader_Collection_Label']")
	protected BaseElement collectionFilterOption;
	
	@FindBy(xpath = "//*[@id='navHeader_Category_Label']")
	protected BaseElement categoryFilterOption;
	
	@FindBy(xpath = "//*[@id='navHeader_Price_Label']")
	protected BaseElement priceFilterOption;
	
	@FindBy(xpath = "//*[@id='navHeader_Color_Label']")
	protected BaseElement colorFilterOption;
	
	@FindBy(xpath = "//*[@id='navHeader_Size_Label']")
	protected BaseElement sizeFilterOption;
	
	@FindBy(xpath = "//*[@id='dk_selected']")
	protected BaseElement sortOption;
	
	@FindBy(xpath = "//*[@id='price_display']/span[contains(@id,'offerPrice')]")
	protected List<WebElement> displayedPrice;
	
	/**
	 * Method to verify if search result header is displayed
	 * @return - true is exists, else false
	 */
	public Boolean verifySearchResultHeaderExists() {
		LOGGER.info("Verifying if search result page displayed");
		if(searchResultTerm.exists()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to verify search term in the search result header
	 * @param searchTerm - Search Term
	 */
	protected void verifySearchTerm(String searchTerm) {
		LOGGER.info("Verifying provided search term: " + searchTerm + " in search result header");
		if(searchTerm.contains("/")) {
			searchTerm = searchTerm.replace("/", "");
		}
		assertThat(searchResultTerm.getText()).as("Search term displayed on the search result header").isEqualToIgnoringCase(searchTerm);
	}
	
	/**
	 * Method to retrieve total search result count from each department
	 * @return - total count of search result from each department
	 */
	private int getTotalSearchResultUsingEachDepartmentTotal() {
		LOGGER.info("Retrieving total search result count using each department total");
		int total = 0;
		for(int i = 0; i< rightColumnDepartmentTotalList.size(); i++) {
			String n = rightColumnDepartmentTotalList.get(i).getText();
			int num = Integer.parseInt(n);
			total += num;
		}
		return total;
	}
	
	/**
	 * Method to verify total search result from each department matches with total count in search result header
	 */
	protected void verifyTotalCount() {
		LOGGER.info("Verifying total count");
		assertThat(getTotalSearchResultUsingEachDepartmentTotal()).as("Search result total count from each department").isEqualTo(Integer.parseInt(searchResultTotalCount.getText()));
	}
	
	/**
	 * Abstract method to verify list of department displayed on left column
	 */
	protected abstract void verifyDepartmentListOnLeftColumn();
	
	/**
	 * Abstract method to verify no search results found message
	 */
	public abstract void verifyNoSearchResultMessage();
	
	/**
	 * Method to verify prohibited characters error message
	 */
	public void verifyProhibitedCharacter() {
		String prohibitedChars = prohibitedCharacters.getText();
		assertThat(prohibitedChars).as("Prohibited characters").isEqualToIgnoringCase("Prohibited Characters Error");
	}
	
	/**
	 * Abstract method to verify search result
	 * @param searchTerm - Search Term
	 */
	public abstract void verifySearchResult(String searchTerm);
	
	
	public void clickOnFirstElement() {
		List<WebElement> elements = getDriver().findElements(By.xpath("//*[@class = 'productImage focusParent']"));
		LOGGER.info("Going through list of elements with similar paths");
		WebElement e = elements.get(0);
		e.click();		
	}
	
	/**
	 * Method to select first product from search result
	 */
	public void selectFirstProduct() {
		if(productList.size() == 0) {
			return;
		}
		WebElement w = productList.get(0);
		LOGGER.info("Clicking first product: " + w.getAttribute("title") + " from search result ");
		w.click();
	}
	
	/**
	 * Method to select first product from search result
	 */
	public void selectProduct(int num) {
		if(productList.size() == 0) {
			return;
		}
		WebElement w = productList.get(num-1);
		LOGGER.info("Clicking product: " + w.getAttribute("title") + " from search result ");
		w.click();
	}
	
	public void goToFirstProductQuickViewPage() {
		LOGGER.info("Hovering over webelement");
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#quickView_"));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		quickViews.get(0).click();
	}
	
	/**
	 * Method to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home / Sale
	 */
	public void selectDepartmentFromLeftNavigationBar(String department) {
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText().trim();
			if(text.equalsIgnoreCase(department)) {
				LOGGER.info("Clicking department " + department + " link");
				leftColumnDepartmentList.get(i).click();
				break;
			} else {
				continue;
			}
		}
	}
	
	/**
	 * Method to verify provide option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */
	public void verifyOption(String option) {
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			SA.assertThat(collectionFilterOption.isDisplayed()).as("Collection Filter Option").isTrue();
			SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
			SA.assertThat(colorFilterOption.isDisplayed()).as("Color Filter Option").isTrue();
			SA.assertThat(sizeFilterOption.isDisplayed()).as("Size Filter Option").isTrue();
		} else if(option.equalsIgnoreCase("SORT")) {
			LOGGER.info("Verifying sort option");
			SA.assertThat(sortOption.isDisplayed()).as("Sort Option").isTrue();
		}
		SA.assertAll();
	}
	
	/**
	 * Abstract method to filter search product list based on provided price range
	 * @param price - Price Range e.g.: $0 - $25 / $25 - $50 / $300+
	 */
	public abstract void filterSearchResultUsingPriceRange(String price);
	
	/**
	 * Abstract method to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / green / neutral / ivory / red / white
	 */
	public abstract void filterSearchResultUsingColor(String color);
	
	/**
	 * Method to filter search product list using provided size
	 * @param size - Size e.g.: s / m / l / xl / xxl / 4xl
	 */
	public abstract void filterSearchResultUsingSize(String size);
	
	/**
	 * Method to verify price of filtered product list is within provided price range
	 * @param priceRange - Price Range e.g.: $0 - $25
	 */
	public void verifyFilteredProductPrice(String priceRange) {	
		String[] price = priceRange.trim().split("-");
		int lowerLimit = Integer.parseInt(price[0].replace("$", "").trim());
		int upperLimit = Integer.parseInt(price[1].replace("$", "").trim());
		
		if(displayedPrice.size()>0) {
			for(int i=0; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("$", "").split("-")[0]));
				LOGGER.info("Verifying displayed price of products: " + dprice + " is between " + lowerLimit + " and " + upperLimit);
				SA.assertThat((lowerLimit <= dprice) && (dprice <= upperLimit)).as("Displayed Price: " + dprice + " is within range: " + priceRange).isTrue();
			}
			SA.assertAll();
		}
	}
	
	/**
	 * Method to verify search product list is filtered using provided option
	 * @param option - Option e.g.: black / blue / 
	 */
	public void verifyProductListIsFilteredUsing(String option) {
		pageRefresh();
		String filteredOption = "//div[@class='filterName filterListItem']/span[text()='" + option.toUpperCase() + "']";
		LOGGER.info(filteredOption);
		assertThat(find(By.xpath(filteredOption)).isVisible()).as("Product List is filtered using " + option + " option").isTrue();
	}
	
	/**
	 * Method to sort searched product list using provide price
	 * @param price - Price e.g.: Price Low to High / Price High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		
		//clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking sort option");
		sortOption.withTimeoutOf(5, TimeUnit.SECONDS).waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + price + " sort option");
			String sortOption = "//a[text()='" + price + "']";
			find(By.xpath(sortOption)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Sort option: " + price + " is not available");
		}
		
	}
	
	/**
	 * Method to verify product price in search result is sorted based on provided price option
	 * @param priceRange - Price option e.g.: Price Low to High / Price High to Low
	 */
	public void verifyProductListIsSorted(String priceRange) {
		
		pageRefresh();
		
		boolean result = true;
		
		if(displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price Low To High")) {
			int previous = Math.round(Float.parseFloat(displayedPrice.get(0).getText().replace("$", "").split("-")[0]));
			
			for(int i=1; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("$", "").split("-")[0]));
				LOGGER.info("Verifying Price: " + previous + " is less than or equal to Price: " + dprice);
				if(previous > dprice) {
					result = false;
					break;
				}
				previous = dprice;
			}
			
			assertThat(result).as("Product List is sorted in ascending order").isTrue();
			
		} else if (displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price High To Low")) {
			int previous = Math.round(Float.parseFloat(displayedPrice.get(0).getText().replace("$", "").split("-")[0]));
			
			for(int i=1; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("$", "").split("-")[0]));
				LOGGER.info("Verifying Price: " + previous + " is greater than or equal to Price: " + dprice);
				if(previous < dprice) {
					result = false;
					break;
				}
				previous = dprice;
			}
			
			assertThat(result).as("Product List is sorted in descending order").isTrue();
			
		} else {
			LOGGER.info("Incorrect sort Option: " + priceRange + " provided");
			
		}
		
	}
	
}
