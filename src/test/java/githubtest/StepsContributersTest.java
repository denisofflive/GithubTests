package githubtest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Денисов Денис")
@DisplayName("Наведение мышкой на Contributors и проверка текста Andrei Solntsev")

public class StepsContributersTest {

    @Test
    public void testLambdaContributorsSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = "1920x1080";

        step("Открыть репозиторий селенида", () -> {
            open("https://github.com/selenide/selenide");
        });
        step("Навести мышкой на аватар Сontributors", () -> {
            $(".Layout-sidebar").$(byText("Contributors")).ancestor("div")
                    .$("ul li").hover();
        });
        step("Провека текста Andrei Solntsev", () -> {
            $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        });


        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");

        sleep(2000);

    }
}
