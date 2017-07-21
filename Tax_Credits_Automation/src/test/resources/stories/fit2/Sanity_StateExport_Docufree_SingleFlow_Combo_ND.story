Given User log in for screening process
When Perform Docufree screening for eligible record
Given Hire through rest API
Given I Log in to Back Office with correct credential<UserName> <Password>
When Verify the Record in hub search page
Then edit Status of Screening Record to Status
Then Edit Employment Unit for Specific User On Edit Details Page

Given User Navigate To the PSN Update Generate DOL and COM Page
When User Search <SSNNumber> in PSN Update Genrate DOL and COM and Click on Count Button
Given Enter All the Details With PSN Date and State and click on Export Button

Then User should be able to see all the correct details on ND Exported Files

Examples:
fit2//Sanity_StateExport_Docufree_SingleFlow_Combo_ND.table
