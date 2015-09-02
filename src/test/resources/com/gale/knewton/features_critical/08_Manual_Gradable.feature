Feature: Student reviews score on LPN for a manually graded activity once instructor has finished grading on manual grading widget
  
      @LoginAsInstructor @LoginAndersen @SmokeAndersen @SmokeGulati @3leg 
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor


  @CreateCourse @LogincreateLaunch @SmokeAndersen @SmokeGulati @3leg 
  Scenario: I want to create a new course
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click Create Course hyperlink and navigate to create course page
    And I select Create a new course option and click on Continue
    Then I should be navigated to Course Details page and enter course details
    And click Create Course button
    Then course should be created
    And we save the course info and navigate to dashboard

  @LaunchCourse @LogincreateLaunch @LoginLaunch @SmokeAndersen @SmokeGulati @3leg 
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window
    
     @AcceptEulaIfAppears @LogincreateLaunch @SmokeAndersen @SmokeGulati @3leg
  Scenario: I want to accept EULA page for the newly created course
    Given I am on the MindTap window
    When verify presence of Eula and accept EULA if present
    Then I am on instructor's LPN page
    
@CriticalSuite @SmokeAndersen 
 Scenario: I want to access Assessment, create and link Simple Assessment to LPN
 	Given I am on instructor's LPN page
 	And I am on Select Assessment page

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
 	
 @StudentLoginAgain @SmokeAndersen 
 Scenario: I want to login successfully as a student on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as student
    When I provide student username and password and hit login button
    Then I should be able to login successfully as a student
    
      @EnrollCourse @LoginEnrollAndAcceptEula @SmokeAndersen @SmokeGulati
  Scenario: I want to enroll into a course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I enter Course Key and click Register
    And confirm the course on Confirm Course Information page
    Then I should be able to see the Course on dashboard under My Courses & Materials

@StudentLaunchesCourse @SmokeAndersen 
 Scenario: I want to launch course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I open the course and click launch
     And verify presence of Eula and accept EULA if present
    Then I am on Student's LPN page
 
	
	@StudTakeManuallyGradableActivity  @SmokeAndersen 
Scenario: Launch and Take Manually Gradable Video activity as student
	Given I should be on Student's LPN page
	When I click the already linked Manually Gradable video activity
	Then I am on Manually Gradable video activity page
	When I provide response in video activity textbox and move to review and submit tab
	Then I should see correct message for manual grading activity
 	And I submit Video Activity for grading
 	Then I should be on Student's LPN page
 	
@StudCheckPendingScoreForManualGradableAct @SmokeAndersen 
Scenario: Check the score for Manually Gradable Activity
    Given I should be on Student's LPN page
 	Then I see score as Pending on LPN for manually graded activity on LPN
 	
 	
	
      @LoginAsInstructor @LoginAndersen @SmokeAndersen @SmokeGulati @3leg @y
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor
    
    
  @LaunchCourse @LogincreateLaunch @LoginLaunch @SmokeAndersen @SmokeGulati @3leg @y
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window
    
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
 
 @StudentVerifyManualGradingScore @SmokeAndersen  @test1 @SmokeGulati 
 Scenario: Validate score of manually graded activity on LPN
	Given I should be on Student's LPN page
	Then correct score for manually graded activity should be displayed on LPN
    And I click on close activity
	
@StudVerifiesEdtiGradeDetailsPage @SmokeAndersen 
Scenario: Launch and verify Manual Grading Widget as student
	Given I should be on Student's LPN page
	When I click the already linked Manually Gradable video activity
	Then I am on Activity Information Page
	When I click On Review button
	Then I reach Manual Grading widget successfully
	