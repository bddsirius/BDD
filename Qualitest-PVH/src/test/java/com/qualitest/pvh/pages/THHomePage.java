package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://th-b2cna-pq1.pvh.com/en")
public class THHomePage extends HomePage {
	
	@FindBy( id = "breadcrumb")
	private BaseElement breadCrumb;
	
	@FindBy(xpath = "//*[@id='breadcrumb']/a[2]")
	private BaseElement deptBreadCrumb;
	
	@FindBy(xpath = "//*[@class = 'productImage focusParent']/a")
	protected List<WebElement> productList;
	
	@FindBy(xpath = "//*[@id = 'WOMEN_EX']//*[@class = 'mega-menu pull-left masonry-brick']/li/a")
	private List<WebElement> thWomensList;

	@FindBy(xpath = "//*[@id = 'MEN_EX']//*[@class = 'mega-menu pull-left masonry-brick']/li/a")
	private List<WebElement> thMensList;
	@FindBy(xpath = "//*[@id = 'MS_KIDS_EX']//*[@class = 'mega-menu pull-left masonry-brick']/li/a")
	private List<WebElement> thKidsList;
	@FindBy(xpath = "//*[@id = 'TOMMY_NOW_EX']//*[@class = 'mega-menu pull-left masonry-brick']/li/a")
	private List<WebElement> thTNowList;
	@FindBy(xpath = "//*[@id = 'TOMMY_JEANS_EX']//*[@class = 'mega-menu pull-left masonry-brick']/li/a")
	private List<WebElement> thTJeansList;
	@FindBy(xpath = "//*[@id = 'ADP_CONTENT_EX']//*[@class = 'mega-menu pull-left masonry-brick']/li/a")
	private List<WebElement> thTAdpList;
	@FindBy(xpath = "//*[@id = 'SALE_EX']//*[@class = 'mega-menu pull-left masonry-brick']/li/a")
	private List<WebElement> thSaleList;
	
