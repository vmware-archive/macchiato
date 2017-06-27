package io.pivotal.macchiato.pages;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

public abstract class Page {

    private final Matcher<View> assertion;

    public Page(Matcher<View> assertion) {
        this.assertion = assertion;
    }

    void doAssertion() {
        onView(assertion).check(matches(isDisplayed()));
    }

    public static <T extends Page> T assertOnPage(T page) {
        page.doAssertion();
        return page;
    }
}
