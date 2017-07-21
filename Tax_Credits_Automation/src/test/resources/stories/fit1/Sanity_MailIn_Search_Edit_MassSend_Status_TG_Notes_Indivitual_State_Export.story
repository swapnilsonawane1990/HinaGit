Narrative:
As a user
I want to perform Mail-In Screening, Search/Status check/Edit/Status Change/Mass Send Fax-Email/Export to Excel/Document Status/TG/Questions/Notes/ and State Export Action
So that user get the state export files for Selected state with Expected Data

Scenario: Verify that Mail In Screening with Search/Status check/Edit/Status Change/Mass Send Fax-Email/Export to Excel/Document Status/TG/Questions/Notes/ and State Export Action
Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
Given User Navigate to Mail In Screening Page
Given User perform Mail-In screening test
When Search the Manual Key In Record with SSN


Examples:
fit2//Sanity_MailIn_Search_Edit_MassSend_Status_TG_Notes_Indivitual_State_Export.table
