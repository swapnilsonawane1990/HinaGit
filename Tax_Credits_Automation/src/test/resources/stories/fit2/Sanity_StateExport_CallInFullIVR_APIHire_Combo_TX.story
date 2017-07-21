Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User Perform Call In Screening API Hire Combo and For Texas State
Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Given User Perform Call In Screening for Company <companyName>

Given Manager hire through rest API
Given User Search SSN in Hub
Then edit Status of Screening Record to Status

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then The status of record <ExpectedSSN> should be changed to K from E

Given Enter All the Details With PSN Date and State and click on Export Button
Then User should be able to see all the correct details on Exported Files

Examples:
fit2//Sanity_StateExport_CallInFullIVR_APIHire_Combo_TX.table