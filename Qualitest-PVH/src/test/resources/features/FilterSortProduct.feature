@module=filterSortProduct
Feature: Filter Sort Product 
	Description: This feature allows user to filter and sort product

@id=1
Scenario Outline: Verify option to filter product list is displayed on search result page
	Given User access <brand> website 
	When User searches for <keyword>
	And User select <department> from search result
	Then User should see option to "filter" product list
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department |
	| CKUS	| Shirt   | Men        |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department |
	| CKCA	| Shirt   | Men        |

	@brand=TH 
	Examples: 
	| brand	| keyword | department |
	| TH	| Shirt   | Men        |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department |
	| SPEEDO | Shirt   | Men        |
		
@id=2
Scenario Outline: Verify option to sort product list is displayed on search result page 
	Given User access <brand> website 
	When User searches for <keyword>
	And User select <department> from search result
	Then User should see option to "sort" product list
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department |
	| CKUS	| Shirt   | Men        |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department |
	| CKCA	| Shirt   | Men        |

	@brand=TH 
	Examples: 
	| brand	| keyword | department |
	| TH	| Shirt   | Men        |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department |
	| SPEEDO | Shirt   | Men        |
	
@id=3
Scenario Outline: Verify filtering product list based on Price 
	Given User access <brand> website 
	When User searches for <keyword>
	And User select <department> from search result
	And User filter product using price range <priceRange>
	Then User should see products within price range <priceRange>
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department | priceRange  |
	| CKUS	| Shirt   | Men        | $0 - $25    |
	| CKUS	| Jeans   | Men        | $100 - $150 |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department | priceRange          |
	| CKCA	| Shirt   | Men        | CAD $0 - CAD $100   |
	| CKCA	| Shirt   | Men        | CAD $200 - CAD $300 |

	@brand=TH 
	Examples: 
	| brand	| keyword | department | priceRange  |
	| TH	| Shirt   | Men        | $0 – $25    |
	| TH    | Shirt   | Men        | $25 - $50   |
	| TH    | Shirt   | Men        | $50 - $100  |
	| TH	| Jeans   | Men        | $100 - $150 |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department | priceRange      |
	| SPEEDO | Shirt   | Men        | $10.00 - $19.99 |
	| SPEEDO | Shirt   | Men        | $20.00 - $29.99 |
	| SPEEDO | Shirt   | Men        | $30.00 - $49.99 |

@id=4
Scenario Outline: Verify filtering product list based on Color 
	Given User access <brand> website
	When User searches for <keyword>
	And User select <department> from search result
	And User filter product using color <color>
	Then User should see products list filtered using <color>
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department | color |
	| CKUS	| Shirt   | Men        | black |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department | color |
	| CKCA	| Shirt   | Men        | black |

	@brand=TH 
	Examples: 
	| brand	| keyword | department | color |
	| TH	| Shirt   | Men        | black |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department | color |
	| SPEEDO | Shirt   | Men        | black |

@id=5
Scenario Outline: Verify filtering product list based on Size 
	Given User access <brand> website 
	When User searches for <keyword>
	And User select <department> from search result
	And User filter product using size <size>
	Then User should see products list filtered using <size>
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department | size |
	| CKUS	| Shirt   | Men        | 4xl  |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department | size |
	| CKCA	| Shirt   | Men        | 4xl  |

	@brand=TH 
	Examples: 
	| brand	| keyword | department | size |
	| TH	| Shirt   | Men        | 4xl  |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department | size |
	| SPEEDO | Shirt   | Men        | s    |

@id=6
Scenario Outline: Verify filtering product list based on Category 
	Given User access <brand> website 
	When User searches for <keyword>
	And User select <department> from search result
	And User filter product using category <category>	
	Then User should see products list filtered using <category>
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department | category   |
	| CKUS	| Shirt   | Men        | BIG + TALL |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department | category |
	| CKCA	| Shirt   | Men        | BODY     |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department | category |
	| SPEEDO | Shirt   | Men        | swimwear |
	
@id=7
Scenario Outline: Verify sorting product list based on Price Low to High
	Given User access <brand> website 
	When User searches for <keyword>
	And User select <department> from search result
	And User sort product using price <price>
	Then User should see product list sorted based on <price>
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department | price             |
	| CKUS	| Shirt   | Men        | Price Low To High |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department | price             |
	| CKCA	| Shirt   | Men        | Price Low To High |

	@brand=TH 
	Examples: 
	| brand	| keyword | department | price            |
	| TH	| Shirt   | Men        | Price Low - High |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department | price              |
	| SPEEDO | Shirt   | Men        | Price: Low To High |
	
@id=8
Scenario Outline: Verify sorting product list based on Price High to Low
	Given User access <brand> website 
	When User searches for <keyword>
	And User select <department> from search result
	And User sort product using price <price>
	Then User should see product list sorted based on <price> 
	
	@brand=CKUS 
	Examples: 
	| brand	| keyword | department | price             |
	| CKUS	| Shirt   | Men        | Price High To Low |

	@brand=CKCA 
	Examples: 
	| brand	| keyword | department | price             |
	| CKCA	| Shirt   | Men        | Price High To Low |

	@brand=TH 
	Examples: 
	| brand	| keyword | department | price            |
	| TH	| Shirt   | Men        | Price High - Low |
	
	@brand=SPEEDO 
	Examples: 
	| brand	 | keyword | department | price              |
	| SPEEDO | Shirt   | Men        | Price: High To Low |
