package com.example.rehabilitacja;

import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import com.example.rehabilitacja.Activities.RegisterActivity;
import com.example.rehabilitacja.Activities.Validation.Validate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterActivityTest {

    private RegisterActivity registerActivity;
    private EditText name;

    @Rule
    public ActivityTestRule<RegisterActivity> activityRule =
            new ActivityTestRule<>(RegisterActivity.class);

    @Before
    public void initValidEditText(){
        registerActivity = activityRule.getActivity();
        name = registerActivity.findViewById(R.id.name);
        name.setText("Seweryn");
    }

    @Test
    public void checkIfEditTextInputsAreCorrect(){
        Assert.assertEquals(name.getText().toString(),
                Validate.getInstance().editTextArray((RelativeLayout)
                        registerActivity.findViewById(R.id.myRegisterLayout)).get(0));
    }

}

