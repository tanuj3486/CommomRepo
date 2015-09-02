Feature: Instructor Verifies the Lesson center configuration page  Functionality

As an instructor,
  When I am using valid username and password on Login screen,
  I should be able to login successfully on SSO dashboard and logout successfully
  and able to Create, Enroll and Launch course
  
  @LCconfig @SmokeLc @q
  Scenario: I want to login as an instructor on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as instructor
    When I provide instructor username and password and hit login button
    Then I should be able to login successfully as an instructor
    
     @LCconfig @SmokeLc
  Scenario: I want to create a new course and verify that instructor is able to create a new course for the title in which lesson center app is provisioned.
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click Create Course hyperlink and navigate to create course page
    And I select Create a new course option and click on Continue
    Then I should be navigated to Course Details page and enter course details
    And click Create Course button
    Then course should be created
    And we save the course info and navigate to dashboard

  @LCconfig @SmokeLc @q
  Scenario: I want to launch the course from instructor's dashboard
    Given I am on the Cengage Learning instructor's sso dashboard
    When I click newly created course
    Then I am on the MindTap window 
    
  @LCconfig @SmokeLc @q
  Scenario: I want to accept EULA page for the newly created course
    Given I am on the MindTap window
    When verify presence of Eula and accept EULA if present
    Then I am on Lesson center instructor LPN page
  
  @LCconfig @SmokeLc
  Scenario: I want to select Lesson center from add activity page and redirected to Lesson center config page
      Given I should be on Lesson center instructor LPN page
      And I am on Add Activity page
      And Verify ‘Lesson Center page' LOGO  on Add activity page
      When I select Lesson Center from Activity List
      Then I am on Lesson Center Config Page
      
  @LCconfig
  Scenario:Verify that instructor is able see ‘Select Lesson Settings’, ‘Select Learning Objectives’ options on accessing the ‘Lesson center configuration’ page.
      Given I should be on Lesson Center configuration page
      And I Verify text and headings on Lesson Center Page
    
   @LCconfig
  Scenario: Verify that instructor is able to see ‘please fill this field ‘message on clicking continue button if name is not entered
   Given I should be on Lesson Center configuration page
   When I verify that lesson center name cannot be empty
   Then I see validation message on hovering mouse over continue button
   
  @LCconfig @SmokeLc
  Scenario: Verify that instructor is able to enter Lesson center Name, Description and Due Date 
   Given I should be on Lesson Center configuration page
   When I fill all necessary feilds on LC config page
   Then I am able to see Continue button as Disabled
   
   @LCconfig @SmokeLc
  Scenario: I want to Verify that instructor is able to see ‘Please enter a valid due date.’ message on clicking continue button if due date is not entered.
   Given I should be on Lesson Center configuration page
   Then I see validation message on hovering mouse over continue button
   When instructor click on due date feild
   Then I am able to see calender widget
   And I am not able to enter Past Due Dates
   When instructor click on due date feild
   Then I select valid date from calender
  
    @LCconfig @SmokeLc
  Scenario: I Verify that instructor is able to enter ‘Target Mastery Score’ for lesson center
   Given I should be on Lesson Center configuration page
   When I Verify validation message on entering wrong Target score 
   Then I verify that ‘Target Mastery Score’ is in the range of 0-100
   And I enter target mastery score for lesson center
   And I am able to increment and decrement the score using the arrow

@LCconfig
  Scenario: Verify that instructor is able to see all learning objectives under 'Select Learning Objectives'
  Given I should be on Lesson Center configuration page
  Then I am able to see all learning Objectives
  And I am able to see more learning objectives by clicking forward button
  When I click on 20page size, I see maximum 20 learning objective
  Then I see validation message on hovering mouse over continue button

