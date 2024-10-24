import org.junit.jupiter.api.Test;

public class RegistrationTests extends BaseTest {

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

        String subject = "Maths";
        String hobby = "Reading";

        String pictureFileName = "avatar.png";

        String currentAddress = "1195 Borregas Drive";
        String state = "Uttar Pradesh";
        String city = "Lucknow";

        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userNumber)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(pictureFileName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city);

        registrationPage.submitRegistrationForm();

        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", pictureFileName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}
