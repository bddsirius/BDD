package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://sp-b2cna-pq1.pvh.com")
public class SpeedoHomePage extends HomePage {

	
	@FindBy( id = "breadcrumb")
	private BaseElement breadCrumb;
	
	@FindBy(xpath = "//*[@id='breadcrumb']/a[2]")
	private BaseElement deptBreadCrumb;
	
	@FindBy(xpath = "//*[@class = 'productImage focusParent']/a")
	protected List<WebElement> productList;
	
	@FindBy(xpath = "//*[@id='womens']//*[@class='navItem']/a")
	private List<WebElement> WomensList;
	@FindBy(xpath = "//*[@id='men']//*[@class='navItem']/a")
	private List<WebElement> MensList;
	@FindBy(xpath = "//*[@id='kids']//*[@class='navItem']/a")
	private List<WebElement> KidsList;
	@FindBy(xpath = " //*[@id='goggles']//*[@class='navItem']/a")
	private List<WebElement> GogglesList;
	@FindBy(xpath = " //*[@id='gear']//*[@class='navItem']/a")
	private List<WebElement> GearList;
	@FindBy(xpath = " //*[@id='teams']//*[@class='navItem']/a")
	private List<WebElement> TeamsList;
	@FindBy(xpath = " //*[@id='sale']//*[@class='navItem']/a")
	private List<WebElement> SaleList;
	
	
	
	@FindBy(xpath = "//*[@class = 'tt-suggestion-text tt-suggestion-text-custom']")
	private List<WebElement> searchSuggestionList;

	@FindBy(xpath = "//*[@id='headerInner']/div[3]/div[2]/a[1]")
	private BaseElement myAcc;
	
