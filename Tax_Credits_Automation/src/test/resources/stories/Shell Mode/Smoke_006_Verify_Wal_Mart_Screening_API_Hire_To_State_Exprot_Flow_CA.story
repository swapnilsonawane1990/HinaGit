Narrative:
As a user
I want to perform Stand Alone Screening, So that records Should displayed in Hub
Scenario: Verify that User should be able to perform Stand Alone Screening
Given User log in for screening process
Given User Perform Web In Walmart Screening

Examples:
iat//Smoke_006_Verify_Wal_Mart_Screening_API_Hire_To_State_Exprot_Flow_CA.table

Scenario: Verify that User Search SSN and do the State Export
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Then Verify Hub Search Result in Grid

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button


Given Enter All the Details With PSN Date and State and click on Exprot Button
Then Verify State Export Data file for state CA

Examples:
iat//Smoke_006_Verify_Wal_Mart_Screening_API_Hire_To_State_Exprot_Flow_CA.table