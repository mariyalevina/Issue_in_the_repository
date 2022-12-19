package com.levina.tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {REPOSITORY}")
    public void searchForRepository(String REPOSITORY) {
        $("[name=q]").setValue(REPOSITORY).pressEnter();
    }

    @Step("Открываем первый репозиторий в списке")
    public void openFirstRepository() {
        $$("ul.repo-list li").first().$("a").click();
    }

    @Step("Проверяем что в репозиторие присутствует название {ISSUE_NAME}")
    public void nameIssuesIsPresent(String ISSUE_NAME) {
        $("#issues-tab").shouldBe(visible).shouldHave(text(ISSUE_NAME));
    }
}
