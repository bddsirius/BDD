@module=checkout
Feature: Checkout
	Description: This feature allows user to checkout
	
@id=1
Scenario Outline: Adding new shipping address during checkout
    Given User access <brand> website
    And User add <item> to cart
    When User provides <guestFields> into address fields
    And User adds new address <newAddress> into fields
    Then User verifies that new address has been selected <newAddress>
	
	@brand=CKUS
	Examples:
	| brand  | item           | guestFields                                                                                           | newAddress                                                                                          |
	| CKUS   | 3-pack combed  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
	@brand=TH
	Examples:
	| brand  | item           |  guestFields                                                                                          | newAddress                                                                              						|
	| TH     | joggers women  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
	
	@brand=SPEEDO
	Examples:
	| brand  | item           |  guestFields                                                                                          | newAddress                                                                                          |
	| SPEEDO | joggers        | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |

@id=2
Scenario Outline: Editing shipping address during checkout
    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    When User edits and adds the address fields <editAddress>
    Then User verifies the editted address is selected <editAddress>
    
    @brand=CKUS
    Examples:
	| brand | email                     | password   | item            | editAddress                                                                                 |
	| CKUS  | ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | 3-pack combed   | ckSpeedoTH2@yopmail.com;Bobby;Smith; US 22;21;Bridgewater;New Jersey; ;08807;1234567890     |
	
	@brand=CKCA
    Examples:
	| brand | email                     | password   | item                | editAddress                                                                                     |
	| CKCA  | ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | striped sweater men | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;21;Calgary;Alberta; ;T2T 0C6;9085262900 |
	
	@brand=TH
	Examples:
	| brand | email                     | password   | item            | editAddress                                                                                             |
	| TH    | ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | joggers women   | ckSpeedoTH2@yopmail.com;Bobby;Smith; US 22;21;Bridgewater;New Jersey;United States;08807;1234567890     |
	
	@brand=SPEEDO
	Examples:
	| brand | email                     | password   | item            | editAddress                                                                                 |
	| SPEEDO| ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | flippers        | ckSpeedoTH2@yopmail.com;Bobby;Smith; US 22;21;Bridgewater;New Jersey; ;08807;1234567890     |
	
@id=3
Scenario Outline: Adding new billing address during checkout
	Given User access <brand> website
	And User add <item> to cart
	When User provides <guestFields> into address fields
	And User adds new address <newBilling> into billing fields
	Then User verifies that new billing address is selected <newBilling>
	
	@brand=CKUS
	Examples:
	| brand  | item           | guestFields                                                                                           | newBilling                                                                                          |
	| CKUS   | 3-pack combed  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
	@brand=TH
	Examples:
	| brand  | item           |  guestFields                                                                                          | newBilling                                                                                                      |
	| TH     | joggers women  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
	
	@brand=SPEEDO
	Examples:
	| brand  | item           |  guestFields                                                                                          | newBilling                                                                                          |
	| SPEEDO | joggers        | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |

@id=4
Scenario Outline: Editing billing address during checkout
    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
  	And User add <item> to cart
    And User goes to check out from cart
    And User adds new address <newBilling> into billing fields signed in
    When User edits and adds the billing address fields <editAddress>
    Then User verifies the editted billing address is selected <editAddress>
    
    @brand=CKUS
    Examples:
	| brand | email                     | password   | item            | editAddress                                                                                     | newBilling                                                                                          |
	| CKUS  | ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | 3-pack combed   | ckSpeedoTH2@yopmail.com;Alex;Smith; Frontier Road;21;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
	@brand=TH
	Examples:
	| brand | email                     | password   | item            | editAddress                                                                                         | newBilling                                                                                                      |
	| TH    | ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | joggers women   | ckSpeedoTH2@yopmail.com;Alex;Smith; US 22;21;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
	
	@brand=SPEEDO
	Examples:
	| brand | email                     | password   | item            | editAddress                                                                             |  newBilling                                                                                         |
	| SPEEDO| ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | flippers        | ckSpeedoTH2@yopmail.com;Alex;Smith; US 22;21;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |

