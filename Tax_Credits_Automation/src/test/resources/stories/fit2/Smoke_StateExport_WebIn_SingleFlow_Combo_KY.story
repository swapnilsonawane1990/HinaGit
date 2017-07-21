Given User log in for screening process
Given User perform screening test for Xml In

Given Hire Using REST API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify hub search result data

Given Search for Record and Do the eSign mass Print Queue
When User Update the PSN Details For Records
And User Update the DOL Details For Records
And User Update the COM Details For Records

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on KY Exported Files

Examples:
fit2//Smoke_StateExport_WebIn_SingleFlow_Combo_KY.table