Feature: Instructor perform Progress app Best and Last features.

  @LoginAsInstructor @LoginAndersen @SmokeAndersen @SmokeGulati @3leg @CriticalSuite
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor

  @LaunchCourse @LogincreateLaunch @LoginLaunch @SmokeAndersen @SmokeGulati @3leg @CriticalSuite
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window
    
  @InstLaunchesProgressApp  @InstProgressApp @SmokeGulati @SmokeAndersen @CriticalSuite
  Scenario: Instructor launches the Progress App
    Given I should be on instructor's LPN page
    And Click Add activity button on instructor LPN
    
 @Best @CriticalSuite
 Scenario: Instructor Creates Best simple assessment activity
    Given I am on Select Assessment page
    When I select Simple Assessment as creation type
    When I select radio for product in Simple Assessment activity
    Then I choose Best simple assessment and click publish
    And I logout from the Instructor

@Last 
     Scenario: Instructor Creates Best simple assessment activity
    Given I am on Select Assessment page
    When I select Simple Assessment as creation type
    When I select radio for product in Simple Assessment activity
    Then I choose Best simple assessment and click publish
    And I logout from the Instructor
  
 @Best @Last @CriticalSuite
 Scenario: I want to login as a student and launch a course 
   Given I am on the Cengage Learning Login Page to login as student
   When I provide student username and password and hit login button
   Then I should be able to login successfully as a student
   Given I am on the Cengage Learning student's sso dashboard
   When I open the course and click launch
    
 @Best @CriticalSuite
 Scenario: Launch Simple Assessment Best activity as student
 Given I should be on Student's LPN page
 When I click the already linked Simple Assessment activity
 Then I am on Assessment Activity Information page
 When I click on Start button on Activity Page
 Then I am on Simple Assessment activity page
 
  @Last
 Scenario: Launch Simple Assessment Best activity as student
 Given I should be on Student's LPN page
 When I click the already linked Last Simple Assessment activity
 Then I am on Simple Assessment activity page
 
 @Best @Last @CriticalSuite
 Scenario: Scenario: Take Simple Assessment activity as student
 Given I should be on Simple Assessment activity page
 When I launch Activity and answer one Question
 And I submit Simple Assessment activity
 And I save the LPN score for this Take
 
 @Best @Last @CriticalSuite
 Scenario: Take Simple Assessment activity Second Time as student and verify the Best score
 Given I should be on Student's LPN page
 When I click the already linked Simple Assessment activity
 Then I launch the simple assessment activity
 When I launch Activity and answer one Question
 Then I submit the activity and click on I am done
 And I save the LPN score for this Take

@Best @CriticalSuite
Scenario:Instructor verify the Best score
 Then verify for the Best score
 When I logout from the Student
 
 @Last
 Scenario:Instructor verify the Last score
 Then verify for the Last score
 When I click the Log out link on Student DashBoard Page
 Then I should be able to logout successfully as a student

 @Best @Last @CriticalSuite
 Scenario:I want to login as a Instructor to review the simple assessment
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor
    
 @Best @Last @CriticalSuite
  Scenario: I want to launch the course to be reviwed from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window
    
 @Best @CriticalSuite
 Scenario: Instructor launches the Progress App to review the Best Score
    Given I should be on instructor's LPN page
    When I click on progress app icon from App dock At Instructor End
    Then I click on Student name shown on the progress app
    When I click on Quiz name for review
    Then Instructor Review the student score for Best case
    
 @Last
 Scenario: Instructor launches the Progress App to review the Best Score
    Given I should be on instructor's LPN page
    When I click on progress app icon from App dock At Instructor End
    Then I click on Student name shown on the progress app
    When I click on Quiz name for review
    Then Instructor Review the student score for Last case
     
