@module=loyalty
Feature: Loyalty
	Description: This feature allows verification on promo codes
	
@id=1
Scenario Outline: Verify existing loyalty member is able to view available rewards
    Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User verifies the member rewards are available
	
	@brand=CKUS
	Examples:
	| brand | email                          | password    |
	| CKUS  | badrinathvenusep11@yopmail.com | Passw0rd    |
	
@id=2
Scenario Outline: Verify user is able to added multiple reward to a single order
	Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
    And User selects two awards
    Then User verifies that two awards have been applied
    And User cancels the order
    
    @brand=CKUS
	Examples:
	| brand | email                          | password    | item       |
	| CKUS  | badrinathvenusep11@yopmail.com | Passw0rd    |            |
    