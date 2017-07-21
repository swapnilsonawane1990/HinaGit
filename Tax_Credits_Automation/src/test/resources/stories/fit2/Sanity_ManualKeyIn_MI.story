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


Examples:
fit2//Sanity_ManualKeyIn_SignleFlow_Search_StatusCheck_ChangeStatusToE_Combo_State_Export.table
