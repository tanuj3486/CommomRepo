Feature: Students reviews previous takes of Simple Assessment, Inline Assessment and SAA activity

As a Student,
When I login into Mindtap course
and launch already attempted Simple Assessment, Inline Assessment and SAA activity
then I should be able to verify the recorded score on Assessment Actvity Information page
and Review the attempted activity

@StuReviewsSA @StuReviewActivity @SmokeAndersen @SmokeGulati @LoginStudent
Scenario: Student review the previous take of Simple Assessment distinct activity
	Given I should be on Student's LPN page
	And Attempted Simple Assessment activity is present on LPN
	When I click on attempted Simple Assessment activity for review
	Then I am on Assessment Activity Information page
	And Recorded Score is displayed same as score on LPN's Simple Assessment activity link
	And Review button is displayed
	When I click on Review button
	Then Attempted Simple Assessment activity is displayed
	When I click close icon
	
@StuReviewsSAA  @SmokeGulati @sa @LoginStudent
Scenario: Student review the previous take of SAA activity
	Given I should be on Student's LPN page
	And Attempted SAA activity is present on LPN
	When I click on attempted SAA activity
	Then I am on Assessment Activity Information page
	And Recorded Score is displayed same as score on LPN's SAA activity link
	And Review button is displayed
	When I click on Review button
	Then Attempted SAA activity is displayed 
     When I logout from the Student
 
	
	 