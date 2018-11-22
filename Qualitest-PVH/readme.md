Qualitest BDD Framework
	As the name suggest this is a test automation framework based on Behavior Driven Development in which tests are specified in terms of the desired behavior of the unit. This framework is based on Serenity Screenplay, Cucumber and Junit framework which helps to write better structured, more maintainable automated acceptance criteria, and also produces rich meaningful test reports that not only report on the test results, but also what features have been tested. 

Getting Started
	Framework can be accessed from git using: https://github.com/QualitestNJDev/Qualitest-BDD-Framework

Prerequisites
	Below are the tools that needs to be installed:
	1. JAVA: Install JDK and set up environment variables
	2. IDE: Install any IDE, Eclipse is preferred. Naturals plugin also needs to be installed in Eclipse to work with feature files.
	3. NODE.JS and Appium: Needed only for testing on mobile

How to work with framework
	1. Basic project setup steps:
		This step is not needed if you are downloading project from git to start. Jump to step 2 for starting automation, else continue:
		i. Create Maven Project in Eclipse
			1) with correct group id (should always create with com.qualitestgroup)
			2) with correct artifact id (should be name of application/client ex. gmail in this case)
		ii. Add following dependencies
			1) Aeonbits Owner - Used to better manage Java Properties
			2) Serenity Junit - Serenity Junit library
			3) Serenity Cucumber - Serenity Cucumber library which intern has Serenity Core, Serenity ScreenPlay, Serenity ScreenPlay Webdriver
			7) AssertJ Core
			8) Hamcrest All
		iii. Add following plugins
			1) Maven Compiler Plugin
			2) Maven Surefire Plugin
			3) Maven Failsafe Plugin
			4) Serenity Maven Plugin
			5) Eclipse lifecycle mapping Plugin
			6) Cucumber JVM Parallel Plugin
		iv. Create resources folder under test
		v. Create driver and features folder under the resources folder
		vi. Add necessary driver files under drivers folder. For ex. Chromedriver.exe
		vii. Create serenity.properties file under project root folder and add following properties:
			1) serenity.project.name=GMAIL-POC
			2) serenity.use.unique.browser = false
			3) serenity.dry.run=false
			4) serenity.browser.maximize=true
			5) serenity.take.screenshots=AFTER_EACH_STEP
			6) webdriver.driver=chrome
			7) webdriver.chrome.driver=src/test/resources/drivers/win/chromedriver.exe
			8) webdriver.gecko.driver=src/test/resources/drivers/win/geckodriver.exe
			9) webdriver.timeouts.implicitlywait=1000
			10) chrome.switches=--homepage=about:blank,--no-first-run
		viii. Create log4j.properties file under resources folder
			# Root logger option
			1) log4j.rootLogger=INFO, file, stdout
			# Direct log messages to a log file
			2) log4j.appender.file=org.apache.log4j.RollingFileAppender
			3) log4j.appender.file.File=target/log/gmail.log
			4) log4j.appender.file.MaxFileSize=100MB
			5) log4j.appender.file.MaxBackupIndex=10
			#log4j.appender.file.Append=false
			6) log4j.appender.file.layout=org.apache.log4j.PatternLayout
			7) log4j.appender.file.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n			
			# Direct log messages to stdout
			8) log4j.appender.stdout=org.apache.log4j.ConsoleAppender
			9) log4j.appender.stdout.Target=System.out
			10) log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
			11) log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
	2. Steps for starting scripting:
		i. Create Feature files:
			Refer point 5 and 6 mentioned in Resources section to learn writing good feature files.
			1) Best Practices for creating feature files: 
				1) Feature files should be organized hierarchically as per different functionalities.
				2) Feature files should be created for business/end user perspective and should not be considered as test steps.
				3) Each scenario within each feature file should not be independent and should not depend on other scenario for execution.
		ii. Create Step Definition
			1) Create Actor/User: These are the classes which maps to each scenario steps and are created just like a business user would complete scenario step
			2) Create Step library: These are classes which maps to the actions performed by the Actor/User
			3) Create Page Repository: This is the repository of application components/elements and operation that can be performed on those elements
			4) Create Hooks: This the library of steps that needs to be completed as part of pre-requisite or post scenario completion
			5) Create Tags: As part of this step scenarios are tagged with annotation to group/categories them
		iii. Create Runner

Resources:
	1. Cucumber: https://cucumber.io/school
	2. Tools QA: http://toolsqa.com/cucumber/cucumber-tutorial/
	3. Testing Excellence: https://www.testingexcellence.com/bdd-guidelines-best-practices/
	4. Serenity: http://www.thucydides.info/#/learnserenity
	5. For Each: https://www.foreach.be/blog/9-tips-improving-cucumber-test-readability
	6. Engine Yard: https://www.engineyard.com/blog/15-expert-tips-for-using-cucumber
	7. Aeonbits Owner: http://owner.aeonbits.org/docs/usage/

https://github.com/serenity-bdd/serenity-documentation/blob/master/src/asciidoc/remote.adoc