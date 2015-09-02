  Feature: Instructor launches the progress app, verifies score, reviews previous takes and view mastery report.
  
    When I login into Mindtap course
  I can launch the progress app,
  Verify the scores of attempted activities,
  Review the previous takes of attempted activities,
  and can view mastery report of ESC/USC
  
    @InstLaunchesProgressApp  @InstProgressApp  @SmokeAndersen @test1 @Best @Last 
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor

  @InstLaunchesProgressApp  @InstProgressApp @SmokeAndersen @test1 @Best @Last 
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

  @InstViewMasteryReportForESC @InstProgressApp @SmokeGulati @SmokeAndersen 
  Scenario: Instructor view mastery report for ESC
    Given I should be on Instructor's progress app
    And "Mastery Report" tab is displayed
    When I click on "Mastery Report" tab
    Then Configured ESC chapter is displayed with two stars rating
    When I click on chapter link
    Then Learning Objectives for the selected chapter are displayed

  @InstViewsUscMasteryReport  @InstProgressApp @SmokeGulati @SmokeAndersen 
  Scenario: Instructor view the mastery report for USC.
    Given I should be on Instructor's progress app
    And "Mastery Report" tab is displayed
    When I click on "Mastery Report" tab
    Then USC chapter is displayed with two stars rating
    When I click on USC chapter link
    Then Learning Objectives for the selected USC chapter are displayed

  @InstViewSAAinProgressApp @InstProgressApp @SmokeGulati 
  Scenario: Instructor view the score of attempted SAA activity in progress app
    Given I should be on Instructor's progress app
    When I click on "Overview" tab
    Then Correct score is displayed for attempted SAA activity at instructor end
    
    
    