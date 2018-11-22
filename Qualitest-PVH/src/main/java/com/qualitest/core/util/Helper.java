package com.qualitest.core.util;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import net.thucydides.core.webdriver.WebDriverFacade;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public final class Helper {

	//private static String PROPERTY_DRIVER = "webdriver.driver";
	private static String PROPERTY_APPIUM_PLATFORM = "appium.platformName";

	public static String IOS = SupportedWebDriver.IPHONE.toString().toLowerCase();
	public static String ANDROID = SupportedWebDriver.ANDROID.toString().toLowerCase();
	public static String WIN = "win";
	public static String MAC = "mac";
	public static String CHROME = SupportedWebDriver.CHROME.toString().toLowerCase();
	public static String FIREFOX = SupportedWebDriver.FIREFOX.toString().toLowerCase();
	public static String IE = SupportedWebDriver.IEXPLORER.toString().toLowerCase();
	public static String SAFARI = SupportedWebDriver.SAFARI.toString().toLowerCase();
	public static String APPIUM = SupportedWebDriver.APPIUM.toString().toLowerCase();

	//private static final Logger Log = LoggerFactory.getLogger(Helper.class);

	private Helper() {
		// private constructor to prevent instantiation
	}
	
	public static String getDriverName() {
		return getDriverFacade().getDriverName().toLowerCase();
	}

	public static boolean isMobile() {
		return getDriverName().equals(APPIUM);
	}

	public static String getMobilePlatformName() {
		return getSerenityProperties().getProperty(PROPERTY_APPIUM_PLATFORM).toLowerCase();
	}

	public static EnvironmentVariables getSerenityProperties() {
		return SystemEnvironmentVariables.createEnvironmentVariables();
	}

	public static WebDriverFacade getDriverFacade() {
		return (WebDriverFacade) StepEventBus.getEventBus().getBaseStepListener().getDriver();
	}

	public static WebDriver getDriver() {
		return StepEventBus.getEventBus().getBaseStepListener().getDriver();
	}

	public static Capabilities getCapabilities() {
		return getDriverFacade().getCapabilities();
	}

	public static void dd() {

		// this.enable = variables.getPropertyAsBoolean("testrails.enable", false);

		System.out.println("****************ee3443434343434333333333333333");
		System.out.println(isMobile());
		System.out.println(getMobilePlatformName());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

	}

}
