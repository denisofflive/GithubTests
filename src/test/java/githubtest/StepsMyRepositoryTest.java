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
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("Денисов Денис")
@DisplayName("Поиск и проверка репозитория Denisofflive по шагам")

public class StepsMyRepositoryTest {

    @Test
    public void testLambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        Configuration.browserSize = "1920x1080";

        step("Открыть страницу github", () -> {
            open("https://github.com");
        });
        step("Ввести в поле поиска denisofflive и нажать Enter", () -> {
            $("[data-test-selector=nav-search-input]").setValue("denisofflive").pressEnter();
        });
        step("Нажимаем на линк от первого результата поиска", () -> {
            $$("ul.repo-list li").first().$("a").click();
        });
        step("Проверить в заголовке denisofflive / denisofflive", () -> {
            $("h2").shouldHave(text("denisofflive / denisofflive"));
        });


        Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");

        sleep(1000);

    }


}
