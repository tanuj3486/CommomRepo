Feature: Access Unit Study Center and verify error message as Instructor
  
  As an instructor,
  When I log in to MindTap course,
  I should be able to access Unit Study Center of any one chapter from LPN and verify error message.
  
   @r
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor

  @r 
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window

  @r @SmokeGulati @smokeTest
  Scenario: I want to accept EULA page for the newly created course
    Given I am on the MindTap window
    Then I am on instructor's LPN page

   @InstAccessLaunchUSC @SmokeAndersen @SmokeGulati @SkipIE @r @smokeTest
   Scenario: Access Unit Study Center on LPN as Instructor
     Given I should be on instructor's LPN page
     When I navigate to a chapter from LPN
     Then Unit Exam Center link should be present
     
 @InstAccessLaunchUSC @SkipIE @SmokeAndersen @SmokeGulati @r @smokeTest
  Scenario Outline: Launch USC as Instructor and verify error message
     Given Unit Exam Center link should be present
     When I click on USC link
     Then I should be navigated to USC page and error message displayed as <error>
     
    Examples:
 	|error|
 	|Instructors don’t have access to Student View of the Study Center at the Unit and Exam level. To edit the Exam Study Center for students, click on the pencil and then choose “Edit Options". Please contact your local learning consultant for more information.|