Narrative:
As a user
I want to perform Stand Alone Screening, So that records Should displayed in Hub
Scenario: Verify that User should be able to perform Stand Alone Screening
Given User log in for screening process
Given User Perform Web In Walmart Screening

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Then Verify all hub fields


Examples:
fit2//Sanity_StateExport_Walmart_Esign_API_Hire_Individual_OH.table