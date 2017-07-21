Given User log in for screening process
Given User perform screening test

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Combo and search the <SSNNumber> for Specified Date
Then The status of record <ExpectedSSN> should be changed to K from E

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files SC Files
And Verify State Export Data file for state SC

Examples:
fit2//Sanity_StateExport_WebIn_SingleFlow_Combo_SC.table