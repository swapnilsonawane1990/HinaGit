Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify the Reset functionality for SSN Number
Given I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button Only
When I Click on Reset Button
Then Reset should be performed for Search Result and fields

Examples:
data//fit2//003_US123_Verify_Buttons_On_Search_SSN_Page.table