package com.qualitest.core.element;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.pages.WebElementFacadeImpl;

public class BaseElementImpl extends WebElementFacadeImpl implements BaseElement {

	public static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	public BaseElementImpl(final WebDriver driver, final ElementLocator locator,
			final long implicitTimeoutInMilliseconds) {
		super(driver, locator, null, implicitTimeoutInMilliseconds, implicitTimeoutInMilliseconds);
	}

	public BaseElementImpl(final WebDriver driver, final ElementLocator locator,
			final long implicitTimeoutInMilliseconds, final long waitForTimeoutInMilliseconds) {
		super(driver, locator, null, implicitTimeoutInMilliseconds, waitForTimeoutInMilliseconds);
	}

	public void fill(String text) {
		waitForMe();
		super.type(text);
	}

	public String getFill() {
		waitForMe();
		return super.getTextValue();
	}

	public boolean exists(int timeoutMilliSeconds) {
		
        try {
        	waitForMe(timeoutMilliSeconds);
        } catch (Exception e) {
     
        	return false;
        }
     
		return isVisible();
	}

	public boolean exists() {
		return exists((int) (long)this.timeoutInMilliseconds());
	}

	
	public void waitForMe(int timeoutMilliSeconds) {
		LOGGER.info(String.format("Waiting for %s to become enabled with a timeout of %d", this.toString(), timeoutMilliSeconds));
		
		withTimeoutOf(timeoutMilliSeconds, TimeUnit.MILLISECONDS).waitUntilEnabled();
	}
	
	public void waitForMe() {
		waitForMe((int) (long)this.timeoutInMilliseconds());
	}


}