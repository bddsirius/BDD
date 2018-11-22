package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CKItemPage extends ItemPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(CKItemPage.class);

	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement popUpClose;
	
	@FindBy(id = "WC_MiniShopCartDisplay_link_1_1")
	private BaseElement firstProductInCartDisplay;

	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
	private BaseElement outOfStockClass;

	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeList;

	@FindBy(xpath = "//*[@id = 'shopping-bag-link']")
	private BaseElement checkOut;
	
	@FindBy(xpath = "//*[@id = 'product-added-container']//*[contains( text(), 'Edit bag' ) ]")
	private BaseElement productAddedEditBag;
	
	@FindBy(xpath = "//*[@id= 'MiniShopCartAll']//*[contains( text(), 'Edit bag' ) ]")
	private BaseElement miniCartDisplayEditBag;

	public void clickOffPopUp() {
		if (popUpClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpClose.click();
		}
	}
	
	public void clickEditBagFromMiniCart() {
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			LOGGER.info("Clicking on the edit bag option in the mini cart display");
			Actions action = new Actions(getDriver());
			WebElement w = getDriver().findElement(By.id("mini_cart_link"));
			action.moveToElement(w).build().perform();
			miniCartDisplayEditBag.click();
		
	}
	
	public Float checkStock() {
		if (lowStock.exists()) {
			LOGGER.info("Lowstock message: " + lowStock.getText());
			String str = lowStock.getText();

			str = str.replaceAll("\\D+", "");
			Float stock = Float.parseFloat(str);
			return stock;
		} else {
			return (float) 0.0;
		}
	}

	public int checkToBagIfEmpty() {
		int i = itemsInBag.size();
		if (i == 0) {
			LOGGER.info("The bag is empty");
		} else {
			LOGGER.info("The bag contains: " + i + " items");
		}
		return i;
	}

	/**
	 * Method to add product to cart for first size available in stock
	 */
	public void chooseRandomSizeandAddToBag() {
		pageRefresh();
		clickOffPopUp();
		
		if(!oneSize.exists() && sizeList.size() == 0) {
			LOGGER.info("There is no size selection, or one size selection");
		}
		
		if (oneSize.exists()) {
			LOGGER.info("There is only one size, which is the one that is selected and added");
			if (pageLevelMessage.exists() || outOfStock.exists()) {
				LOGGER.info("Error exists: " + pageLevelMessage.getText());
			}
		} else if (sizeList.size() == 1) {
			LOGGER.info("There is only one selction of sizes available");
			List<WebElement> size = sizeList.get(0).findElements(By.className("available"));
			for (WebElement s : size) {
				LOGGER.info("Selecting size: " + s.getText());
				s.click();
				if (outOfStock.exists() || pageLevelMessage.exists()) {
					LOGGER.info("No stock available for size: " + s.getText());
					continue;
				} else {
					LOGGER.info("Stock available for size: " + s.getText());
					break;
				}
			}
		} else {
			List<WebElement> length = sizeList.get(1).findElements(By.className("available"));
			for (WebElement l : length) {
				LOGGER.info("List of avilable lengths: " + l.getText());
			}
			for (WebElement l : length) {
				LOGGER.info("Selecting length: " + l.getText());
				l.click();
				List<WebElement> waist = sizeList.get(0).findElements(By.className("available"));
				for (WebElement w : waist) {
					LOGGER.info("List of available waists: " + w.getText());
				}
				for (WebElement w : waist) {
					LOGGER.info("Selecting waist: " + w.getText());
					w.click();
					if (outOfStock.exists() || pageLevelMessage.exists()) {
						LOGGER.info("No stock available for waist: " + w.getText());
						continue;
					} else {
						LOGGER.info("Stock is avilable for length: " + l.getText() + " and waist: " + w.getText());
						break;
					}
				}
				if (outOfStock.exists() || pageLevelMessage.exists()) {
					l.click();
					continue;
				} else {
					break;
				}
			}
		}
	}

	public String getNameOfFirstItemInBagDisplay() {
		String name = firstProductInCartDisplay.getText();
		LOGGER.info("Getting the name of the first product in cart display as: " + name);
		return name;
	}

	public void verifyItemInCartDisplayInCorner() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#mini_cart_link"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();

		if (firstProductInCartDisplay.exists()) {
			assertThat(getProductName()).isEqualTo(getNameOfFirstItemInBagDisplay());
		} else {
			assertThat(getProductName()).contains("nothing");
			LOGGER.debug("The cart is empty");
		}
	}

	public void clickGoToCheckOut() {
		if (checkOut.exists()) {
			LOGGER.info("Clicking on go to checkout");
			checkOut.click();
		} else {
			LOGGER.info("No checkout button to click");
		}

	}

}