package com.levina.tests;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class IssueLambdaStepTest {

    private final static String REPOSITORY = "selenide";
    private final static String ISSUE_NAME = "Issues";

    @Test
    void CheckingForAnIssueInARepository() {

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("ищем репозиторий " + REPOSITORY, () -> {
            $("[name=q]").setValue(REPOSITORY).pressEnter();
        });
        step("Открываем первый репозиторий в списке", () -> {
            $$("ul.repo-list li").first().$("a").click();
        });
        step("Проверяем что в репозиторие присутствует название " + ISSUE_NAME, () -> {
            $("#issues-tab").shouldBe(visible).shouldHave(text(ISSUE_NAME));
        });

    }
}
