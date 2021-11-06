package fifthHomework.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static fifthHomework.tests.TestData.*;
import static fifthHomework.tests.TestData.hobbyMusic;

public class HobbyComponent {

    private SelenideElement hobbyCheckBox = $("#hobbiesWrapper");

    public String setHobbies(int hobbiesNumber) {
        String hobbiesList = "";
        switch (hobbiesNumber) {
            case 1:
                hobbyCheckBox.$(byText(hobbyGenerated)).click();
                hobbiesList = hobbyGenerated;
                break;
            case 2:
                hobbyCheckBox.$(byText(hobbySport)).click();
                hobbyCheckBox.$(byText(hobbyRead)).click();
                hobbiesList = hobbySport + ", " + hobbyRead;
                break;
            case 3:
                hobbyCheckBox.$(byText(hobbySport)).click();
                hobbyCheckBox.$(byText(hobbyRead)).click();
                hobbyCheckBox.$(byText(hobbyMusic)).click();
                hobbiesList = hobbySport + ", " + hobbyRead + ", " + hobbyMusic;
        }
        return hobbiesList;
    }
}
