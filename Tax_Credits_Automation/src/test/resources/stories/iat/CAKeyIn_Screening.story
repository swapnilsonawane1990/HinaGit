Given User Log in to Back Office with correct credential<UserName> <Password>
When I Go To Search <SSNNumber> Page, Enter the <SSNNumber> and click on Search Button
Given User log in for screening process
When User Perform CAKeyIn screening for eligible record
Then Screening should be completed successfully

Examples:
iat//CAKeyIn_Screening.table