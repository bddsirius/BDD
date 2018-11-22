@module=storeLocator
Feature: Store Locator 
	Description: This feature allows user to search store near to the location provided

@id=1 
Scenario Outline: Verify store locator search is prepopulated with Sufferen NY 10901 US
	Given User access <brand> website 
	When User navigate to store locator
	Then User should see <location> as pre populated
	
	@brand=CKUS 
	Examples: 
	| brand	| location         |
	| CKUS	| Suffern NY 10901 |

	@brand=CKCA 
	Examples: 
	| brand	| location         |
	| CKCA	| Suffern NY 10901 |

	@brand=TH 
	Examples: 
	| brand	| location            |
	| TH	| Suffern NY 10901 US |
		
@id=2 
Scenario Outline: Verify store locator search with invalid value e.g. asdfasdf 
	Given User access <brand> website 
	And User navigate to store locator 
	When User search <location> on store locator 
	Then User should see no result <message>
	
	@brand=CKUS 
	Examples: 
	| brand	| location | message            |
	| CKUS	| asdfasdf | No locations found |

	@brand=CKCA 
	Examples: 
	| brand	| location | message            |
	| CKCA	| asdfasdf | No locations found |

	@brand=TH 
	Examples: 
	| brand	| location | message            |
	| TH	| asdfasdf | No locations found |
	
@id=3 
Scenario Outline: Verify store locator search with valid value 
	Given  User access <brand> website 
	And User navigate to store locator 
	When User search <location> on store locator 
	Then User should see valid search result for <location>
	
	@brand=CKUS 
	Examples: 
	| brand	| location           |
	| CKUS	| Edison, New Jersey |

	@brand=CKCA 
	Examples: 
	| brand	| location           |
	| CKCA	| Edison, New Jersey |

	@brand=TH 
	Examples: 
	| brand	| location           |
	| TH	| Edison, New Jersey |