	@FindBy(xpath = "//*[@id='ck_kids_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckKidsList;
	
	@FindBy(xpath = "//*[@id='ck_underwear']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckUnderwearList;

	@FindBy(xpath = "//*[@id = 'footerSectionWrapper']//div[@class = 'column']/a")
	private List<WebElement> allFooterLinks;
	
	@FindBy(xpath = "//*[@id = 'footerMiddle']//a")
	private List<WebElement> allFooterBottomLinks;
	
	@FindBy(xpath = "//*[@id='my_account_link']")
	private BaseElement myAcc;
	
	@FindBy(xpath = "//*[@id='footerTop']/div/div[1]/a")
	private List<WebElement> footerSection1;
	
	@FindBy(xpath = "//*[@id='footerTop']/div/div[2]/a")
	private List<WebElement> footerSection2;
	
	@FindBy(xpath = "//*[@id='footerTop']/div/div[3]/a")
	private List<WebElement> footerSection3;
	
	@FindBy(xpath = "//*[@id='headerNavList']/nav/div")
	private List<WebElement> HeaderDeptList;
	
	@FindBy(xpath = "//*[@id = 'signUpEmail']")
	private BaseElement signUpEmailInput;
	
	@FindBy(xpath = "//*[@id = 'subscribeNewsletter']")
	private BaseElement signUpButton;
	
	@FindBy(xpath = "//*[@id = 'WC_NewsletterSignup_Overlay']")
	private BaseElement signUpAgree;
	
	@FindBy(xpath = "//div[@id = 'signUpSuccess']")
	private BaseElement popUpThankYou;
	
	@FindBy(xpath = "//*[@id = 'nlCongrats']")
	private BaseElement popUpThankYou2;
	
	@FindBy(xpath = "//*[@id = 'capture_input']/div[@id = 'signUpError']")
	private BaseElement signUpError;
	
	@FindBy(css = "a.storeLocator")
	private BaseElement storeLocator;

	@FindBy(id = "my_account_link")
	private BaseElement goToMyAccount;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THHomePage.class);

	private CurrentPage currentPage;
	
	/**
	 * Method to click store locator link from footer
	 */
	public void clickStoreLocator() {
		LOGGER.info("Clicking Store Locator link from footer");
		storeLocator.click();
	}
	
	@Override
	/**
	 * Method to launch Tommy Hilfiger website
	 */
	public void navigateTo(String thURL) {
		LOGGER.info("Navigating to Tommy Hilfiger website");
		getDriver().get(thURL);
	}

	@Override
	/**
	 * Method to verify Tommy Hilfiger home page title
	 */
	public void verifyPageTitle() {
		assertThat(currentPage.getTitle()).as("Tommy Hilfiger Home Page Title")
				.isEqualTo("Tommy Hilfiger | Official Site and Online Store");
	}
	
	public void verifyAllHeaderLinks()
	{
		for(int i = 0; i < HeaderDeptList.size(); i++)
		{
			LOGGER.info("Checking Department Link : " + HeaderDeptList.get(i).getText());
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
			HeaderDeptList.get(i).click();
			String pageTitle = getDriver().getTitle().toLowerCase();
			SA.assertThat(pageTitle.contains(HeaderDeptList.get(i).getText().toLowerCase()));
			
			
			getDriver().navigate().back();
		}
		SA.assertAll();
		
	}

	public void goToMyAccountPage() {
		goToMyAccount.click();
	}
	
	/**
	 * Method to verify footer and links exist
	 */
	public void verifyFooterExists()
	{
		LOGGER.info("Verifying Footer is Displayed");
		//calls method to check if text is displayed
		CheckFooterText(footerSection1);
		CheckFooterText(footerSection2);
		CheckFooterText(footerSection3);
	
		//calling method to make sure links go
		ClickFooterLinks(footerSection1);
		ClickFooterLinks(footerSection2);
		ClickFooterLinks(footerSection3);
	
		
		
		SA.assertAll();
		
	}
	
	public void capturePopUp() {
		LOGGER.info("Starting the look for a pop up");
		if(popUpClose.isVisible()) {
			LOGGER.info("The pop up is visible");
			return;
		}else {
			for(int i = 0; i < HeaderDeptList.size(); i++) {
				WebElement w = HeaderDeptList.get(i);
				String name = w.findElement(By.xpath(".//a")).getText();
				LOGGER.info("Clicking the department: "+name);
				w.findElement(By.xpath(".//a")).click();
				if(popUpClose.isVisible()) {
					LOGGER.info("Pop up located");
					break;
				}
				getDriver().navigate().back();
				LOGGER.info("Going back to the home page");
				if(popUpClose.isVisible()) {
					LOGGER.info("Pop up located");
					break;
				}
				pageRefresh();
				if(popUpClose.isVisible()) {
					LOGGER.info("Pop up located");
					break;
				}
			}
		}
		LOGGER.info("Could not find Pop up");
	}
	
	private void enterSignUpEmail(String email) {
		LOGGER.info("Inputting the email: "+email+ " into the sign up");
		signUpEmailInput.click();
		sleep(1000);
		signUpEmailInput.type(email);
	}
	
	public void clickSignUpPopUp() {
		LOGGER.info("Clicking the Sign up button for the pop up");
		signUpButton.click();
	}
	
	private void clickAgreement() {
		LOGGER.info("Clicking the agree to terms ");
		signUpAgree.click();
	}
	
	public void enterAndSubmitSignUpPopUp(String email) {
		String i = String.valueOf(randomInt());
		enterSignUpEmail(i+email);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickAgreement();
		clickSignUpPopUp();
	}
	public void enterAndSubmitSignUpPopUpWithoutRandomAddition(String email) {
		enterSignUpEmail(email);
		sleep(2000);
		clickAgreement();
		clickSignUpPopUp();
	}
	public void verifyCongratsPopUpSignUp() {
		sleep(2000);
		boolean isTrue = popUpThankYou.isVisible();
		assertThat(isTrue).as("Congrats pop up exists").isTrue();
	}
	public void verifyCongratsPopUpSignUpAtStart() {
		sleep(2000);
		boolean isTrue = popUpThankYou2.isVisible();
		assertThat(isTrue).as("Congrats pop up exists").isTrue();
	}

	private String getSignUpErrorMessage() {
		if(signUpError.exists()) {
			String s = signUpError.getText();
			LOGGER.info("Field Error Message is: "+s);
			return s;
		}else {
			LOGGER.info("There is no field error message");
			return "";
		}
	}
	@Override
	public void verifyNoEmailUnSuccessfulPopUp() {
		assertThat(getSignUpErrorMessage()).as("Error Exists").isEqualToIgnoringCase("Please enter a valid email address.");
	}
	public void goToMyAccount() {
		// TODO Auto-generated method stub
		myAcc.click();
	}

	
	

	public void verifyFooterNamesExists(String names)
	{
		int curPos = 0;
		LOGGER.info("Verifying Footer Names Are Displayed");
		//calls method to check if text is displayed
		curPos = CheckFooterTextWithNames(footerSection1,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection2,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection3,names,curPos);
		
		
	}
	
	
	
public void verifyAllHeaderCategoryLinks(String dept, String links) {
		

		if(dept.equalsIgnoreCase("women"))
		{
			verifyHeaderCategoryLinks("//*[@id='WOMEN_EX']/a",  thWomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyHeaderCategoryLinks("//*[@id='MEN_EX']/a",  thMensList, links);
		}
		else if(dept.equalsIgnoreCase("kids"))
		{
			verifyHeaderCategoryLinks("//*[@id='MS_KIDS_EX']/a",  thKidsList, links);
		}
		else if(dept.equalsIgnoreCase("tommynow"))
		{
			verifyHeaderCategoryLinks("//*[@id='TOMMY_NOW_EX']/a",  thTNowList, links);	
		}
		else if(dept.equalsIgnoreCase("tommy jeans"))
		{
			verifyHeaderCategoryLinks("//*[@id='TOMMY_JEANS_EX']/a", thTJeansList, links);	
		}
		else if(dept.equalsIgnoreCase("tommy adaptive"))
		{
			verifyHeaderCategoryLinks("//*[@id='ADP_CONTENT_EX']/a",  thTAdpList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyHeaderCategoryLinks("//*[@id='SALE_EX']/a",  thSaleList, links);
		}
		
	
	}

	
	public void verifyAllDeptBreadCrumbLinks(String dept, String links) {
		
		
		if(dept.equalsIgnoreCase("women"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='WOMEN_EX']/a",  thWomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='MEN_EX']/a",  thMensList, links);
		}
		else if(dept.equalsIgnoreCase("kids"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='MS_KIDS_EX']/a",  thKidsList, links);
		}
		else if(dept.equalsIgnoreCase("tommynow"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='TOMMY_NOW_EX']/a",  thTNowList, links);	
		}
		else if(dept.equalsIgnoreCase("tommy jeans"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='TOMMY_JEANS_EX']/a", thTJeansList, links);	
		}
		else if(dept.equalsIgnoreCase("tommy adaptive"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ADP_CONTENT_EX']/a",  thTAdpList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='SALE_EX']/a",  thSaleList, links);
		}
	}
	
	
	
	
	
	public void verifyAllCatPageGoToItemPage(String dept, String links) {

		
		if(dept.equalsIgnoreCase("women"))
		{
			verifyCatPageGoToItemPage("//*[@id='WOMEN_EX']/a",  thWomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyCatPageGoToItemPage("//*[@id='MEN_EX']/a",  thMensList, links);
		}
		else if(dept.equalsIgnoreCase("kids"))
		{
			verifyCatPageGoToItemPage("//*[@id='MS_KIDS_EX']/a",  thKidsList, links);
		}
		else if(dept.equalsIgnoreCase("tommynow"))
		{
			verifyCatPageGoToItemPage("//*[@id='TOMMY_NOW_EX']/a",  thTNowList, links);	
		}
		else if(dept.equalsIgnoreCase("tommy jeans"))
		{
			verifyCatPageGoToItemPage("//*[@id='TOMMY_JEANS_EX']/a", thTJeansList, links);	
		}
		else if(dept.equalsIgnoreCase("tommy adaptive"))
		{
			verifyCatPageGoToItemPage("//*[@id='ADP_CONTENT_EX']/a",  thTAdpList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyCatPageGoToItemPage("//*[@id='SALE_EX']/a",  thSaleList, links);
		}
	}
	
	
	
	
	
	
	
	public void verifyHeaderCategoryLinks(String xPathS,  List<WebElement> list, String links) {
		// TODO Auto-generated method stub
		String[] arr = links.split(";");
		List<String> linksList = Arrays.asList(arr);
		
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath(xPathS));
		action.moveToElement(we).build().perform();
		int counter = 0;
		String text;
		

		for(int i = 0; i < list.size(); i++)
		{
			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			text = list.get(i).getText().toLowerCase();
			if(linksList.contains(text))
			{
				counter++;
				LOGGER.info(text);
				list.get(i).click();
						
						if(breadCrumb.isVisible())
						{
							if(text.equals("modern cotton bedding"))
							{
								assertThat(breadCrumb.getText().toLowerCase().contains("duvet covers + sheets")).isTrue();
							}
							else
							{
								assertThat(breadCrumb.getText().toLowerCase().contains(text)).isTrue();
							}
							
							//assertThat(breadCrumb.getText().toLowerCase().contains(headerName)).isTrue();
							LOGGER.info("breadcrumb : " + breadCrumb.getText().toLowerCase());
						}
	
							getDriver().navigate().back();

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clickOffPopUp();
				if(counter >= linksList.size())
				{
					break;
				}

				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
			}
		}
		
		if(counter != linksList.size())
		{
			LOGGER.info("One or more links could not be found in the dept given");
			assertThat("One or more links could not be found in the dept given").isEmpty();
		}
		assertALL();
	}
	
	public void verifyDeptBreadCrumbLinks(String xPathS,  List<WebElement> list, String links) {
		// TODO Auto-generated method stub

		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath(xPathS));
		action.moveToElement(we).build().perform();
		
		String[] arr = links.split(";");
		List<String> linksList = Arrays.asList(arr);
		int counter = 0;
		String text;
		
		for(int i = 0; i < list.size(); i++)
		{
			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			text = list.get(i).getText().toLowerCase();
				if(linksList.contains(text))
				{
						counter++;
						LOGGER.info(text);
						list.get(i).click();
						
						if(breadCrumb.isVisible())
						{
							String linkText = deptBreadCrumb.getText();
							LOGGER.info("bcrumb : " +  linkText);
							deptBreadCrumb.click();
							clickOffPopUp();
							String pageTitle = getDriver().getTitle().toLowerCase();
							SA.assertThat(pageTitle.contains(linkText.toLowerCase()));
							LOGGER.info("pagetitle : " + pageTitle);
							getDriver().navigate().back();
						}
							getDriver().navigate().back();
				}
			
			clickOffPopUp();
			if(counter >= linksList.size())
			{
				break;
			}

			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			
		}
		
		if(counter != linksList.size())
		{
			LOGGER.info("One or more links could not be found in the dept given");
			assertThat("One or more links could not be found in the dept given").isEmpty();
		}
		assertALL();
	}
	
	
	
	
	
	public void verifyCatPageGoToItemPage(String xPathS,  List<WebElement> list, String links) {
		// TODO Auto-generated method stub

		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath(xPathS));
		action.moveToElement(we).build().perform();
		
		String[] arr = links.split(";");
		List<String> linksList = Arrays.asList(arr);
		int counter = 0;
		String text;
		
		for(int i = 0; i < list.size(); i++)
		{
			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			text = list.get(i).getText().toLowerCase();
			if(linksList.contains(text))
			{
						counter++;
						LOGGER.info(text);
						list.get(i).click();
						
						if(!productList.isEmpty())
						{
							
							WebElement w = productList.get(0);
							LOGGER.info("Clicking first product: " + w.getAttribute("title") + " from search result ");
							String itemName = w.getText();
							w.click();
							
							clickOffPopUp();
							String pageTitle = getDriver().getTitle().toLowerCase();
							SA.assertThat(pageTitle.contains(itemName.toLowerCase()));
							LOGGER.info("pagetitle : " + pageTitle);
							getDriver().navigate().back();
						}
						else
						{
							LOGGER.info("No Product List To Test For : " + text);
						}
						getDriver().navigate().back();
						if(counter >= linksList.size())
						{
							break;
						}
			
						clickOffPopUp();
			}
			

			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			
		}
		
		assertALL();
	}
	
	public void checkFooterLinkGoesToCorrespondingPage(String category){		
		for(int i = 0;i < allFooterLinks.size(); i++){
			//name of the category we are searching in footer;
			String nameOfFootCategory = allFooterLinks.get(i).getText();
			LOGGER.debug("Checking Text of Link : " + nameOfFootCategory);
			if(category.toUpperCase().equals(nameOfFootCategory.toUpperCase())) {
				allFooterLinks.get(i).click();
				Boolean isThere = false;
				switch(nameOfFootCategory.toUpperCase()) {
				
		          case "CUSTOMER SERVICE": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Customer Service')]")).size() > 0;
		                 break; 
		          case "ORDER STATUS": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Track Your Order')]")).size() > 0;
		                 break;
		          case "MY ACCOUNT": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'RETURNING CUSTOMER')]")).size() > 0;
		                 break;
		          case "WISHLIST": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'RETURNING CUSTOMER')]")).size() > 0;
		                 break;
		          case "STORE LOCATOR":
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Find a store near you')]")).size() > 0;
		                 break;
		          case "GLOBAL SITE": 
		        	  isThere = getDriver().getCurrentUrl().equals("http://global.tommy.com/int/en/about/overview/16");
		                 break;
		          case "CORPORATE RESPONSIBILITY":
		        	  isThere = getDriver().getCurrentUrl().equals("http://global.tommy.com/int/en/about/corporate-responsibility/our-3-principles/16");
		        	  	 break;
		          case "PRESS":
		        	  isThere = getDriver().getCurrentUrl().equals("http://global.tommy.com/int/en/newsroom/press-contacts/16");
		                 break;
		          case "AFFILIATE PROGRAM":
		         	  isThere = getDriver().findElements(By.xpath("//div[contains( text(), 'Publisher Registration')]")).size() > 0;
		              break;
		          case "CAREERS": 
		        	  isThere = getDriver().getCurrentUrl().equals("https://www.pvh.com/people");	 
		                 break;
		          default:
		        	  isThere = pageTitleOrLinkContainsWord(nameOfFootCategory);
		          }
				LOGGER.debug("isThere is: "+isThere+" for iteration "+i);
				assertThat(isThere).isTrue();	 
				getDriver().navigate().back();
				clickOffPopUp();
				sleep(1500);
				break;
			}
		}
	}
}
