### ITC_SampleCode

**Test Scenario:** ```Complete the registration process of monsterindia.com Job Portal.``` \
**Test Steps:** \
```•	Fill Personal Details including name, email, password, current location, mobile number, upload resume.``` \
```•	Fill Education Details including qualification, specialization, institute, education type, passing year, skills.```
```•	Fill Preferences including upload photo, location, industry, function, role, job type, employment type etc.``` 

It’s a maven project with positive test case in the Java class ```TypicalUseCases``` 

The locators for Web elements are stored in the following Java classes
```PageRegistrationEducationDetails```
```PageRegistrationPersonalDetails```
```PageRegistrationPreferences``` 

Test Data like random email, name, Mobile number etc. can be obtained from the following classes
```Enums```
```RandomData```. Test data can also be obtained or modified from the following classes
```EducationDetailsValues```
```PersonalDetailsValues```
```PreferencesValues```. Currently, they have getter methods as we have only positive test case.

The class ```Registration``` contains the implementation of test scenario.

Test Environment: Windows (may be required as there are file uploads)

