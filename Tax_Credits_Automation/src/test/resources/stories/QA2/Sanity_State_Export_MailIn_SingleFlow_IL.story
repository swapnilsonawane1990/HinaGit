Narrative:
As a user
I want to perform Mail-In Screening, Search/Status check/Edit/Status Change/Mass Send Fax-Email/Export to Excel/Document Status/TG/Questions/Notes/ and State Export Action
So that user get the state export files for Selected state with Expected Data

Scenario: Verify that Mail In Screening with Search/Status check/Edit/Status Change/Mass Send Fax-Email/Export to Excel/Document Status/TG/Questions/Notes/ and State Export Action
Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
Given User Navigate to Mail In Screening Page
Given User perform Mail-In screening test
Then The Search <ExpectedSSN> should be displayed in the result
Then The Search <ExpectedSSN> SSN Status correctly should be displyed on Hub

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then The status of record <ExpectedSSN> should be changed to K from E
Then User should be able to see all the correct details on Exported Files IL Files
Given Enter All the Details With PSN Date and State and click on Export Button

Examples:
QA2//Sanity_MailIn_Search_Edit_MassSend_Status_TG_Notes_Indivitual_State_Export.table

