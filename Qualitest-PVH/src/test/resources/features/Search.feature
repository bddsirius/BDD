@module=searchProduct 
Feature: Search Product 
	Description: This feature uses search bar to verify search results

@id=1 
Scenario Outline: Search prodcuts using department 
	Given User access <brand> website 
	When User searches for <department> 
	Then User should see results for <department>
	
	@brand=CKUS 
	Examples: 
	| brand	 | department |
	| CKUS	 | Men        |
	| CKUS	 | Women      |
	| CKUS	 | Underwear  |
	| CKUS	 | Home       |
	| CKUS	 | sale       |
	@brand=CKCA 
	Examples: 
	| brand	 | department |
	| CKCA	 | Men        |
	| CKCA	 | Women      |
	| CKCA	 | Underwear  |
	| CKCA	 | Sale       |
	@brand=TH 
	Examples: 
	| brand	 | department  |
	| TH	 | Women       |
	| TH     | Men         |
	| TH	 | Tommy Jeans |
	| TH	 | Kids        |
	| TH	 | Sale        |
	@brand=SPEEDO 
	Examples: 
	| brand	 | department |
	| Speedo | Women      |
	| Speedo | Men        |
	| Speedo | Kids       |
	| Speedo | Goggles    |
	| Speedo | Gear       |
	| Speedo | Sale       |
	| Speedo | Teams      |
	
@id=2 
Scenario Outline: Search products using category 
	Given  User access <brand> website 
	When  User searches for <category> 
	Then  User should see results for <category> 
	
	@brand=CKUS 
	Examples: 
	| brand	 | category   |
	| CKUS	 | All        |
	| CKUS	 | Plus Size  |
	| CKUS	 | Denims     |
	| CKUS	 | Socks      |
	| CKUS	 | OuterWear  |
	| CKUS	 | Sunglasses |
	@brand=CKCA 
	Examples: 
	| brand	 | category   |
	| CKCA	 | All        |
	| CKCA	 | Plus Size  |
	| CKCA	 | Socks      |
	| CKCA	 | OuterWear  |
	| CKCA	 | Denims     |
	| CKCA	 | Sunglasses |
	@brand=TH 
	Examples: 
	| brand	 | category   |
	| TH	 | All        |
	| TH	 | Denims     |
	| TH     | Leggings   |
	| TH	 | Socks      |
	| TH	 | OuterWear  |
	| TH	 | Sunglasses |
	@brand=SPEEDO 
	Examples: 
	| brand	 | category   |
	| SPEEDO | Performance|
#	| SPEEDO | Fitness    |
#	| SPEEDO | Elite      |
#	| SPEEDO | Caps       |
#	| SPEEDO | Plus Size  |
#	| SPEEDO | Recreation |
	
@id=3 
Scenario Outline: Search products using style 
	Given  User access <brand> website 
	When  User searches for <style> 
	Then  User should see results for <style> 
	
	@brand=CKUS 
	Examples: 
	| brand	 | style        |
	| CKUS	 | Active Tops  |
	| CKUS	 | Crew Neck    |
	| CKUS	 | V-Neck       |
	| CKUS	 | Henley       |
	@brand=CKCA 
	Examples: 
	| brand	 | style        |
	| CKCA	 | Active Tops  |
	| CKCA	 | Crew Neck    |
	| CKCA	 | V-Neck       |
	| CKCA	 | Henley       |
	@brand=TH 
	Examples: 
	| brand	 | style        |
	| TH	 | Active Tops  |
	| TH	 | Crew Neck    |
	| TH	 | V-Neck       |
	| TH	 | Henley       |
	@brand=SPEEDO 
	Examples: 
	| brand	 | style        |
	| Speedo | Bottoms      |
	| Speedo | Jammers      |
	| Speedo | One Piece    | 
	| Speedo | Jackets      |
	| Speedo | Volley       |
	| Speedo | Cover Ups    |
	
