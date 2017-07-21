Narrative:
As a user
I want to perform Web-In Screening, Manager Hire

Scenario: Verify that User should be able to perform Web in Screening and Hire
Given User log in for screening process
Given User perform screening test
Given I Log in to Back Office with correct credential for Client User <UserName> <Password>
Given I Navigate to SCP Hire Compliance Page and Enter SSN and click on Search
Then I entered Gave info greater than job offer date and clicked on Submit
Then Logout from Hiring Compliance

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then The Search <ExpectedSSN> should be displayed in the result

Then Verify Hub Search Result in Grid

Examples:
iat//ManagerHire_Hire_with_past_dates_QD_screen.table