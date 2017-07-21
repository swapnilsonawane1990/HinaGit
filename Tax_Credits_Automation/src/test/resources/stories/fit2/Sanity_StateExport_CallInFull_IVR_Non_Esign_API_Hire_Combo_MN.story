Given User log in for screening process

Given I Log in to Back Office with correct credential<UserName> <Password>
!-- When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
When I Navigate to Hub Page from Portal Application
Given User Perform Call In Screening for Company <companyName>
Then I Log out from Back Office and Portal application

Given I Log in to Back Office with correct credential for Client User <UserName> <Password>
And I Navigate to Hire Compliance Page and Search with SSN
Then I should see records should be hired status

Given I Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button


!-- Then The Search <ExpectedSSN> should be displayed in the result

Then edit Employment Information from Details page
Then edit Status of Screening Record to Status
Given Search for Record and Do the eSign mass Print Queue

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button

Given Enter All the Details With PSN Date and State and click on Exprot Button
Then User should be able to see all the correct details on NY Exported Files

Examples:
fit2//Sanity_StateExport_CallInFull_IVR_Non_Esign_API_Hire_Combo_MN.table