Given User log in for screening process
When Perform Evo Xml Handshake through API
Given Perform EVO XML screening

Given Hire through rest API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Given Search for Record and Do the eSign mass Print Queue
When User Update the PSN Details For Records
And User Update the DOL Details For Records
And User Update the COM Details For Records


Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files for TN State
!-- And Verify State Export Data file for state TN 

Examples:
fit2//Sanity_StateExport_Evo-XMLScreening_APIHire_Individual_TN.table
