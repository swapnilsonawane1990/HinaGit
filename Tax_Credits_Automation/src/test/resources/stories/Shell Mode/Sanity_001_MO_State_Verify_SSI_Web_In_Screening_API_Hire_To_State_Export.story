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

Then edit Status of Screening Record to Status
Given Esign Mass Print Queue with User Specified Dates

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Combo and search the <SSNNumber> for Specified Date
Then The status of record <ExpectedSSN> should be changed to K from E

Given Enter All the Details With PSN Date and State and click on Exprot Button
Then User should be able to see all the correct details on MO Exported Files

Examples:
iat//Sanity_001_MO_State_Verify_SSI_Web_In_Screening_API_Hire_To_State_Export.table