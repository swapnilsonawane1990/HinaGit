Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: User Perform Call In Screening API Hire Combo and For Texas State
Given User log in for screening process

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Given User Perform Call In Screening for Company <companyName>

Examples:
iat//SCP_Notify_CallIn_SingleFlow.table