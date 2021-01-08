Feature: Smartbear application 

Background: Open the browser 

	Given open the browser 
	
@Order	
Scenario: login in to the application 

	When navigates to the application 
	And enter username 
	And enter password 
	And click login 
	Then  verify login is successfull 

Scenario: verify order 

	When navigates to the application 
	And enter username 
	And enter password 
	And click login 
	Then  verify login is successfull 
	Given click on order page 
	When  select product 
	And  enter the quantity 
	And  enter the discount 
	
Scenario Outline: login in to the application 

	When navigates to the application "<url>" 
	And enter username "<userName>" 
	And enter password "<password>" 
	And click login 
	Then  verify login is successfull 
	
	Examples: 
		|url|userName|password|
		|http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx|Tester|test|
		|http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx|Tester|tester|
		
Scenario: Dummy scenario

	Given print tosca. 
	
Scenario: Dummy scenario

	Given print selenium. 
	
Scenario: Dummy scenario

	Given print perfecto. 
