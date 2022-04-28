package githubtest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContributorsTest {

  @Test
  void solntsevShouldBeFirstContributor(){

    Configuration.browserSize = "1920x1080";

    // open repository page
    open("https://github.com/selenide/selenide");

    // bring mouse over the first avatar on contributors tab
    $(".Layout-sidebar").$(byText("Contributors")).ancestor("div")
            .$("ul li").hover();

    // check: popup is showing Andres Solntsev
    $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

    sleep(2000);

  }


}
