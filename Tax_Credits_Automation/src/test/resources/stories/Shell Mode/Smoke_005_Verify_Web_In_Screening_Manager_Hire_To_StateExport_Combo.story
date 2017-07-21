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
iat//Smoke_005_Verify_Web_In_Screening_Manager_Hire_To_StateExport_Combo.table

Scenario: Verify that User Search SSN and do the State Export
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Then Verify Hub Search Result in Grid
Then edit Employment Information from Details page
Then edit Status of Screening Record to Status

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button


Given Enter All the Details With PSN Date and State and click on Exprot Button
Then Verify State Export Data file for state AR

Examples:
iat//Smoke_005_Verify_Web_In_Screening_Manager_Hire_To_StateExport_Combo_2.table
