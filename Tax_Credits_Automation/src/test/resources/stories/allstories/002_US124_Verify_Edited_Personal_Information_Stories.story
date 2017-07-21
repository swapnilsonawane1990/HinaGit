Narrative:
As a IAT user Application User
I want to Edit The Personal Information Of a Candidiate
So that information should get updated as per edit

Scenario: Verify that SSN Personal information should be edited
Given I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button Only
When I Double Click on SSN and Edit the Personal Information related to search SSN
Then The Newly Edited Information Should be Displayed

Examples:
data//fit2//002_US124_Verify_Edited_Personal_Information_Stories_Scenario01.table

Scenario: Verify that Back Button functinality On edit SSN Page
Given I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button Only
When I Double Click on SSN and Edit the Personal Information related to search SSN
Then Click On the Back Button, Edit Button Should be displayed

Examples:
data//fit2//002_US124_Verify_Edited_Personal_Information_Stories_Scenario02.table