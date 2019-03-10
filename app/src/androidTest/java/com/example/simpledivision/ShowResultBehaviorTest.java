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

/*import androidx.test.espresso.ViewAction;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnitRunner;

import android.support.test.runner.AndroidJUnit4;*/
/*import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;*/


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowResultBehaviorTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);
    private String firstValueToBetyped;
    private String secondValueToBetyped;

    @Before
    public void initValidString() {
        //InstrumentationRegistry.getTargetContext();
        //MainActivity mainActivity = new MainActivity();

        firstValueToBetyped = "10";
        secondValueToBetyped = "5";
    }

    @Test
    public void showResult() {
        onView(withId(R.id.first)).perform(typeText(firstValueToBetyped));
        onView(withId(R.id.second)).perform(typeText(secondValueToBetyped));
        onView(withId(R.id.result_button)).perform(click());
        onView(withText("2.00")).check(matches(isDisplayed()));

    }
}