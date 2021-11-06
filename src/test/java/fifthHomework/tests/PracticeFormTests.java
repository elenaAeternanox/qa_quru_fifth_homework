package fifthHomework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fifthHomework.tests.TestData.*;
import static java.lang.Thread.sleep;

public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("Check Practice form on the 'https://demoqa.com/automation-practice-form' page")
    void fillFormTest() throws InterruptedException {
        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(email)
                .chooseGenderCheckbox(gender)
                .typeMobile(phoneNumber)
                .selectPicture(pictureFileSource + fileName)
                .typeCurrentAddress(currentAddress)
                .selectState(statePrefix, state)
                .selectCity(cityPrefix, city);

        String
                birthdayCheck = registrationPage.setBirthdayDate(birthdayDayMonthYear),
                listOfSubjects = registrationPage.setSubjects(subjectsNumber),
                listOfHobbies = registrationPage.setHobbies(hobbiesNumber);

        registrationPage
                .clickSubmitButton()
                .checkResultsFormIsDisplayed();

        registrationPage
                .checkResultsValue(rowStudentName, firstName + ' ' + lastName)
                .checkResultsValue(rowStudentEmail, email)
                .checkResultsValue(rowGender, gender)
                .checkResultsValue(rowMobile, phoneNumber)
                .checkResultsValue(rowDateOfBirth, birthdayCheck)
                .checkResultsValue(rowSubjects, listOfSubjects)
                .checkResultsValue(rowHobbies, listOfHobbies)
                .checkResultsValue(rowPicture, fileName)
                .checkResultsValue(rowAddress, currentAddress)
                .checkResultsValue(rowStateAndCity, state + " " + city);

        registrationPage
                .clickCloseButton()
                .checkResultsFormIsClosed();
    }
}
