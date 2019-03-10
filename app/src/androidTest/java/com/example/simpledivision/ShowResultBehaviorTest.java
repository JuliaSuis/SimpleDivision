package com.example.simpledivision;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowResultBehaviorTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    private String firstValueToBetyped;
    private String secondValueToBetyped;
    private String zeroValuetoBetyped;
    private String noValuetoBetyped;

    @Before
    public void initValidString() {

        firstValueToBetyped = "10";
        secondValueToBetyped = "5";
        zeroValuetoBetyped = "0";
        noValuetoBetyped = "";
    }

    @Test
    public void showResultForInteger() {
        onView(withId(R.id.first)).perform(typeText(firstValueToBetyped));
        onView(withId(R.id.second)).perform(typeText(secondValueToBetyped));
        onView(withId(R.id.result_button)).perform(click());
        onView(withText("2.00")).check(matches(isDisplayed()));

    }

    @Test
    public void showResultForNan() {
        onView(withId(R.id.first)).perform(typeText(zeroValuetoBetyped));
        onView(withId(R.id.second)).perform(typeText(zeroValuetoBetyped));
        onView(withId(R.id.result_button)).perform(click());
        onView(withText("Nan result")).check(matches(isDisplayed()));
    }

    @Test
    public void showResultForInf() {
        onView(withId(R.id.first)).perform(typeText(firstValueToBetyped));
        onView(withId(R.id.second)).perform(typeText(zeroValuetoBetyped));
        onView(withId(R.id.result_button)).perform(click());
        onView(withText("Inf result")).check(matches(isDisplayed()));
    }

    @Test
    public void showResultForEmptyFields() {
        onView(withId(R.id.first)).perform(typeText(noValuetoBetyped));
        onView(withId(R.id.second)).perform(typeText(secondValueToBetyped));
        onView(withId(R.id.result_button)).perform(click());
        onView(withText("Err: enter valid numbers.")).check(matches(isDisplayed()));
    }

}