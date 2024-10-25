import org.junit.jupiter.api.Test;

public class TextBoxTests extends BaseTest {

    String userName = "John Smith";
    String userEmail = "johnsmith@gmail.com";
    String currentAddress = "123 asd zxc";
    String permanentAddress = "456 iop bnm";

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress);

        textBoxPage.submitUserForm();

        textBoxPage.verifyUserName(userName)
                .verifyEmail(userEmail)
                .verifyCurrentAddress(currentAddress)
                .verifyPermanentAddress(permanentAddress);
    }
}