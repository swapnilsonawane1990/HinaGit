Narrative:
As a user
I want to perform Mail-In Screening, Search/Status check/Edit/Status Change/Mass Send Fax-Email/Export to Excel/Document Status/TG/Questions/Notes/ and State Export Action
So that user get the state export files for Selected state with Expected Data

Scenario: Verify that Mail In Screening with Search/Status check/Edit/Status Change/Mass Send Fax-Email/Export to Excel/Document Status/TG/Questions/Notes/ and State Export Action
Given User log in for screening process
Given User perform screening test

Given Manager hire through rest API

Examples:
iat//Smoke_001_Verify_Web_In_Screening_Manager_Hire_To_State_Exprot_Flow.table

Scenario: Verify that User Search SSN and State Export
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
iat//Sanity_MailIn_Search_Edit_MassSend_Status_TG_Notes_Indivitual_State_Export.table
