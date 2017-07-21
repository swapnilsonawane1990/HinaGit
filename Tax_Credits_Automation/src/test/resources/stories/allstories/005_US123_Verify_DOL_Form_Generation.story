Meta:

Narrative:
As a application User
I want to perform esign mass process queue in hub
So that I can change the status of record from E to K

Scenario: Perform_Esign_Mass_Printing_For_SSN

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Then The status of record <ExpectedSSN> should be changed to K from E

Examples:
test//003_US123_Perform_Esign_Mass_Process_For_SSN.table