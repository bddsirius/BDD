package com.qualitest.core.util;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;

import com.qualitest.core.element.BaseElement;

public final class Verify {
	
	private static boolean useSoftAssertions = false;
	
	private static SoftAssertions softAssertions = new SoftAssertions();
	
	private Verify(){
		// Private constructor to prevent instantiation
	}
	
	public static void useSoftAssertions(boolean useSoft) {
		useSoftAssertions = useSoft;
	}
	
	public static void pushSoftAssertions()	{
		softAssertions.assertAll();
	}

	public static void exists(BaseElement e, boolean expected, String validationText) {
		actualExpected(e.exists(), expected, validationText);
	}

	public static void exists(BaseElement e, boolean expected) {
		String msg = msgBoolean(expected,  "element %s exists on page", "element %s does not exist on page");
		exists(e, expected, String.format(msg, e));
	}

	public static void enabled(BaseElement e, boolean expected, String validationText) {
		actualExpected(e.isCurrentlyEnabled(), expected, validationText);
	}

	public static void enabled(BaseElement e, boolean expected) {
		String msg = msgBoolean(expected, "element %s is enabled on page", "element %s is disabled on page");
		enabled(e, expected, String.format(msg, e));
	}

	public static void text(BaseElement e, String expected, String validationText) {
		if (useSoftAssertions)
			softAssertions.assertThat(e.getFill()).as(validationText).isEqualTo(expected);
		else {
			assertThat(e.getFill()).as(validationText).isEqualTo(expected);
		}
	}
	
	public static void actualExpected(boolean actual, boolean expected, String validationMsg) {
		validationMsg = "Verification " + validationMsg;
				
		if(actual != expected) {
			if(useSoftAssertions)
				softAssertions.fail(validationMsg);
			else
				fail(validationMsg);
		}
	}

	private static String msgBoolean(boolean condition, String stringTrue, String stringFalse) {	
		return condition? stringTrue:stringFalse;
	}

}
