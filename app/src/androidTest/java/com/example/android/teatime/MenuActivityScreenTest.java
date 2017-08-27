package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
/**
 * Created by manvi on 27/8/17.
 */

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {
    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule = new ActivityTestRule<MenuActivity>(MenuActivity.class);
    public static final String TEA_NAME = "Green Tea";

    @Test
    public void clickGridViewItem_OpensOrderActivity() {
        //Finish writing this test which will click on a gridView Tea item and verify that
        // the OrderActivity opens up with the correct tea name displayed.
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(1)
                .perform(click());

        // Checks that the OrderActivity opens with the correct tea name displayed
        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));
    }
}
