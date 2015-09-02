Feature: Take ESC activity as a Student

As a Student,
When I login into Mindtap course
I can Take - Launch and submit ESC activity, both pre-built and instructor designed
    
@StudLaunchESC  @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Student Launches ESC activity
Given I should be on Student's LPN page
When I click the already linked ESC activity
Then I am on Exam Study Center page

@StuVerifyESC  @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Student verifies Mastery Report and chapter content
Given I should be on Exam Study Center page
When I click Mastery Report link
Then Chapter configured from instructor is displayed
And Relevant chapter content is displayed

@StuVerifyESC  @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Verify that student is able to submit answers and receives feedback in Unit Study Center.
Given I should be on Exam Study Center page
When Student submit answers 
Then Student is able to receive feedback

@StuClosesESC @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Student is able to close ESC activity
Given I should be on Exam Study Center page
When I click close icon
Then I am on Student's LPN page

@StudLaunchPrebuiltESC  @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Student Launches and takes pre-built ESC activity
Given I should be on Student's LPN page
When I click on pre built ESC on LPN
Then I am on Exam Study Center page
When I click Mastery Report link
Then Chapter configured from instructor is displayed
And Relevant chapter content is displayed
When I click close icon
Then I am on Student's LPN page

@StudLaunchPrebuiltESC  @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Verify that student is able to take Unit Study Center
Given I should be on Student's LPN page
When I navigate to a chapter from LPN
Then Unit Exam Center link should be present
When I click on USC link
Then I am on Unit Study Center page
Then Next button is displayed and is clickable

@StuVerifyESC  @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Verify that student is able see Mastery Report LOs associated with chapter while taking Unit Study Center.
Given I should be on Unit Study Center page
When I click Mastery Report link
Then Learning objetives associated with chapter available on Mastery Report

@StuVerifyESC  @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Verify that student is able to submit answers and receives feedback in Unit Study Center.
Given I should be on Unit Study Center page
When Student submit answers 
Then Student is able to receive feedback

@StuClosesESC @SkipIE @SmokeAndersen @SmokeGulati @CriticalSuite @we
Scenario: Verify Student is able to close Unit Study Center
Given I should be on Exam Study Center page
When I click close icon
Then I am on Student's LPN page

  



 	 