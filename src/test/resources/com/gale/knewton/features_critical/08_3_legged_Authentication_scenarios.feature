Feature: Login/Logout to SSO, Create, Enroll and Launch course
  
  As an instructor,
  When I am using valid username and password on Login screen,
  I should be able to login successfully on SSO dashboard and logout successfully
  and able to Create, Enroll and Launch course

  @CriticalSuite
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor


  @CriticalSuite
  Scenario: I want to create a new course
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click Create Course hyperlink and navigate to create course page
    And I select Create a new course option and click on Continue
    Then I should be navigated to Course Details page and enter course details
    And click Create Course button
    Then course should be created
    And we save the course info and navigate to dashboard

   @CriticalSuite
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window
  
   @CriticalSuite
  Scenario: knewton instructor is able to see loading screen processing please wait on launching the New Course for old user
    Then I should be able to see loading screen processing,please wait
    When I click on Enter button on splash screen
    Then I click on disable dashborad
    And I logout from the Instructor
 
  @CriticalSuite
 Scenario: I want to login as a student and launch a course 
   Given I am on the Cengage Learning Login Page to login as student
   When I provide student username and password and hit login button
   Then I should be able to login successfully as a student
   Given I am on the Cengage Learning student's sso dashboard
  
 @CriticalSuite
 Scenario: I want to enroll into a course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I enter Course Key and click Register
    And confirm the course on Confirm Course Information page
    Then I should be able to see the Course on dashboard under My Courses & Materials

  @CriticalSuite
  Scenario: I want to launch course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I open the course and click launch   
    
  @CriticalSuite
  Scenario: knewton Student is able to see loading screen processing please wait on launching the New Course for old user
    Then I should be able to see loading screen processing,please wait
    When I click on Enter button on splash screen
    Then I click on disable dashborad
    Then I am on Student's LPN page
    When I logout from the Student
  
   @CriticalSuite
  Scenario: I want to login as an instructor on providing valid credentials 
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor

 @CriticalSuite
  Scenario: I want to launch the course from instructor's dashboard and verify old instructor is not able to see processing window and authentication screen for old course
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I should not be able to see loading screen processing,please wait
    And I should not be able to see 3Legged authentication screen
    Then I am on the MindTap window
    And I logout from the Instructor

 @CriticalSuite
 Scenario: I want to login as a student and launch a course 
   Given I am on the Cengage Learning Login Page to login as student
   When I provide student username and password and hit login button
   Then I should be able to login successfully as a student
   Given I am on the Cengage Learning student's sso dashboard
   
  @CriticalSuite
  Scenario: I want to launch course from Student's dashboard and verify old student is not able to see processing window and authentication screen for old course
    Given I am on the Cengage Learning student's sso dashboard
    When I open the course and click launch   
    Then I should not be able to see loading screen processing,please wait
    And I should not be able to see 3Legged authentication screen
    Then I am on the MindTap window
    And I logout from the Student
  
  