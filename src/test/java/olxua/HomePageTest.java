package olxua;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class HomePageTest {

    private final String userEmail = "uthertester@gmail.com";
    private final String userPassword = "kad@-$fl+1-%LN";
    private final SelenideElement acceptCookiesButton = $("[class='btn-accept']");

    @BeforeMethod
    private void start(){
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 4;
        Selenide.open("https://www.olx.ua/");
    }

    @Test
    public void checkCookieBlock(){
        $("#cookiesBar").shouldBe(Condition.visible);
        $("[class*='cookie-close']").click();
    }

    @Test
    public void checkUserLogin(){
        $("#topLoginLink").click();
        $("#userEmail").setValue(userEmail);
        $("#userPass").setValue(userPassword);
        $("#se_userLogin").click();

    }
}