@id=4
Scenario Outline: Editing billing address during checkout for CKCA
	Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User sends editted <billingAddress> and <shippingAddress> into CKCA fields
	And User sends payment information for CKCA
	Then User verifies the editted billing address is selected <billingAddress>
	
	@brand=CKCA
    Examples:
	| brand | email                     | password   | item            | shippingAddress                                                                                 | billingAddress                                                                                    |
	| CKCA  | ckSpeedoTH2@yopmail.com   | 1qaz@WSX   | 3-pack combed   | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932  Richmond Road;21;Calgary;Alberta; ;T2T 0C6;19085262900 | chck3+ckus@testmail.com;Shaun;Smith;461  Goyeau Ave;22;Windsor;Ontario;Canada;N9A 1H9;9082316660 |
	
@id=5
Scenario Outline: Selecting existing shipping address during checkout
	Given User access <brand> website
	And User add <item> to cart
	When User provides <guestFields> into address fields
    And User adds new address <newAddress> into fields
	Then User should verify selecting another shipping address applies to order

	@brand=CKUS
	Examples:
	| brand  | item           | guestFields                                                                                           | newAddress                                                                                          |
	| CKUS   | 3-pack combed  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
	@brand=TH
	Examples:
	| brand  | item           |  guestFields                                                                                          | newAddress                                                                                                      |
	| TH     | joggers women  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
	
	@brand=SPEEDO
	Examples:
	| brand  | item           |  guestFields                                                                                          | newAddress                                                                                          |
	| SPEEDO | joggers        | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=6
Scenario Outline: Selecting existing billing address during checkout
	Given User access <brand> website
	And User add <item> to cart
	When User provides <guestFields> into address fields
	And User adds new address <newBilling> into billing fields
	And User adds new address <secondNewBilling> into billing fields
	Then User should verify selecting another billing address applies to order <newBilling>

	@brand=CKUS
	Examples:
	| brand  | item           | guestFields                                                                                           | newBilling                                                                                                      | secondNewBilling                                                                                       |
	| CKUS   | 3-pack combed  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660    |
	
	@brand=TH
	Examples:
	| brand  | item           |  guestFields                                                                                          | newBilling                                                                                                      | secondNewBilling                                                                                                |
	| TH     | joggers women  | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
	
	@brand=SPEEDO
	Examples:
	| brand  | item           |  guestFields                                                                                          | newBilling                                                                                                      | secondNewBilling                                                                                       |
	| SPEEDO | joggers        | chck1speedo@gmail.com;Bobby;Smith;1200 US 22;21;Bridgewater;New Jersey; ;08807;1234567890             | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660             | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660    |

@id=7
Scenario Outline: Checkout using Visa card
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type | number           | code | expMonth | expYear |
	| CKUS  | Jeans   | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    |
	
	@brand=TH
	Examples:
	| brand | product  | addressFields                                                                                         | type | number           | code | expMonth | expYear |
	| TH    | sweaters | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand  | product | addressFields                                                                                         | type | number           | code | expMonth | expYear |
	| SPEEDO | fitness | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | 
    
@id=8
Scenario Outline: Checkout using MasterCard
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type       | number           | code | expMonth | expYear |
	| CKUS  | wallet  | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=TH
	Examples:
	| brand | product | addressFields                                                                                         | type       | number           | code | expMonth | expYear |
    | TH    | shirt   | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand | product | addressFields                                                                                         | type       | number           | code | expMonth | expYear |
	| SPEEDO| fitness | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | 
    
