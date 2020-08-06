package com.example.rehabilitacja.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.rehabilitacja.Activities.Validation.Validate;
import com.example.rehabilitacja.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button signIn = findViewById(R.id.nextsignbutton);
        signIn.setOnClickListener(new MoveToMenuActivity());
    }

    private class MoveToMenuActivity implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(Validate.getInstance().notEmptyField(Validate.getInstance().editTextArray(
                    (RelativeLayout) findViewById(R.id.myRegisterLayout)))){
                moveToMenuActivity();
            }
        }
    }

    private void moveToMenuActivity(){
        Intent intent = new Intent(this, MenuActicity.class);
        startActivity(intent);
    }
}
