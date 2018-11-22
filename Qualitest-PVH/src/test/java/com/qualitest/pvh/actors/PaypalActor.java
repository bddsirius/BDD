package com.qualitest.pvh.actors;

import com.qualitest.core.actor.BaseActor;
import com.qualitest.pvh.pages.PaypalCheckoutPage;
import com.qualitest.pvh.pages.PaypalHomePage;
import com.qualitest.pvh.pages.PaypalSignInPage;

public class PaypalActor extends BaseActor{

	PaypalHomePage ppHOP;
	PaypalSignInPage ppSIP;
	PaypalCheckoutPage ppCOP;
	
	/**
	 * Step to login with provided Paypal account
	 * @param email - Paypal email address
	 * @param password - Paypal password
	 */
	public void PayWithPaypal(String email, String password) {
		ppHOP.clickLogin();
		ppSIP.loginToPaypal(email, password);
		ppCOP.clickPayNow();
	}
	
	public void PayWithPaypalCKCA(String email, String password) {
		ppSIP.loginToPaypal(email, password);
		ppCOP.clickPayNow();
	}
	
}
