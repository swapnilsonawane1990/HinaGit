Narrative:
As a user
I want to perform Web-In Screening, API Hire and State Export Action
So that user get the state export files for Selected state

Scenario: Verify that User should be able to perform Web In Screening API Hire and State Export

Given User log in for screening process
Given User perform screening test

Given Manager hire through rest API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then The status of record <ExpectedSSN> should be changed to K from E

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files

Examples:
iat//Smoke_003_Verify_Web_In_Screening_API_Hire_To_State_Export.table