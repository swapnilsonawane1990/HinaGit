Meta:

Narrative:
As a application User
I want to perform advance Search on hub
So that I can see the required details as per search criteria

Scenario: Verify Search with Area and SSN Field

Given User Navigate To the Home page
When User Go To Advance Search Page and Search for ssn area Company
Then The Search Result should be displayed with correct value for SSN AND AREA AND Company

Examples:
test//002_US_ID02_Hub_Search_With_Area_SSN_Company.table