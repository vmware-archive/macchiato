package io.pivotal.macchiato;

import android.support.test.espresso.ViewInteraction;

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

public class Macchiato {

  public static void assertHasText(String text) {
    viewWithText(text).check(matches(isDisplayed()));
  }

  public static void assertDoesNotHaveText(String text) {
    viewWithText(text).check(matches(not(isDisplayed())));
  }

  public static void clickOn(int id) {
      viewWithId(id).perform(click());
  }

  public static void clickOn(String text) {
    viewWithText(text).perform(click());
  }

  public static void fillField(String hint, String value) throws InterruptedException {
    viewWithHint(hint).perform(typeText(value), closeSoftKeyboard());
    Thread.sleep(500);
  }

  private static ViewInteraction viewWithId(int id) {
    return onView(withId(id));
  }

  private static ViewInteraction viewWithText(String text) {
    return onView(withText(text));
  }

  private static ViewInteraction viewWithHint(String hint) {
    return onView(withHint(hint));
  }
}
