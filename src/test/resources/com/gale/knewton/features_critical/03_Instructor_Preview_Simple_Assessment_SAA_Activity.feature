Feature: Instructor previews various type of activities


  @LoginInstructor @CriticalSuite @test4 
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor

  @LaunchCourse @CriticalSuite @test4 
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window

  @AcceptEulaIfAppears @test4 @CriticalSuite 
  Scenario: I want to accept EULA page for the newly created course
    Given I am on the MindTap window
    Then I am on instructor's LPN page
 
@InstPreviewSimpleAssessment @CriticalSuite @test3 
 Scenario: Preview Simple Assessment distinct activity and verify no score is generated on LPN and progress App
 	Given I should be on instructor's LPN page
 	When I click the already linked Simple Assessment activity
 	Then I am on Simple Assessment activity page
 	When I launch Activity and answer one Question
 	And I click on Check My Work button
 	And I submit Simple Assessment activity
	Then I am on instructor's LPN page
	And score is not generated on LPN after instructor preview for distinct Simple Assessment
	When I click on progress app icon from App dock At Instructor End
	And score is not generated on progress app after instructor preview
	And I close progress App
    And I click on home icon
	
@InstPreviewSAA @CriticalSuite @test3 
 Scenario: Preview SAA distinct activity as instructor and verify no score is generated on LPN and progress App
 	Given I should be on instructor's LPN page
 	When I click the already linked SAA activity
 	Then I am on SAA distinct activity page
 	When I click on 'Start Activity' button on overview page
 	And I answer first question
 	And I submit SAA distinct activity
	Then I am on instructor's LPN page	
	And score is not generated on LPN after instructor preview for distinct SAA
	When I click on progress app icon from App dock At Instructor End
	And score is not generated on progress app after instructor preview
	And I close progress App
    And I click on home icon

	
 @InsPreviewInlineSA @CriticalSuite @test3 
 Scenario:  Preview Simple Assessment inline activity and verify no score is generated on LPN and progress App
 	Given I should be on instructor's LPN page
 	And I Navigate to the First Ebook Document
 	When I click start for the linked inline Simple Assessment activity
 	Then I am on inline Simple Assessment activity page
 	When I click Start Activity and submit answer for a Question
 	And I click Check My Work button
 	Then Feedback section and Try Another button is displayed
 	And I submit inline Simple Assessment activity
    And score is not generated on Ebook doc after instructor preview for inline Simple Assessment
	Then I am on Ebook Document Page
	When I click on progress app icon from App dock At Instructor End
	And score is not generated on progress app after instructor preview
	And I close progress App

 @InsPreviewInlineSA @CriticalSuite @test3 
 Scenario:  Go to Add Activity Page
Given I am on instructor's LPN page
 	And Click Add activity button on instructor LPN
