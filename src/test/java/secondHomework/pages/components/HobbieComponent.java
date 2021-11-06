package secondHomework.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static secondHomework.tests.TestData.*;
import static secondHomework.tests.TestData.hobbieMusic;

public class HobbieComponent {

    private SelenideElement hobbieCheckBox = $("#hobbiesWrapper");

    public String setHobbies(int hobbiesNumber) {
        String hobbiesList = "";
        switch (hobbiesNumber) {
            case 1:
                hobbieCheckBox.$(byText(hobbieGenerated)).click();
                hobbiesList = hobbieGenerated;
                break;
            case 2:
                hobbieCheckBox.$(byText(hobbieSport)).click();
                hobbieCheckBox.$(byText(hobbieRead)).click();
                hobbiesList = hobbieSport + ", " + hobbieRead;
                break;
            case 3:
                hobbieCheckBox.$(byText(hobbieSport)).click();
                hobbieCheckBox.$(byText(hobbieRead)).click();
                hobbieCheckBox.$(byText(hobbieMusic)).click();
                hobbiesList = hobbieSport + ", " + hobbieRead + ", " + hobbieMusic;
        }
        return hobbiesList;
    }
}
