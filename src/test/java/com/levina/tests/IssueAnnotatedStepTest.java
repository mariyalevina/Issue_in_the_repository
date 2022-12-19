package com.levina.tests;


import org.junit.jupiter.api.Test;


public class IssueAnnotatedStepTest {

    private final static String REPOSITORY = "selenide";
    private final static String ISSUE_NAME = "Issues";

    @Test
    void CheckingForAnIssueInARepository() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openFirstRepository();
        steps.nameIssuesIsPresent(ISSUE_NAME);
    }
}
