package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://ckca-b2cna-pq1.pvh.com/en")
public class CKCAHomePage extends HomePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(CKCAHomePage.class);

	private CurrentPage currentPage;
	
	@FindBy(xpath = "//*[@id=\'headerNavList\']/div")
	private List<WebElement> HeaderDeptList;
	
	@FindBy(xpath = "//*[@id ='navWrapper']/h3")
	private BaseElement categoryLink;
	
	@FindBy(xpath = "//*[@id='footerNav']/div/ul/li/a")
	private List<WebElement> allFooterLinks;
	
	@FindBy(xpath = "//*[@id=\'departmentSubs\']/section/div/div[2]/article/h2")
	private BaseElement IntroVerifier205;
	
	@Override
	/**
	 * Method to verify Calvin Klein - CA home page title
	 */
	public void verifyPageTitle() {
		assertThat(currentPage.getTitle()).as("Clavin Klein - CA Home Page Title")
				.isEqualTo("Calvin Klein | Official Site and Online Stores|");
	}

	public void verifyAllHeaderLinks()
	{
		String dept = HeaderDeptList.get(0).getText().toUpperCase();
		HeaderDeptList.get(0).click();
		SA.assertThat(IntroVerifier205.getText().toUpperCase().contains(dept));
		LOGGER.info("Checking Department Link : " + dept + " Against :" + IntroVerifier205.getText().toUpperCase());
		LOGGER.info("value " + IntroVerifier205.getText().toUpperCase().contains(dept));
		getDriver().navigate().back();
		
		for(int i = 1; i < HeaderDeptList.size(); i++)
		{
			if(!(HeaderDeptList.get(i).getText().equalsIgnoreCase("projects")))
			{
				if(HeaderDeptList.get(i).getText().equalsIgnoreCase("kids"))
				{
					verifyHeaderLink(HeaderDeptList.get(i),"GIRL", categoryLink);
				}
				else
				{
					verifyHeaderLink(HeaderDeptList.get(i), HeaderDeptList.get(i).getText().toUpperCase(), categoryLink);
				}
			}
		}
		SA.assertAll();
		
	}
	
	/**
	 * Method to launch Calvin Klein CA website
	 */
	public void navigateTo(String ckcaURL) {
		LOGGER.info("Navigating to Calvin Klein - CA website");
		getDriver().get(ckcaURL);
	}

	@Override
	public void verifyCongratsPopUpSignUp() {
		
	}

	@Override
	public void verifyNoEmailUnSuccessfulPopUp() {
		// TODO Auto-generated method stub
		
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
		          case "TRACK ORDER": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Track your international package')]")).size() > 0;
		                 break;
		          case "PREFERRED CUSTOMER PROGRAM": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Returning Customer')]")).size() > 0;
		                 break;
		          case "STORE LOCATOR":
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Find a store near you')]")).size() > 0;
		                 break;
		          case "WOMEN'S SIZE GUIDE": 
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), \"Women's Size Chart\")]")).size() > 0;
		                 break;
		          case "MEN'S SIZE GUIDE":
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), \"Men's Size Chart\")]")).size() > 0;
		        	  	 break;
		          case "KIDS'S SIZE GUIDE":
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), \"Kid's Size Chart\")]")).size() > 0;
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

}
