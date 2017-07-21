Narrative:
As a user
I want to perform Stand Alone Screening, So that records Should displayed in Hub
Scenario: Verify that User should be able to perform Stand Alone Screening
Given User log in for screening process
Given User Perform Web In Walmart Screening

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify all hub fields

Given Search for Record and Do the eSign mass Print Queue
When User Update the PSN Details For Records
And User Update the DOL Details For Records
And User Update the COM Details For Records

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files for OH State

Examples:
fit2//Sanity_StateExport_Walmart_Esign_API_Hire_Individual_OH.table