Given User log in for screening process
Given User perform screening test

Given Manager hire through rest API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify all hub fields

Given Search for Record and Do the eSign mass Print Queue
When User Update the PSN Details For Records
And User Update the DOL Details For Records
And User Update the COM Details For Records

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files for CO Family
And Verify State Export Data file for state CO

Examples:
iat//Smoke_StateExport_WebIn_APIHire_Individual_CO.table