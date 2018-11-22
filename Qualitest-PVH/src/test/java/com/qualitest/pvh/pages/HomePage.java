package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;
import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePage extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	protected SoftAssertions SA = new SoftAssertions();
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	protected BaseElement popUpClose;
	
	@FindBy(xpath="(//img[@alt='Close Dialog'])[2]")
	private BaseElement popUpTwoClose;
	
	@FindBy(xpath = "//a[@title='Go to the Sign In page']")
	private BaseElement signIn;

	@FindBy(xpath = "//*[@id='CatalogSearchForm']/div[@class='searchInputWrapper clearfix']/a")
	private BaseElement searchButton;

	@FindBy(xpath = "//*[@id = 'SimpleSearchForm_SearchTerm']")
	private BaseElement searchInput;

	@FindBy(xpath = "//*[@id= 'mini_cart_link']")
	private BaseElement cart;

	@FindBy(xpath = "//*[@class = 'autoSuggestDivNestedList clearfix']/li/a/span")
	private List<WebElement> searchSuggestionList;

	@FindBy(xpath = "//*[@id = 'WC_MiniShopCartDisplay_link_3']")
	private BaseElement editCart;

	@FindBy(xpath = "//a[text()='Store Locator']")
	private BaseElement storeLocator;
	
	/**
	 * Method to click store locator link from footer
	 */
	public void clickStoreLocator() {
		LOGGER.info("Clicking Store Locator link from footer");
		storeLocator.click();
	}

	/**
	 * Abstract method to launch provided url
	 * 
	 * @param url - URL
	 */
	public abstract void navigateTo(String url);

	public abstract void verifyCongratsPopUpSignUp();
	
	/**
	 * Method to close pop up
	 */
	public void clickOffPopUp() {
		if (popUpClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpClose.click();
		}
	}
	
	/**
	 * Helper Method to verify header links
	 */
	public void verifyHeaderLink(WebElement link, String linkTxt, BaseElement categoryLink)
	{
		
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			clickOffPopUp();
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			link.click();
			String catTxt = categoryLink.getAttribute("className").toUpperCase();
			LOGGER.info("Checking Department Link : " + linkTxt + " Against :" + catTxt);
			LOGGER.info("value " + catTxt.contains(linkTxt));
			SA.assertThat(catTxt).contains(linkTxt);
			//assertThat(false).isTrue();
			//SA.assertAll();
			getDriver().navigate().back();
			//SA.assertThat(footerLinks.get(i).getText().isEmpty() == false);
	}
	
	public void assertALL()
	{
		SA.assertAll();
	}
	
	/**
	 * Helper method to clean up searching each list of links in the footer
	 * @param tempList
	 */
			public void CheckFooterText(List<WebElement> tempList)
			{

				SA.assertThat(tempList.isEmpty() == false);
				//Runs thru the list of elements in the footer checks if theyre text isnt empty 
				for(int i = 0;i < tempList.size(); i++)
				{
					LOGGER.info("Checking Text of Link : " + tempList.get(i).getText());
					SA.assertThat(tempList.get(i).getText().isEmpty() == false);
						
				}
			}
			
			
			
			/**
			*Helper method to clean up searching each list of links in the footer
			*/
			public void ClickFooterLinks(List<WebElement> tempList)
			{
				int temp = 0;
				//Handles unique case where speedo has a value in its link which is not a link
				if(tempList.get(0).getText().equalsIgnoreCase( "Call 1-888-4SPEEDO"))
				{
					temp++;
				}
				for(int x = temp;x < tempList.size(); x++)
				{
					
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					LOGGER.info("Checking Link : " + tempList.get(x).getText());
					clickOffPopUp();
					
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempList.get(x).click();
					//*********Should somehow check here if link brings to proper page
					getDriver().navigate().back();
					//SA.assertThat(footerLinks.get(i).getText().isEmpty() == false);
					
				} 
				
			}
			
			/**
			*Helper method to clean up searching each list of links in the footer
			*/
	
	protected int randomInt() {
		int i = (int)(Math.random() * ((1000 - 1) + 1)) + 1;
		LOGGER.info("Getting a random number of: "+i);
		return i;
	}
			
	public void clickOffPopUpTwo() {
		if (popUpTwoClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpTwoClose.click();
		}
	}
	
	/**
	 * Method to click signIn/Register link
	 */
	public void clickSignInRegister() {
		LOGGER.info("Click SignIn / Register link");
		try {
			signIn.click();
		} catch (Exception e) {
			LOGGER.info("Sign in button was not visible so refreshing page");
			pageRefresh();
			signIn.click();
		}
		clickOffPopUp();
	}

	/**
	 * Abstract method to verify home page title
	 */
	public abstract void verifyPageTitle();

	/**
	 * Method to click on search button
	 */
	private void clickSearch() {
		LOGGER.info("Clicking search button");
		sleep(1000);
		searchButton.click();
	}

	/**
	 * Method to enter search term in search field
	 * 
	 * @param searchTerm - search term
	 */
	public void enterSearchTerm(String searchTerm) {
		clickSearch();
		LOGGER.info("Entering search term: " + searchTerm);
		searchInput.type(searchTerm);
	}

	/**
	 * Method to click on cart from header
	 */
	public void clickCart() {
		LOGGER.info("Clicking cart from header");
		if (editCart.exists()) {
			editCart.click();
		} else {
			cart.click();
		}
	}
	

	/**
	 * Method to enter search term and perform search
	 * 
	 * @param item - search term
	 */
	public void submitSearchFor(String item) {
		enterSearchTerm(item);
		clickSearch();
	}

	/**
	 * Method to verify user is not signed in
	 */
	public void verifyUserIsNotSignedIn() {
		assertThat(signIn.exists()).as("User is not Signned in").isTrue();
	}
	
	/**
	 * Method to verify search suggestions displayed matches provided search term
	 * @param searchTerm - Search Term
	 */
	public void verifySearchSuggestions(String searchTerm) {
		for (WebElement w : searchSuggestionList) {
			String s = w.getText();
			LOGGER.info("Verifying suggestion: " + s);
			SA.assertThat(s).as("Search Suggestion").contains(searchTerm);
		}
		SA.assertAll();
	}
	
	protected boolean pageTitleOrLinkContainsWord(String word) {
		String url = getDriver().getCurrentUrl();
		String title = getDriver().getTitle();
		
		url = url.replaceAll("-", "");
		url = url.toLowerCase();
		title = title.toLowerCase();
		title = title.replaceAll(" ", "");
		title = title.replaceAll("'", "");
		title = title.replaceAll("-", "");
		String noSpacesWord = word.replaceAll(" ", "");
		noSpacesWord = noSpacesWord.toLowerCase();
		noSpacesWord = noSpacesWord.replaceAll("'", "");
		LOGGER.info("Getting the page URL: "+url);
		LOGGER.info("Getting the page title: "+title);
		LOGGER.info("Word with no spaces is: "+noSpacesWord);
		if(url.contains(noSpacesWord) || title.contains(noSpacesWord)) {
			LOGGER.info("Returning true");
			return true;
		}else {
			LOGGER.info("Returning false");
			return false;
		}
		
	}
	
	public abstract void verifyNoEmailUnSuccessfulPopUp();

	
	public int CheckFooterTextWithNames(List<WebElement> tempList, String Names, int q)
	{

		String[] arr = Names.split(";");
		int temp = 0;;
		SA.assertThat(tempList.isEmpty() == false);
		//Runs thru the list of elements in the footer checks if theyre text isnt empty 
		for(int i = 0;i < tempList.size(); i++)
		{
			//if(arr.length <= i+q)
			//{
				temp = i;
				LOGGER.info("Checking Text of Link : " + tempList.get(i).getText().toLowerCase());
				LOGGER.info("Against Given Link    : " + arr[i+	q]);
				SA.assertThat(tempList.get(i).getText().toLowerCase().contentEquals(arr[i+q])).isTrue();
			//}
		}
		SA.assertAll();
		return q+temp+1;
	}
	
	
	public void clickCartSimple() {
		LOGGER.info("Clicking cart from header");

			cart.click();
	} 
}