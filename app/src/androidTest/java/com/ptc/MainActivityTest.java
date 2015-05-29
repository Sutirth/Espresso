package com.ptc;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Lenovo on 28-05-2015.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public final ActivityRule<MainActivity> main = new ActivityRule<>(MainActivity.class);

    @Test
    public void shouldBeAbleToLaunchMainScreen(){
      //  onView(withText("Hello")).check(ViewAssertions.matches(isDisplayed()));
            onView(withId(R.id.etText)).perform(ViewActions.typeText("I like Expresso"));

            onView(withId(R.id.btnSubmit)).perform(ViewActions.click());

           onView(withId(R.id.secondText)).check(ViewAssertions.matches(ViewMatchers.withText("I like Expresso")));
    }
}
