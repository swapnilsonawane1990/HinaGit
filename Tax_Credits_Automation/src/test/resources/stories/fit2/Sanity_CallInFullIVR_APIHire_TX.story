Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Given User Perform Call In Screening for Company <companyName>
Given Manager hire through rest API
Given User Search SSN in Hub
Then Verify Hub Search Result in Grid

Examples:
fit2//Sanity_StateExport_CallInFullIVR_APIHire_Combo_TX.table