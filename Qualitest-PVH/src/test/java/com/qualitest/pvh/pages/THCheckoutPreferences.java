package com.qualitest.pvh.pages;

public class THCheckoutPreferences extends CheckoutPreferences {

	//@Override
	//protected void selectState(String state) {
	//	stateSelect.type(state);
	//}
	
	@Override
	public void editCheckoutInformation(String guestFields) {
		// TODO Auto-generated method stub
		checkForEnterAddrMan();
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectCountry(arr[5]);
		selectState(arr[6]);
		enterZip(arr[7]);
		enterPhone(arr[8]);
		if(checkForCreditCardInfo())
		{
			enterCreditCard(arr[9]);
			selectExpMonth(arr[10]);
			selectExpYear(arr[11]);
		}
		clickUpdate();
	}
}
