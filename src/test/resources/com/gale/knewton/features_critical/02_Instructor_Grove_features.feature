Feature: Grove - instructor access and preview various Assessment activities
  
  As an instructor/student,
  When I log in to MindTap course,
  I land on MindTap LPN for course, access Assessment, link it to LPN and Preview.

@CriticalSuite 
 Scenario: I want to access Assessment, create and link Simple Assessment to LPN
 	Given I am on instructor's LPN page
 	And I am on Select Assessment page

  @AccessAssessmentSA @CriticalSuite 
  Scenario: I want to view Simple Assessment Activity List on Selecting Simple Assessment creation type
	Given I am on Select Assessment page
	And Creation type display as "Simple Assessment"
 	Then verify if cancel button appears  
 	When I select Simple Assessment as creation type
 	Then I should see product title in creation type Panel
 	When I expand title panel
 	Then I should see Assessment Activity list

  @ViewOptionsWithActivtyList @CriticalSuite 
  Scenario: I want to see Used and Preview buttons against each Simple Assessment Activity
	Given I should see Assessment Activity list
	Then I should see preview button against each assignment activity
	And I should see used button against each assignment activity
	And I should see various assignment option groups
	When I click on Preview button for first Assessment
	Then verify the preview panel for assessment
	
  @AccessAssessmentSA @CriticalSuite @test3 
 Scenario: I want to access Assessment, create and link Simple Assessment to LPN
	And I publish practice Simple Assessment activity
	And I save distinct Simple Assessment activity with default options
	Then I am on instructor's LPN page
	And verify created Simple Assessment activity should linked to LPN
	
  @AccessinlineSAAndlinkToEBook @CriticalSuite @test3 
 Scenario: I want to access Inline Assessment and link as inline activity
 	Given I should be on instructor's LPN page
 	And I Navigate to the First Ebook Document
 	And I enter the Edit Mode to reach Add Activity Panel
	Then select Inline Assessment from the Activity list
	Then verify creation type display as "Simple Assessment"
	When I select Simple Assessment as creation type
	And I publish practice Simple Assessment activity
	And I save inline Simple Assessment activity with default options
	Then verify created Simple Assessment activity should linked to the Ebook Document	
	And I am on Select Assessment page
 

  @AccessAssessmentSAA @SmokeGulati @CriticalSuite
  Scenario: I want to access Assessment and verify that practice button appears unchecked on selecting an Activity
	Given I am on Select Assessment page
	And Creation type displayed as "SAA"
	When I select SAA as creation type
	And I Select an Assessment Test For SAA 
	Then verify unchecked Practice button option on selecting SAA  
	And I click on cancel button
	
	
	@AccessAssessmentSAA @CriticalSuite @test3
	Scenario: I want to access Assessment, create and link SAA activity to LPN
	Given I am on Select Assessment page
	And Creation type displayed as "SAA"
	When I select SAA as creation type
	And I publish first SAA activity
	And I save distinct SAA activity with default options
	Then I am on instructor's LPN page
	And verify created SAA activity should linked to LPN
	
	@AccessAssessmentSAA @CriticalSuite
	Scenario: I want to preview ‘SAA’ activity on clicking Preview button via ‘Assessment’ page
	Given I am on instructor's LPN page
	And  I am on Select Assessment page  
  	And Creation type displayed as "SAA"
	When I select SAA as creation type
	And I expand title panel
	Then I should see Assessment Activity list
	And I should see preview button against each assignment activity
    When I click on Preview button for SAA first Assessment
	Then verify the preview panel for SAA	
  
 @AccessinlineSAAndlinkToEBook @SmokeGulati @SmokeAndersen 
 Scenario: I want to access Inline Assessment and link as inline activity
 	Given I should be on instructor's LPN page
 	And I Navigate to the First Ebook Document
 	And I enter the Edit Mode to reach Add Activity Panel
	Then select Inline Assessment from the Activity list
	Then verify creation type display as "Simple Assessment"
	When I select Simple Assessment as creation type
	And I publish practice Simple Assessment activity
	And I save inline Simple Assessment activity with default options
	Then verify created Simple Assessment activity should linked to the Ebook Document
	

 	



	

	  
 