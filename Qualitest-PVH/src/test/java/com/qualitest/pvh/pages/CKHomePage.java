package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://ck-b2cna-pq1.pvh.com/en")
public class CKHomePage extends HomePage {

	protected SoftAssertions SA = new SoftAssertions();
	
	@FindBy(id = "headerLogout")
	private BaseElement logoutDropDown;

	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement popUpClose;
	
	@FindBy(xpath = "//*[@id=\"logoutMenu\"]//*[contains(text(),\"Saved Items\")]")
	private BaseElement myAccountWishlist;
	
	@FindBy(xpath = "//*[@class = 'productImage focusParent']/a")
	protected List<WebElement> productList; 
	
	@FindBy(xpath = "//*[@id='breadcrumb']/a[2]")
	private BaseElement deptBreadCrumb;
	
	List<WebElement> ck205CatList = new ArrayList<WebElement>();
	
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[2])/div/a")
	private List<WebElement> ck205CatList1;
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[3])/div/a")
	private List<WebElement> ck205CatList2;
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[4])/div/a")
	private List<WebElement> ck205CatList3;
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[5])/div/a")
	private List<WebElement> ck205CatList4;
	@FindBy( id = "breadcrumb")
	private BaseElement breadCrumb;
	
	@FindBy(xpath = "//*[@id='ck_womens_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckWomensList;
	
	@FindBy(xpath = "//*[@id='ck_mens_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckMensList;
	
	@FindBy(xpath = "//*[@id='ck_kids_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckKidsList;
	
	@FindBy(xpath = "//*[@id='ck_underwear']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckUnderwearList;
	
	@FindBy(xpath = "//*[@id='home_LSV_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckHomeList;
	
	@FindBy(xpath = "//*[@id='ck_sale-COL']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckSaleList;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[1]/ul/li/a")
	private List<WebElement> footerSection1;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[2]/ul/li/a")
	private List<WebElement> footerSection2;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[3]/ul/li/a")
	private List<WebElement> footerSection3;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[4]/ul/li/a")
	private List<WebElement> footerSection4;
	
	@FindBy(xpath = "//*[@id='footerNav']/div/ul/li/a")
	private List<WebElement> allFooterLinks;
	
	@FindBy(xpath = "//*[@id=\'headerNavList\']/div")
	private List<WebElement> HeaderDeptList;
	
	@FindBy(xpath = "//*[@id='contentRecommendationWidget_Logo']/div/a/img")
	private BaseElement homeImage;
	
	@FindBy(id = "ck_205W39NYC")
	private BaseElement header205;
	
	@FindBy(id = "ck_womens_BRD")
	private BaseElement headerWomen;
	
	@FindBy(id = "ck_mens_BRD")
	private BaseElement headerMen;
	
	@FindBy(id = "ck_kids_BRD")
	private BaseElement headerKids;
	
	@FindBy(id = "ck_underwear")
	private BaseElement headerUnderwear;
	
	@FindBy(id = "home_LSV_BRD")
	private BaseElement headerHome;
	
	@FindBy(id = "ck_sale-COL")
	private BaseElement headerSale;
	
	@FindBy(id = "ck_projects")
	private BaseElement headerProj;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign up')]")
	private BaseElement signUpButton;
	
	@FindBy(xpath = "//*[@id = 'signUpEmail']")
	private BaseElement signUpEmailInput;
	
	@FindBy(xpath = "//*[@id = 'ckEmailCaptureContainerSuccess']")
	private BaseElement popUpThankYou;
	
	@FindBy(xpath = "//*[@id ='navWrapper']/h3")
	private BaseElement categoryLink;
	
	@FindBy(xpath = "//*[@id = 'agree']")
	private BaseElement popUpAgreeCKCA;
	
	@FindBy(xpath = "//*[@id = 'fieldErrorMessage']")
	protected BaseElement signUpError;
	
	@FindBy(xpath = "//*[@id = 'headerLogout']")
	private BaseElement goToAccountButton;
	
	@FindBy(xpath = "//*[@class = 'myaccount_header']/a[1]")
	private BaseElement goToAccountOnPage;
	
	private CurrentPage currentPage;

	private static final Logger LOGGER = LoggerFactory.getLogger(CKHomePage.class);

	@Override
	/**
	 * Method to launch Calvin Klein US website
	 */
	public void navigateTo(String ckusURL) {
		LOGGER.info("Navigating to Calvin Klein - US website");
		getDriver().get(ckusURL);
	}
	
	@Override
	/**
	 * Method to verify Calvin Klein - US home page title
	 */
	public void verifyPageTitle() {
		LOGGER.info("Verifying Calvin Klein - US Home Page is displayed");
		assertThat(currentPage.getTitle()).as("Calvin Klein - US Home Page Title")
				.isEqualTo("Calvin Klein® USA | Official Online Site & Store");
		
	}
	
	
	public void verifyAllHeaderLinks()
	{
		for(int i = 0; i < HeaderDeptList.size(); i++)
		{	
			if(!(HeaderDeptList.get(i).getText().equalsIgnoreCase("projects")))
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
		}
		assertALL();
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
		//calling method to make sure links go
		ClickFooterLinks(footerSection1);
		ClickFooterLinks(footerSection2);
		ClickFooterLinks(footerSection3);
		ClickFooterLinks(footerSection4);
		
		
		SA.assertAll();
		
	}
	
	public void goToMyWishlist() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		myAccountWishlist.click();
	}
	
	public void goToMyAccount() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		logoutDropDown.click();
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
		signUpEmailInput.type(email);
	}
	
	public void clickSignUpPopUp() {
		LOGGER.info("Clicking the Sign up button for the pop up");
		String brand = Serenity.sessionVariableCalled("brand");
		if(brand.equals("CKCA")) {
			clickPopUpAgree();
		}
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
	
	private void clickPopUpAgree() {
		LOGGER.info("Click on the pop up agree on CKCA");
		popUpAgreeCKCA.click();
	}
	
	public void verifyCongratsPopUpSignUp() {
		boolean isTrue = popUpThankYou.isVisible();
		assertThat(isTrue).as("Congrats pop up exists").isTrue();
	}

	@Override
	public void verifyNoEmailUnSuccessfulPopUp() {
		assertThat(getSignUpErrorMessage()).as("Error Exists").isEqualToIgnoringCase("Please enter a valid email address.");
	}
	
	public void clickGoToAccount() {
		LOGGER.info("Go to account click");
		sleep(3000);
		goToAccountButton.click();
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
	
    public void clickGoToAccountOnPage() {
        LOGGER.info("Go to account click");
        sleep(3000);
        goToAccountOnPage.click();
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
				
		          case "FAQS":
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'frequently asked questions')]")).size() > 0  ;
		              break;
		          case "ORDER STATUS": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Track By Order Number')]")).size() > 0;
		                 break;
		          case "PREFERRED LOYALTY PROGRAM": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Returning Customer')]")).size() > 0;
		                 break;
		          case "STORE LOCATOR":
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Find a store near you')]")).size() > 0;
		                 break;
		          case "CALVIN KLEIN JEANS":
		        	  isThere = getDriver().getCurrentUrl().contains("/jeans");
		              break;
		          case "WOMEN'S JEANS": 
		        	  isThere = getDriver().getCurrentUrl().contains("calvin-klein-jeans-women"); 
		                 break;
		          case "MEN'S JEANS":
		        	  isThere = getDriver().getCurrentUrl().contains("calvin-klein-jeans-men");	
		        	  	 break;
		          case "WATCHES + JEWELRY":
		        	  isThere = getDriver().getCurrentUrl().contains("watches-jewelry"); 
		                 break;
		          case "ABOUT CALVIN KLEIN":
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'About CALVIN KLEIN, INC.')]")).size() > 0;
		              break;
		          case "CAREERS": 
		        	  isThere = getDriver().getCurrentUrl().equals("https://www.pvh.com/people/work-with-us");	 
		                 break;
		          case "EMAIL US":
		        	  	isThere = true;
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


	public void verifyFooterNamesExists(String names)
	{
		int curPos = 0;
		LOGGER.info("Verifying Footer Names Are Displayed");
		//calls method to check if text is displayed
		curPos = CheckFooterTextWithNames(footerSection1,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection2,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection3,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection4,names,curPos);		
	}
	
	public void verifyAllHeaderCategoryLinks(String dept, String links) {
		
		if(dept.equalsIgnoreCase("205w39nyc"))
		{
			Actions action = new Actions(getDriver());
			WebElement we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();
			we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();

			ck205CatList.addAll(ck205CatList1);
			ck205CatList.addAll(ck205CatList2);
			ck205CatList.addAll(ck205CatList3);
			ck205CatList.addAll(ck205CatList4);
			verifyHeaderCategoryLinks("//*[@id='ck_205W39NYC']/a",  ck205CatList, links);
		}
		else if(dept.equalsIgnoreCase("women"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_womens_BRD']/a",  ckWomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_mens_BRD']/a",  ckMensList, links);
		}
		else if(dept.equalsIgnoreCase("kids"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_kids_BRD']/a",  ckKidsList, links);
		}
		else if(dept.equalsIgnoreCase("underwear"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_underwear']/a",  ckUnderwearList, links);	
		}
		else if(dept.equalsIgnoreCase("home"))
		{
			verifyHeaderCategoryLinks("//*[@id='home_LSV_BRD']/a",  ckHomeList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_sale-COL']/a",  ckSaleList, links);
		}
		

		
	}

	
public void verifyAllDeptBreadCrumbLinks(String dept, String links) {
		
		if(dept.equalsIgnoreCase("205w39nyc"))
		{
			Actions action = new Actions(getDriver());
			WebElement we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();
			we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();
			
			ck205CatList.addAll(ck205CatList1);
			ck205CatList.addAll(ck205CatList2);
			ck205CatList.addAll(ck205CatList3);
			ck205CatList.addAll(ck205CatList4);
			verifyDeptBreadCrumbLinks("//*[@id='ck_205W39NYC']/a",  ck205CatList, links);
		}
		else if(dept.equalsIgnoreCase("women"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_womens_BRD']/a",  ckWomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_mens_BRD']/a",  ckMensList, links);
		}
		else if(dept.equalsIgnoreCase("kids"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_kids_BRD']/a",  ckKidsList, links);
		}
		else if(dept.equalsIgnoreCase("underwear"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_underwear']/a",  ckUnderwearList, links);	
		}
		else if(dept.equalsIgnoreCase("home"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='home_LSV_BRD']/a",  ckHomeList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_sale-COL']/a",  ckSaleList, links);
		}
	}

public void verifyAllCatPageGoToItemPage(String dept, String links) {
	
	if(dept.equalsIgnoreCase("205w39nyc"))
	{
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
		action.moveToElement(we).build().perform();
		we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
		action.moveToElement(we).build().perform();
		
		ck205CatList.addAll(ck205CatList1);
		ck205CatList.addAll(ck205CatList2);
		ck205CatList.addAll(ck205CatList3);
		ck205CatList.addAll(ck205CatList4);
		verifyCatPageGoToItemPage("//*[@id='ck_205W39NYC']/a",  ck205CatList, links);
	}
	else if(dept.equalsIgnoreCase("women"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_womens_BRD']/a",  ckWomensList, links);
	}
	else if(dept.equalsIgnoreCase("men"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_mens_BRD']/a",  ckMensList, links);
	}
	else if(dept.equalsIgnoreCase("kids"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_kids_BRD']/a",  ckKidsList, links);
	}
	else if(dept.equalsIgnoreCase("underwear"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_underwear']/a",  ckUnderwearList, links);	
	}
	else if(dept.equalsIgnoreCase("home"))
	{
		verifyCatPageGoToItemPage("//*[@id='home_LSV_BRD']/a",  ckHomeList, links);
	}
	else if(dept.equalsIgnoreCase("sale"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_sale-COL']/a",  ckSaleList, links);
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
			try
			{
				text = list.get(i).getText().toLowerCase();
			}
			catch(StaleElementReferenceException e)
			{
				getDriver().navigate().refresh();
				ck205CatList.clear();
				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
				ck205CatList.addAll(ck205CatList1);
				ck205CatList.addAll(ck205CatList2);
				ck205CatList.addAll(ck205CatList3);
				ck205CatList.addAll(ck205CatList4);
				text = ck205CatList.get(i).getText().toLowerCase();
			}
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
		LOGGER.info("list size : " + list.size());
		for(int i = 0; i < list.size(); i++)
		{
			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			try
			{
				text = list.get(i).getText().toLowerCase();
			}
			catch(StaleElementReferenceException e)
			{
				getDriver().navigate().refresh();
				ck205CatList.clear();
				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
				ck205CatList.addAll(ck205CatList1);
				ck205CatList.addAll(ck205CatList2);
				ck205CatList.addAll(ck205CatList3);
				ck205CatList.addAll(ck205CatList4);
				text = ck205CatList.get(i).getText().toLowerCase();
			}
			
			LOGGER.info("current item : " + text);
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
							
							if(counter >= linksList.size())
							{
								break;
							}
				}
			
			clickOffPopUp();
			

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
			try
			{
				text = list.get(i).getText().toLowerCase();
			}
			catch(StaleElementReferenceException e)
			{
				getDriver().navigate().refresh();
				ck205CatList.clear();
				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
				ck205CatList.addAll(ck205CatList1);
				ck205CatList.addAll(ck205CatList2);
				ck205CatList.addAll(ck205CatList3);
				ck205CatList.addAll(ck205CatList4);
				text = ck205CatList.get(i).getText().toLowerCase();
			}
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
