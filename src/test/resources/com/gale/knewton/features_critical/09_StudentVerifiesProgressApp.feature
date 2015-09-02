Feature: Student launches the progress app, verifies score, reviews previous takes and view mastery report.

As a Student,
When I login into Mindtap course
I can launch the progress app,
Verify the scores of attempted activities,
Review the previous takes of attempted activities,
and can view mastery report of ESC/USC
    
@StuLaunchesProgressApp  @StuProgressApp @SmokeGulati @SmokeAndersen @x
Scenario: Student launches the Progress App
Given I should be on Student's LPN page
When I click on progress app icon from App dock
Then "My Grades" and "Mastery Report" tabs are displayed
And My Grades tab is active by default

@StuVerifiesSAinProgressApp @StuProgressApp @SmokeGulati @SmokeAndersen 
Scenario: Student verifies the score of attempted Simple Assessment activity in progress app
Given I should be on Student's progress app
And Correct score is displayed for attempted Distinct Simple Assessment activity

@StuVerifiesInlineSAinProgressApp @StuProgressApp @SmokeGulati @SmokeAndersen 
Scenario: Student verifies the score of attempted Inline Simple Assessment activity in progress app
Given I should be on Student's progress app
And Correct score is displayed for attempted Inline Simple Assessment activity
 
@StuVerifiesSAAinProgressApp @SmokeGulati 
Scenario: Student verifies the score of attempted SAA activity in progress app
Given I should be on Student's progress app
And Correct score is displayed for attempted SAA activity

@StuReviewsDistinctSaInProgressApp  @StuProgressApp @SmokeGulati @SmokeAndersen 
Scenario: Student review the previous take of a Simple Assessment distinct activity.
Given I should be on Student's progress app
When I click on Simple Assessment activity link
Then correct score for the current attempt is displayed for Distinct Simple Assessment activity
And View button is displayed
When I click on view button
Then Attempted Simple Assessment activity is displayed
When I click close icon

@StuReviewsInlineSaInProgressApp  @StuProgressApp @SmokeGulati @SmokeAndersen @x
Scenario: Student review the previous take of a inline Simple Assessment distinct activity.
Given I should be on Student's progress app
When I click on inline Simple Assessment activity link
Then correct score for the current attempt is displayed for inline Simple Assessment activity
And View button is displayed
When I click on view button
Then Attempted Inline Simple Assessment activity is displayed

@StuReviewsSaaInProgressApp @StuProgressApp @SmokeGulati 
Scenario: Student review the previous take of a SAA distinct activity.
Given I should be on Student's progress app
When I click on SAA activity link
Then correct score for the current attempt is displayed for SAA activity
And View button is displayed
When I click on view button
Then Attempted SAA activity is displayed

@StuViewsEscMasteryReport @StuProgressApp @SmokeGulati @SmokeAndersen 
Scenario: Student view the mastery report for ESC.
Given I should be on Student's progress app
And Mastery Report tab is displayed
When I click on Mastery Report tab
Then Configured ESC chapter is displayed with two stars rating
When I click on chapter link
Then Learning Objectives for the selected chapter are displayed

@StuViewsUscMasteryReport @StuProgressApp @SmokeGulati @SmokeAndersen 
Scenario: Student view the mastery report for USC.
Given I should be on Student's progress app
And Mastery Report tab is displayed
When I click on Mastery Report tab
Then USC chapter is displayed with two stars rating
When I click on USC chapter link
Then Learning Objectives for the selected USC chapter are displayed
 When I logout from the Student