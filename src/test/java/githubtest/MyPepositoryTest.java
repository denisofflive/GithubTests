package githubtest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MyPepositoryTest {

    @Test
    void shouldFindRepositoryTest() {

        Configuration.browserSize = "1920x1080";
        // Открыть страницу https://github.com
        open("https://github.com");

        // Ввести в поле поиска denisofflive и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("denisofflive").pressEnter();

        // Нажимаем на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();

        //Проверить в заголовке denisofflive / denisofflive
        $("h2").shouldHave(text("denisofflive / denisofflive"));

        sleep(2000);
    }
}
