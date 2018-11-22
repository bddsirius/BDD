package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CKCheckoutPage extends CheckoutPage{

	private static final Logger LOGGER = LoggerFactory.getLogger(CKCheckoutPage.class);
	
	@FindBy(xpath = "//*[@id = 'LoyaltyProgram']//h1[@class = 'large expandableSectionHeader']")
	private BaseElement rewardsWindowOpen;
	
	@FindBy(xpath = "//*[@id = 'rewardsList']/div")
	private List<WebElement> listOfRewards;
	
	@FindBy(xpath = "//*[@name = 'rewards']")
	private List<WebElement> listOfRewardsCheckList;
	
	@FindBy(xpath = "//*[@id = 'discountDetailsSection']/div/div[2]")
	private List<WebElement> listOfAppliedRewards;
	
	@FindBy(xpath = "//*[@id = 'WC_SingleShipmentOrderTotalsSummary_td_10']")
	private BaseElement orderTotal;
	
	@FindBy(xpath = "//*[@id = 'WC_SingleShipmentOrderTotalsSummary_td_2']")
	private BaseElement orderSubTotal;
	
	@FindBy(xpath = "//*[@class = 'youSaved clearfix']/div[2]/div")
	private BaseElement amountSaved;

	
	public void clickRewardsTab() {
		LOGGER.info("Clicking the rewards tab");
		rewardsWindowOpen.click();
	}
	
	public String modPrice(String price) {
		LOGGER.info("Incoming price to be modded is: "+price);
		price = price.replace("-", "");
		price = price.replace("$", "");
		price = price.replace(",", "");
		LOGGER.info("The modded price is: "+price);
		return price;
	}
	
	private String getAmountSaved() {
		String text = amountSaved.getText();
		text = text.replace("$", "");
		text = text.replace(",", "");
		LOGGER.info("Returning an amount saved of: "+text);
		return text;
	}
	
	private String allDiscountedApplied() {
		if(listOfAppliedRewards.size() == 0) {
			LOGGER.info("There are no rewards applied");
			return  "";
		}else if(listOfAppliedRewards.size() == 1) {
			String text = modPrice(listOfAppliedRewards.get(0).getText());
			LOGGER.info("There is an reward list size of 1, which is: "+text);
			return text;
		}
		else {
			LOGGER.info("Getting the list of rewards applied");
			double d = 0.00;
			for(WebElement w: listOfAppliedRewards) {
				String reward = w.getText();
				reward = modPrice(reward);
				d += Double.parseDouble(reward);
			}
			String s = String.valueOf(d);
			String[] arr = s.split(".");
			if(arr[1].length() == 1) {
				s=s+"0";
			}
			return s;
		}
		
	}
	
	public double getOrderTotal() {
		String text = orderTotal.getText();
		text = text.replace("$", "");
		text = text.replace(",", "");
		LOGGER.info("Getting an order total of: "+text);
		double f = Double.parseDouble(text);
		return f;
	}
	
	public double getSubOrderTotal() {
		String text = orderSubTotal.getText();
		text = text.replace("$", "");
		text = text.replace(",", "");
		LOGGER.info("Getting an order subtotal of: "+text);
		double f = Double.parseDouble(text);
		return f;
	}
	
	public void deSelectAwards() {
		for(WebElement w: listOfRewardsCheckList) {
			if(w.isSelected()) {
				try
				{
				    Thread.sleep(3000);
				}
				catch(InterruptedException ex)
				{
				    Thread.currentThread().interrupt();
				}
				LOGGER.info("clicking off the reward");
				w.click();
			}
		}
	}
	
	public void selectTwoAwards() {
		if(listOfRewardsCheckList.size() < 2) {
			LOGGER.info("There are less than two rewards. So we could only choose one");
			selectFirstReward();
		}else {
			try{
			    Thread.sleep(3000);
			}
			catch(InterruptedException ex){
			    Thread.currentThread().interrupt();
			}
			if(!listOfRewardsCheckList.get(0).isSelected()) {
				listOfRewardsCheckList.get(0).click();
			}
			if(!listOfRewardsCheckList.get(1).isSelected()) {
				listOfRewardsCheckList.get(1).click();
			}
		}
	}
	
	public void selectFirstReward() {
		if(listOfRewardsCheckList.get(0).isSelected()) {
			LOGGER.info("The first reward is selected, so will continue");
		}else {
			LOGGER.info("Clicking the first reward");
			try
			{
			    Thread.sleep(5000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			listOfRewardsCheckList.get(0).click();
			try{
			    Thread.sleep(3000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
		}
	}

	public String getTotalSelected() {
		if(listOfAppliedRewards.size() == 0) {
			LOGGER.info("The list of rewards available is zero");
			return "";
		}else {
			double total = 0.00;
			for(WebElement w: listOfRewards) {
				if(w.findElement(By.xpath(".//*[@class = 'checkbox']")).isSelected()) {
					String text = w.findElement(By.xpath(".//span")).getText();
					text = modPrice(text);
					double temp = Double.parseDouble(text);
					total+=temp;
				}
				
			}
			String t = String.valueOf(total);
			LOGGER.info("Returning a total of: "+t);
			int index = t.indexOf('.');
			if(t.substring(index+1).equals("0")) {
				t=t+"0";
			}
			return t;
		}
	}
	
	public void verifyRewardsApplied(String amountSaved, String rewardTotal) {
		try
		{
		    Thread.sleep(5000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		SA.assertThat(allDiscountedApplied()).as("Reward total").isEqualTo(getTotalSelected());
		SA.assertThat(getAmountSaved()).as("Amount saved").isEqualTo(getTotalSelected());
		SA.assertAll();
	}
	public void verifyRewardsApplied() {
		try
		{
		    Thread.sleep(5000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		SA.assertThat(allDiscountedApplied()).as("Reward total").isEqualTo(getTotalSelected());
		SA.assertThat(getAmountSaved()).as("Amount saved").isEqualTo(getTotalSelected());
		SA.assertAll();
	}

	public String getColorText() {
		// TODO Auto-generated method stub
		return colorItem1.getText();
	}
	public String getSizeText() {
		// TODO Auto-generated method stub
		return sizeItem1.getText();
	}
	public String getQuantText() {
		// TODO Auto-generated method stub
		return quantItem1.getSelectedValue().toString();
	}

	
	


	

}
