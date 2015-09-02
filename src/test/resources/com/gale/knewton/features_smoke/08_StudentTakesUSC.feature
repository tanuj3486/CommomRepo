Feature: Take USC activity as a Student

As a Student,
When I login into Mindtap course
I can Take - Launch and submit USC activity
    
@StuTakesUSC  @SkipIE @SmokeAndersen @SmokeGulati @LoginStudent
Scenario: Student Launches USC activity
	Given I should be on chapter LPN
	When I click on USC link
	Then I am on Unit Study Center page

@StuTakesUSC @SkipIE @SmokeAndersen @SmokeGulati @LoginStudent
Scenario: Student verifies Mastery Report link, chapter content and Next button
	Given I should be on Unit Study Center page
	Then Mastery Report link is available
	And Chapter content is displayed with relevant chapter title
	And Next button is displayed and is clickable
 
@StuTakesUSC @SkipIE @SmokeAndersen @SmokeGulati @LoginStudent
Scenario: Student is able to close USC activity
	Given I should be on Unit Study Center page
	When I click close icon
	Then I am on chapter LPN

	

  



 	 