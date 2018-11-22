@module=footer
Feature: Footer
Description: This feature verifys links including the footer and department tabs

@id=1
Scenario Outline: Verfiy that footer links exist
	Given User access <brand> website
	Then User verifies <footernames> exists
	
	@brand=CKUS
	Examples:
	| brand	 | footernames |
	| CKUS 	 | faqs;order status;returns;shipping;coupons;preferred loyalty program;store locator;accessibility;women's underwear;men's underwear;calvin klein jeans;women's jeans;men's jeans;watches + jewelry;about calvin klein;about raf simons;careers;student discount;email us|

	@brand=CKCA
	Examples:
	| brand	 | footernames|
	| CKCA   | shipping;returns;track order;coupons;women's size guide;men's size guide;kids's size guide;preferred customer program;store locator;accessibility;205w39nyc;women;men;kids;underwear;women's underwear;men's underwear;sale;calvin klein jeans;about calvin klein;about raf simons;careers;projects;email us;|

	@brand=TH
	Examples:
	| brand  | footernames |
	| TH     | customer service;order status;your order;shipping;returns;size guide;my account;wish list;faqs;global site;corporate responsibility;careers;press;affiliate program;sitemap;terms & conditions;privacy policy;ca transparency in supply chain & uk modern slavery statement;accessibility|
	
	@brand=SPEEDO
	Examples:
	| brand  | footernames |
	| SPEEDO | call 1-888-4speedo;customer service;accessibility;speedo size chart;become a dealer;become a sponsored team;order status;shipping & delivery;return policy;payment options;racing swimsuits;training swimwear;triathlon gear;lifeguard swimsuits;water polo gear;aquatic fitness;aquatic fitness;lap swimming;in the water;on land;kids - begin to swim;women's swimwear;men's swimwear;swim goggles;kids swimwear;swim gear & equipment;swim caps;overview;training;gear;classes|

	
@id=2
Scenario Outline: Verify department category links go to correct pages
	Given User access <brand> website
	Then User verifies footer links go to correct page <category>
	
	@brand=CKUS
	Examples:
	| brand	 | category      |
	| CKUS 	 | store locator |

	@brand=CKCA
	Examples:
	| brand	 | category     |
	| CKCA   | coupons      |

	@brand=TH
	Examples:
	| brand  | category      |
	| TH     | FAQS          |
	
	@brand=SPEEDO
	Examples:
	| brand  | category     |
	| SPEEDO | Order Status |
