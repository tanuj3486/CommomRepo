Feature: Instructor perform actions on configuration page of both Exam Study Center and Unit Study Center, verify its linking on LPN 

  As an instructor
  When I log in to MindTap course,
  I should be able to perform on configuration page of both Exam Study Center and Unit Study Center and verify its linking on LPN.
  
    
   @AccessESCandLinkToLPN @SmokeAndersen  @SkipIE @CriticalSuite 
 Scenario: Access Exam Study Center Configurations page
	 Given I am on Add Activity List
	 When I click Exam Study Center from Activities list
	 Then I am on Exam Study Center configuration page
	 
	@CriticalSuite 
  Scenario Outline: Verify the components on Exam Study Center configuration panel
	  Given I am on Exam Study Center configuration page
	  Then <component> is displayed on ESC config page
	  
	  Examples:
	  |component|
	  |Exam Target Due Date|
	  |Exam Target Score|
	  |Included Chapters|
	  |Save|
	  
  @CriticalSuite 
  Scenario: Access Exam Study Center Configurations page  
  Given I am on Exam Study Center configuration page
  Then Default Exam Target Due Date is displayed as mm/dd/yyyy 
  And default Exam target score is displayed  

   @CriticalSuite 
   Scenario: Verify Chapter checkboxes are un selected
   Given I am on Exam Study Center configuration page
   Then I see all chapters are unselected on Exam Study Center Configuration page 
   
   @CriticalSuite 
   Scenario: Verify select checkbox action
   Given  I am on Exam Study Center configuration page
   Then I see all chapters are unselected
   When I click on select all checkbox 
   Then I see all chapters should get selected 
   When I click on select all checkbox
   
   @CriticalSuite 
   Scenario: Access Exam Study Center Configurations page
   Given I am on Exam Study Center configuration page
   And I save ESC activity after completing required details on Config page and following MindTap Description page
   Then created ESC should be linked to LPN
   
   @CriticalSuite 
   Scenario: Edit the Exam Study Center title using Edit Options button 
   Given I am on instructor's LPN page
   When I hover on already linked ESC activity  
   And I click on edit options button
   And I edit title of ESC and save it
   Then created ESC should be linked to LPN 
   
    @CriticalSuite 
   Scenario Outline: Verify the components on pre built Exam Study Center configuration panel
    Given I am on instructor's LPN page
    When I hover and click on edit button pre built ESC
    And I click on edit options button
    And  I click on edit options button from edit panel
    Given I am on Exam Study Center configuration page
	Then <component> is displayed on ESC config page
	  
	  Examples:
	  |component|
	  |Exam Target Due Date|
	  |Exam Target Score|
	  |Included Chapters|
	  |Save|
	
	 @CriticalSuite 
	Scenario Outline: Launch ESC Activity as Instructor
 	Given I should be on instructor's LPN page
 	When I click the already linked ESC activity
 	Then I am on Exam Study Center page and error message displayed as <error> 
 	
 	Examples:
 	|error|
 	|Instructors don’t have access to Student View of the Study Center at the Unit and Exam level. To edit the Exam Study Center for students, click on the pencil and then choose “Edit Options". Please contact your local learning consultant for more information.|
 	
 
 	 @CriticalSuite 
   Scenario: Access Unit Study Center on LPN as Instructor
     Given I should be on instructor's LPN page
     When I navigate to a chapter from LPN
     Then Unit Exam Center link should be present
     
	  @CriticalSuite 
  	Scenario Outline: Launch USC as Instructor and verify error message
     Given Unit Exam Center link should be present
     When I click on USC link
     Then I should be navigated to USC page and error message displayed as <error>
     
    Examples:
 	|error|
 	|Instructors don’t have access to Student View of the Study Center at the Unit and Exam level. To edit the Exam Study Center for students, click on the pencil and then choose “Edit Options". Please contact your local learning consultant for more information.|
   
   