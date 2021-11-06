package secondHomework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static secondHomework.tests.TestData.*;

public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("Check Practice form on the 'https://demoqa.com/automation-practice-form' page")
    void fillFormTest() {
        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(email)
                .chooseGenderCheckbox(gender)
                .typeMobile(phoneNumber)
                .setBirthdayDate(birthdayDay, birthdayMonth, birthdayYear)
                .selectPicture(pictureFileSource + fileName)
                .typeCurrentAddress(currentAddress)
                .selectState(statePrefix, state)
                .selectCity(cityPrefix, city);

        String listOfSubjects = registrationPage.setSubjects(subjectsNumber),
                listOfHobbies = registrationPage.setHobbies(hobbiesNumber);

        registrationPage
                .clickSubmitButton()
                .checkResultsFormIsDisplayed();

        registrationPage
                .checkResultsValue(rowStudentName, firstName + ' ' + lastName)
                .checkResultsValue(rowStudentEmail, email)
                .checkResultsValue(rowGender, gender)
                .checkResultsValue(rowMobile, phoneNumber)
                .checkResultsValue(rowDateOfBirth, birthdayDay + " " + birthdayMonth + "," + birthdayYear)
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