@id=4 
Scenario Outline: Search products using occasion 
	Given  User access <brand> website 
	When  User searches for <occasion> 
	Then  User should see results for <occasion> 
	
	@brand=CKUS 
	Examples: 
	| brand  | occasion   |
	| CKUS   | Casual     |
	| CKUS   | Beach      |
	| CKUS   | Work       |
	@brand=CKCA 
	Examples: 
	| brand  | occasion   |
	| CKCA   | Casual     |
	| CKCA   | Beach      |
	| CKCA   | Work       |
	@brand=TH 
	Examples: 
	| brand  | occasion   |
	| TH     | Casual     |
	| TH     | Beach      |
	| TH     | Work       |
	@brand=SPEEDO 
	Examples: 
	| brand  | occasion   |
	| SPEEDO | Sport      |
	| SPEEDO | Beach      |
	| SPEEDO | Work       | 
	
@id=5 
Scenario Outline: Search products using length 
	Given  User access <brand> website 
	When  User searches for <length> 
	Then  User should see results for <length> 
	
	@brand=CKUS 
	Examples: 
	| brand	 | length     |	
	| CKUS   | Long Sleeve|
	| CKUS   | 3/4 sleeve |
	@brand=CKCA 
	Examples: 
	| brand	 | length     |
	| CKCA   | Long Sleeve|
	| CKCA   | 3/4 sleeve |
	@brand=TH 
	Examples: 
	| brand	 | length     |
	| TH     | Long Sleeve|
	| TH     | 3/4 sleeve |
	@brand=SPEEDO 
	Examples: 
	| brand	 | length     |
	| Speedo | Long Sleeve|
	
@id=6 
Scenario Outline: Search products using color 
	Given  User access <brand> website 
	When  User searches for <color> 
	Then  User should see results for <color>
	
	@brand=CKUS 
	Examples: 
	| brand  | color      |
	| CKUS   | Red        |
	| CKUS   | Blue       |
	| CKUS   | Yellow     |
	| CKUS   | Green      |
	| CKUS   | Black      |
	@brand=CKCA 
	Examples: 
	| brand  | color      |
	| CKCA   | Red        |
	| CKCA   | Blue       |
	| CKCA   | Yellow     |
	| CKCA   | Green      |
	| CKCA   | Black      |
	@brand=TH 
	Examples: 
	| brand  | color      |
	| TH     | Red        |
	| TH     | Blue       |
	| TH     | Yellow     |
	| TH     | Green      |
	| TH     | Black      |
	@brand=SPEEDO 
	Examples: 
	| brand  | color      |
	| SPEEDO | Red        |
	| SPEEDO | Blue       |
	| SPEEDO | Yellow     | 
	| SPEEDO | Green      |
	| SPEEDO | Black      | 
	
@id=7 
Scenario Outline: Search products using size 
	Given  User access <brand> website 
	When  User searches for <size> 
	Then  User should see results for <size> 
	
	@brand=CKUS 
	Examples: 
	| brand	 | size  |	
	| CKUS   | XS    |
	| CKUS   | S     |
	| CKUS   | M     |
	| CKUS   | L     |
	@brand=CKCA 
	Examples: 
	| brand	 | size  |
	| CKCA   | XS    |
	| CKCA   | S     |
	| CKCA   | M     |
	| CKCA   | L     |
	@brand=TH 
	Examples: 
	| brand	 | size  |
	| TH     | XS    |
	| TH     | S     |
	| TH     | M     |
	| TH     | L     |
	@brand=SPEEDO 
	Examples: 
	| brand	 | size  |
	| Speedo | XS    |
	| Speedo | S     |
	| Speedo | M     |
	| Speedo | L     | 
	
@id=8 
Scenario Outline: Search products using Style Number 
	Given  User access <brand> website
	When  User searches for <styleNumber>
	Then  User should see <styleNumber> product details
	
	@brand=CKUS 
	Examples: 
	| brand  | styleNumber  | 
	| CKUS   | 15193484     | 
	| CKUS   | 59990440     |           
	| CKUS   | 21884232-100 | 
	| CKUS   | 54015716     | 
	| CKUS   | 38020632-100 |
	@brand=CKCA 
	Examples: 
	| brand  | styleNumber  |
	| CKCA   | 21771662-634 | 
	| CKCA   | 54011632-020 | 
	| CKCA   | 59998506     | 
	| CKCA   | 47201131     |
	@brand=TH 
	Examples: 
	| brand  | styleNumber | 
	| TH     | MW03055     | 
	| TH     | MW02972     | 
	| TH     | UW00982     | 
	| TH     | 7906016     |
	| TH     | UW00983     |
	@brand=SPEEDO 
	Examples: 
	| brand  | styleNumber | 
	| SPEEDO | 7719807     | 
	| SPEEDO | 7707011     | 
	| SPEEDO | 7734117     | 
	| SPEEDO | 7705806     |
	| SPEEDO | 7050920     |
	
