package com.example.rehabilitacja.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rehabilitacja.R;

/**
 * @author Seweryn Drążek
 * @version 29.0.3 03/04/2020
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signinbutton = findViewById(R.id.signinbutton);
        Button registerbutton = findViewById(R.id.registerbutton);

        signinbutton.setOnClickListener(new MoveToSignInActivity());
        registerbutton.setOnClickListener(new MoveToRegisterActivity());
    }

    private class MoveToSignInActivity implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            openSignInActivity();
        }

    }

    private class MoveToRegisterActivity implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            openRegisterActivity();
        }

    }

    private void openSignInActivity(){


        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);

    }

    private void openRegisterActivity(){


        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }

}
