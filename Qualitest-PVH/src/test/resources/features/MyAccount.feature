@module=MyAccount
Feature: My Account
	Description: This feature allows user to edit account details

@id=1
Scenario Outline: Verify editing personal information with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies personal information updated successfully
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234567890 |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKCA   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;7324567890 |
	
@id=2
Scenario Outline: Verify adding checkout preference with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences updated 
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKCA   | qualitestanish1@gmail.com  |  Calvin1  |Anish1;Patel1;3932 Richmond Road;BOX 21;Calgary;Canada;Alberta;T2T 0C6;1234569890;4111111111111111;04;2022 |
													
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         |
	| TH     | qualitestanish1@gmail.com  |  Tommy1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  |  Speedo1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
@id=3
Scenario Outline: Verify adding new shipping address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping address with valid <values>
	Then User verifies new address was added
	
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |values                                                                |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |values                                                                              |
	| TH     | qualitestanish1@gmail.com  | Tommy1   |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |values                                                                |
	| SPEEDO | qualitestanish1@gmail.com  | Speedo1  |Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;08807;7324567890 |
	
@id=4
Scenario Outline: Verify adding new billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds billing address with valid <values>
	Then User verifies new address was added
	
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |values                                                                              |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |values                                                                              |
	| TH     | qualitestanish1@gmail.com  | Tommy1   |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |values                                                                              |
	| SPEEDO | qualitestanish1@gmail.com  | Speedo1  |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;7324567890 |
	
@id=5
Scenario Outline: Verify adding new shipping and billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping and billing address with valid <values>
	Then User verifies new address was added
	
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |values                                                                |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |values                                                                              |
	| TH     | qualitestanish1@gmail.com  | Tommy1   |Anish;Patel;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |values                                                                |
	| SPEEDO | qualitestanish1@gmail.com  | Speedo1  |Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;08807;7324567890 |
	
@id=6
Scenario Outline: Verify removing existing address from address book
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User removes an address from address book
	Then User verifies address was removed
	
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |
	| TH     | qualitestanish1@gmail.com  | Tommy1   |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |
	| SPEEDO | qualitestanish1@gmail.com  | Speedo1  |
	
@id=7
Scenario Outline: Verify adding new shipping address with address verification check failure more then 3 times
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates my address book
	And User adds invalid address clicks update three times <information>
	Then User verifies address has been added
	
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;New Jersey;08889;1234569890;4111111111111111;04;2022 |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKCA   | qualitestanish1@gmail.com  |  Calvin1 |Anish1;Patel1;3932 Richmond Road;BOX 21;Calgary;Alberta;T7T 0C6;1234569890;4111111111111111;04;2022 |
													
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         |
	| TH     | qualitestanish1@gmail.com  |  Tommy1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;New Jersey;08889;1234569890;4111111111111111;04;2022 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  |  Speedo1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;New Jersey;08897;1234569890;4111111111111111;04;2022 |

@id=8
Scenario Outline: Verify personal information on account summary page when user did not provide address during registration
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User verifies personal information without address
	
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |
	| TH     | qualitestanish1@gmail.com  | Tommy1   |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  | Speedo1  |Anish;Patel;7324567890 |
	
@id=9
Scenario Outline: Verify updating existing shipping address with valid information
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User updates an address from address book <information>
	Then User verifies address was updated
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information|
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish1;Patel1;US 22;BOX 15;Bridgewater;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information|
	| TH     | qualitestanish1@gmail.com  | Tommy1   |Anish1;Patel1;US 22;BOX 15;Bridgewater;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  | Speedo1  |Anish1;Patel1;US 22;BOX 15;Bridgewater;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	
@id=10
Scenario Outline: Verify personal information on account summary page with provided address during registration
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User verifies personal information with address
	
	
	@brand=CKUS
	Examples:
	| brand  | email                       | password | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS   | qualitestanish12@gmail.com  | Calvin1  | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   |   1     | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |firstName | lastName | address             | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKCA   | qualitestanish15@gmail.com | Calvin1  |Test PVH  | User     |  1200 US 22         | Qualitest | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | 1       | 1    | United States | New Jersey |                                                            |               |      |
	
	@brand=TH
	Examples:
	| brand  | email                      | password | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| TH     | qualitestanish1@gmail.com  | Tommy1   | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 1    | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ |  web          | men  | 
	
	
