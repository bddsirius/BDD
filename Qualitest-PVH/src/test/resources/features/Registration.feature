@module=registration
Feature: Registration
Description: This feature allows user to create an account

@id=1
Scenario Outline: Partial registration with valid details from SignIn Page
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should be registered successfully without complete details

	Examples:
	| brand | email                 | password  |
	| CKUS  | testckus@testmail.com | abcdef123 |
	
	@brand=CKCA
	Examples:
	| brand | email                 | password  |
	| CKCA  | testckca@testmail.com | abcdef123 |
	
	@brand=TH
	Examples:
	| brand | email                 | password  |
	| TH    | testth@testmail.com   | abcdef123 |

@id=2
Scenario Outline: Complete registration with valid details from SignIn Page

	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should be registered successfully with complete details
	
	@brand=TH
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| TH     | thtest@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
	
	@brand=CKUS
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS   | ckustest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | 
	
	@brand=CKCA
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKCA   | ckcatest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| SPEEDO | speedotest@testmail.com | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | January | 1    |               |            |                                                            |               |      |

@id=3
Scenario Outline: Complete registration without providing details from SignIn Page
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>

	@brand=TH
	Examples:
	| brand  | email                    | password  | firstName |  lastName  |     address    |    apartment    |         city         |      country      |    state    |   zip   |    phone      |  gender |  bMonth   |  bDay  |  prefCountry  | prefState  |                          prefStore                              | communication | type | error  |
	| TH     | miss1+th@yopmail.com     | abcdef123 |           |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  abcde  |   9085262900  |   Male  |  January  |   12   | United States | New Jersey |   Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ    |     web       | men  | The first name field cannot be empty |
	| TH     | miss2+th@yopmail.com     | abcdef123 | Test PVH  |            |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   9085262900  |   Male  |  January  |   12   | United States | New Jersey |   Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ    |     web       | men  | The last name field cannot be empty  |
	| TH     | miss3+th@yopmail.com     | abcdef123 | Test PVH  |   User     |                |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   9085262900  |   Male  |  January  |   12   | United States | New Jersey |   Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ    |     web       | men  | Invalid Address |
	| TH     | miss4+th@yopmail.com     | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |                      |   United States   |  New Jersey |  08807  |   9085262900  |   Male  |  January  |   12   | United States | New Jersey |   Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ    |     web       | men  | Invalid Address |
	| TH     | miss5+th@yopmail.com     | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |               |   Male  |  January  |   12   | United States | New Jersey |   Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ    |     web       | men  | The phone number field cannot be empty |
	
	@brand=CKUS
	Examples:
	| brand  | email                    | password  | firstName |  lastName  |     address    |    apartment    |         city         |      country      |    state    |   zip   |    phone      |  gender |  bMonth   |  bDay  |  prefCountry  | prefState  |                          prefStore                              | communication | type | error  |
	| CKUS   | miss1+ckus@yopmail.com   | abcdef123 |           |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The first name field cannot be empty |
	| CKUS   | miss2+ckus@yopmail.com   | abcdef123 | Test PVH  |            |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The last name field cannot be empty. |
	| CKUS   | miss3+ckus@yopmail.com   | abcdef123 | Test PVH  |   User     |                |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The street address field cannot be empty. |
	| CKUS   | miss4+ckus@yopmail.com   | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |         |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The Zip code/postal code field cannot be empty |
	| CKUS   | miss5+ckus@yopmail.com   | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |               |   Male  |     1     |    1   |               |            |                                                                 |               |      | The phone number field cannot be empty |
	| CKUS   | miss6+ckus@yopmail.com   | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |                      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The city field cannot be empty |
	
	@brand=CKCA
	Examples:
	| brand  | email                    | password  | firstName |  lastName  |     address    |    apartment    |         city         |      country      |    state    |   zip   |    phone      |  gender |  bMonth   |  bDay  |  prefCountry  | prefState  |                          prefStore                              | communication | type | error  |
	| CKCA   | miss1+ckca@yopmail.com   | abcdef123 |           |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The first name field cannot be empty |
	| CKCA   | miss2+ckca@yopmail.com   | abcdef123 | Test PVH  |            |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The last name field cannot be empty |
	| CKCA   | miss3+ckca@yopmail.com   | abcdef123 | Test PVH  |   User     |                |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The street address field cannot be empty |
	| CKCA   | miss4+ckca@yopmail.com   | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |         |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The Zip code/postal code field cannot be empty |
	| CKCA   | miss5+ckca@yopmail.com   | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |               |   Male  |     1     |    1   |               |            |                                                                 |               |      | The phone number field cannot be empty |
	| CKCA   | miss6+ckca@yopmail.com   | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |                      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The city field cannot be empty |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                    | password  | firstName |  lastName  |     address    |    apartment    |         city         |      country      |    state    |   zip   |    phone      |  gender |  bMonth   |  bDay  |  prefCountry  | prefState  |                          prefStore                              | communication | type | error  |
	| SPEEDO | miss1+speedo@yopmail.com | abcdef123 |           |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |  January  |    1   |               |            |                                                                 |               |      | The first name field cannot be empty |
	| SPEEDO | miss2+speedo@yopmail.com | abcdef123 | Test PVH  |            |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |  January  |    1   |               |            |                                                                 |               |      | The last name field cannot be empty |
	| SPEEDO |                          | abcdef123 | Test PVH  |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |  January  |    1   |               |            |                                                                 |               |      | The email field cannot be empty |
	| SPEEDO | miss3+speedo@yopmail.com |           | Test PVH  |   User     |   1200 US 22   |    Qualitest    |     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890  |   Male  |  January  |    1   |               |            |                                                                 |               |      | The password field cannot be empty |

