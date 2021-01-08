Feature: CRM_Pro application 

@Crm
Scenario: login in to the application 

	Given open the browser 
	When navigates to the application
	And enter username and password
	|username|password|
	|Tester|test|
	Then verify login is successfull
	Given click on order page 
	When  select product 
	And  enter the quantity 
	And  enter the discount