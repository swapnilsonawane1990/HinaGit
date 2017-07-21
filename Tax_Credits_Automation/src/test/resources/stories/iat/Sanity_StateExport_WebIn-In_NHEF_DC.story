Narrative:
As a user
I want to perform XML-In Screening and State Export Action

Given User log in for screening process
Given User perform screening test

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Given User Hire the records with NHEF and current date

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files for CO Family
And Verify State Export Data file for state DC


Examples:
iat//Sanity_StateExport_WebIn-In_NHEF_DC.table