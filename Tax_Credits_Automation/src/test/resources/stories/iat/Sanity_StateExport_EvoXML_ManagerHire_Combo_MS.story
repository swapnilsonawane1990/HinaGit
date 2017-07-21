Given User log in for screening process
When Perform Evo Xml Handshake through API
Given Perform EVO XML screening

Given Hire through rest API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Given Search for Record and Do the eSign mass Print Queue
Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Given Enter All the Details With PSN Date and State and click on Export Button

Then User should be able to see all the correct details on MS Exported Files
!-- And Verify State Export Data file for state TN 

Examples:
iat//Sanity_StateExport_EvoXML_ManagerHire_Combo_MS.table
