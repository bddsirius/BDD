@module=email
Feature: Email
	Description: This feature allows verification on the email submission on the sign up overlay
	
@id=1
Scenario Outline: Verify signing up for newsletter with valid email address from signup overlay
    Given User opens website <brand>
    When User enters <email> and submits for newsletter in the pop up
    Then User verifies that email successfully registers
	
	@brand=CKUS
	Examples:
	| brand | email                   | 
	| CKUS  | testPVHuser@yopmail.com |
	
	@brand=CKCA
	Examples:
	| brand | email                   |
	| CKCA  | PVHuser@yopmail.com     |
	
	@brand=TH
	Examples:
	| brand | email                   |
	| TH    | testPVHuser@yopmail.com |
 	
	@brand=SPEEDO
	Examples:
	| brand | email                   |
	| SPEEDO| testPVHuser@yopmail.com |

@id=2
Scenario Outline: Verify signup for newsletter without providing email address on signup overlay displayed
	Given User opens website <brand>
	When User enters no email for newsletter in the pop up
	Then User verifies no email on newsletter pop up error
	
	@brand=CKUS
	Examples:
	| brand |
	| CKUS  |
	
	@brand=CKCA
	Examples:
	| brand |
	| CKCA  |
	
	@brand=TH
	Examples:
	| brand |
	| TH    |

	@brand=SPEEDO
	Examples:
	| brand |	
	| SPEEDO|

@id=3
Scenario Outline: Verify signing up for newsletter with valid email address from account summary page
	Given User opens website <brand>
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	When User provides email for newsletter on account page
	Then User will verify newsletter sign up
	
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

@id=4
Scenario Outline: Verify signing up for newsletter with providing invalid email address from account summary page
	Given User opens website <brand>
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	When User provides invalid email for newsletter on account page
	Then User verifies invalid email with no email on newsletter <error>
	
	@brand=TH
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                              |
	| TH     | thtest@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Please enter a valid email address.|
	
	@brand=CKUS
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                              |
	| CKUS   | ckustest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | Please enter a valid email address.|
	
	@brand=CKCA
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                              |
	| CKCA   | ckcatest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | The E-mail Address is invalid      |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                              |
	| SPEEDO | speedotest@testmail.com | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | January | 1    |               |            |                                                            |               |      | Please enter a valid email address.|
