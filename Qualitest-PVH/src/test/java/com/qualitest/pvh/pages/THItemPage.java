package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class THItemPage extends ItemPage{

private static final Logger LOGGER = LoggerFactory.getLogger(THItemPage.class); 
	
	@FindBy(id = "add2CartBtn")
	private BaseElement addToBag;
	
	@FindBy(id="size_S_OS")
	private BaseElement oneSize;
	
	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
	private BaseElement outOfStock;
	
	@FindBy(id = "pageLevelMessage")
	protected BaseElement pageLevelMessage;
	
	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeSelectors;
	
	@FindBy(id = "size_S_L")
	private BaseElement sizeLarge;
	
	@FindBy(id = "quantity_3074457345624562200")
	private BaseElement quantityPopup;

	@FindBy(xpath = "//*[@id=\"quantity_3074457345624562200\"]/option")
	protected List<WebElement> quantityNum;

	
	/**
	 * click the large button for size
	 */
	@Override
	public void clickLarge() {
		LOGGER.info("Clicking Large");
		sizeLarge.click();
	}
	
	@FindBy(xpath = "//a[contains( text(), 'Checkout')]")
	private BaseElement checkOutFromItemPagePopUp;
	
	
	public void clickCheckOutFromItemPage() {
		if(checkOutFromItemPagePopUp.exists()) {
			LOGGER.info("clicking the checkout from item page");
			checkOutFromItemPagePopUp.click();
		}else {
			sleep(3000);
			Actions action = new Actions(getDriver());
			WebElement we = getDriver().findElement(By.xpath("//*[@id = 'mini_cart_link']"));
			action.moveToElement(we).build().perform();
			checkOutFromItemPagePopUp.click();
		}
	}
	
	
	public void chooseRandomSizeandAddToBag() {
		getDriver().navigate().refresh();
		
		
		if(oneSize.exists()) {
			LOGGER.info("There is only one size, which is the one that is selected and added");
			if(pageLevelMessage.exists() || outOfStock.exists()) {
				LOGGER.info("Error exists: "+pageLevelMessage.getText());
			}
		} else if(sizeSelectors.size() == 1) {
			LOGGER.info("There is only one selction of sizes and user is selecting from");
			List<WebElement> size = sizeSelectors.get(0).findElements(By.className("available"));
			for(WebElement s: size) {
				LOGGER.info("Clicking the size of: "+s.getText());
				s.click();
				if(outOfStock.exists()) {
					LOGGER.info("There is no inventory for: "+s.getText());
					continue;
				}
				if(!outOfStock.exists()) {
					LOGGER.info("Stopping cycle of searching for size");
					break;
				}
			}
		}else{
			List<WebElement> length = sizeSelectors.get(1).findElements(By.className("available"));
			for(WebElement l: length) {
				LOGGER.info("List of lengths are: "+l.getText());
			}
			for(WebElement l: length) {
				LOGGER.info("Clicking length size "+l.getText() );
				l.click();
				List<WebElement> waist = sizeSelectors.get(0).findElements(By.className("available"));		
				for(WebElement w: waist) {
					LOGGER.info("List of waists are: "+w.getText());
				}
				for(WebElement w: waist) {
					LOGGER.info("Clicking waist size: "+w.getText());
					w.click();
					if(outOfStock.exists()) {
						LOGGER.info("There is no inventory for: "+w.getText());
						continue;
					}
					if(!outOfStock.exists()) {
						break;
					}
				}	
				if(outOfStock.exists()) {
					l.click();
					continue;
				}
				if(!outOfStock.exists()) {
					break;
				}
			}
		}
	}
	
//	@FindBy(id = "WC_MiniShopCartDisplay_link_1_1")
//	private BaseElement firstProductInCartDisplay;
//	
//	@FindBy(xpath = "//*[@id=\"contentRecommendationWidget_Logo\"]/div[1]/a/img")
//	private BaseElement goToHomePage;
//	
//	@FindBy(xpath = "//*[@id=\"product\"]/div[3]/div[2]/div[1]/h1/span")
//	private BaseElement nameOfProduct;
//	
//	@FindBy(xpath = "//*[@class='sizeSelector selected']")
//	private BaseElement oneSize;
//	
//	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
//	private BaseElement outOfStock;
//	
//	@FindBy(className = "productNameInner")
//	private BaseElement productName;
//	
//	@FindBy(id = "size_S_L")
//	private BaseElement sizeLarge;
//	
//	@FindBy(id = "size_S_M")
//	private BaseElement sizeMed;
//	
//	@FindBy(xpath = "//*[@class='sizeSelector']")
//	private List<WebElement> sizeSelectors;
//	
//	@FindBy(id = "size_S_S")
//	private BaseElement sizeSmall;
//	
//	@FindBy(xpath = "//*[@class = 'styleNumber']")
//	private BaseElement styleNumber;
//	
//	
//	public void chooseRandomSizeandAddToBag() {
//		
//			if(oneSize.exists() && sizeSelectors.size() == 0) {
//				LOGGER.info("There is one size and color, so user will add to bag the only available");
//				clickAddToBag();
//			}
//		
//			else if(sizeSelectors.size() == 1) {
//
//				LOGGER.info("There is only one selction of sizes and user is selecting from");
//				List<WebElement> size = sizeSelectors.get(0).findElements(By.className("available"));
//				for(WebElement s: size) {
//					LOGGER.info("Clicking the size of: "+s.getText());
//					s.click();
//					clickAddToBag();
//					if(outOfStock.exists()) {
//						LOGGER.info("There is no inventory for: "+s.getText());
//						continue;
//					}
//					if(!outOfStock.exists()) {
//						LOGGER.info("Stopping cycle of searching for size");
//						break;
//					}
//				}
//			}else{
//				List<WebElement> length = sizeSelectors.get(1).findElements(By.className("available"));
//				for(WebElement l: length) {
//					LOGGER.info("List of lengths are: "+l.getText());
//				}
//				for(WebElement l: length) {
//					LOGGER.info("Clicking length size "+l.getText() );
//					l.click();
//					List<WebElement> waist = sizeSelectors.get(0).findElements(By.className("available"));		
//					for(WebElement w: waist) {
//						LOGGER.info("List of waists are: "+w.getText());
//					}
//					for(int i = 0; i<waist.size(); i++) {
//						WebElement w = waist.get(i);
//						LOGGER.info("Clicking waist size: "+w.getText());
//						w.click();
//						if(outOfStock.exists()) {
//							LOGGER.info("There is no inventory for: "+w.getText());
//							continue;
//						}
//						if(!outOfStock.exists()) {
//							clickAddToBag();
//							break;
//						}
//					}	
//					if(verifyErrorExistsSpan("out of stock")) {
//						continue;
//					}
//					if(!verifyErrorExistsSpan("out of stock")) {
//						break;
//					}
//				}
//			}
//	}
//	/**
//	 * click the large button for size
//	 */
//	public void clickLarge() {
//		LOGGER.info("Clicking Large");
//		sizeLarge.click();
//	}
//	/**
//	 * Click the medium button for size
//	 */
//	public void clickMed() {
//		LOGGER.info("Clicking medium");
//		sizeMed.click();
//	}
//	/**
//	 * Click the small button for size
//	 */
//	public  void clickSmall() {
//		LOGGER.info("Clicking small");
//		sizeSmall.click();
//	}
//	public String getNameOfFirstItemInBagDisplay() {
//		String name = firstProductInCartDisplay.getText();
//		LOGGER.info("Getting the name of the first product in cart display as: "+name);
//		return name;
//	}
//	public String getNameOfProduct() {
//		String name  = nameOfProduct.getText();
//		LOGGER.info("Getting the name of product as: "+name);
//		return name;
//	}
//	public String getProductName() {
//		String name  = productName.getText();
//		LOGGER.info("Getting the name of product as: "+name);
//		return name;
//	}
//	public String getStyleNumber() {
//		String text = styleNumber.getText();
//		String[] arr = text.split(":");
//		text = arr[1].replaceAll("\\s+", "");
//		LOGGER.info("Getting the style number: "+text);
//		return text;
//	}
//	public void goToHomePage() {
//		LOGGER.info("Clicking the home page button");
//		goToHomePage.click();
//	}
//	
//	public void selectItemToCart(String size) {
//		LOGGER.info("Selecting item of size "+size);
//		if(size.equalsIgnoreCase("small")) {
//			clickSmall();
//		}else if(size.equalsIgnoreCase("medium")) {
//			clickMed();
//		}else if(size.equalsIgnoreCase("large")) {
//			clickLarge();
//		}else{
//			LOGGER.info("Must pick small, med or large");
//		}
//		clickAddToBag();
//		goToHomePage();
//	}
//	
//	public boolean verifyErrorExistsSpan(String error) { 
//		String locator = "//span[contains(text(),'"+error+"')]";
//		
//		LOGGER.debug("Trying to locate error message using xpath: " + locator);
//		try
//		{
//			find(By.xpath(locator));
//			return true;
//		} catch(Exception e) {
//			return false;
//		}
//	}
//	
//	public void verifyItemInCartDisplayInCorner() {
//		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#mini_cart_link"));
//		Actions builder = new Actions(getDriver());
//		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
//		if(firstProductInCartDisplay.exists()) {
//			assertThat(getProductName()).contains(getNameOfFirstItemInBagDisplay());
//		}else {
//			LOGGER.debug("The cart is empty");
//		}
//	}
//	
	
	@Override
	public void selectQuantityInPopup(String quant) {
		Float quantfloat = Float.parseFloat(quant);
		quantityPopup.click();
		if (checkStock() != 0 & checkStock() < quantfloat) {
			int stock = checkStock().intValue();
			for (int i = 0; i < quantityNum.size(); i++) {
				if (i == stock) {
					LOGGER.info("Selecting quantity: " + i);
					quantityNum.get(i - 1).click();
					break;
				}
			}
		} else {
			for (int i = 0; i < quantityNum.size(); i++) {
				if (i == quantfloat) {
					LOGGER.info("Selecting quantity: " + i);
					quantityNum.get(i - 1).click();
					break;
				}
			}
		}
		replaceButton.click();
		
	}
}
