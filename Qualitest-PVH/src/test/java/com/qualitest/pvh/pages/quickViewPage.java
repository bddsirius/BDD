package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class quickViewPage extends BasePage {
	
	@FindBy(id = "add2CartBtn")
	private BaseElement addToBag;
	
	@FindBy(className = "productNameInner")
	private BaseElement productName;

	@FindBy(xpath = "//*[@class= 'inventoryStatus low']")
	private BaseElement lowStock;
	
	@FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div[2]/div[2]/div/h1/span")
	private BaseElement nameOfProduct;
	
	@FindBy(xpath = "//*[@class = 'namePartPriceContainer']/div[2]/span")
	private List<WebElement> offerPrices;
	
	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
	private BaseElement outOfStock;
	
	@FindBy(id = "pageLevelMessage")
	private BaseElement pageLevelMessage;
	
	@FindBy(xpath = "//*[@id='size_S_One_space_Size']")
	private BaseElement oneSize;
	
	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeSelectors;
	
	@FindBy(id="dk_selected")
	private BaseElement quantity;
	
	@FindBy(xpath = "//*[@class='dk_options_inner']/li")
	private List<WebElement> quantityNum;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(quickViewPage.class);
	
	public Float checkStock() {
		if(lowStock.exists()) {
			LOGGER.info("Lowstock message: " + lowStock.getText());
			String str = lowStock.getText();
			
			str = str.replaceAll("\\D+", "");
			Float stock = Float.parseFloat(str);
			return stock;
		}else {
			return (float) 0.0;
		}
	}
	
	/**
	 * Click the addToBag button that adds product to bag
	 */
	public void clickAddToBag() {
		LOGGER.info("Clicking add to bag");
		addToBag.click();
	}
	
	public void chooseRandomSizeWithStock() {
		
		
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
	
	public void selectQuantity(String quant) {
		Float quantfloat = Float.parseFloat(quant);
		LOGGER.info("The amount of stock left is: " + checkStock());
		quantity.click();
		LOGGER.info("Quantity num: " + quantityNum.get(2).getText());
		if(checkStock() != 0 & checkStock() < quantfloat) {
			int stock = checkStock().intValue();
			for(int i=0; i<quantityNum.size();i++) { 
				if(i == stock) {
					quantityNum.get(i-1).click();
					break;
				}
			}
		}else {
			for(int i=0; i<quantityNum.size();i++) { 
				if(i == quantfloat) {
					quantityNum.get(i-1).click();
					break;
				}
			}
	}
		clickAddToBag();
}
	
	public float returnOfferPrice() {
		WebElement w;
		if(offerPrices.size() == 1) {
			w = offerPrices.get(0);
		}else {
			w = offerPrices.get(1);
		}
		LOGGER.info("Returning an offer price of: "+w.getText());
		String s = w.getText();
		s = s.replace("$", "");
		s = s.replaceAll(",", "");
		LOGGER.info("Modded string value is: "+s);
		if(s.contains("-")) {
			LOGGER.info("There is an issue where even though we selected size and color, there is no exact price displayed. Only a range");
		}
		float f = Float.parseFloat(s);
		return f;	
	}
	public String getProductName() {
		String name  = productName.getText();
		LOGGER.info("Getting the name of product as: "+name);
		return name;
	}
	
}