@id=11
Scenario Outline: Verify my order page when no orders are placed
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to orders page
	Then User verifies no orders have been placed

		
	@brand=CKUS
	Examples:
	| brand  | email                      | password |
	| CKUS   | noOrders@gmail.com         | Calvin1  |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |
	| CKCA   | noOrders@gmail.com         | Calvin1  |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |
	| TH     | noOrders@gmail.com         | Tommy1   |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | noOrders@gmail.com         | Speedo1  |Anish;Patel;7324567890 |


@id=12
Scenario Outline: Verify my order page when account has existing orders
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User add <product> to cart
	And User proceeds to secure checkout
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User navigates to orders page
	Then User verifies there are existing orders

		
	@brand=CKUS
	Examples:
	| brand  | email                             | password | product   | type | number           | code | expMonth | expYear |
	| CKUS   | qualitestanish1@gmail.com         | Calvin1  | pants     | VISA | 4111111111111111 | 456  | 10       | 2020    |
	@brand=CKUS
	Examples:
	| brand | email                      | password |
	| CKUS  | testingpvh123@yopmail.com  | 1qaz@WSX |
	
	@brand=CKCA
	Examples:
	| brand  | email                             | password | product | type | number           | code | expMonth | expYear |
	| CKCA   | qualitestanish1@gmail.com         | Calvin1  | bag     | VISA | 4111111111111111 | 456  | 10       | 2020    |
	
	@brand=TH
	Examples:
	| brand  | email                             | password | product | type |number           | code | expMonth | expYear |
	| TH     | qualitestanish1@gmail.com         | Tommy1   | bra     | VISA |4111111111111111 | 456  | 10       | 2020    |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                             | password | product | type |number           | code | expMonth | expYear |
	| SPEEDO | qualitestanish1@gmail.com         | Speedo1  | bikini  | VISA |4111111111111111 | 456  | 10       | 2020    |	
	
@id=13
Scenario Outline: Verify my rewards when user has no rewards available
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	When User navigates to rewards tab
	Then User verifies user has no rewards on account page
	
	@brand=CKUS
	Examples:
	| brand | email                      | password |
	| CKUS  | testingpvh123@yopmail.com  | 1qaz@WSX |	
	
	
@id=15
Scenario Outline: Verify editing personal information with invalid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies error on account page <error>
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         | error             |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish;Patel;1200 US 22;BOX 15;#$#@!#@$!;United States;New Jersey;08807;1234567890   | Address Not Found |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         | error             |
	| CKCA   | qualitestanish1@gmail.com  | Calvin1  |Anish;Patel;1200 US 22;BOX 15;!@!@#!#;United States;New Jersey;08807;1234567890     | Address Not Found |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         | error             |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22;BOX 15;~!#@~!@;United States;New Jersey;08807;7324567890     | Address Not Found |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            | error             |
	| SPEEDO | qualitestanish1@gmail.com  | Speedo1  |Anish;Patel;7324567890 | Address Not Found |


@id=16
Scenario Outline: Verify updating blank personal information in required fields
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies personal information field error <error>
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                                         | error                           |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22;BOX 15; ;United States;New Jersey;08807;1234567890;4111111111111111;04;2022  | The city field cannot be empty. |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                                         | error                           |
	| CKCA   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22;BOX 15; ;United States;New Jersey;08807;1234567890;4111111111111111;04;2022  | The city field cannot be empty. |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                                         | error                           |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22;BOX 15; ;United States;New Jersey;08807;7324567890;4111111111111111;04;2022  | THE CITY FIELD CANNOT BE EMPTY. |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            | error             |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish; ;7324567890     | Address Not Found |


@id=17
Scenario Outline: Verify updating blank personal information in optional fields
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies personal information updated successfully
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                                              |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Bridgewater;United States;New Jersey;08807;1234567890;4111111111111111;04;2022  |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                                              |
	| CKCA   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Bridgewater;United States;New Jersey;08807;1234567890;4111111111111111;04;2022  |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                                              |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Bridgewater;United States;New Jersey;08807;7324567890|
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish; ;7324567890     |


@id=18
Scenario Outline: Verify updating address with address verification check failling more then 3 times
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User updates personal <information> three times
	Then User verifies personal information updated successfully
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                     |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Camden;United States;New Jersey;08807;1234567890       |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                   |
	| CKCA   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;safawasdf;United States;New Jersey;08807;1234567890  |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                               |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Camden;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish; ;7324567890     |
	

