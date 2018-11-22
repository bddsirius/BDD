@module=Order
Feature: Order
Description: This feature completes orders and cancels or edits them

@id=1
Scenario Outline: Verify editing order as guest user
	Given User access <brand> website
	And User add <product> to cart
	When User provides <addressFields> into address fields
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User clicks edit from order summary page
	When User edits from checkout and continues to review order page
	Then User verify edit change in bag
	
	@brand=CKUS
	Examples:
	| brand | product  | addressFields                                                                                | type       | number           | code | expMonth | expYear |
	| CKUS  | 12207569 | testing123@gmail.com;Dan;Smith;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890   | MasterCard | 5555555555554444 | 456  | 10       | 2020    |

@id=2
Scenario Outline: Verify editing order as guest user
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User add <product> to cart
	When User provides <addressFields> into address fields
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User clicks edit from order summary page
	When User edits from checkout and continues to review order page
	Then User verify edit change in bag
	
	@brand=CKUS
	Examples:
	| brand | product  | addressFields                                                                                | type       | number           | code | expMonth | expYear | email                     | password |
	| CKUS  | 12207569 | testing123@gmail.com;Dan;Smith;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890   | MasterCard | 5555555555554444 | 456  | 10       | 2020    | speedothck123@yopmail.com | Passw0rd |


@id=3
Scenario Outline: Order Item and Cancel as Guest User
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User verify summary of order submitted using credit card <type>
	Then User cancels order and verifys

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                             | type       | number           | code | expMonth | expYear |
	| CKUS  | wallet  | testing123@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=CKCA
	Examples:
	| brand | product | addressFields                                                                             | type       | number           | code | expMonth | expYear |
	| CKCA  | pants   | testing123@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
	
    @brand=TH
	Examples:
	| brand | product | addressFields                                                                                         | type       | number           | code | expMonth | expYear |
    | TH    | pants   | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand | product | addressFields                                                                                         | type       | number           | code | expMonth | expYear |
	| SPEEDO| pants | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | 
	
@id=4
Scenario Outline: Order Item and Cancel as Signed in User
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User add <product> to cart
	And User proceeds to secure checkout
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User cancels order and verifys

	@brand=CKUS
	Examples:
	| brand | email                     |  password |product  | type       | number           | code | expMonth | expYear |
	| CKUS  | qualitestanish1@gmail.com |  Calvin1  |wallet   | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=CKCA
	Examples:
	| brand | email                     |  password | product | type       | number           | code | expMonth | expYear |
	| CKCA  | qualitestanish1@gmail.com |  Calvin1  | pants   | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
	
    @brand=TH
	Examples:
	| brand |  email                    |  password |product | type       | number           | code | expMonth | expYear |
    | TH    | qualitestanish1@gmail.com |  Tommy1   |mens pants   | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand |  email                    |  password |product | type       | number           | code | expMonth | expYear |
	| SPEEDO| qualitestanish1@gmail.com |  Speedo1  |pants   | MasterCard | 5555555555554444 | 456  | 10       | 2020    | 
    
@id=5
Scenario Outline: Check order status as a guest user
	Given User access <brand> website
	And User navigates to guest orders and searches <orderNum> <email>
	Then Guest user confirms that <order> is there and <status> is correct

	
	@brand=CKUS
	Examples:
	| brand | orderNum      |  email                      |  order     | status     |
	| CKUS  | 51529004      |  123sadflaks@gmail.com      |  51529004  | CANCELED   |
     
    @brand=CKCA
	Examples:
	| brand | orderNum      |  email                      |  order     | status     |
	| CKCA  | 51529004      |  123sadflaks@gmail.com      |  51529004  | CANCELED   |
	
    @brand=TH
	Examples:
	| brand | orderNum      |  email                      |  order      | status     |
	| TH    | 51529007      |  123sadflaks@gmail.com      |  51530006   | PROCESSING   |
	
    @brand=SPEEDO
    Examples:
    | brand   | orderNum      |  email                      |  order     | status     |
    | SPEEDO  | 51530005      |  123sadflaks@gmail.com      |  51530005  | PROCESSING   |
	
@id=6
Scenario Outline: Verify order status as Signed in user
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to my orders
	Then User confirms <order> is there and <status> is correct

	@brand=CKUS
	Examples:
	| brand | email                     |  password | order     | status     |
	| CKUS  | qualitestanish1@gmail.com |  Calvin1  | 51527039  | PROCESSING |
    
    @brand=CKCA
	Examples:
	| brand | email                     |  password | order     | status     |
	| CKCA  | qualitestanish1@gmail.com |  Calvin1  | 51527039  | PROCESSING |
	
    @brand=TH
	Examples:
	| brand | email                     | password | order    | status     |
	| TH    | qualitestanish1@gmail.com | Tommy1   | 51529007 | PROCESSING |
	
    @brand=SPEEDO
    Examples:
    | brand   | email                     |  password | order     | status   |
    | SPEEDO  | qualitestanish1@gmail.com |  Speedo1  | 51528028  | CANCELED |
