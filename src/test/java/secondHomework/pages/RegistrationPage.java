package secondHomework.pages;

import com.codeborne.selenide.SelenideElement;
import secondHomework.pages.components.CalendarComponent;
import secondHomework.pages.components.HobbieComponent;
import secondHomework.pages.components.SubjectComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static secondHomework.tests.TestData.*;

public class RegistrationPage {

    // locators & elements
    private final static String WELCOME_MESSAGE = "Thanks for submitting the form";
    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderRadioButton = $("#genterWrapper"),
            mobileInput = $("#userNumber"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            statePrefixInput = $("#react-select-3-input"),
            cityPrefixInput = $("#react-select-4-input"),
            submitButton = $("#submit"),
            resultsForm = $("#modal-dialog"),
            resultsFormTitle = $("#example-modal-sizes-title-lg"),
            resultsTable = $(".table-responsive"),
            closeButton = $("#closeLargeModal");

    public CalendarComponent calendar = new CalendarComponent();
    public SubjectComponent subjects = new SubjectComponent();
    public HobbieComponent hobbie = new HobbieComponent();

    // actions
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage chooseGenderCheckbox(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public RegistrationPage typeMobile(String value) {
        mobileInput.setValue(value);
        return this;
    }

    public RegistrationPage selectPicture(String pictureFile) {
        pictureUpload.uploadFile(new File(pictureFile));
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage selectState(String prefixOfState, String stateName) {
        statePrefixInput.setValue(prefixOfState);
        $(byText(stateName)).click();
        return this;
    }

    public RegistrationPage selectCity(String prefixOfCity, String cityName) {
        cityPrefixInput.setValue(prefixOfCity);
        $(byText(cityName)).click();
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultsFormIsDisplayed() {
        resultsForm.isDisplayed();
        resultsFormTitle.shouldHave(text(WELCOME_MESSAGE));
        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage clickCloseButton() {
        closeButton.click();
        return this;
    }

    public RegistrationPage checkResultsFormIsClosed() {
        resultsForm.shouldNotBe(visible);
        formTitle.isDisplayed();
        return this;
    }
}
