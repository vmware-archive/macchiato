package io.pivotal.macchiato;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static org.hamcrest.Matchers.not;

public class Helpers {

    // Assertions

    public static void assertHasText(String text) {
        onView(withText(text)).check(matches(isDisplayed()));
    }

    public static void assertDoesNotHaveText(String text) {
        onView(withText(text)).check(matches(not(isDisplayed())));
    }

    // Actions

    public static void clickOn(int id) {
        onView(withId(id)).perform(click());
    }

    public static void clickOn(String text) {
        onView(withText(text)).perform(click());
    }

    public static void fillField(String hint, String value) throws InterruptedException {
        onView(withHint(hint)).perform(typeText(value), closeSoftKeyboard());
    }
}
