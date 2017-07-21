Given User log in for screening process
Given I Log in to Back Office with correct credential<UserName> <Password>
Given User Navigate to Mail In Screening Page
Given User perform Mail-In screening test
Then The Search <ExpectedSSN> should be displayed in the result

Examples:
fit2//Sanity_MailIn_Search_Edit_MassSend_Status_TG_Notes_Indivitual_State_Export.table
