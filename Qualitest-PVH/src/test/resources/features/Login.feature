@module=login
Feature: Login
	Description: This feature allows user to access account using their registered credentials 

@id=1
Scenario Outline: Login with valid credentials
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
	
	@brand=CKUS
	Examples:
	| brand  | email               | password |
	| CKUS   | asdfasdf1@gmail.com | 1qaz@WSX |
	
	@brand=CKCA
	Examples:
	| brand  | email               | password |
	| CKCA   | asdfasdf3@gmail.com | 1qaz@WSX |
	
	@brand=TH
	Examples:
	| brand  | email               | password |
	| TH     | asdfasdf3@gmail.com | 1qaz@WSX |
	
	@brand=SPEEDO
	Examples:
	| brand  | email               | password |
	| SPEEDO | asdfasdf4@gmail.com | 1qaz@WSX |

@id=2
Scenario Outline: Login with invalid credentials
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should get error message <error>
	
	@brand=CKUS
	Examples:
	| brand  | email                    | password | error                  	                     			  |
	| CKUS   | qualitestanish@gmail.com | invalid1 | The email or password you entered does not match our records |
	
	@brand=CKCA
	Examples:
	| brand  | email                    | password | error                  	                     			  |
	| CKCA   | qualitestanish@gmail.com | invalid1 | The email or password you entered does not match our records |
	
	@brand=TH
	Examples:
	| brand  | email                    | password | error                  	                     			  |
	| TH     | qualitestanish@gmail.com | invalid1 | EITHER THE E-MAIL OR PASSWORD ENTERED IS INCORRECT.          |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                    | password | error                  	                     			  |
	| SPEEDO | qualitestanish@gmail.com | invalid1 | Either the E-mail or password entered is incorrect           |

@id=3
Scenario Outline: Attempt to login with invalid password more then 5 times
	Given User access <brand> website
	When User navigate to login page
	And User login using <email> and <password> more then 5 times
	Then User should get error message <error>
	
	@brand=CKCA
	Examples:
	| brand  | email              | password | error                                                 |
	| CKCA   | test1@testmail.com | Calvin33 | Wait a few seconds before attempting to log in again. |
	
	@brand=CKUS
	Examples:
	| brand  | email              | password | error                                                 |
	| CKUS   | test1@testmail.com | Calvin33 | Wait a few seconds before attempting to log in again. |
	
	@brand=TH
	Examples:
	| brand  | email              | password | error                                                 |
	| TH     | test1@testmail.com | Tommy33  | WAIT A FEW SECONDS BEFORE ATTEMPTING TO LOG IN AGAIN  |
	
	@brand=SPEEDO
	Examples:
	| brand  | email              | password | error                                                 |
	| SPEEDO | test1@testmail.com | Speedo33 | Wait a few seconds before attempting to log in again. |

@id=4
Scenario Outline: Login with old password after resetting password
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User reset password
	And User try to login using old password
	Then User should get error message <error>
	
	@brand=CKUS
	Examples:
	| brand  | email                 	  | password  | error                                                        |
	| CKUS   | restpassword@testmail.com  | 1qaz@WSX  | The email or password you entered does not match our records |
	
	@brand=CKCA
	Examples:
	| brand  | email                 	  | password  | error                                                        |
	| CKCA   | restpassword4@testmail.com | 1qaz@WSX  | The email or password you entered does not match our records |
	
	@brand=TH
	Examples:
	| brand  | email                 	  | password  | error                                                        |
	| TH     | restpassword2@testmail.com | 1qaz@WSX  | EITHER THE E-MAIL OR PASSWORD ENTERED IS INCORRECT.          |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                 	  | password  | error                                                        |
	| SPEEDO | restpassword3@testmail.com | 1qaz@WSX  | Either the E-mail or password entered is incorrect           |

@id=5
Scenario Outline: Login with new password after resetting password
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User reset password
	And User try to login using <email> and <newPassword>
	Then User should be login successfully
	
	@brand=CKUS
	Examples:
	| brand  | email                      | password | newPassword |
	| CKUS   | restpassword@testmail.com  | 1qaz@WSX | Calvin2     |
	
	@brand=CKCA
	Examples:
	| brand  | email                      | password | newPassword |
	| CKCA   | restpassword4@testmail.com | 1qaz@WSX | Calvin3     |
	
	@brand=TH
	Examples:
	| brand  | email                      | password | newPassword |
	| TH     | restpassword2@testmail.com | 1qaz@WSX | Tommy3      |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                      | password | newPassword |
	| SPEEDO | restpassword3@testmail.com | 1qaz@WSX | Speedo3     |
