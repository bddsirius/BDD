@module=forgotPassword
Feature: Forgot Password
	Description: This feature allows user to send password reset email

@id=1
Scenario Outline: Access forgot password with valid account email
	Given User access <brand> website
	When User navigate to login page
	And User navigates to forgot password page
	And User sends password reset link to <email>
	Then User should be able to confirm password reset was sent

	@brand=CKUS
	Examples:
	| brand | email                    |
	| CKUS  | qualitestanish@gmail.com |
	
	@brand=CKCA
	Examples:
	| brand | email                    |
	| CKCA  | qualitestanish@gmail.com |
	
	@brand=TH
	Examples:
	| brand | email                    |
	| TH    | qualitestanish@gmail.com |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                    |
	| SPEEDO | qualitestanish@gmail.com |

@id=2
Scenario Outline: Access forgot password with invalid account email
	Given User access <brand> website
	When User navigate to login page
	And User navigates to forgot password page
	And User sends password reset link to <email>
	Then User should get error message <error>

	@brand=CKUS
	Examples:
	| brand | email                | error 																    |
	| CKUS  | qualitestanish@g.com | Sorry, we couldn't find an account associated with that email address. |
	
	@brand=CKCA
	Examples:
	| brand | email                | error 																    |
	| CKCA  | qualitestanish@g.com | Sorry, we couldn't find an account associated with that email address. |
	
	@brand=TH
	Examples:
	| brand | email                | error 																    |
	| TH    | qualitestanish@g.com | SORRY, WE COULDN'T FIND AN ACCOUNT ASSOCIATED WITH THAT EMAIL ADDRESS. |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                | error 																 |
	| SPEEDO | qualitestanish@g.com | Sorry, we couldn't find an account associated with that email address. |

@id=3
Scenario Outline: Reset password with invalid credentials
	Given User access <brand> website 
	When User navigate to login page 
	And User navigates to forgot password page 
	And User sends password reset link to <email> 
	And User navigates to email folder <password> 
	When User should have email for password reset 
	And User should change password on new page <newPassword>
	 
	@brand=CKUS 
	Examples: 
	| brand | email                    | password   | newPassword | 
	| CKUS  | willgriffinwk8@gmail.com | Giants1234 | 1234        | 
	
	@brand=CKCA
	Examples:
	| brand | email                    | password   | newPassword |
	| CKCA  | willgriffinwk8@gmail.com | Giants1234 | 1234        |
	
	@brand=TH
	Examples:
	| brand | email                    | password   | newPassword | 
	| TH    | willgriffinwk8@gmail.com | Giants1234 | 1234        |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                    | password   | newPassword |
	| SPEEDO | willgriffinwk8@gmail.com | Giants1234 | 1234        |	

@id=4
Scenario Outline: Reset password with valid credentials
	Given User access <brand> website 
	When User navigate to login page 
	And User navigates to forgot password page 
	And User sends password reset link to <email> 
	And User navigates to email folder <password> 
	When User should have email for password reset 
	And User should change password on new page <newPassword>
	Then User should successfully login with new password 
	 
	@brand=CKUS 
	Examples: 
	| brand  | email                     | password    | newPassword  | 
	| CKUS   | willgriffinwk8@gmail.com  | Giants1234  | 1qaz@WSX     | 
	
	@brand=CKCA
	Examples:
	| brand  | email                     | password    | newPassword  |
	| CKCA   | willgriffinwk8@gmail.com  | Giants1234  | 1qaz@WSX     |
	
	@brand=TH
	Examples:
	| brand  | email                     | password    | newPassword  | 
	| TH     | willgriffinwk8@gmail.com  | Giants1234  | 1qaz@WSX     |
	
	@brand=SPEEDO
	Examples:
	| brand  | email                     | password    | newPassword  |
	| SPEEDO | willgriffinwk8@gmail.com  | Giants1234  | 1qaz@WSX     |	
