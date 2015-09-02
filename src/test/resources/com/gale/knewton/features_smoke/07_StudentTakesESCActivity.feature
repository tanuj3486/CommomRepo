Feature: Take ESC activity as a Student

As a Student,
When I login into Mindtap course

I can Take - Launch and submit ESC activity, both pre-built and instructor designed
    
@StudLaunchESC  @SkipIE @SmokeAndersen @SmokeGulati  @LoginStudent
Scenario: Student Launches ESC activity
Given I should be on Student's LPN page
When I click the already linked ESC activity
Then I am on Exam Study Center page

@StuVerifyESC  @SkipIE @SmokeAndersen @SmokeGulati  @LoginStudent
Scenario: Student verifies Mastery Report and chapter content
Given I should be on Exam Study Center page
When I click Mastery Report link
Then Chapter configured from instructor is displayed
And Relevant chapter content is displayed

@StuClosesESC @SkipIE @SmokeAndersen @SmokeGulati  @LoginStudent
Scenario: Student is able to close ESC activity
Given I should be on Exam Study Center page
When I click close icon
Then I am on Student's LPN page

  



 	 