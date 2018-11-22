@module=promotions
Feature: Promotions
	Description: This feature allows verification on promo codes
	
@id=4
Scenario Outline: Apply invalid promo code as guest user
	Given User access <brand> website
	And User add <item> to cart
	And User applies promo <code>
	Then User should get promo error message <text>
	
	@brand=CKUS
	Examples:
	| brand  | item                 | text                           | code     |
	| CKUS   | cotton stretch 3     | ABCDEFG is an invalid code     | ABCDEFG  |

	@brand=CKCA
	Examples:
	| brand  | item               | text                           | code      |
	| CKCA   | cotton stretch 3   | ABCDEFG is an invalid code     | ABCDEFG   |
	
	@brand=TH
	Examples:
	| brand  | item                     | text                           | code      |
	| TH     | Mens Dress Pants         | ABCDEFG is an invalid code     | ABCDEFG   |

	@brand=SPEEDO
	Examples:
	| brand  | item                     | text                                 | code      |
	| SPEEDO | flippers                 | Promotion code "ABCDEFG" is invalid. | ABCDEFG   |
	
@id=5
Scenario Outline: Verify applying valid promo code which is applicable to more then one item in cart as guest user
    Given User access <brand> website
    And User add <item> to cart
    And User add <secondItem> to cart
    And User applies promo <code>
    Then User verifies promo should be added <code>
    

  @brand=CKUS
  Examples: 
  | brand| item           | code           | secondItem   |
  | CKUS | 00883733818001 | GWPORDER       |              |
  
 @brand=TH 
 Examples: 
  | brand| item           | code           | secondItem   |
  | TH   | WW184551       | EXTRAEXTRA     | 7866528      |
  
  
  
@id=6
Scenario Outline: Verify removing applied promo code from cart as guest user
    Given User access <brand> website
    And User add <item> to cart
    And User applies promo <code>
    Then User verifies removal of promo
    
 @brand=TH 
 Examples: 
  | brand| item           | code           | 
  | TH   | WW184551       | EXTRAEXTRA     |
    
    
  