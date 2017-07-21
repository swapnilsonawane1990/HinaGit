Narrative:
As a user
I want to perform Stand Alone Screening, So that records Should displayed in Hub
Scenario: Verify that User should be able to perform Stand Alone Screening
Given User log in for screening process
Given User Perform Web In Walmart Screening

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

!-- Then edit Employment Information from Details page
Then edit Status of Screening Record to Status
Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button


Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on NY Exported Files

Examples:
fit2//Sanity_StateExport_Walmart_Non_Esign_API_Hire_Combo_NY.table