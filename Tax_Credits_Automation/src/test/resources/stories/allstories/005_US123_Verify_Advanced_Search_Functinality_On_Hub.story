Meta:

Narrative:
As a application User
I want to perform advance Search on hub
So that I can see the required details as per the search criteria

Scenario: Verify advanced Search result for client id
Given I Logged in and Advanced Search Page is displayed
When I Search with valid clientID
Then I should see the correct Search result for specified client ID

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_On_Hub.table


Scenario: Verify advanced Search result for Area and Company
When I Search with valid Area and Company Name
Then I should see the correct Search result for specified Area and Company

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_For_Area_CompanyName.table

Scenario: Verify advanced Search result for Application Status
Given I Logged in and Advanced Search Page is displayed
When I Search with valid Application Status
Then I should see the correct Search result for specified Application Status

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_For_Application_Status.table

Scenario: Verify advanced Search result for StartDate From and StartDate to

Given I Logged in and Advanced Search Page is displayed
When I Search with valid Start Date From and Start Date to fields
Then I should see the correct Search result for specified Start Date Range

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_For_StartDatetofrom.table

Scenario: Verify advanced Search result for Hire Date Field

Given I Logged in and Advanced Search Page is displayed
When I Search with valid Hire Date
Then I should see the correct Search result for Hire date Field

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_For_HireDate.table

Scenario: Verify advanced Search result for Confirmation Number

Given I Logged in and Advanced Search Page is displayed
When I Search with valid Confirmation Number
Then I should see the correct Search result for Confirmation Number

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_For_Confirmation_Number.table

Scenario: Verify advanced Search result for Work Start And to Date

Given I Logged in and Advanced Search Page is displayed
When I Search with valid Work Start Date and End date
Then I should see the correct Search result for Work Start

Examples:
data//fit2//005_US123_Verify_Advanced_Search_Functinality_For_workstartTo.table