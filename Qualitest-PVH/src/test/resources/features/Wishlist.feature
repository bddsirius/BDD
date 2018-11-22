@module=wishlist
Feature: Wishlist
Description: This feature uses Wishlist to verify 

@id=1
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
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |wallet          |

	@brand=CKCA
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |wallet          |

	@brand=TH
	Examples:
	| brand	 | email                    | password|item  		   |
	| TH     | qualitestanish1@gmail.com| Tommy1  |mens dress pants|

@id=2
Scenario Outline: Verify adding a item to wishlist that is already in wishlist
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
    And User add <item> to cart
	And User adds item from cart to wishlist
	And User add <item> to cart
	And User adds item from cart to wishlist
	Then User verifies <error> item is already in wishlist
		
	@brand=CKUS
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |wallet          |

	@brand=CKCA
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |wallet          |

	@brand=TH
	Examples:
	| brand	 | email                    | password|item  		   |
	| TH     | qualitestanish1@gmail.com| Tommy1  |mens dress pants|
#	| TH     | qualitestanish1@gmail.com| Tommy1  |wallet          |
#	| TH     | qualitestanish1@gmail.com| Tommy1  |women's shoes   |
#	| TH     | qualitestanish1@gmail.com| Tommy1  |vests           |

@id=3
Scenario Outline: Verify adding a new item to wishlist from cart as guest user
	Given User access <brand> website
	When User navigate to login page
    When User searches for <item>
	And User clicks on product
	And User chooses random size
	And User adds the product to their wishlist
	And User try to login using <email> and <password>
	And User navigates to wishlist
	Then User verifies wishlist item matches item from cart
	
	@brand=CKUS
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |wallet          |
#	| CKUS   | qualitestanish1@gmail.com| Calvin1 |shirt           |
#	| CKUS   | qualitestanish1@gmail.com| Calvin1 |women's shoes   |
#	| CKUS   | qualitestanish1@gmail.com| Calvin1 |vests           |

	@brand=CKCA
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |underwear       |
#	| CKCA   | qualitestanish1@gmail.com| Calvin1 |shirt           |
#	| CKCA   | qualitestanish1@gmail.com| Calvin1 |women's shoes   |
#	| CKCA   | qualitestanish1@gmail.com| Calvin1 |vests           |

	@brand=TH
	Examples:
	| brand	 | email                    | password|item  		   |
	| TH     | qualitestanish1@gmail.com| Tommy1  |mens dress pants|
#	| TH     | qualitestanish1@gmail.com| Tommy1  |wallet          |
#	| TH     | qualitestanish1@gmail.com| Tommy1  |women's shoes   |
#	| TH     | qualitestanish1@gmail.com| Tommy1  |vests           |

@id=4
Scenario Outline: Verify adding a item to wishlist wtihout selecting a size
	Given User access <brand> website
	When User navigate to login page
    When User searches for <item>
	And User clicks on product
	And User adds the product to their wishlist
	Then User verifies user is prompted to select a size
	
	@brand=CKUS
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKUS   | qualitestanish1@gmail.com| Calvin1 |pants           |
#	| CKUS   | qualitestanish1@gmail.com| Calvin1 |shirt           |
#	| CKUS   | qualitestanish1@gmail.com| Calvin1 |women's shoes   |
#	| CKUS   | qualitestanish1@gmail.com| Calvin1 |vests           |

	@brand=CKCA
	Examples:
	| brand	 | email                    | password|item 		   |
	| CKCA   | qualitestanish1@gmail.com| Calvin1 |pants           |
#	| CKCA   | qualitestanish1@gmail.com| Calvin1 |shirt           |
#	| CKCA   | qualitestanish1@gmail.com| Calvin1 |women's shoes   |
#	| CKCA   | qualitestanish1@gmail.com| Calvin1 |vests           |

	@brand=TH
	Examples:
	| brand	 | email                    | password|item  		   |
	| TH     | qualitestanish1@gmail.com| Tommy1  |mens dress pants|
#	| TH     | qualitestanish1@gmail.com| Tommy1  |wallet          |
#	| TH     | qualitestanish1@gmail.com| Tommy1  |women's shoes   |
#	| TH     | qualitestanish1@gmail.com| Tommy1  |vests           |