@id=9
Scenario Outline: Checkout using Discover card
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type     | number           | code | expMonth | expYear |
    | CKUS  | wallet  | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | Discover | 6011123412331112 | 456  | 10       | 2020    |
    
    @brand=TH
	Examples:
	| brand | product | addressFields                                                                                         | type     | number           | code | expMonth | expYear |
    | TH    | shirt   | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | Discover | 6011123412331112 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand | product | addressFields                                                                                         | type     | number           | code | expMonth | expYear |
	| SPEEDO| fitness | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | Discover | 6011123412331112 | 456  | 10       | 2020    | 
        
@id=10
Scenario Outline: Verify checkout using American Express card
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type             | number          | code | expMonth | expYear |
	| CKUS  | wallet  | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | American Express | 378282246310005 | 4561 | 10       | 2020    | 

	@brand=TH
	Examples:
	| brand | product | addressFields                                                                                         | type             | number          | code | expMonth | expYear |
	| TH    | shirt   | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005 | 4561 | 10       | 2020    |

	@brand=SPEEDO
    Examples:
    | brand  | product | addressFields                                                                                         | type             | number           | code | expMonth | expYear |
	| SPEEDO | fitness | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 456  | 10       | 2020    | 

@id=11
Scenario Outline: Verify checkout using Paypal
	Given User access <brand> website
	And User add <item> to cart
	When User provides <guestFields> into address fields
	And User select shipping method <shippingMethod>
	And User submit order using paypal account <email> and <password>
	Then User verify summary of order submitted using paypal
	And User cancels the order
		
	@brand=CKUS
	Examples:
	| brand | item          |guestFields                                                                                              |email               |password|shippingMethod|
	| CKUS  | jacket        |Testerpvh1@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |Testerpvh1@gmail.com|passw0rd|standard      |
	
	@brand=TH
	Examples:
	| brand | item          |guestFields                                                                                              |email               |password|shippingMethod|
	| TH    | bra           |Testerpvh1@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |Testerpvh1@gmail.com|passw0rd|standard      |
	
	@brand=SPEEDO
	Examples:
	| brand | item          |guestFields                                                                                              |email               |password|shippingMethod|
	| SPEEDO| briefs        |Testerpvh1@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |Testerpvh1@gmail.com|passw0rd|standard      |

@id=11
Scenario Outline: Verify checkout using Paypal
	Given User access <brand> website
    And User add <item> to cart
    When User edits and adds the address fields <editAddress>
    And User navigates to Paypal Checkout	
    And User pays with Paypal <email> and <password>
    And User cancels the order
		
	@brand=CKCA
	Examples:
	| brand | item          |editAddress                                                                                              |email               |password|
	| CKCA  | jacket        |chck3+ckus@testmail.com;Shaun;Smith;461 Goyeau Ave;22;Windsor;Ontario;Canada;N9A 1H9;9082316660         |Testerpvh1@gmail.com|passw0rd|
	
@testType=positive @testType=smoke @id=12
Scenario Outline: Verify checkout using GiftCard
	Given User access <brand> website
	And User add <item> to cart
    When User provides <guestFields> into address fields
	And User provides GiftCard information <number> and <pin>
	Then User verifies GiftCard was applied

	@brand=CKUS
	Examples:
	| brand | item          |guestFields                                                                                           |number          |  pin   |
	| CKUS  | wallet        |testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |7777063816079827|42679890|
	
	@brand=CKCA
	Examples:
	| brand | item          |guestFields                                                                                           |number          |  pin   |
	| CKCA  | wallet        |testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |7777063816079827|42679890|
	
	@brand=TH
	Examples:
    | brand | item          |guestFields                                                                                           |number             |  pin   |
	| TH    | stock         |testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |6006492136503706713|  1256  |
	

@id=13	
Scenario Outline: Verify checkout using Loyalty
	Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User selects loyalty rewards <rewardAmount>
    Then User verifies that a hundred dollar loyalty award is applied
    And User cancels the order
	
	@brand=CKUS
	Examples:
	| brand | item          | email                             | password  | rewardAmount |
	| CKUS  | wallet        | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        |
	

