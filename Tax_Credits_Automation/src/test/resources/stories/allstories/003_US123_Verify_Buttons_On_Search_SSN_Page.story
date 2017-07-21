Narrative:
As a ADMIN User
I want to perform an Search SSN Operation
So that I can see the Reset

Scenario: Verify that Reset, Export to Excel button should be displayed
Given I log in as the Admin user
Given I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button Only
Then Reset and Export Button should be displayed

Examples:
data//fit2//003_US123_Verify_Buttons_On_Search_SSN_Page.table