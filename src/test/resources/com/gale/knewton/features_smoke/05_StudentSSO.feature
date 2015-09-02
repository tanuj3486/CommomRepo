Feature: Login/Logout to SSO as student, Enroll and Launch course
  
  As a student,
  When I am using valid username and password on Login screen,
  I should be able to login successfully on SSO dashboard and logout successfully
  and also be able to Enroll and Launch courses from the dashboard

  @LoginStudent @test1 @SmokeAndersen @SmokeGulati @StudentLoginAndLaunchCourse @StudLaunchPrebuiltESC @smokeTest
  Scenario: I want to login successfully as a student on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as student
    When I provide student username and password and hit login button
    Then I should be able to login successfully as a student
    
 @EnrollCourse @LoginEnrollAndAcceptEula @SmokeAndersen @SmokeGulati @r @sa @LoginStudent @smokeTest
  Scenario: I want to enroll into a course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I enter Course Key and click Register
    And confirm the course on Confirm Course Information page
    Then I should be able to see the Course on dashboard under My Courses & Materials
    
  @LaunchCourseAsStudent @test1 @StudentLoginAndLaunchCourse @smokeTest @LoginEnrollAndAcceptEula @SmokeAndersen @SmokeGulati @te @StudLaunchPrebuiltESC
  Scenario: I want to launch course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I open the course and click launch
    And verify presence of Eula and accept EULA if present
    Then I am on Student's LPN page

  @LogoutStudent
  Scenario: I want to logout successfully as a student 
    Given I am on the Cengage Learning Home Page of Student
    When I click the Log out link on Student DashBoard Page
    Then I should be able to logout successfully as a student
