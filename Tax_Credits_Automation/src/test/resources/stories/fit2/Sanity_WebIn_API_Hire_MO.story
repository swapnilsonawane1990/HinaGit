Narrative:
As a user
I want to perform eligible Web-In Screening for SSI, API Hire and State Export Action
So that user get the state export files for Selected state MO

Scenario: Verify that User should be able to perform XML In Screening API Hire and State Export for Webin SSI

Given User log in for screening process
And User perform screening test for Xml In

Given hire through XML rest API for Retro

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result


Examples:
fit2//Sanity_StateExport_WebIn_Esign_API_Hire_Combo_MO.table