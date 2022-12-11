package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSoftAssertions {

    @BeforeAll
    static void setup() {

        Configuration.baseUrl = "https://github.com";
    }
    @Test
    void SearchSoftAssertionsInWiki() {

        Configuration.headless = false;
        open("/selenide/selenide");
        //Открыть раздел Wiki
        $("#wiki-tab").click();
        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions и открыть ее
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        //Проверить, что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class")).shouldBe(visible);
    }
}
