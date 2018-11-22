package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

public class THRegistrationDetailsPage extends RegistrationDetailsPage {

	@FindBy(id = "WC_MemberInfo_HomeStore_Country")
	private BaseElement preferredLocationCountry;
	
	@FindBy(id = "WC_MemberInfo_HomeStore_State")
	private BaseElement preferredLocationState;
	
	@FindBy(id = "WC_MemberInfo_HomeStore")
	private BaseElement preferredLocationStore;
	
	@FindBy(xpath = "//*[@id=\"channels\"]/label[1]")
	private BaseElement preferredCommunicationsWebsite;
	
	@FindBy(xpath = "//*[@id=\"channels\"]/label[2]")
	private BaseElement preferredCommunicationsRetailStore;
	
	@FindBy(xpath = "//*[@id=\"channels\"]/label[3]")
	private BaseElement preferredCommunicationsCompanyStore;
	
	@FindBy(xpath = "//*[@id=\"products\"]/label[1]")
	private BaseElement genderWomen;
	
	@FindBy(xpath = "//*[@id=\"products\"]/label[2]")
	private BaseElement genderMen;
	
	@FindBy(xpath = "//*[@id=\"products\"]/label[3]")
	private BaseElement kids;
	
	@FindBy(xpath = "//*[@id=\"WC_MyAccountCenterLinkDisplay_div_6\"]/div[2]")
	private BaseElement WelcomeMessage;
	
	@FindBy(xpath = "//a[contains(text(), 'Enter your address manually ')]")
	private List<WebElement> enterManual;

	private static final Logger LOGGER = LoggerFactory.getLogger(THRegistrationDetailsPage.class);
	
	
	/**
	 * Method to select preferred location country
	 * @param country - Preferred Location Country
	 */
	public void selectLocationCountry(String country) {
		LOGGER.info("Selecting Preference Country: "+country);
		Select roledropdown = new Select(preferredLocationCountry);
		roledropdown.selectByVisibleText(country);
	}
	
	/**
	 * Method to select preferred location state
	 * @param state - Preferred Location State
	 */
	public void selectLocationState(String state) {
		LOGGER.info("Selecting preference state: "+ state);
		Select roledropdown = new Select(preferredLocationState);
		roledropdown.selectByVisibleText(state);
	}
	
	/**
	 * Method to select preferred store
	 * @param store - Preferred Store
	 */
	public void selectLocationStore(String store) {
		LOGGER.info("Selecting preference store: "+store);
		Select roledropdown = new Select(preferredLocationStore);
		roledropdown.selectByVisibleText(store);
		
	}

	
	/**
	 * Method to select communication preference
	 * @param type - Communication Type. Possible value are: web / retails / company
	 */
	public void selectTypeOfCommunications(String type) {
		if(type.equalsIgnoreCase("web")) {
			LOGGER.info("Selecting communication type as web");
			preferredCommunicationsWebsite.click();
		}else if(type.equalsIgnoreCase("retail")) {
			LOGGER.info("Selecting communication type as retail");
			preferredCommunicationsRetailStore.click();
		}else if(type.equals("company")) {
			LOGGER.info("Selecting communication type as company");
			preferredCommunicationsCompanyStore.click();
		}else {
			LOGGER.info("Incorrect type of communication provided: " + type + " , Correct values can be web / retail / company" );
		}
	}
	
	/**
	 * Method to select type of clothes preference
	 * @param type - Cloth preference type. Possible value are: women / men / kids
	 */
	public void selectTypeOfClothes(String type) {
		if(type.equalsIgnoreCase("women")) {
			LOGGER.info("Selecting clothes preference as women");
			genderWomen.click();
		}else if(type.equalsIgnoreCase("men")) {
			LOGGER.info("Selecting clothes preference as men");
			genderMen.click();
		}else if(type.equals("kids")) {
			LOGGER.info("Selecting clothes preference as kids");
			kids.click();
		}else {
			LOGGER.info("Incorrect clothes preference provided: " + type + " , correct values can be : women / men / kids");
		}
	}
	
	protected void clickEnterManual() {
		if(enterManual.size()>0) {
			LOGGER.info("Clicking enter manual address info");
			enterManual.get(0).click();
		} else {
			LOGGER.info("Enter manual address link is not displayed");
		}
	}
	
	
	/**
	 * Method to enter registration details on tommy hilfiger website
	 * @param firstName - First Name
	 * @param lastName - Last Name
	 * @param address - Address Line 1
	 * @param apartment - Apartment Number
	 * @param city - City
	 * @param country - Country. Value is case sensitive e.g.: United States , Canada
	 * @param state - State. Value is case sensitive e.g.: New Jersey , New York
	 * @param zip - Zip Code
	 * @param phone - Phone Number
	 * @param gender - Gender
	 * @param bMonth - DOB Month. Value should be a string e.g. January , February
	 * @param bDay - DOB Day. Value should be between 1 to 31
	 * @param locationCountry - Preferred Location Country
	 * @param locationState - Preferred Location State
	 * @param locationStore - Preferred Store
	 * @param communication - Communication Type. Value should be web / retail / company
	 * @param type - Cloth preference type. Possible value are: women / men / kids
	 */
	public void fillOutRegistration(String firstName, String lastName, String address, String apartment, String city, String country, String state, String zip, String phone, String gender, String bMonth, String bDay, String locationCountry, String locationState, String locationStore, String communication, String type) {
		enterFirstName(firstName);
		enterLastName(lastName);
		clickEnterManual();
		enterApartment(apartment);
		enterAddress(address);
		enterCity(city);
		selectCountry(country);
		selectState(state);
		enterZip(zip);
		enterPhone(phone);
		selectGender(gender);
		selectBirthdayMonth(bMonth);
		selectBirthdayDay(bDay);
		selectLocationCountry(locationCountry);
		selectLocationState(locationState);
		selectLocationStore(locationStore);
		selectTypeOfCommunications(communication);
		selectTypeOfClothes(type);
		clickSave();
	}
	
	/**
	 * Method to verify Tommy Hilfiger Registration detail page title
	 */
	public void verifyPageTitle() {
		String title = this.getTitle();
		assertThat(title).as("Regiration Details Page Title").isEqualTo("Tommy Hilfiger - Register");
	}
	
}