Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
When Perform manaul Key from paper screening

When Search the Manual Key In Record with SSN
Then Verify all hub fields

!-- Given Search for Record and Do the eSign mass Print Queue
When User Update the PSN Details For Records
And User Update the DOL Details For Records
And User Update the COM Details For Records

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files for KS State

!-- Then Verify State Export Data file for state NC

Examples:
iat//Sanity_StateExport_ManualKeyIn_Singleflow_Individual_KS.table