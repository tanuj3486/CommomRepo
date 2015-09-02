Feature: instructor access and preview various Assessment activities
  
  As an instructor/student,
  When I log in to MindTap course,
  I land on MindTap LPN for course, access Assessment, link it to LPN and Preview.

@AccessAssessmentSAA @SmokeGulati @smokeTest
Scenario: I want to access Assessment, create and link SAA activity to LPN
	Given I am on Select Assessment page
	And Creation type displayed as "SAA"
	When I select SAA as creation type
	And I publish first SAA activity
	And I save distinct SAA activity with default options
	Then I am on instructor's LPN page
	And verify created SAA activity should linked to LPN

	
@AccessAssessmentSA @SmokeGulati @SmokeAndersen @smokeTest
 Scenario: I want to access Assessment, create and link Simple Assessment to LPN
 	Given I am on instructor's LPN page
 	And I am on Select Assessment page
 	And Creation type display as "Simple Assessment" 
 	When I select Simple Assessment as creation type
	And I publish practice Simple Assessment activity
	And I save distinct Simple Assessment activity with default options
	Then I am on instructor's LPN page
	And verify created Simple Assessment activity should linked to LPN
	

@InstLaunchSimpleAssessment @LaunchSubmitSA @SmokeAndersen @SmokeGulati @smokeTest
 Scenario: Launch Simple Assessment distinct activity
 	Given I should be on instructor's LPN page
 	When I click the already linked Simple Assessment activity
 	When I am on Simple Assessment activity page
 	
 @InstSubmitSimpleAssessment @LaunchSubmitSA @SmokeAndersen @SmokeGulati @smokeTest
 Scenario: Submit Simple Assessment distinct activity
 Given I am on Simple Assessment activity page
 	When I launch Activity and answer one Question
 	And I click on Check My Work button
 	And I submit Simple Assessment activity
	Then I am on instructor's LPN page
	
@InstLaunchSAA @SmokeGulati @InstLaunchSubmitSAA @sa @smokeTest
 Scenario: Launch SAA distinct activity as instructor
 	Given I should be on instructor's LPN page
 	When I click the already linked SAA activity
 	Then I am on SAA distinct activity page
 	 
 @InstSubmitSAA @SmokeGulati @InstLaunchSubmitSAA @sa @smokeTest
 Scenario: Submit SAA distinct activity as instructor
 	Given I should be on SAA activity page
 	When I click on 'Start Activity' button on overview page
 	And I answer first question
 	And I submit SAA distinct activity
	Then I am on instructor's LPN page
	  
@LinkManualGradableActivity @SmokeAndersen 
 Scenario: I want to Link a Manual Gradable Activity on LPN
 	Given I am on Select Assessment page
 	When I select Simple Assessment as creation type
	And I publish manually gradable video activity
	And I save manually gradable activity with default options
	Then I am on instructor's LPN page
	And verify created manually gradable activity should be linked to LPN
	
	  
@InstPreviewManuallyGradableActivity @SmokeAndersen 
 Scenario: Preview Manually Gradable Video activity from LPN
 	Given I should be on instructor's LPN page
 	When I click the already linked Manually Gradable video activity
 	Then I am on Manually Gradable video activity page
 	When I provide response in video activity textbox and move to review and submit tab
 	Then I should see correct message for manual grading activity
 	And I submit Video Activity for grading
 	Then I am on instructor's LPN page
 	
