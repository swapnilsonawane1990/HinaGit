Narrative:
As a user
I want to perform SSN Number Search
So that correct result should be displayed for given SSN Number

Scenario: Verify the search result for VALID SSN Number
Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Examples:
fit2//001_US123_Search_for_SSN_Number_Stories.table