@id=19
Scenario Outline: Verify updating existing billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User updates billing fields on account page <values>
	Then User verifies existing billing address has been updated

	@brand=CKUS
	Examples:
	| brand  | email                      | password |values                                                                   |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Bridgewater;United States;New Jersey;08807;1234567890|
	
	@brand=TH
	Examples:
	| brand  | email                      | password |values                                                                     |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Bridgewater;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |values                                                                |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Bridgewater;United States;New Jersey;08807;7324567890 |
	
@id=20
Scenario Outline: Verify updating existing shipping and billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User updates shipping and billing fields <values>
	Then User verifies existing billing address has been updated

	@brand=CKUS
	Examples:
	| brand  | email                      | password |values                                                                      |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Sunday;United States;New Jersey;08807;1234567890   |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |values                                                                     |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Sunday;United States;New Jersey;08807;7324567890  |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |values                                                                    |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Sunday;United States;New Jersey;08807;7324567890 |


@id=21
Scenario Outline: Verify updating existing shipping address with address verification check failure more then 3 times
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User inputs shipping data <information> three times
	Then User verifies updated address with an error on address book
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                 |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Batboy;United States;New Jersey;08807;1234567890   |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                 |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Batboy;United States;New Jersey;08807;7324567890   |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information                                                                 |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Batboy;United States;New Jersey;08807;7324567890   |	
	

@id=22
Scenario Outline: Verify updating existing billing address with address verification check failure more then 3 times
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User inputs billing <information> three times to update
	Then User verifies updated address with an error on address book
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                               |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Supi;United States;New Jersey;08807;1234567890   |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                             |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Supi;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information                                                              |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Supi;United States;New Jersey;08807;7324567890  |	



@id=23
Scenario Outline: Verify updating existing shipping and billing address with address verification check failure more then 3 times
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User inputs shipping and billing <information> three times
	Then User verifies updated address with an error on address book
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                 |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                 |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information                                                                 |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |	


@id=24
Scenario Outline: Verify adding new billing address with address verification check failure more then 3 times
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds a new billing address and submits three times <information>
	Then User verifies address has been added

	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                 |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                 |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information                                                                 |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |	
	

@id=25
Scenario Outline: Verify adding new shipping and billing address with address verification check failure more then 3 times
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping and billing address and submits three times <information>
	Then User verifies address has been added

	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                 |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                 |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information                                                                 |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |	
	
@id=26
Scenario Outline: Verify user is able to cancel adding new address in address book
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds a shipping address but cancels <information>
	Then User verifies that the address worked on is canceled

	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                 |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                 |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information                                                                 |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX |Anish;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |	



@id=27
Scenario Outline: Verify removing all existing addresses in address book
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping address with valid <values>
	And User adds shipping address with valid <values2>
	And User deletes all the addresses saved in the address book
	Then User verifies there is only one address in the address book

	@brand=CKUS
	Examples:
	| brand  | email                      | password | values                                                                     | values2                                                                       |
	| CKUS   | testingpvh123@yopmail.com  | 1qaz@WSX | Steve;Smith;1120 US 22;Box 11;Bridgewater;New Jersey;08807;7324567890      | Cindy;Smith;656 Saint George Avenue; ;Woodbridge;New Jersey;07095;7324567890  |
	
	@brand=TH
	Examples:
	| brand  | email                      | password | values                                                                              | values2                                                                                    |
	| TH     | testingpvh123@yopmail.com  | 1qaz@WSX | Steve;Smith;1120 US 22;Box 11;Bridgewater;United States;New Jersey;08807;7324567890 | Cindy;Smith;656 Saint George Avenue; ;Woodbridge;United States;New Jersey;07095;7324567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password | values                                                                 | values2                                                                      |
	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX | Steve;Smith;1120 US 22;Box 11;Bridgewater;New Jersey;08807;7324567890  | Cindy;Smith;656 Saint George Avenue; ;Woodbridge;New Jersey;07095;7324567890 |



@id=28
Scenario Outline: Add Checkout Preferences With Invalid Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences error
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  | adfs; ;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;088087;1234569890;4111111111111111;04;2022 |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKCA   | qualitestanish1@gmail.com  |  Calvin1  |Anish1; ;3932 Richmond Road;BOX 21;Calgary;Canada;Alberta;T2T TDC6;1234569890;4111111111111111;04;2022 |
													
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         |
	| TH     | qualitestanish1@gmail.com  |  Tommy1  | adfs; ;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;088087;1234569890;4111111111111111;04;2022 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  |  Speedo1 | adfs; ;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;088087;1234569890;4111111111111111;04;2022 |
	
	
