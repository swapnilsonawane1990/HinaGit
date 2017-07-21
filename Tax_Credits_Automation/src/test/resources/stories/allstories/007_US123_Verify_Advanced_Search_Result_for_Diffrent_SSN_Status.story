Meta:

Narrative:
As a application User
I want to perform advance Search on hub
So that I can see the required details as per search criteria

Scenario: Verify advanced Search result for Diffrent SSN Status

Given I Logged in and Advanced Search Page is displayed
When I Search by selecting Valid Status on Hub Search
Then I should see the correct Search result for Selected Status

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_For_DiffrentStatus.table