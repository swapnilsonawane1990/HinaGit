Narrative:
As a user I want to perform XML-In Screening and State Export Action
So that user get the state export files for Selected state

Scenario: Verify that User should be able to perform XML in Screening

Given User log in for screening process
Given User perform screening test for Xml In

Given Manager hire through rest API

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result



Examples:
fit2//Sanity_StateExport_XML-In_SingleFlow_LA.table
