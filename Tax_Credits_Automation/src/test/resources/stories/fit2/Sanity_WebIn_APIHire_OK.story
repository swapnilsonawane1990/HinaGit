Given User log in for screening process
Given User perform screening test

Given hire through XML rest API for Retro
And I Log in to Back Office with correct credential for Client User <UserName> <Password>
Then Manager hire to update the status to E

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify hub search result data


Examples:
fit2//Sanity_StateExport_WebIn_APIHire_Combo_OK.table