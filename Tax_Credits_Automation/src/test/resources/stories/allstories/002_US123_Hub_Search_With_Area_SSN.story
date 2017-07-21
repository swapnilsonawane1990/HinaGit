Meta:

Narrative:
As a application User
I want to perform advance Search on hub
So that I can see the required details as per search criteria

Scenario: Verify Search with Area and SSN Field

Given User Navigate To the Home page
When User Go To Advance Search Page and Search for ssn and area
Then The Search Result should be displayed with correct value for SSN AND AREA

Examples:
test//002_US_ID01_Hub_Search_With_Area_SSN.table