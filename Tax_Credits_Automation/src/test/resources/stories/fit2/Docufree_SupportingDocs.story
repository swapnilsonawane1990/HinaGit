Given User log in for screening process
When Perform Docufree screening for eligible record
Given Hire through rest API
When Perform docufree support docs request for driving lisence age and address
And Perform docufree support docs request for BirthCert Age
And Execute docufree job for status change
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify updated documents status in document tab
Then Verify docufree request in hub

Examples:
fit2//Docufree_SupportingDocs.table