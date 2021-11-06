package fifthHomework.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static fifthHomework.tests.TestData.*;
import static fifthHomework.tests.TestData.secondSubject;

public class SubjectComponent {

    private SelenideElement subjectSelector = $("#subjectsInput");

    public String setSubjects(int subjectNumber) {
        String subjectsList = "";
        switch (subjectNumber) {
            case 1:
                subjectSelector.setValue(firstSubjectPrefix);
                $(byText(firstSubject)).click();
                subjectsList = firstSubject;
                break;
            case 2:
                subjectSelector.setValue(firstSubjectPrefix);
                $(byText(firstSubject)).click();
                subjectSelector.setValue(secondSubjectPrefix);
                $(byText(secondSubject)).click();
                subjectsList = firstSubject + ", " + secondSubject;
                break;
        }
        return subjectsList;
    }
}
