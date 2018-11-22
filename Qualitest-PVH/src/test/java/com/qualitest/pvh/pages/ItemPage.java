package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.naming.LimitExceededException;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class ItemPage extends BasePage {

	@FindBy(id = "add2CartBtn")
	private BaseElement addToBag;

	@FindBy(xpath = "//*[@id='mini_cart_link']")
	private BaseElement cart;

	@FindBy(id = "shopping-bag-link")
	private BaseElement cartPopUp;

	@FindBy(id = "WC_MiniShopCartDisplay_link_1_1")
	private BaseElement firstItemInBagDisplay;

	@FindBy(id = "WC_MiniShopCartDisplay_link_1_1")
	private BaseElement firstProductInCartDisplay;

	@FindBy(xpath = "//*[@class = 'inventoryStatus high']")
	private BaseElement highStock;

	@FindBy(xpath = "//*[@id=\"contentRecommendationWidget_Logo\"]/div/a")
	private BaseElement homePageButton;

	@FindBy(className = "mini_cart_product clearfix ")
	protected List<WebElement> itemsInBag;

	@FindBy(xpath = "//*[@class= 'inventoryStatus low']")
	protected BaseElement lowStock;

	@FindBy(xpath = "//*[@id=\"product\"]/div[2]/div/div[2]/div[2]/div/h1/span")
	private BaseElement nameOfProduct;

	@FindBy(xpath = "//*[@id = 'price_display']/span")
	private List<WebElement> offerPrices;

	@FindBy(id = "size_S_one_space_size")
	protected BaseElement oneSize;

	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
	protected BaseElement outOfStock;

	@FindBy(className = "productNameInner")
	private BaseElement productName;

	@FindBy(id = "price_display")
	private BaseElement productPrice;

	@FindBy(id = "dk_selected")
	private BaseElement quantity;

	@FindBy(xpath = "//*[@class='dk_options_inner']/li")
	protected List<WebElement> quantityNum;

	@FindBy(id = "size_S_l")
	private BaseElement sizeLarge;

	@FindBy(id = "size_S_m")
	private BaseElement sizeMed;

	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeSelectors;

	@FindBy(id = "size_S_s")
	private BaseElement sizeSmall;

	@FindBy(xpath = "//*[@class = 'styleNumber']")
	private BaseElement styleNumber;

	@FindBy(xpath = "//*[@id = 'qty_']")
	private List<WebElement> quantities;

	@FindBy(xpath = "//*[@class = 'product_title']/h3/a")
	private List<WebElement> listOfItems;

	@FindBy(xpath = "//*[@id='add2WishlistRight']")
	private WebElement addToWishlist;

	@FindBy(xpath = "//*[@class = 'productNameInner']")
	private BaseElement productNameProductDetails;
	
	@FindBy(id="fieldErrorMessage")
	private BaseElement selectSizeError;

	@FindBy(xpath = "//*[@id = 'swatchcontainer']/ul/li")
	private List<WebElement> listOfColors;
	
	@FindBy(id = "colorValue")
	private BaseElement colorVal;
	
	@FindBy(id = "replaceBtn")
	protected BaseElement replaceButton;
	
	@FindBy(xpath = "//*[@id = 'pageLevelMessage']")
	protected BaseElement pageLevelMessage;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ItemPage.class);
	
	private SoftAssertions SA = new SoftAssertions();

	protected HomePage homePage;

	public String getColorText()
	{
		return colorVal.getText();
	}
	public void clickColorOption(int num)
	{
		
		listOfColors.get(num).click();
	}
	
	
	public String getPageLevelMessage()
	{
		if(pageLevelMessage.exists())
		{
			return pageLevelMessage.getText();
		}
		else
		{
			return " ";
		}
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
	 * Chooses the first avialable size and adds it to the cart
	 */
	public void chooseRandomSizeandAddToBag() {
		pageRefresh();
		if (oneSize.exists()) {
			LOGGER.info("There is only one size, which is the one that is selected and added");
			if (pageLevelMessage.exists() || outOfStock.exists()) {
				LOGGER.info("Error exists: " + pageLevelMessage.getText());
			}
		} else if (sizeSelectors.size() == 1) {
			LOGGER.info("There is only one selction of sizes and user is selecting from");
			List<WebElement> size = sizeSelectors.get(0).findElements(By.className("available"));
			for (WebElement s : size) {
				LOGGER.info("Clicking the size of: " + s.getText());
				s.click();
				if (outOfStock.exists()) {
					LOGGER.info("There is no inventory for: " + s.getText());
					continue;
				}
				if (!outOfStock.exists()) {
					LOGGER.info("Stopping cycle of searching for size");
					break;
				}
			}
		} else {
			List<WebElement> length = sizeSelectors.get(1).findElements(By.className("available"));
			for (WebElement l : length) {
				LOGGER.info("List of lengths are: " + l.getText());
			}
			for (WebElement l : length) {
				LOGGER.info("Clicking length size " + l.getText());
				l.click();
				List<WebElement> waist = sizeSelectors.get(0).findElements(By.className("available"));
				for (WebElement w : waist) {
					LOGGER.info("List of waists are: " + w.getText());
				}
				for (WebElement w : waist) {
					LOGGER.info("Clicking waist size: " + w.getText());
					w.click();
					if (outOfStock.exists()) {
						LOGGER.info("There is no inventory for: " + w.getText());
						continue;
					}
					if (!outOfStock.exists()) {
						break;
					}
				}
				if (outOfStock.exists()) {
					l.click();
					continue;
				}
				if (!outOfStock.exists()) {
					break;
				}
			}
		}
	}

	/**
	 * Method to click addToBag button on product details page
	 */
	public void clickAddToBag() {
		LOGGER.info("Clicking add to bag");
		addToBag.click();
	}

	/**
	 * Method to navigate to cart page from product details page
	 */
	public void clickGoToCart() {
		LOGGER.info("Clicking go to cart");
		if (cartPopUp.exists()) {
			LOGGER.info("Clicking the go to cart button on the popup window on the top right");
			cartPopUp.click();
		} else {
			LOGGER.info("Clicking on the standard cart link on the top right");
			cart.waitUntilClickable().click();
		}
	}

	public String getSizesSelected() {

		LOGGER.info("Retrieving size of the item");
		if (oneSize.exists()) {
			LOGGER.info("Returning a size of 0 because there weren't any sizes to choose from");
			return "One Size";
		} else if (sizeSelectors.size() == 1) {
			try {
				String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'selected available']/span"))
						.getText();
				LOGGER.info("Returning a size of: " + i);
				return i;
			} catch (Exception e) {
				String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'available selected']/span"))
						.getText();
				LOGGER.info("Returning a size of: " + i);
				return i;
			}
		} else {
			String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'selected available']/span")).getText();
			String j = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'available selected']/span")).getText();
			String ret = i + "/" + j;
			LOGGER.info("Returning a size of: " + ret);
			return ret;
		}
	}

	public void clickHomePage() {
		LOGGER.info("Clicking the homepage icon to go back to homepage");
		homePageButton.click();
	}

	/**
	 * click the large button for size
	 */
	public void clickLarge() {
		LOGGER.info("Clicking Large");
		sizeLarge.click();
	}

	/**
	 * Click the medium button for size
	 */
	public void clickMed() {
		LOGGER.info("Clicking medium");
		sizeMed.click();
	}

	/**
	 * Click the small button for size
	 */
	public void clickSmall() {
		LOGGER.info("Clicking small");
		sizeSmall.click();
	}

	public String getNameOfFirstItemInBagDisplay() {
		String name = firstProductInCartDisplay.getText();
		LOGGER.info("Retrieving name of the first product in cart display as: " + name);
		return name;
	}

	/**
	 * Gets the name of a product
	 * 
	 * @return
	 */
	public String getNameOfProduct() {
		String name = nameOfProduct.getText();
		LOGGER.info("Retrieving name of product: " + name);
		return name;
	}

	public String getPrice() {
		String price = productPrice.getText();
		LOGGER.info("The price of the product is: " + price);
		return price;
	}

	/**
	 * Method to retrieve product name from product details page
	 * 
	 * @return - Product Name
	 */
	public String getProductName() {
		String name = productName.getText();
		LOGGER.info("Product name retrieved: " + name);
		return name;
	}

	/**
	 * Returns a string of the style number
	 * 
	 * @return
	 */
	public String getStyleNumber() {
		String text = styleNumber.getText();
		LOGGER.info("Retrieving style number: " + text);
		return text;
	}

	public void goToCart() {
		LOGGER.info("Clicking the checkout button");
		cartPopUp.click();
	}

	public int lowStockGetInt() {
		String s = lowStock.getText();
		String[] splited = s.split("\\s+");
		int i = Integer.parseInt(splited[1]);
		LOGGER.info("Returning an int of :" + i + " in low stock");
		return i;
	}

	public void processOrder(String size) {
		if (size.equalsIgnoreCase("small")) {
			clickSmall();
		} else if (size.equalsIgnoreCase("medium")) {
			clickMed();
		} else if (size.equalsIgnoreCase("large")) {
			clickLarge();
		} else {
			LOGGER.info("Must pick small, med or large");
		}
		clickAddToBag();
		goToCart();
	}

	/**
	 * Method to retrieve product price
	 * 
	 * @return - Product price
	 */
	public float returnOfferPrice() {
		WebElement w;
		if (offerPrices.size() == 1) {
			w = offerPrices.get(0);
		} else {
			w = offerPrices.get(1);
		}
		String s = w.getText();
		s = s.replace("$", "");
		s = s.replaceAll(",", "");
		if(s.contains("CAD")) {
			s = s.replace("CAD ", "");
		}
		LOGGER.info("Product price is: " + s);
		float f = Float.parseFloat(s);
		return f;
	}

	/**
	 * Select an item size that is either small, medium or large
	 * 
	 * @param size
	 */
	public void selectItemToCart(String size) {
		LOGGER.info("Selecting item of size " + size);
		if (size.equalsIgnoreCase("small")) {
			clickSmall();
		} else if (size.equalsIgnoreCase("medium")) {
			clickMed();
		} else if (size.equalsIgnoreCase("large")) {
			clickLarge();
		} else {
			LOGGER.info("Must pick small, med or large");
		}
		clickAddToBag();
		clickGoToCart();
	}

	public void selectQuantity(String quant) {
	
		Float quantfloat = Float.parseFloat(quant);
		quantity.click();
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
		clickAddToBag();
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

	public void adjustQuantity(String name, String quant) {
		getDriver().navigate().refresh();
		int iteration = -1;
		Float quantfloat = Float.parseFloat(quant);
		LOGGER.info("The list of items is size: " + listOfItems.size());
		for (int i = 0; i < listOfItems.size(); i++) {
			String s = listOfItems.get(i).getText();
			if (s.equalsIgnoreCase(name)) {
				LOGGER.info("The name found here: " + s);
				iteration = i;
			}
		}
		if (iteration < 0) {
			LOGGER.info("The name of the item is not in the cart");
		} else {
			LOGGER.info("Found the name in the cart, selecting quantity");
			WebElement w = quantities.get(iteration);
			LOGGER.info("Selecting " + quant + " in the dropdown");
			LOGGER.info("The amount of stock left is: " + checkStock());
			if (checkStock() != 0 & checkStock() < quantfloat) {
				int stock = checkStock().intValue();
				Select quantdropdown = new Select(w);
				quantdropdown.selectByVisibleText(Integer.toString(stock));
			} else {
				Select roledropdown = new Select(w);
				roledropdown.selectByVisibleText(quant);
			}
		}
	}

	public void addToWishList() {
		LOGGER.info("Adding item to wishlist...");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", addToWishlist);
		waitABit(5000);
		addToWishlist.click();
	}

	/**
	 * Method to verify product details page displayed for provided style number
	 * 
	 * @param styleNum - Style Number of the product
	 */
	public void verifyProductDetailsPageForSpecificStyleNumber(String styleNum) {
		LOGGER.info("Verifying stlye number on product details page");
		String pdpStyleNumber = styleNumber.getText();
		assertThat(pdpStyleNumber).as("Product Details Page displayed for product with Style Number")
				.isEqualTo(styleNum);
	}

	
	
	public void selectQuantityInPopup(String quant) {
		Float quantfloat = Float.parseFloat(quant);
		quantity.click();
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
	public void verifyPleaseSelectSize() {
		LOGGER.info("Verifying the user is prompted to select a size...");
		SA.assertThat(selectSizeError.getText()).containsIgnoringCase("Please select a size");
		SA.assertAll();
	}
	
	public void verifyPageLevelError(String error) {
		assertThat(pageLevelMessage.getText()).as("Page level error").isEqualToIgnoringCase(error);
	}
	
	public void adjustQuantityAddToBag(int quant)
	{
		quantity.click();
		quantityNum.get(quant).click();
		addToBag.click();
	}
}
