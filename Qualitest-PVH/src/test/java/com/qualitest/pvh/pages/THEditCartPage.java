package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class THEditCartPage extends EditCartPage {

	@FindBy(xpath = "//*[@class='sizeSelector selected']")
	private BaseElement oneSize;
	
	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeSelectors;
	
	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
	private BaseElement outOfStock;
	
	@FindBy(xpath = "//*[@class = 'selected available']/span")
	private BaseElement sizeSelected1; 
	
	@FindBy(xpath = "//*[@class = 'available selected']/span")
	private BaseElement sizeSelected2;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(THEditCartPage.class);
	
	public void resetSelectedSizes() {
		if(sizeSelected1.exists()) {
			LOGGER.info("Reseting sizes selected");
			sizeSelected1.click();
		}else if(sizeSelected2.exists()) {
			LOGGER.info("Reseting sizes selected");
			sizeSelected2.click();
		}else {
			LOGGER.info("No need to reset size selected");
		}
	}
	
	public void chooseNextAvailableSize(String chosen) {
			
			resetSelectedSizes();
		
			String chosenLength = "";
			String chosenWaist = "";
			if(chosen.contains("/")) {
				String[] arr = chosen.split("/");
				chosenLength = arr[0];
				LOGGER.info("Chosen length is: "+chosenLength);
				chosenWaist = arr[1];
				LOGGER.info("Chosen waist is: "+chosenWaist);
			}else {
				chosenLength = chosen;
			}
			
			
			if(oneSize.exists()) {
				
				LOGGER.info("There is only one size");
				clickUpdateBag();
		
			} else if(sizeSelectors.size() == 1) {
				
				LOGGER.info("There is only one selction of sizes and user is selecting from");
				List<WebElement> size = sizeSelectors.get(0).findElements(By.xpath("//*[@class = 'available']"));
				String upSize = "";
				for(WebElement s: size) {
					LOGGER.info("Clicking the size of: "+s.getText());
					s.click();		
					if(s.getText().equals(chosenLength)) {
						LOGGER.info("Skipping the exact size of: "+chosenLength);
						continue;
					}
					if(outOfStock.exists()) {
						LOGGER.info("There is no inventory for: "+s.getText());
						continue;
					}
					if(!outOfStock.exists()) {
						LOGGER.info("Stopping cycle of searching for size");
						upSize = s.getText();
						break;
					}
				}
				if(outOfStock.exists()) {
					LOGGER.info("There is no other size available");
				}
				LOGGER.info("Changing the value of size to: "+upSize);
				Serenity.setSessionVariable("size").to(upSize);
				clickUpdateBag();
				
			}else{
				
				String upSize = "";
				List<WebElement> length = getDriver().findElements(By.xpath("//*[@class='sizeSelector'][2]/ul/li[@class ='available']"));
				for(int i = 0; i< length.size(); i++) {
					WebElement l = length.get(i);
					LOGGER.info("Clicking length size "+l.getText() );
					l.click();
					List<WebElement> waist = getDriver().findElements(By.xpath("//*[@class='sizeSelector'][1]/ul/li[@class ='available']"));		
					for(WebElement w: waist) {
						LOGGER.info("List of waists are: "+w.getText());
					}
					for(WebElement w: waist) {
						LOGGER.info("Clicking waist size: "+w.getText());
						w.click();
						if(l.getText().equals(chosenLength) && w.getText().equals(chosenWaist)) {
							LOGGER.info("Skipping the length and waist combo because this was the same as before");
							continue;
						}
						else if(outOfStock.exists()) {
							LOGGER.info("There is no inventory for: "+w.getText());
							continue;
						}
						if(!outOfStock.exists()) {
							LOGGER.info("Size combo of:"+w.getText()+" "+l.getText()+" exists");
							upSize = w.getText();
							break;
						}
					}
					if(sizeSelected2.exists()) {
						LOGGER.info("waist selected size is displayed");
						LOGGER.info("Displaying: length: "+l.getText()+" waist: "+sizeSelected2.getText());
						if(sizeSelected2.getText().equalsIgnoreCase(chosenWaist) && l.getText().equals(chosenLength)) {
							l.click();
							continue;
						}
					}	
					else if(outOfStock.exists()) {
						l.click();
						continue;
					}
					if(!outOfStock.exists()) {
						LOGGER.info("Adding the length text to upSize");
						upSize = upSize+"/"+l.getText();
						break;
					}
				}
				if(outOfStock.exists()) {
					LOGGER.info("There is no other size available");
				}
				LOGGER.info("Saving size as upsize: "+upSize);
				Serenity.setSessionVariable("size").to(upSize);
				clickUpdateBag();
				
			}
	}
		
}
