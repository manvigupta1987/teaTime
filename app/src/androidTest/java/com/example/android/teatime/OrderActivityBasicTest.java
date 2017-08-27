package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by manvi on 27/8/17.
 */

//This indicates that we want to run this test with AndroidJunit 4 class.
// It will helps in launching app as well as running UI test on it.
@RunWith(AndroidJUnit4.class)
public class OrderActivityBasicTest {
    //it is rule that provides functional testing for a single activity
    @Rule public ActivityTestRule<OrderActivity> mActivityRule = new ActivityTestRule<OrderActivity>(OrderActivity.class);

    //          - Check that the initial quantity is zero
    //          - Click on the decrement button
    //          - Verify that the decrement button won't decrease the quantity 0 and cost below $0.00
    @Test
    public void clickDecrementButton_ChangesQuantityAndCost() {
        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));

        onView(withId(R.id.decrement_button)).perform(click());

        onView(withId(R.id.quantity_text_view)).check(matches(withText("0")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$0.00")));

    }

    @Test
    public void clickIncrementButton_ChangesQuantityAndCost(){
        //1. Find the view
        //2. Perform action on view
        onView(withId(R.id.increment_button)).perform(click());

        //3. check if the view does what is expected
        onView(withId(R.id.quantity_text_view)).check(matches(withText("1")));
        onView(withId(R.id.cost_text_view)).check(matches(withText("$5.00")));
    }


}