@id=14
Scenario Outline: Verify checkout using Shoprunner
	Given User access <brand> website
	And User add <item> to cart
	And User checkout using Shoprunner <email> and <password>
	Then User verifies order summary page matches purchase and shoprunner
	And User cancels the order
	
	@brand=CKUS
	Examples:
	| brand | item          |email                 |  password     |
	| CKUS  | jacket        |testatech123@gmail.com|  password123  |
	
	@brand=TH
	Examples:
	| brand | item          |email                 |  password     |
	| TH    | jacket        |testatech123@gmail.com|  password123  |
	
	@brand=SPEEDO
	Examples:
	| brand    | item       |email                 |  password     |
	| SPEEDO   | jacket     |testatech123@gmail.com|  password123  |
	
	
@id=15
Scenario Outline: Checkout using CreditCard and GiftCard
	Given User access <brand> website
	And User add <item> to cart
    When User provides <addressFields> into address fields 
	And User provides GiftCard information <giftCardNumber>, <giftCardPin>
	Then User verifies GiftCard was applied
	And User submit order using credit card <creditCardType>, <creditCardNumber>, <creditCardCode>, <creditCardExpMonth>, <creditCardeExpYear>
	Then User verify summary of order submitted using credit card <creditCardType>
		
	@brand=CKUS
	Examples: Calvin Klein - US
	| brand | item    | addressFields                                                                                         | creditCardType   | creditCardNumber | creditCardCode | creditCardExpMonth | creditCardeExpYear | giftCardNumber   | giftCardPin |
	| CKUS  | jackets | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA             | 4111111111111111 | 456            | 10                 | 2020               | 7777063816079827 | 42679890    |
	| CKUS  | jackets | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard       | 5555555555554444 | 456            | 10                 | 2020               | 7777063816079827 | 42679890    |
	| CKUS  | jackets | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | Discover         | 6011123412331112 | 456            | 10                 | 2020               | 7777063816079827 | 42679890    |
	| CKUS  | jackets | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 4561           | 10                 | 2020               | 7777063816079827 | 42679890    |
	
	@brand=TH
	Examples: Tommy Hilfiger
	| brand | item   | addressFields                                                                                         | creditCardType   | creditCardNumber | creditCardCode | creditCardExpMonth | creditCardeExpYear | giftCardNumber     | giftCardPin |
	| TH    | jacket | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA             | 4111111111111111 | 456            | 10                 | 2020               | 6006492136503497289| 9654        |
	| TH    | jacket | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard       | 5555555555554444 | 456            | 10                 | 2020               | 6006492136503497289| 9654        |
	| TH    | jacket | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | Discover         | 6011123412331112 | 456            | 10                 | 2020               | 6006492136503497289| 9654        |
	| TH    | jacket | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 4561           | 10                 | 2020               | 6006492136503497289| 9654        |


@id=16
Scenario Outline: Verify checkout using Paypal and GiftCard
	Given User access <brand> website
	And User add <item> to cart
	When User provides <guestFields> into address fields
	And User provides GiftCard information <number> and <pin>
	Then User verifies GiftCard was applied
	And User navigates to Paypal Checkout
	And User pays with Paypal <email> and <password>
	Then User verifies order summary page matches purchase and paypal
	And User cancels the order
	
	@brand=CKUS
	Examples:
	| brand | item          |guestFields                                                                                              |number              |pin      |email               |password|
	| CKUS  | jacket        |Testerpvh1@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |7777063816079827    |42679890 |Testerpvh1@gmail.com|passw0rd|
	
	@brand=TH
	Examples:
	| brand | item          |guestFields                                                                                              |number             |  pin   |email               |password|
	| TH    | bra           |Testerpvh1@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |6006492136503497289|  9654  |Testerpvh1@gmail.com|passw0rd|
	
	@brand=SPEEDO
	Examples:
	| brand | item          |guestFields                                                                                              |email               |password|
	| SPEEDO| jacket        |Testerpvh1@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 |Testerpvh1@gmail.com|passw0rd|
		
