package com.qualitest.pvh.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
/*@CucumberOptions(features= {
				"src/test/resources/features/Login.feature",
				"src/test/resources/features/Registration.feature",
				"src/test/resources/features/ForgotPassword.feature",
				"src/test/resources/features/Search.feature",
				"src/test/resources/features/BagCart.feature",
				"src/test/resources/features/Checkout.feature",
				"src/test/resources/features/Footer.feature",
				"src/test/resources/features/Wishlist.feature",
				"src/test/resources/features/Loyalty.feature",
				"src/test/resources/features/Promotions.feature",
				"src/test/resources/features/MyAccount.feature",
				"src/test/resources/features/Email.feature",
				"src/test/resources/features/ModifyOrder.feature",
				"src/test/resources/features/Navigation.feature",
				"src/test/resources/features/StoreLocator.feature",
				"src/test/resources/features/FilterSortProduct.feature"
				},
		glue = {"com.qualitest.pvh.teststeps"}
		)*/


//@CucumberOptions(features= "src/test/resources/features", tags="@bagcart , @checkout",  format = {"pretty"},  glue = {"com.qualitest.pvh.teststeps"} )
@CucumberOptions(
strict = true, 
monochrome = true, 
features = {"src/test/resources/features"},
dryRun = false, 
glue = {"com.qualitest.pvh.teststeps"}, 
tags = {},
plugin = { "pretty",  "json:target/RawJsonResult/Windows7Chrome60.json"}
)
public class TestRunner {}  