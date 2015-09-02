Feature: Student takes Assessment - Simple Assessment, SAA

As a Student
When I Login as Student
I should be able to launch and Submit Assessment activity from LPN


@StudLaunchSAdistinct @StuLaunchSubmitDistnct @SmokeGulati @SmokeAndersen @te @LoginStudent
Scenario: Launch Simple Assessment distinct activity as student
	Given I should be on Student's LPN page
	When I click the already linked Simple Assessment activity
	Then I am on Simple Assessment activity page
	
@StuResumeDistictSA_Activity @SmokeAndersen @SmokeGulati @r @LoginStudent @smokeTest
Scenario: Resume Simple Assessment distinct activity as student
	Given I should be on Simple Assessment activity page
	When I launch Activity and answer one Question
	And I click on Check My Work button
	And I close the activity without submitting it
	Then I am on Student's LPN page
	When I click the already linked Simple Assessment activity
	Then I am on Simple Assessment Activity page where I left
	

@StudSubmitSADistinct @StuLaunchSubmitDistnct @SmokeGulati @SmokeAndersen @r @LoginStudent @smokeTest
Scenario: Submit Simple Assessment distinct activity as student
 	Given I am on Simple Assessment Activity page where I left
 	And I submit Simple Assessment activity
	Then I am on Student's LPN page
	And LPN score is displayed on Simple Assessment activity link
		
@StudLaunchSAA @SmokeGulati @StuLaunchSubmitSAA @sa @LoginStudent @smokeTest
Scenario: Launch SAA distinct activity as Student
	Given I should be on Student's LPN page
	When I click the already linked SAA activity
	Then I am on SAA distinct activity page
	
@StuResumeSAA @SmokeGulati @sa @LoginStudent @smokeTest
Scenario: Resume SAA distinct activity as student
	Given I am on SAA distinct activity page
	When I click on 'Start Activity' button on overview page
	And I answer first question
	And I close the activity without submitting it
	Then I am on Student's LPN page
	When I click the already linked SAA activity
	Then I am on Simple Assessment Activity page where I left

@StudSubmitSAA @SmokeGulati @StuLaunchSubmitSAA @sa @LoginStudent @smokeTest
Scenario: Submit SAA activity as Student
 	Given I am on Simple Assessment Activity page where I left
 	And I submit SAA distinct activity
	Then I am on Student's LPN page
	And LPN score is displayed on SAA activity link
	
@StudTakeManuallyGradableActivity  @SmokeAndersen @test1 @r 
Scenario: Launch and Take Manually Gradable Video activity as student
	Given I should be on Student's LPN page
	When I click the already linked Manually Gradable video activity
	Then I am on Manually Gradable video activity page
	When I provide response in video activity textbox and move to review and submit tab
	Then I should see correct message for manual grading activity
 	And I submit Video Activity for grading
 	Then I should be on Student's LPN page
 	
@StudCheckPendingScoreForManualGradableAct @SmokeAndersen @test1 @r
Scenario: Check the score for Manually Gradable Activity
    Given I should be on Student's LPN page
 	Then I see score as Pending on LPN for manually graded activity on LPN
 	