@id=17
Scenario Outline: Verify checkout using CreditCard and Loyalty
	Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User selects loyalty rewards <rewardAmount>
    And User provides payment information for loyalty <Type>, <Number>, <Code>, <expMonth>, <expYear>
    Then User verifies that the award was applied with valid billing information <rewardAmount>
	And User cancels the order
	
	@brand=CKUS
	Examples:
	| brand | item           | email                             | password  | rewardAmount | Type             |Number           |Code|expMonth|expYear|
	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | VISA             |4111111111111111 |456 |10      | 2020  |
	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | MasterCard       |5555555555554444 |456 |10      | 2020  |
	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | Discover         |6011123412331112 |456 |10      | 2020  |
	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | American Express |341111111111111  |4563|10      | 2020  |

@id=19
Scenario Outline: Verify checkout using Credit Card, GiftCard, Loyalty
	Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User selects loyalty rewards <rewardAmount>
    And User enters gift card fields <giftNumber>, <giftPin>
    And User provides payment information for loyalty <Type>, <Number>, <Code>, <expMonth>, <expYear>
    Then User will verify gift card, credit card and loyalty used <rewardAmount>, <Type>
    And User cancels the order
    
	
	@brand=CKUS
	Examples:
	| brand | item     | email                             | password  | rewardAmount | Type             |Number           |Code|expMonth|expYear| giftNumber        | giftPin  |
	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | VISA             |4111111111111111 |456 |10      | 2020  | 7777063816079827  | 42679890 |
	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | MasterCard       |5555555555554444 |456 |10      | 2020  | 7777063816079827  | 42679890 |
	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | Discover         |6011123412331112 |456 |10      | 2020  | 7777063816079827  | 42679890 |
	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com    | Passw0rd  | 15.00        | American Express |341111111111111  |4563|10      | 2020  | 7777063816079827  | 42679890 |

@id=21
Scenario Outline: Verify checkout using Shoprunner and Giftcard
	Given User access <brand> website
	And User order product <item>
	And User login using Shoprunner <email> and <password>
	And User applies giftcard in Shoprunner with giftcard <number> and <pin>
	And User checkout Shoprunner
	Then User verifies order summary page matches purchase and shoprunner
	And User cancels the order
	
	@brand=CKUS
	Examples:
	| brand | item           |email                 |  password     | number          | pin    |
	| CKUS  | watch          |testatech123@gmail.com|  password123  | 7777063816087566|67910187|
	
@id=23
Scenario Outline: Verify checkout from minicart
	Given User access <brand> website
	When User searches for <product>
	And User clicks on product
	And User chooses random size
	Then User verifies they are on the checkout page

	@brand=TH
	Examples:
	| brand | product |
	| TH    | Shirts  |
	
@id=24
Scenario Outline: Verify editing an item during checkout
    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User proceeds to secure checkout
    And User edits an item at checkout
    Then User verifies that the item has been edited
	@brand=CKUS
	Examples:
	| brand  | email                     |  password | item       |        
	| CKUS   | qualitestanish1@gmail.com |  Calvin1  | 54011737	  | 
	
@id=25
Scenario Outline: Verify removing an item during checkout
    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User proceeds to secure checkout
    Then User removes and verifies that item is removed
	@brand=CKUS
	Examples:
	| brand  | email                     |  password | item       |        
	| CKUS   | qualitestanish1@gmail.com |  Calvin1  | 54011737	  | 
	
	
	@brand=TH
	Examples:
	| brand  | email                        |  password  | item       |        
	| TH     | qualitestanish1@gmail.com    |  Tommy1    | 7646083	  | 
	
	@brand=SPEEDO
	Examples:
	| brand  | email                        	|  password  | item       |        
	| SPEEDO | qualitestanish1@gmail.com        |  Speedo1   | mens tops  | 
	
