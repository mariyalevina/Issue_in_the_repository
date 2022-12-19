package com.levina.tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class IssueSelenideTest {

    @Test
    void CheckingForAnIssueInARepository() {

        open("https://github.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#issues-tab").shouldBe(visible).shouldHave(text("Issues"));
    }
}