@id=29
Scenario Outline: Add Checkout Preferences With Invalid Billing Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits billing checkout preferences <information>
	Then User verifies checkout preferences error
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish1;  ;  ;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKCA   | qualitestanish1@gmail.com  |  Calvin1 |Anish1;  ;  ;BOX 21;Calgary;Canada;Alberta;T2T 0C6;1234569890;4111111111111111;04;2022 |
													
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         |
	| TH     | qualitestanish1@gmail.com  |  Tommy1  |Anish1;  ;1200 US 22;BOX 15;   ;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  |  Speedo1  |Anish1;   ;1200 US 22;BOX 15;  ;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	
@id=30
Scenario Outline: Add Checkout Preferences With invalid Credit Card Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences card error
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;41111111111111;04;2022 |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKCA   | qualitestanish1@gmail.com  |  Calvin1  |Anish1;Patel1;3932 Richmond Road;BOX 21;Calgary;Canada;Alberta;T2T 0C6;1234569890;41111111111111;04;2022 |
													
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         |
	| TH     | qualitestanish1@gmail.com  |  Tommy1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;41111111111111;04;2022 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  |  Speedo1  |Anish1;Patel1;1200 US 22;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;41111111111111;04;2022 |
	
	
@id=31
Scenario Outline: Add Checkout Preferences With Empty Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences empty error
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKUS   | qualitestanish1@gmail.com  | Calvin1  |Anish1;  ;  ;BOX 15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password |information                                                                         |
	| CKCA   | qualitestanish1@gmail.com  |  Calvin1  |Anish1;  ;  ;BOX 21;Calgary;Canada;Alberta;T2T 0C6;1234569890;4111111111111111;04;2022 |
													
	@brand=TH
	Examples:
	| brand  | email                      | password |information                                                                         |
	| TH     | qualitestanish1@gmail.com  |  Tommy1  |Anish1;  ;1200 US 22;BOX 15;   ;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password |information            |
	| SPEEDO | qualitestanish1@gmail.com  |  Speedo1  |Anish1;   ;1200 US 22;BOX 15;  ;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	
@id=32
Scenario Outline: Verify saved items when user has no saved items
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to wishlist
	Then User verifies wishlist is empty
	
	
	@brand=CKUS
	Examples:
	| brand	 | email                    | password|
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |
	
	@brand=CKCA
	Examples:
	| brand	 | email                    | password|
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |
	
	@brand=TH
	Examples:
	| brand	 | email                    | password|
	| TH     | qualitestanish1@gmail.com| Tommy1  |
	
	
@id=33
Scenario Outline: Verify adding a new item to wishlist from cart as signed in user
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
	And User adds item from cart to wishlist
	And User navigates to wishlist
	Then User verifies wishlist item matches item from cart
		
	@brand=CKUS
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |pants           |

	@brand=CKCA
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |wallet          |

	@brand=TH
	Examples:
	| brand	 | email                    | password|item  		   |
	| TH     | qualitestanish1@gmail.com| Tommy1  |mens dress pants|
	
	
@id=34
Scenario Outline: Verify sharing saved items without providing mandatory details
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to wishlist
	And User shares wishlist
	Then User verifies mandatory details not provided error
	
	
	@brand=CKUS
	Examples:
	| brand	 | email                    | password|
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |
	
	@brand=CKCA
	Examples:
	| brand	 | email                    | password|
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |
	
	@brand=TH
	Examples:
	| brand	 | email                    | password|
	| TH     | qualitestanish1@gmail.com| Tommy1  |
	
	
@id=35
Scenario Outline: Verify sharing saved items with valid details
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to wishlist
	And User provides share wishlist details <toEmail>, <fromName>, <fromEmail>, <message>
	And User shares wishlist
	Then User verifies wishlist was shared
	
	
	@brand=CKUS
	Examples:
	| brand	 | email                    | password|        toEmail         |fromName|       fromEmail         |   message  |
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |qualitestanish@gmail.com|Anish   |qualitestanish1@gmail.com|Look at this|
	
	@brand=CKCA
	Examples:
	| brand	 | email                    | password|        toEmail         |fromName|       fromEmail         |   message  |
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |qualitestanish@gmail.com|Anish   |qualitestanish1@gmail.com|Look at this|
	
	@brand=TH
	Examples:
	| brand	 | email                    | password|        toEmail         |fromName|       fromEmail         |   message  |
	| TH     | qualitestanish1@gmail.com| Tommy1  |qualitestanish@gmail.com|Anish   |qualitestanish1@gmail.com|Look at this|
