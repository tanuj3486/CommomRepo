 Feature: Login/Logout to SSO as student, Enroll and Launch course
  
  As a student, @CriticalSuite
  When I am using valid username and password on Login screen,
  I should be able to login successfully on SSO dashboard and logout successfully
  and also be able to Enroll and Launch courses from the dashboard


  @LoginStudent @test1 @SmokeAndersen @SmokeGulati @CriticalSuite @we
  Scenario: I want to login successfully as a student on providing valid credentials
    Given I am on the Cengage Learning Login Page to login as student
    When I provide student username and password and hit login button
    Then I should be able to login successfully as a student
 

  @LaunchCourseAsStudent @CriticalSuite @we @LoginEnrollAndAcceptEula @SmokeAndersen @SmokeGulati 
  Scenario: I want to launch course successfully
    Given I am on the Cengage Learning student's sso dashboard
    When I open the course and click launch
    Then I am on Student's LPN page
 
      
  @test4 @CriticalSuite 
  Scenario: Launch Simple Assessment distinct activity as student
	Given I should be on Student's LPN page
	When I click the already linked Simple Assessment activity
	Then I am on Simple Assessment activity page
	
  @test4 @CriticalSuite 
  Scenario: Close and Resume Simple Assessment distinct activity as student
	Given I should be on Simple Assessment activity page
	When I launch Activity and answer one Question
	And I click on Check My Work button
	And I close the activity without submitting it
	Then I am on Student's LPN page
	When I click the already linked Simple Assessment activity
	Then I am on Simple Assessment Activity page where I left
	

 @test4 @CriticalSuite 
 Scenario: Complete Simple Assessment distinct activity as student
 	Given I am on Simple Assessment Activity page where I left
 	And I submit Simple Assessment activity
	Then I am on Student's LPN page
	And LPN score is displayed on Simple Assessment activity link

@CriticalSuite @we
 Scenario: Student review the previous take of Simple Assessment distinct activity
	Given I should be on Student's LPN page
	And Attempted Simple Assessment activity is present on LPN
	When I click on attempted Simple Assessment activity for review
	Then I am on Assessment Activity Information page
	And Recorded Score is displayed same as score on LPN's Simple Assessment activity link
	And Review button is displayed
	When I click on Review button
	Then Attempted Simple Assessment activity is displayed
	When I click close icon
	
	
	@CriticalSuite @we
Scenario: Student re-take the previously taken Simple Assessment distinct activity
	Given I should be on Student's LPN page
	And Attempted Simple Assessment activity is present on LPN
	When I click on attempted Simple Assessment activity for review
	Then I am on Assessment Activity Information page
	When I click Start button on Assessment Information page
	Then I am on Simple Assessment activity page
	When I launch Activity and answer one Question
	And I click on Check My Work button
	And I submit Simple Assessment activity
	Then I am on Student's LPN page
	And LPN score is displayed on Simple Assessment activity link

	@CriticalSuite @StuLaunchSubmitSAA @we
 Scenario: Launch SAA distinct activity as Student
	Given I should be on Student's LPN page
	When I click the already linked SAA activity
	Then I am on SAA distinct activity page

 @CriticalSuite @we
 Scenario: Close and Resume SAA distinct activity as student
	Given I am on SAA distinct activity page
	When I click on 'Start Activity' button on overview page
	And I answer first question
	And I close the activity without submitting it
	Then I am on Student's LPN page
	When I click the already linked SAA activity
	Then I am on Simple Assessment Activity page where I left

 @CriticalSuite @we
 Scenario: Complete SAA activity as Student
 	Given I am on Simple Assessment Activity page where I left
 	And I submit SAA distinct activity
	Then I am on Student's LPN page
	And LPN score is displayed on SAA activity link

@CriticalSuite @we
 Scenario: Student not allowed to Re-Take distinct SAA activity
 	Given I am on Student's LPN page
 	Then verify that student is not able to re-take SAA activity
 	
 @CriticalSuite @we
 Scenario: Student review the previous take of SAA activity
	Given I should be on Student's LPN page
	And Attempted SAA activity is present on LPN
	When I click on attempted SAA activity
	Then I am on Assessment Activity Information page
	And Recorded Score is displayed same as score on LPN's SAA activity link
	And Review button is displayed
	When I click on Review button
	Then Attempted SAA activity is displayed 
	
@CriticalSuite @we
 Scenario: Student launches inline Simple Assessment distinct activity
 	Given I should be on Student's LPN page
 	And I Navigate to the First Ebook Document
 	When I click start for the linked inline Simple Assessment activity
 	Then I am on inline Simple Assessment activity page
 	
 @CriticalSuite @we
 Scenario: Student Resumes inline Simple Assessment Activity
 	Given I should be on inline Simple Assessment activity page
 	When I click Start Activity and submit answer for a Question
 	And I click Check My Work button
 	Then Feedback section and Try Another button is displayed
 	And I close the inline Simple Assessment activity without submitting it
 	Then I am on Ebook Document Page and continue button appears for activity
 	When I click continue for the linked inline Simple Assessment activity
 	Then I am on Inline Simple Assessment Activity page where I left
 	
 @CriticalSuite @we
 Scenario: Student submits inline Simple Assessment distinct activity
 	Given I am on Inline Simple Assessment Activity page where I left
 	And I submit inline Simple Assessment activity
	Then I am on Ebook Document Page
	And LPN score is displayed on Inline Simple Assessment activity link
	
	
	@CriticalSuite @we
 Scenario: Student is able to re-take a Simple Assessment inline activity if Max attempt is allowed
 	Given I should be on Student's LPN page
 	And I Navigate to the First Ebook Document
 	When I click takeAgain for the linked inline Simple Assessment activity
 	Then I am on inline Simple Assessment activity page
 	And I submit inline Simple Assessment activity
	Then I am on Ebook Document Page
	When I click close icon
	
	

        
 
 