@id=4
Scenario Outline: Register with valid details post checkout as Guest User
	Given User access <brand> website
	And User order product <styleNumber>
	And User provide <email> , <firstName> , <lastName> , <address> , <apartment> , <city> , <state> , <country> , <zip> , <phone> into shipping information
	When User provide <password> on checkout page
	Then User should be registered successfully
	
	@brand=CKUS
	Examples:
	| brand  | styleNumber | email                     | password | firstName | lastName | address         | apartment | city        | state      | country       | zip    | phone      |
	| CKUS   | 26900010    | chck1+ckus@testmail.com   | 1qaz@WSX | Bobby     | Smith    | 1200 US 22      | Box 15    | Bridgewater | New Jersey |               | 08807  | 1234567890 |
	
	@brand=CKCA
	Examples:
	| brand  | styleNumber | email                     | password | firstName | lastName | address         | apartment | city        | state      | country       | zip    | phone      |
	| CKCA   | 21681786    | chck1+ckca@testmail.com   | 1qaz@WSX | Bobby     | Smith    | 1642 Bloor St W |           | Toronto     | Ontario    |               | M6P1A7 | 9085262900 |
	
	@brand=TH
	Examples:
	| brand  | styleNumber | email                     | password | firstName | lastName | address         | apartment | city        | state      | country       | zip    | phone      |
	| TH     | MW05143     | chck1+th@testmail.com     | 1qaz@WSX | Bobby     | Smith    | 1200 US 22      | Box 15    | Bridgewater | New Jersey | United States | 08807  | 1234567890 |
	
	@brand=SPEEDO
	Examples:
	| brand  | styleNumber | email                     | password | firstName | lastName | address         | apartment | city        | state      | country       | zip    | phone      |
	| SPEEDO | 7748017     | chck1+speedo@testmail.com | 1qaz@WSX | Bobby	  | Smith    | 1200 US 22      | Box 15    | Bridgewater | New Jersey |               | 08807  | 9085262900 |

@id=5
Scenario Outline: Complete Registration when providing invalid address and submitting 3 times
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	When User submits invalid address 3 times
	Then User should be registered successfully with complete details
	
	@brand=TH
	Examples:
	| brand | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| TH    | invadd1+th@yopmail.com   | abcdef123 | Test PVH  | User     | 1200       | Qualitest | Bridgewater | United States | New Jersey | 08807 | 9085262900 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
	
	@brand=CKUS
	Examples:
	| brand | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS  | invadd1+ckus@yopmail.com | abcdef123 | Test PVH  | User     | 1200       | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      |
	
	@brand=CKCA
	Examples:
	| brand | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKCA  | invadd2+ckca@yopmail.com | abcdef123 | Test PVH  | User     | 1200 US 22 |           | Bridgewater | Canada        | Alberta    | 08806 | 1234567890 |        |         |      |               |            |                                                            |               |      |


