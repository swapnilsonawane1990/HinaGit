Given User log in for screening process
When Perform Evo Xml Handshake through API
Given Perform EVO XML screening

!-- Given Manager hire through rest API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify hub search result data

Given Search for Record and Do the eSign mass Print Queue
Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Given Enter All the Details With PSN Date and State and click on Exprot Button
Then User should be able to see all the correct details on Exported Files for UT State
!-- Then Verify State Export Data file for state NC

Examples:
iat//Sanity_StateExport_EvoXML_Singleflow_Combo_UT.table