Narrative:
As a user
I want to perform Web-In Screening, Manager Hire and State Export Action
So that user get the state export files for Selected state

Scenario: Verify that User should be able to perform Web In Screening
Given User log in for screening process
Given User perform screening test

Examples:
test//001_Verify_Screening.table

Scenario: Verify Manager Hire
Given I Log in to Back Office with correct credential<UserName> <Password>
And I Navigate to Hire Compliance Page and Search with SSN
Then I should see records should be hired status

Examples:
test//001_Verify_Manager_Hire.table

Scenario: Verify the search result for VALID SSN Number
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Examples:
fit2//001_US123_Search_for_SSN_Number_Stories.table

Scenario: Verify Mass Processing
Given Search for Record and Do the eSign mass Print Queue

Examples:
test//Verify_Mass_Processing.table

Scenario: Perform_Esign_Mass_Printing_For_SSN

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then The status of record <ExpectedSSN> should be changed to K from E

Examples:
test//003_US123_Perform_Esign_Mass_Process_For_SSN.table


Scenario: Verify State Export with Valid Details

Given Enter All the Details With PSN Date and State and click on Exprot Button
Then User should be able to see all the correct details on Exported Files

Examples:
test//Verify_State_Export_With_Valid_Records.table