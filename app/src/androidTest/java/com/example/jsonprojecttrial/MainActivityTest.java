package com.example.jsonprojecttrial;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.jsonprojecttrial.home.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activity = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void scrollToPosition(){
        Espresso.onView(ViewMatchers.withId(R.id.rvResults))
                .perform(RecyclerViewActions.actionOnItemAtPosition(50, ViewActions.longClick()));
    }

}
