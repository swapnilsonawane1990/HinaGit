Narrative:
As a user
I want to perform Web-In Screening, Manager Hire and State Export Action
So that user get the state export files for Selected state

Scenario: Verify that User should be able to perform Web in Screening and Hire
Given User log in for screening process
Given User perform screening test
Given I Log in to Back Office with correct credential for Client User <UserName> <Password>
And I Navigate to Hire Compliance Page and Search with SSN
Then I should see records should be hired status

Examples:
fit2//Smoke_001_Verify_Web_In_Screening_Manager_Hire_To_State_Exprot_Flow.table

Scenario: Verify that User Search SSN and do the State Export
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then The status of record <ExpectedSSN> should be changed to K from E

Given Enter All the Details With PSN Date and State and click on Exprot Button
Then User should be able to see all the correct details on Exported Files

Examples:
fit2//Smoke_001_Verify_Web_In_Screening_Manager_Hire_To_State_Exprot_Flow_2.table