@id=9 
Scenario Outline: Search products using brand 
	Given  User access <brand> website 
	When  User searches for <brands> 
	Then  User should see results for <brands> 
	
	@brand=TH 
	Examples: 
	| brand	 | brands              |
	| TH     | Hilfiger Collection |
	| TH     | Tommy Jeans         |
	| TH     | Tommy Hilfiger      |

@id=10 
Scenario Outline: Search products using type 
	Given  User access <brand> website 
	When  User searches for <type> 
	Then  User should see results for <type> 
	
	@brand=CKUS 
	Examples: 
	| brand  | type       |
	| CKUS   | Fitness    |
	| CKUS   | Performance|
	@brand=CKCA 
	Examples: 
	| brand  | type       |
	| CKCA   | Fitness    |
	| CKCA   | Performance|
	@brand=TH 
	Examples: 
	| brand  | type       |
	| TH     | Fitness    |
	| TH     | Performance|
	| TH     | Recreation |
	@brand=SPEEDO 
	Examples: 
	| brand  | type       |
	| SPEEDO | Fitness    |
	| SPEEDO | Performance|
	| SPEEDO | Recreation | 
	
@id=11 
Scenario Outline: Search products using invalid keyword 
	Given  User access <brand> website 
	When  User searches for <keyword> 
	Then  User should see no search results message
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword |
	| CKUS  | 1234    |
	| CKUS	| asd1234 |
	@brand=CKCA
	Examples: 
	| brand	| keyword |
	| CKCA  | 1234    |
	| CKCA	| asd1234 |
	@brand=TH
	Examples: 
	| brand	| keyword |
	| TH    | 1234    |
	| TH  	| asd1234 |
	@brand=SPEEDO
	Examples: 
	| brand	 | keyword |
	| Speedo | 1234    |
	| Speedo | asd1234 |

@id=12 
Scenario Outline: Search products using keyword with special character
	character 
	Given  User access <brand> website 
	When  User searches for <keyword> 
	Then  User should get prohibited characters error 
	
	@brand=CKUS 
	Examples: 
	| brand | keyword | 
	| CKUS	| 123!@#  |
	| CKUS	| !@#     |
	| CKUS	| asd!@#  |
	| CKUS	| !!??@#$ |
	@brand=CKCA 
	Examples: 
	| brand | keyword | 
	| CKCA	| 123!@#  |
	| CKCA	| !@#     |
	| CKCA	| asd!@#  |
	| CKCA	| !!??@#$ |
	@brand=TH 
	Examples: 
	| brand | keyword |
	| TH 	| 123!@#  |
	| TH	| !@#     |
	| TH	| asd!@#  |
	| TH	| !!??@#$ |
	@brand=SPEEDO 
	Examples: 
	| brand  | keyword |
	| Speedo | 123!@#  |
	| Speedo | !@#     |
	| Speedo | asd!@#  |
	| Speedo | !!??@#$ | 
	
@id=13 
Scenario Outline: Search products without providing search keyword 
	Given  User access <brand> website 
	When  User searches for <keyword> 
	Then  User should remain on home page 
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword |
	| CKUS  |         |
	@brand=CKCA 
	Examples: 
	| brand	| keyword |
	| CKCA  |         |
	@brand=TH 
	Examples: 
	| brand	| keyword |
	| TH    |         |
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword |
	| Speedo |         |
	
@id=14 
Scenario Outline: Search products which are currently not available 
	Given  User access <brand> website 
	When  User searches for <item> 
	Then  User should see no search results message 
	
	@brand=CKUS 
	Examples: 
	| brand | item    |          
	| CKUS  | 4534018 | 
	| CKUS  | 45BK322 | 
	| CKUS  | 20F6541 |
	@brand=CKCA 
	Examples: 
	| brand | item    |
	| CKCA  | 4534018 | 
	| CKCA  | 45BK322 | 
	| CKCA  | 20F6541 |
	@brand=TH 
	Examples: 
	| brand | item    | 
	| TH    | 4534018 | 
	| TH    | 45BK322 |
	| TH    | 20F6541 |
	@brand=SPEEDO 
	Examples: 
	| brand  | item    | 
	| SPEEDO | 4534018 |
	| SPEEDO | 45BK322 |
	| SPEEDO | 20F6541 |
	
