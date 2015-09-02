     
Feature: Instructor reviews previous takes of Simple Assessment, Inline Assessment and SAA activity
  
  As a Instructor,
  When I login into Mindtap course
  and launch already attempted Simple Assessment, Inline Assessment and SAA activity
  then I should be able to verify the recorded score on Assessment Actvity Information page
  and Review the attempted activity
  As a Instructor,
  
  @InstLaunchesProgressApp  @InstProgressApp @SmokeGulati @SmokeAndersen @test1 @Best @Last @sa
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor

  @InstLaunchesProgressApp  @InstProgressApp @SmokeGulati @SmokeAndersen @test1 @Best @Last @sa
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window

      @InstLaunchesProgressApp  @InstProgressApp @SmokeGulati @SmokeAndersen @test1 
  Scenario: Instructor launches the Progress App
    When I click on progress app icon from App dock At Instructor End
    Then "Overview", "Analytics", "Gradebook" and "Mastery Report" tabs are displayed on progress app
    And Gradebook tab is active by default
    And I click on progress app icon from App dock At Instructor End

  @InstReviewsDistinctSaInProgressApp @SmokeAndersen @SmokeGulati 
  Scenario: Instructor review the previous take of a Simple Assessment distinct activity.
    Given I should be on Instructor's progress app
    When I click on "Overview" tab
    When I click on Simple Assessment activity link at instructor end
    Then correct score for the current attempt is displayed for Distinct Simple Assessment activity at instructor end
    Then I click on score
    And View button is displayed
    When I click on view button
    Then Attempted Simple Assessment activity is displayed
    When I click close icon

   @InstReviewsPreviousTakeDistinctSAA @SmokeGulati @y @sa
   Scenario: Instructor review the previous take of a SAA distinct activity.
    Given I should be on Instructor's progress app
    When I click on "Overview" tab
    When I click on distinct SAA activity link at instructor end
    Then correct score for the current attempt is displayed for distinct SAA activity at instructor end
    And I close progress App

@CriticalSuite @SmokeAndersen @y
 Scenario: I want to Grade manuall gradable activity from progress app
 	Given I am on instructor's LPN page
 	 When I click on progress app icon from App dock At Instructor End
 	 Then I navigate to page and grades activity
 	 
 	  	  	
 @StudentLoginAgain @SmokeAndersen 
 Scenario: I want to login successfully as a student on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as student
    When I provide student username and password and hit login button
    Then I should be able to login successfully as a student
    
    
@StudentLaunchesCourse @SmokeAndersen 
Scenario: I want to launch course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I open the course and click launch
    Then I am on Student's LPN page
 
 @StudentVerifyManualGradingScore @SmokeAndersen  @test1 
 Scenario: Validate score of manually graded activity on LPN
	Given I should be on Student's LPN page
	Then correct score for manually graded activity should be displayed on LPN
    And I click on close activity
    Then I am on Student's LPN page
	
@StudVerifiesEdtiGradeDetailsPage @SmokeAndersen 
Scenario: Launch and verify Manual Grading Widget as student
	Given I should be on Student's LPN page
	When I click the already linked Manually Gradable video activity
	Then I am on Activity Information Page
	When I click On Review button
	Then I reach Manual Grading widget successfully
	And I click on close activity
    


    
 
    