@LCconfig
  Scenario: Instructor is able to expand and collapse the chapters
  Given I should be on Lesson Center configuration page
  When I expand the chapters and select a checkbox against a chapter name
  Then I am able to see all the learning objective of a chapter as selected
  And I am able to see 'Include Assessment' after Selecting a Learning Objective
  When I See disabled feilds under Include assessment
  Then On clicking Checkbox under assessment feilds become enabled
  And I am able to see message while hovering mouse over feilds

   
   @LCconfig @SmokeLc
  Scenario:Verify that instructor is able to link the lesson center on LPN including prerequisite and instructional material.
   Given I should be on Lesson Center configuration page
   And I Include Prerequisite and instruction material and Assessments
   

@LCconfig @SmokeLc
  Scenario: i verify continue button availability and  click it 
   When I am able to see Continue button as Enabled if all mandatory feilds are entered 
   When I click continue button on LC config page
   Then I am on Mindtap activity page 
   
   @LCconfig @SmokeLc
  Scenario:Verify that instructor is able to see Name, description and due date in no editable mode on MindTap activity page.
   When I verify instructor is able to see Name, description and due date in no editable mode on MindTap activity page
   Then I save Lesson center with default options
   Then I am on Lesson center instructor LPN page
   
   @LCconfig @SmokeLc
  Scenario: I want to verify that Lesson center activity is displayed at Instructor LPN.
  Given I should be on Lesson center instructor LPN page
  And Linked Lesson Center is displayed at LPN page

  @LCconfig
  Scenario: I want to Verify that instructor is able to see "The Knewton Adaptive Application experienced an error.
   Given I should be on Lesson center instructor LPN page
   When I select previously linked lesson center activity present On LPN
   Then I am able to see Knewton Adaptive Application Error
   When I click close icon
   
   @LCconfig 
  Scenario: I want to select Lesson center from add activity page and redirected to Lesson center config page
      Given I should be on Lesson center instructor LPN page
      And I am on Add Activity page
      When I select Lesson Center from Activity List
      Then I am on Lesson Center Config Page
      
  @LCconfig
  Scenario: Verify that instructor is able to link the lesson center on LPN without selecting prerequisite.  
    Given I should be on Lesson Center configuration page
    When I fill all necessary feilds on LC config page
    When instructor click on due date feild
    Then I select valid date from calender
    When I not included Assessment while linking Lesson Center
    When I click continue button on LC config page
    Then I am on Mindtap activity page 
    Then I save Lesson center with default options
    Then I am on Lesson center instructor LPN page
    And Linked Lesson Center is displayed at LPN page

 @LCconfig
  Scenario: I want to select Lesson center from add activity page and redirected to Lesson center config page
      Given I should be on Lesson center instructor LPN page
      And I am on Add Activity page
      When I select Lesson Center from Activity List
      Then I am on Lesson Center Config Page
      
  @LCconfig
  Scenario: Verify that instructor is able to link the lesson center on LPN without selecting instructional material  
    Given I should be on Lesson Center configuration page
    When I fill all necessary feilds on LC config page
    When instructor click on due date feild
    Then I select valid date from calender
    When I not included Instruction material while linking Lesson Center
    When I click continue button on LC config page
    Then I am on Mindtap activity page 
    Then I save Lesson center with default options
    Then I am on Lesson center instructor LPN page
    And Linked Lesson Center is displayed at LPN page

@LCconfig
  Scenario: I want to select Lesson center from add activity page and redirected to Lesson center config page
      Given I should be on Lesson center instructor LPN page
      And I am on Add Activity page
      When I select Lesson Center from Activity List
      Then I am on Lesson Center Config Page
      
  @LCconfig
  Scenario: Verify that instructor is able to link the lesson center on LPN without Including Assessment 
    Given I should be on Lesson Center configuration page
    When I fill all necessary feilds on LC config page
    When instructor click on due date feild
    Then I select valid date from calender
    When I not included prerequisite while linking Lesson Center
    When I click continue button on LC config page
    Then I am on Mindtap activity page 
    Then I save Lesson center with default options
    Then I am on Lesson center instructor LPN page
    And Linked Lesson Center is displayed at LPN page


   