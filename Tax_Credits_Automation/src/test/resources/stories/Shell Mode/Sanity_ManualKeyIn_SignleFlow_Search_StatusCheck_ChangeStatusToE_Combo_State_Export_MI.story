Narrative:
As a user
I want to perform Manual Key In Screening, Search/Status check/Change Status to E, Combo and State Export Action
So that user get the state export files for Selected state with Expected Data

Scenario: Verify that Manual Key In Screening, Search/Status check/Change Status to E, Combo and State Export Action
Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
When Perform manaul Key from paper screening
When Search the Manual Key In Record with SSN
Then The Search <ExpectedSSN> should be displayed in the result
Then The Search <ExpectedSSN> SSN Status correctly should be displyed on Hub

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then The status of record <ExpectedSSN> should be changed to K from E

Given Enter All the Details With PSN Date and State and click on Exprot Button
Then User should be able to see all the correct details on Exported Files for MI State

Examples:
iat//Sanity_ManualKeyIn_SignleFlow_Search_StatusCheck_ChangeStatusToE_Combo_State_Export.table
