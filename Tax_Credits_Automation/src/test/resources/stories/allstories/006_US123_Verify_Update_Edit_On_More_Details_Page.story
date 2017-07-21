Meta:

Narrative:
As a user
I want to perform edit on More Details Page
So that I more details fields are updated with edited value

Scenario: Verify Update on Records Status Field on More details Page

Given I Logged in and Advanced Search Page is displayed
When I Search by selecting Valid Status on Hub Search
And Open the record and update status on more details Page
Then I Should see the updated status for the record on edit page

Examples:
data//fit2//006_US123_Verify_Update_on_Records_Status_Field_on_More_details_Page.table

Scenario: Verify Update on Records PSN Date and Resubmit Field on More details Page

Given I Logged in and Advanced Search Page is displayed
When I Search by selecting Valid Status on Hub Search
And Open the record and update PSN Date on more details Page
Then I Should see the updated PSN Date for the record on More Details Page

Examples:
data//fit2//006_US123_Verify_Update_on_Records_PSN_Date_ReSubmit_Field_on_More_details_Page.table

Scenario: Verify Update on Records State Date ivnalid Date verification and Appeal sent Date Field on More details Page

Given I Logged in and Advanced Search Page is displayed
When I Search by selecting Valid Status on Hub Search
And Open the record and update State Date ivnalid Date verification and Appeal sent Date on more details Page
Then I Should see the updated State Invalid  Date verification Appeal for the record on More Details Page

Examples:
data//fit2//006_US123_Verify_Update_on_Records_State_invalidation_Appeal_Date_ReSubmit_Field_on_More_details_Page.table

Scenario: Verify Update on Need Letter Report Date Field on More details Page

Given I Logged in and Advanced Search Page is displayed
When I Search by selecting Valid Status on Hub Search
And Open the record and update Need Letter Received Date
Then I Should see the updated Need Letter Received Date with Updated Value

Examples:
data//fit2//006_US123_Verify_Update_on_Records_Need_Letter_Report_Field_on_More_details_Page.table

Scenario: Verify Update on Need Letter Report Date Field on More details Page

Given I Logged in and Advanced Search Page is displayed
When I Search by selecting Valid Status on Hub Search
And Open the record and change the Target Group on more details Page
Then I Should see the updated Target Group on the main page

Examples:
data//test//006_US123_Verify_Update_on_Target_Group_Field_on_More_details_Page.table