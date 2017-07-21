Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Verify Manager Hire
Given I Log in to Back Office with correct credential<UserName> <Password>
And I Navigate to Hire Compliance Page and Search with SSN
Then I Navigate to Hire Compliance Page and Search with SSN

Examples:
data//test//001_Verify_Manager_Hire.table