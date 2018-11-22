@module=bagCart
Feature: Bag and Cart
Description: This feature uses Bag and Cart to verify 

@id=1
Scenario Outline: Add product to cart from product details page as guest user
	Given User access <brand> website
	When User searches for <product>
	And User clicks on product
	And User chooses random size
	And User selects the quantity and sets it to <firstquantity> and adds it to bag
	Then User verifies title on product page matches item on cart page
	
	@brand=CKUS
	Examples:
	| brand	 | product 		   | firstquantity |
	| CKUS   | mens dress pants| 1             |


	@brand=CKCA
	Examples:
	| brand	 | product 		   | firstquantity |
	| CKUS   | mens dress pants| 1             |


	@brand=TH
	Examples:
	| brand  | product          | firstquantity |
	| TH     | womens jeans     | 1             |

	
	@brand=SPEEDO
	Examples:
	| brand  | product         | firstquantity |
	| SPEEDO | red             | 1             |
