Narrative:
As a user
I want to perform Call-In Screening, So that records Should displayed in Hub
Scenario: Verify that User should be able to perform Call In Screening and Hire
Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Examples:
fit2//Smoke_call_In_Admin_login.table

Scenario: Verify that Scrrenig with call in method
Given User Perform Call In Screening for Company <companyName>

Examples:
fit2//callinscreening_test.table