	private CurrentPage currentPage;

	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoHomePage.class);

	@FindBy(xpath = "//*[@id=\'footerContainer\']/div[1]/div[1]/div[1]/div[1]/a")
	private List<WebElement> footerSection1;
	
	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[2]/div[1]/a")
	private List<WebElement> footerSection2;
	
	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[1]/div[2]/div[2]/a")
	private List<WebElement> footerSection3a;
	
	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[1]/div[2]/a")
	private List<WebElement> footerSection3;

	@FindBy(xpath = "//*[@id=\"footerContainer\"]/div[1]/div[1]/div[2]/div[2]/div[1]/a")
	private List<WebElement> footerSection4a;
	
	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[2]/div[2]/a[1]")
	private List<WebElement> footerSection4;
	
	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[2]/div[2]/div[2]/a")
	private List<WebElement> footerSection5a;
	
	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[2]/div[2]/a")
	private List<WebElement> footerSection5;

	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[1]/div[3]/a")
	private List<WebElement> footerSection6;
	
	@FindBy(xpath = "//*[@id='footerContainer']/div[1]/div[1]/div[2]/div[3]/a")
	private List<WebElement> footerSection7;
	
	@FindBy(xpath = "//*[@id=\'headerNavList\']/div")
	private List<WebElement> HeaderDeptList;
	
	@FindBy(xpath = "//*[@class ='categoryShortDescription']")
	private BaseElement categoryLink;
	
	@FindBy(xpath = "//*[@class = 'form_input']/input[1]")
	private BaseElement signUpEmailInput;
	
	@FindBy(xpath = "//*[@class = 'form_input']/input[2]")
	private BaseElement signUpButton;
	
	@FindBy(xpath = "//*[@id = 'overlaySignUpSuccess']")
	private BaseElement popUpThankYou;
	
	@FindBy(xpath = "//*[@class = 'error_container']/ div[@id = 'signUpError']")
	private BaseElement signUpError;
	
	@FindBy(xpath = "//*[@id = 'footerContainer']//div[@class = 'leftContainer']//a")
	private List<WebElement> allFooterLinks;
	
	public void verifyAllHeaderLinks()
	{
		
		for(int i = 0; i < HeaderDeptList.size(); i++)
		{
			if(HeaderDeptList.get(i).getText().equalsIgnoreCase("kids"))
			{
				//change back to girls
				verifyHeaderLink(HeaderDeptList.get(i),"GIRLS", categoryLink);
				
			}
			else
			{
				verifyHeaderLink(HeaderDeptList.get(i), HeaderDeptList.get(i).getText().toUpperCase(), categoryLink);
			}
		}

		SA.assertAll();
		
	}
	
	/**
	 * Method to verify header links
	 */
	public void verifyHeaderLink(WebElement link, String linkTxt)
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
			String catTxt = categoryLink.getText();
			LOGGER.info("Checking Department Link : " + linkTxt + " Against :" + catTxt);
			LOGGER.info("value " + catTxt.contains(linkTxt));
			SA.assertThat(catTxt.contains(linkTxt));
			getDriver().navigate().back();
			
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
		CheckFooterText(footerSection4);
		CheckFooterText(footerSection5);
		CheckFooterText(footerSection6);
		CheckFooterText(footerSection7);
		//calling method to make sure links go
		ClickFooterLinks(footerSection1);
		ClickFooterLinks(footerSection2);
		ClickFooterLinks(footerSection3);
		ClickFooterLinks(footerSection4);
		ClickFooterLinks(footerSection5);
		ClickFooterLinks(footerSection6);
		ClickFooterLinks(footerSection7);
		
		
		SA.assertAll();
		
	}
	
	
		
	@Override
	/**
	 * Method to launch Speedo website
	 */
	public void navigateTo(String speedoURL) {
		LOGGER.info("Navigating to Speedo website");
		getDriver().get(speedoURL);
	}
	
	@Override
	/**
	 * Method to verify Speedo home page title
	 */
	public void verifyPageTitle() {
		assertThat(currentPage.getTitle()).as("Speedo Home Page Title")
				.isEqualTo("Shop Speedo Swimsuits &amp; Swimwear | Speedo USA");
	}

	@Override
	/**
	 * Method to verify search suggestions displayed matches provided search term
	 * @param searchTerm - Search Term
	 */
	public void verifySearchSuggestions(String word) {
		for (WebElement w : searchSuggestionList) {
			String s = w.getText();
			LOGGER.info("Checking if: " + s + " is related to " + word);
			SA.assertThat(s).as("Search Suggestion").contains(word);
		}
		SA.assertAll();
	}
	
	
	public void capturePopUp() {
		LOGGER.info("Starting the look for a pop up");
		if(popUpClose.isVisible()) {
			return;
		}else {
			for(WebElement w: HeaderDeptList) {
				String name = w.findElement(By.xpath(".//a/span")).getText();
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
			}
		}
		LOGGER.info("Could not find Pop up");
	}
	
	private void enterSignUpEmail(String email) {
		LOGGER.info("Inputting the email: "+email+ " into the sign up");
		signUpEmailInput.sendKeys(email);
	}
	
	public void clickSignUpPopUp() {
		LOGGER.info("Clicking the Sign up button for the pop up");
		signUpButton.click();
	}
	
	public void enterAndSubmitSignUpPopUp(String email) {
		String i = String.valueOf(randomInt());
		enterSignUpEmail(i+email);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickSignUpPopUp();
	}
	public void verifyCongratsPopUpSignUp() {
		boolean isTrue = popUpThankYou.isVisible();
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
		curPos = CheckFooterTextWithNames(footerSection4,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection5,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection6,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection7,names,curPos);
	}
	
	public void checkFooterLinkGoesToCorrespondingPage(String category){		
		for(int i = 0;i < allFooterLinks.size(); i++){
			//name of the category we are searching in footer;
			String nameOfFootCategory = allFooterLinks.get(i).getText();
			LOGGER.debug("Checking Text of Link : " + nameOfFootCategory);
			if(category.toUpperCase().equals(nameOfFootCategory.toUpperCase())) {
				
				if(!allFooterLinks.get(i).getText().equals("Call 1-888-4SPEEDO")) {
					allFooterLinks.get(i).click();
				}
				Boolean isThere = false;
				switch(nameOfFootCategory.toUpperCase()) {
				
		          case "SPEEDO SIZE CHART": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Speedo Size Charts & Product Information')]")).size() > 0;
		                 break; 
		          case "ORDER STATUS": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Track Your Order')]")).size() > 0;
		                 break;
		          case "SHIPPING & DELIVERY": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'SPEEDO SHIPPING')]")).size() > 0;
		                 break;
		          case "RACING SWIMSUITS": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Racing')]")).size() > 0;
		                 break;
		          case "TRAINING SWIMWEAR":
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Training')]")).size() > 0;
		                 break;
		          case "TRIATHLON GEAR": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Triathlon')]")).size() > 0;
		                 break;
		          case "LIFEGUARD SWIMSUITS":
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Guard')]")).size() > 0;
		        	  	 break;
		          case "WATER POLO GEAR":
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Water Polo')]")).size() > 0;
		                 break;
		          case "SWIM GOGGLES":
		         	  isThere = getDriver().findElements(By.xpath("//span[contains( text(), 'Swimming Goggles')]")).size() > 0;
		              break;
		          case "CLASSES": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Classes')]")).size() > 0;
		        	  break;
		          case "TRAINING":
		        	  isThere = getDriver().getTitle().toLowerCase().contains("training");
		                 break;
		          case "OVERVIEW":
		        	  isThere = getDriver().getTitle().toLowerCase().contains("overview");
		              break;
		          case "GEAR": 
		        	  isThere = getDriver().getTitle().toLowerCase().contains("gear");
		        	  break;
		          case "KIDS - BEGIN TO SWIM": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'Kids - Begin To Swim')]")).size() > 0;
		                 break; 
		          case "SWIM GEAR & EQUIPMENT": 
		         	  isThere = getDriver().findElements(By.xpath("//span[contains( text(), 'Gear')]")).size() > 0;
		                 break; 
		          case "CALL 1-888-4SPEEDO": 
		         	  isThere = true;
		                 break; 
		          default:
		        	  isThere = pageTitleOrLinkContainsWord(nameOfFootCategory);
		          }
				LOGGER.debug("isThere is: "+isThere+" for iteration "+i);
				assertThat(isThere).isTrue();	 
				if(!allFooterLinks.get(i).getText().equals("Call 1-888-4SPEEDO")) {
					getDriver().navigate().back();
				}
				sleep(1500);
				break;
			}		
		}
	}

	
	
	public void verifyAllHeaderCategoryLinks(String dept, String links) {
	
		if(dept.equalsIgnoreCase("women"))
		{
			verifyHeaderCategoryLinks("//*[@id='womens']/a", WomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyHeaderCategoryLinks("//*[@id='mens']/a", MensList, links);
		}
		else if(dept.contains("kids"))
		{
			verifyHeaderCategoryLinks("//*[@id='kids']/a", KidsList, links);

		}
		else if(dept.equalsIgnoreCase("goggles"))
		{
			verifyHeaderCategoryLinks("//*[@id='goggles']/a", GogglesList, links);	
		}
		else if(dept.equalsIgnoreCase("gear"))
		{
			verifyHeaderCategoryLinks("//*[@id='gear']/a", GearList, links);	
		}
		else if(dept.equalsIgnoreCase("teams"))
		{
			verifyHeaderCategoryLinks("//*[@id='teams']/a",  TeamsList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyHeaderCategoryLinks("//*[@id='sale']/a",  SaleList, links);
		}
	
	}
	
	
	
	public void verifyAllDeptBreadCrumbLinks(String dept, String links) {
		
		if(dept.equalsIgnoreCase("women"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='womens']/a", WomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='mens']/a", MensList, links);
		}
		else if(dept.contains("kids"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='kids']/a", KidsList, links);
		}
		else if(dept.equalsIgnoreCase("goggles"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='goggles']/a", GogglesList, links);	
		}
		else if(dept.equalsIgnoreCase("gear"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='gear']/a", GearList, links);	
		}
		else if(dept.equalsIgnoreCase("teams"))
		{

			verifyDeptBreadCrumbLinks("//*[@id='teams']/a",  TeamsList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{

			verifyDeptBreadCrumbLinks("//*[@id='sale']/a",  SaleList, links);
		}
	
	}
	
	
	
public void verifyAllCatPageGoToItemPage(String dept, String links) {
		
		if(dept.equalsIgnoreCase("women"))
		{
			verifyCatPageGoToItemPage("//*[@id='womens']/a", WomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyCatPageGoToItemPage("//*[@id='mens']/a", MensList, links);
		}
		else if(dept.contains("kids"))
		{
			verifyCatPageGoToItemPage("//*[@id='kids']/a", KidsList, links);
		}
		else if(dept.equalsIgnoreCase("goggles"))
		{
			verifyCatPageGoToItemPage("//*[@id='goggles']/a", GogglesList, links);	
		}
		else if(dept.equalsIgnoreCase("gear"))
		{
			verifyCatPageGoToItemPage("//*[@id='gear']/a", GearList, links);	
		}
		else if(dept.equalsIgnoreCase("teams"))
		{

			verifyCatPageGoToItemPage("//*[@id='teams']/a",  TeamsList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{

			verifyCatPageGoToItemPage("//*[@id='sale']/a",  SaleList, links);
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
			text = list.get(i).getText().toLowerCase();
			if(linksList.contains(text))
			{
				counter++;
				LOGGER.info(text);
				list.get(i).click();
						
						if(breadCrumb.isVisible())
						{
							assertThat(breadCrumb.getText().toLowerCase().contains(text)).isTrue();
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
		
		if(counter < linksList.size())
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
		
		LOGGER.info("in method " + list.size());
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
			
			
						clickOffPopUp();
			}
			if(counter >= linksList.size())
			{
				break;
			}

			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			
		}
		
		assertALL();
	}
	
	
	
	
	
	
	
	
}