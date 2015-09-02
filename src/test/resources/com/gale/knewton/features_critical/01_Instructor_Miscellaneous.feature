Feature: Miscellaneous - Login/Logout to SSO, Create, Enroll and Launch course,
Also, create, hide, unhide and delete folders and Unit
  
  As an instructor,
  When I am using valid username and password on Login screen,
  I should be able to login successfully on SSO dashboard successfully
  and able to Create, Enroll and Launch course
  and able to create, hide, unhide and delete unit and folder on LPN

  @LoginInstructor @CriticalSuite 
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor

  @CreateCourse @test4 @CriticalSuite 
  Scenario: I want to create a new course
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click Create Course hyperlink and navigate to create course page
    And I select Create a new course option and click on Continue
    Then I should be navigated to Course Details page and enter course details
    And click Create Course button
    Then course should be created
    And we save the course info and navigate to dashboard

  @LaunchCourse @CriticalSuite @test4 
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window

  @AcceptEulaIfAppears @test4 @CriticalSuite 
  Scenario: I want to accept EULA page for the newly created course
    Given I am on the MindTap window
    Then I am on instructor's LPN page
 
@CreateUnit @CriticalSuite 
 Scenario: I want to create a Unit on LPN
    Given I am on instructor's LPN page
    When I add a Unit from Add activity option
    Then I should see the created Unit on LPN
    
 @CreateFolder @CriticalSuite 
  Scenario: I want to create a Folder on LPN
    Given I am on instructor's LPN page
    When I add a Folder from Add activity option
    Then I should see the created Folder on LPN
    
 @HideUnhideUnit @CriticalSuite 
 Scenario: I want to hide/unhide Unit from LPN
    Given I should see the created Unit on LPN
    When I hover on the Unit
    And I click hide activity link
    Then Unit should get hidden on LPN
    When I hover on the Unit
    And I click show activity link for unit
    Then hidden unit gets visible again
    
 @DeleteUnit @CriticalSuite 
 Scenario: I want to delete Unit from LPN
    Given I should see the created Unit on LPN
    When I hover on the Unit
    And I click delete activity link
    Then Unit should get deleted from LPN

    
 @HideUnhideFolder @CriticalSuite 
 Scenario: I want to hide/unhide Folder from LPN
    Given I should see the created Folder on LPN
    When I hover on the Folder
    And I click hide activity link
    Then Folder should get hidden on LPN
    When I hover on the Folder
    And I click show activity link for folder
    Then hidden folder gets visible again
    
  @DeleteFolder @CriticalSuite 
 Scenario: I want to delete Folder from LPN
    Given I should see the created Folder on LPN
    When I hover on the Folder
    And I click delete activity link
    Then Folder should get deleted from LPN
  

  @LogoutInstructor
  Scenario: I want to logout successfully @wan
    Given I am on the Cengage Learning Home Page of Instructor
    When I click the Sign out button on Instructor DashBoard Page
    Then I should be able to logout successfully as an Instructor
