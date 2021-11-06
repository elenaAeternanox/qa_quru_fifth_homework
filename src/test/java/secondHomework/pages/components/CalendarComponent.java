package secondHomework.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement dateInput = $("#dateOfBirthInput");

    public void setDate(String day, String month, String year) {
        dateInput.click();
        $(byClassName("react-datepicker__year-select")).selectOption(year);
        $(byClassName("react-datepicker__month-select")).selectOption(month);
        $(byText(day)).click();
    }

}
