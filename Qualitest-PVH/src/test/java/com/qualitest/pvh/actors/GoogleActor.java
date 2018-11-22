package com.qualitest.pvh.actors;

import com.qualitest.core.actor.BaseActor;
import com.qualitest.pvh.pages.GMailHomePage;
import com.qualitest.pvh.pages.GoogleEmailPage;
import com.qualitest.pvh.pages.GoogleSignInPage;

public class GoogleActor extends BaseActor {

	GoogleEmailPage googleEP;
	GMailHomePage googleHP;
	GoogleSignInPage googleSIP;
	
	/**
	 * Goes to the inboc by opening the gmail homepage
	 * Then it signs in
	 * @param email Sign in gmail email (needs to be valid)
	 * @param password Sign in gmail password (needs to be valid)
	 * @param num Number of seconds to wait on the gmail email list page
	 */
	public void goToInbox(String email, String password, int num) {
		googleHP.open();
		googleHP.clickSignIn();
		googleSIP.signIn(email, password, num);
	}

	/**
	 * Goes to the first email in the email list and clicks it
	 */
	public void goToEmailAndClickHere() {
		googleEP.clickFirstEmail();
		googleEP.clickClickHere();
	}
	
	/**
	 * Opens the google email list page. On the email list page, it clicks the select all button and clicks delete. To delete all
	 */
	public void goToInboxAndDeleteAllEmails() {
		googleEP.open();
		googleEP.deleteAllEmails();
	}
	
}
