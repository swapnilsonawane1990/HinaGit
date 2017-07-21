Given User log in for screening process
Given User perform screening test

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify hub search result data

Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then User should be able to see all the correct details on Exported Files for VI State

Examples:
QA2//Sanity_WebIn_APIHire_Combo_VI.table