@id=6
Scenario Outline: Partial registration with invalid details from SignIn Page

	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>

	@brand=CKUS
	Examples:
	| brand | email                   | password | error                                       |
	| CKUS  | testregisterckca1       | 1qaz@WSX | The email entered is not in a valid format. |
	| CKUS  | testregisterckca1@gmail | 1qaz@WSX | The email entered is not in a valid format. |
	| CKUS  | testregisterckca1.com   | 1qaz@WSX | The email entered is not in a valid format. |
	| CKUS  | @gmail.com              | 1qaz@WSX | The email entered is not in a valid format. |
	
	@brand=CKCA
	Examples:
	| brand | email                   | password | error                                       |
	| CKCA  | testregisterckca1       | 1qaz@WSX | The email entered is not in a valid format. |
	| CKCA  | testregisterckca1@gmail | 1qaz@WSX | The email entered is not in a valid format. |
	| CKCA  | testregisterckca1.com   | 1qaz@WSX | The email entered is not in a valid format. |
	| CKCA  | @gmail.com              | 1qaz@WSX | The email entered is not in a valid format. |
	
	@brand=TH
	Examples:
	| brand | email                   | password | error                                       |
	| TH    | testregisterckca1       | 1qaz@WSX | The email entered is not in a valid format. |
	| TH    | testregisterckca1@gmail | 1qaz@WSX | The email entered is not in a valid format. |
	| TH    | testregisterckca1.com   | 1qaz@WSX | The email entered is not in a valid format. |
	| TH    | @gmail.com              | 1qaz@WSX | The email entered is not in a valid format. |

@id=7
Scenario Outline: Registration without providing details from SignIn Page
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>
	
	@brand=CKCA
	Examples:
	| brand | email | password | error                            |
	| CKCA  |       |          | The email field cannot be empty. |
	
	@brand=CKUS
	Examples:
	| brand | email | password | error                            |
	| CKUS  |       |          | The email field cannot be empty. |
	
	@brand=TH
	Examples:
	| brand | email | password | error                            |
	| TH    |       |          | The email field cannot be empty. |


@id=8
Scenario Outline: Complete registration with invalid details from SignIn Page
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>
	
	@brand=TH
	Examples:
	| brand  | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                                              |
	| TH     | inv1+th@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | abcde | 9085262900 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Address Not Found                                  | 
	| TH     | inv2+th@testmail.com     | abcdef123 | Test PVH  | User     | 22         | Qualitest | Bridgewater | United States | New Jersey | 08807 | 9085262900 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Invalid Address                                    |
	| TH     | inv3+th@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Phone number is not in a valid format              |
	| TH     | inv4+th@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | M           | United States | New Jersey | 08807 | 9085262900 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Address Not Found                                  |
	
	@brand=CKUS
	Examples:
	| brand  | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                                              |
	| CKUS   | inv1+ckus@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | abcde | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | The Zip code entered is not in a valid format      |
	| CKUS   | inv2+ckus@testmail.com   | abcdef123 | Test PVH  | User     | 22         | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | Invalid Address                                    |
	| CKUS   | inv3+ckus@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | M           | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | Address Not Found                                  |
	
	@brand=CKCA
	Examples:
	| brand  | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                                              |
	| CKCA   | inv1+ckca@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | abcde | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | The Zip code entered is not in a valid format      |
	| CKCA   | inv2+ckca@testmail.com   | abcdef123 | Test PVH  | User     | 22         | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | Invalid Address                                    |
	| CKCA   | inv3+ckca@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | M           | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | Address Not Found                                  |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                                              |
	| SPEEDO | inv1speedo               | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | abcde | 1234567890 | Male   | January | 1    |               |            |                                                            |               |      | The email entered is not in a valid                |
	| SPEEDO | inv2+speedo@testmail.com | abcd      | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | January | 1    |               |            |                                                            |               |      | You entered a password with less than 6 characters |
