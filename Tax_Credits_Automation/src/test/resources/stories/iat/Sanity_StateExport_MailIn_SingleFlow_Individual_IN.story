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

Given Search for Record and Do the eSign mass Print Queue
When User Update the PSN Details For Records
And User Update the DOL Details For Records
And User Update the COM Details For Records

Then User should be able to see all the correct details on Exported Files IL Files
Given Enter All the Details With PSN Date and State and click on Export Button

Examples:
iat//Sanity_StateExport_MailIn_SingleFlow_Individual_IN.table