@id=26
Scenario Outline: Verify applying a promo code during checkout
	Given User access <brand> website
	And User add <item> to cart
	When User applies checkout promo code <code>
	Then User verifies that promo code is applied in checkout
	
	
  @brand=CKUS
  Examples: 
  | brand | item           | code           | secondItem    |
  | CKUS  | 21801776-438   | FALL20         | 72253719      |
   
  @brand=TH 
  Examples: 
  | brand | item           | code           | secondItem    |
  | TH    | FM01016        | CCP2B61QF      | UU00004       |
  
  @brand=SPEEDO
  Examples:
  | brand | item           | code           | secondItem    |
  | SPEEDO| 7719782-2      | LTF25          | 7723019       |

@id=27
Scenario Outline: Verify removing a promo code during checkout
	Given User access <brand> website
	And User add <item> to cart
	When User applies checkout promo code <code>
	Then User verifies removing promo code applied
	
 @brand=CKUS
  Examples: 
  | brand | item           | code           | secondItem    |
  | CKUS  | 21801776-438   | FALL20         | 72253719      |
   
  @brand=TH 
  Examples: 
  | brand | item           | code           | secondItem    |
  | TH    | FM01016        | CCP2B61QF      | UU00004       |
  
  @brand=SPEEDO
  Examples:
  | brand | item           | code           | secondItem    |
  | SPEEDO| 7719782-2      | LTF25          | 7723019       |

@id=28
Scenario Outline: Verify updating quantity during checkout
	Given User access <brand> website
	And User add <product> to cart
	And User adjusts to <quantity> on checkout page
	Then User verifies item quantity is updated
	
	@brand=CKUS
	Examples:
	| brand | product        | quantity |
	| CKUS  | shirt          | 2        |
	
	@brand=TH
	Examples:
	| brand | product        | quantity |
	| TH    | shirt          | 2        |
	
	@brand=SPEEDO
	Examples:
	| brand  | product        | quantity |
	| SPEEDO | shirt          | 2        |

@id=29
Scenario Outline: Verify adding new shipping address during checkout from review order page
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User adds new address <newAddress> into fields from review order page
    Then User verifies that new address has been selected <newAddress>

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type | number           | code | expMonth | expYear | newAddress                                                                                          |
	| CKUS  | wallet  | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
	@brand=TH
	Examples:
	| brand | product  | addressFields                                                                                         | type | number           | code | expMonth | expYear | newAddress                                                                                                      |
	| TH    | sweaters | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
    
    @brand=SPEEDO
    Examples:
    | brand  | product | addressFields                                                                                         | type | number           | code | expMonth | expYear | newAddress                                                                                          |
	| SPEEDO | flipper | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
    
@id=30
Scenario Outline: Verify adding new billing address during checkout from review order page
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User adds new address <newBilling> into billing fields from review order page
	Then User verifies that new billing address is selected <newBilling>

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type | number           | code | expMonth | expYear | newBilling                                                                                        |
	| CKUS  | wallet  | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
	@brand=TH
	Examples:
	| brand | product  | addressFields                                                                                         | type | number           | code | expMonth | expYear | newBilling                                                                                                    |
	| TH    | sweaters | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
    
    @brand=SPEEDO
    Examples:
    | brand  | product | addressFields                                                                                         | type | number           | code | expMonth | expYear | newBilling                                                                                          |
	| SPEEDO | bag     | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 			   | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
    
