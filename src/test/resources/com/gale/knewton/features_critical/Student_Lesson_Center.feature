Feature: Student Verifies the Lesson center Functionality

  @LCconfig @w @SmokeLc @Assessment 
  Scenario: I want to login successfully as a student on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as student
    When I provide student username and password and hit login button
    Then I should be able to login successfully as a student
    
  @LCconfig @SmokeLc 
  Scenario: I want to enroll into a course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I enter Course Key and click Register
    And confirm the course on Confirm Course Information page
    Then I should be able to see the Course on dashboard under My Courses & Materials
    
   @Assessment @LCconfig 
  Scenario: I want to launch course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I open the course and click launch
    And verify presence of Eula and accept EULA if present
    Then I am on Student's LPN page
 
    
    @LCconfig @w @Assessment 
Scenario: Verify Instructor is able to Edit Lesson Details
  Given I should be on Lesson center instructor LPN page
  When I select previously linked lesson center activity present On LPN
  Then I attempt mastery Questions on LC activity
  When I click close icon
  
   @Assessment
    Scenario: i verify mastery achieved message and Assessment Enabled 
   Given I should be on Student's LPN page
   When I select previously linked lesson center activity present On LPN
   And i see "Assessment Unlocked!" message on top of the header on achieving the mastery
   Then I launch Assessment and Answer One Question
   And I click CheckMyWork button
   Then i am able to take ASSESSMENT questions
   When I click close icon
       
       
    @LCconfig @w @SmokeLc 
Scenario: i verify Assessment tab operations
Given I should be on Student's LPN page
When i verify assessment tab is not availaible on lesson center if it is not included
Then i am able to take that lesson center

   

       
     @LCconfig @w
  Scenario: I see Lesson Center activities present on Student LPN and verify MAstery tab and Assessment availability
  Given I should be on Student's LPN page
  When I select previously linked lesson center activity present On LPN
  Then i see Mastery tab as enabled and Assessment tab as disabled
  And i see "Assessment will be available when you achieve Mastery or on DATE, TIME" message just right to disable ASSESSEMT tab
  
 
  @LCconfig 
  Scenario Outline: I see Lesson Center activities present on Student LPN
  Given I should be on Student's LPN page
  When i open on other LC activities and Verify student is not able to take future LCs and error message displayed as <error>
  Examples:
  |error|
  |This Lesson Center is currently gated/unavailable. It will become available once you achieve Mastery on the pre required Lesson Center(s) or when their due date is reached. Please contact your Instructor for more details.|
 

 @LCconfig
Scenario: Verify Instructor is able to Edit Lesson Details
Given I should be on Lesson center instructor LPN page
When I navigate to edit options from Instructor LPN page
Then I verify Lesson center Name,Description,Due Date and Target Mastrey are editable
And I saved the changes
   