@id=15 
Scenario Outline: Search suggestion should match the entered search term 
	Given  User access <brand> website
	When  User inputs search <search>
	Then  User should see search suggestions related to <searchTerm> 
	
	@brand=CKUS 
	Examples: 
	| brand | searchTerm | 
	| CKUS  | Men        | 
	| CKUS  | Women      |           
	| CKUS  | Red        | 
	| CKUS  | Hot        | 
	| CKUS  | Summer     |
	@brand=CKCA 
	Examples: 
	| brand | searchTerm |
	| CKCA  | Men        | 
	| CKCA  | Women      | 
	| CKCA  | Red        | 
	| CKCA  | Hot        | 
	| CKCA  | Summer     |
	@brand=TH 
	Examples: 
	| brand | searchTerm | 
	| TH    | Men        | 
	| TH    | Women      |
	| TH    | red        |
	| TH    | hot        |
	| TH    | summer     |
	@brand=SPEEDO 
	Examples: 
	| brand  | searchTerm |
	| SPEEDO | Women      |
	| SPEEDO | Elite      |
	| SPEEDO | Tankini    |
	| SPEEDO | Fitness    |
	
@id=16 
Scenario Outline: Search products as guest user from home page
	Given  User access <brand> website 
	And  User is not signed in 
	When  User searches for <product> 
	Then  User should see results for <product> 
	
	@brand=CKUS 
	Examples: 
	| brand  | product | 
	| CKUS   | t-shirt |
	@brand=CKCA 
	Examples: 
	| brand  | product |
	| CKCA   | t-shirt |
	@brand=TH 
	Examples: 
	| brand  | product |
	| TH     | t-shirt |
	@brand=SPEEDO 
	Examples: 
	| brand  | product |
	| Speedo | trunks  |
	
@id=17 
Scenario Outline: Search products as signed in user from home page
	Given  User access <brand> website 
	When  User navigate to login page 
	And  User try to login using <email> and <password> 
	When  User searches for <product> 
	Then  User should see results for <product> 
	
	@brand=CKUS 
	Examples: 
	| brand | email                     | password | product |
	| CKUS  | qualitestanish1@gmail.com | Calvin1  | t-shirt |
	@brand=CKCA 
	Examples: 
	| brand | email                     | password | product |
	| CKCA  | qualitestanish1@gmail.com | Calvin1  | t-shirt |
	@brand=TH 
	Examples: 
	| brand | email                     | password | product | 
	| TH    | qualitestanish1@gmail.com | Tommy1   | t-shirt |
	@brand=SPEEDO 
	Examples: 
	| brand  | email 				 	 | password | product |
	| Speedo | qualitestanish1@gmail.com | Speedo1	| trunks  |
	
@id=18 
Scenario Outline: Search products from product details page 
	Given  User access <brand> website 
	When  User searches for <product> 
	And  User clicks on product 
	When  User searches for <product> 
	Then  User should see results for <product> 
	
	@brand=CKUS 
	Examples: 
	| brand | product |
	| CKUS  | t-shirt |
	@brand=CKCA 
	Examples: 
	| brand | product |
	| CKCA  | t-shirt |
	@brand=TH 
	Examples: 
	| brand | product |
	| TH    | t-shirt |
	@brand=SPEEDO 
	Examples: 
	| brand  | product |
	| Speedo | trunks  | 
	
@id=19 
Scenario Outline: Search products from cart/bag page 
	Given  User access <brand> website 
	And  User goes to cart 
	When  User searches for <product> 
	Then  User should see results for <product> 
	
	@brand=CKUS 
	Examples: 
	| brand | product | 
	| CKUS  | t-shirt |
	@brand=CKCA 
	Examples: 
	| brand | product |
	| CKCA  | t-shirt |
	@brand=TH 
	Examples: 
	| brand | product |
	| TH    | t-shirt |
	@brand=SPEEDO 
	Examples: 
	| brand  | product |
	| Speedo | trunks  |
