Meta:

Narrative:
As a application User
I want to perform advance Search on hub
So that I can see the required details as per search criteria

Scenario: Verify Search with Name Contains and Company Field

Given User Navigate To the Home page
When User Go To Advance Search Page and Search for Name Contains and Company
Then The Search Result should be displayed with correct value for Name Contains AND Company

Examples:
test//002_US_ID04_Hub_Search_With_Name_Contains_Company.table