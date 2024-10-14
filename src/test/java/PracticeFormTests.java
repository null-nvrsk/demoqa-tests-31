import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";
        Configuration.browserSize = "1280x720";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successRegistrationTest() {
        String firstName = "John";
        String lastName = "Smith";
        String userEmail = "johnsmith@gmail.com";
        String userGender = "Male";
        String userNumber = "8001234567";
        String userBirthYear = "1985";
        String userBirthMonth = "August";
        String userBirthDay = "30";

        String subject1 = "Maths";
        String subject2 = "Biology";
        String subject3 = "Computer Science";

        String hobby1 = "Reading";
        String hobby2 = "Music";

        String pictureFileName = "avatar.png";

        String currentAddress = "1195 Borregas Drive";
        String state = "Uttar Pradesh";
        String city = "Lucknow";

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper h5").shouldHave(text("Student Registration Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText(userGender)).click();

        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(userBirthYear);
        $(".react-datepicker__month-select").selectOption(userBirthMonth);

        $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(userBirthDay)).click();

        $("#subjectsInput").setValue(subject1).pressTab(); // Maths
        $("#subjectsInput").setValue(subject2).pressTab(); // Biology
        $("#subjectsInput").setValue(subject3).pressTab(); // Computer Science
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();

        $("#uploadPicture").uploadFromClasspath(pictureFileName);

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("button#submit").click();

        $(".modal-content").should(appear);
        $(".modal-content .h4").shouldHave(text("Thanks for submitting the form"));

        SelenideElement tableModal = $(".modal-body .table-responsive");
        tableModal.shouldHave(text(firstName), text(lastName));
        tableModal.shouldHave(text(userEmail));
        tableModal.shouldHave(text(userGender));
        tableModal.shouldHave(text(userNumber));
        tableModal.shouldHave(text(userBirthDay), text(userBirthMonth), text(userBirthYear));
        tableModal.shouldHave(text(subject1), text(subject2), text(subject3));
        tableModal.shouldHave(text(hobby1), text(hobby2));
        tableModal.shouldHave(text(pictureFileName));
        tableModal.shouldHave(text(currentAddress), text(state), text(city));
    }
}
