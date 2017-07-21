Given User log in for screening process
And User perform screening test for Xml In

Given Hire through rest API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result


Examples:
fit2//Sanity_StateExport_XML_In_Screening_APIHire_Combo_GA.table