@id=31
Scenario Outline: Verify editing shipping method during checkout from review order page
	Given User access <brand> website
	And User add <product> to cart
	When User provides <addressFields> into address fields
	And User select shipping method <shippingMethod>
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User selects shipping method <shippingMethod2> from review order page
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verifies shipping method has been edited to <shippingMethod2>
	
	
	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                       |shippingMethod| type | number           | code | expMonth | expYear |shippingMethod2|
	| CKUS  | wallet  | testing@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey; ;08807;7323257940 |standard      | VISA | 4111111111111111 | 456  | 10       | 2020    |overnight      |
	
	@brand=TH
	Examples:
	| brand | product  | addressFields                                                                                         |shippingMethod| type | number           | code | expMonth | expYear |shippingMethod2|
	| TH    | pants    | testing@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey;United States;08807;1234567890 |standard      | VISA | 4111111111111111 | 456  | 10       | 2020    |overnight      |
    
    @brand=SPEEDO
	Examples:
	| brand | product  | addressFields                                                                                         |shippingMethod| type | number           | code | expMonth | expYear |shippingMethod2|
	| SPEEDO| flipper  | testing@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey;United States;08807;1234567890 |standard      | VISA | 4111111111111111 | 456  | 10       | 2020    |overnight      |
	
@id=32
Scenario Outline: Verify editing payment method during checkout from review order page
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User edits payment information on review order page
	And User enters payment information using credit card <type2>, <number2>, <code2>, <expMonth2>, <expYear2>
    Then User verifies the payment information was updated with <type2>, <number2>, <expMonth2>, <expYear2>
    
	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type | number           | code | expMonth | expYear | type2       | number2          | code2| expMonth2| expYear2|
	| CKUS  | wallet  | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | MasterCard  | 5555555555554444 | 456  | 10       | 2020    |
	
	@brand=TH
	Examples:
	| brand | product  | addressFields                                                                                         | type | number           | code | expMonth | expYear |  type2       | number2          | code2| expMonth2| expYear2|
	| TH    | sweaters | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | MasterCard   | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand  | product | addressFields                                                                                             | type | number           | code | expMonth | expYear |  type2       | number2          | code2| expMonth2| expYear2|
	| SPEEDO | flipper | testing@gmail.com;Anish11;Patel11;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | MasterCard   | 5555555555554444 | 456  | 10       | 2020    |

@id=33
Scenario Outline: Verify navigating back from review order page
    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User proceeds to secure checkout
    And User clicks next
    And User provides payment information without submitting <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    Then User verifies can navigate back
	
	@brand=CKUS
	Examples:
	| brand  | email                     |  password | item       | type | number           | code | expMonth | expYear |       
	| CKUS   | qualitestanish1@gmail.com |  Calvin1  | bag   	  | VISA | 4111111111111111 | 456  | 10       | 2020    | 
	
	@brand=TH
	Examples:
	| brand  | email                        |  password  | item       | type | number           | code | expMonth | expYear |             
	| TH     | qualitestanish1@gmail.com    |  Tommy1    | jacket 	  | VISA | 4111111111111111 | 456  | 10       | 2020    |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                        	|  password  | item       |   type | number           | code | expMonth | expYear |                   
	| SPEEDO     | qualitestanish1@gmail.com    |  Speedo1   | mens tops  |   VISA | 4111111111111111 | 456  | 10       | 2020    |
	
@id=34
Scenario Outline: Verify editing order item from review order page
    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User proceeds to secure checkout
    And User clicks next
    And User provides payment information without submitting <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User verifies can edit order
    And User edits product to another size 
	Then User verify edit change in bag
	@brand=CKUS
	Examples:
	| brand  | email                     |  password | item       | type | number           | code | expMonth | expYear |       
	| CKUS   | qualitestanish1@gmail.com |  Calvin1  | 54011737	  | VISA | 4111111111111111 | 456  | 10       | 2020    | 
	
	
	@brand=TH
	Examples:
	| brand  | email                        |  password  | item       | type | number           | code | expMonth | expYear |             
	| TH     | qualitestanish1@gmail.com    |  Tommy1    | 7646083	  | VISA | 4111111111111111 | 456  | 10       | 2020    |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                        	|  password  | item       |   type | number           | code | expMonth | expYear |                   
	| SPEEDO     | qualitestanish1@gmail.com    |  Speedo1   | womens tops|   VISA | 4111111111111111 | 456  | 10       | 2020    |
 