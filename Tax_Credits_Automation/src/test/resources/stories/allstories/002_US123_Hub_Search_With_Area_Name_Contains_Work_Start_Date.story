Meta:

Narrative:
As a application User
I want to perform advance Search on hub
So that I can see the required details as per search criteria

Scenario: Verify Search with Area_Name_Contains_Work_Start_Date Field

Given User Navigate To the Home page
When User Go To Advance Search Page and Search for Area_Name_Contains_Work_Start_Date
Then The Search Result should be displayed with correct value for Area Name contain and work start Date

Examples:
test//002_US_ID07_Hub_Search_With_Area_Name_Contains_Work_Start_Date.table