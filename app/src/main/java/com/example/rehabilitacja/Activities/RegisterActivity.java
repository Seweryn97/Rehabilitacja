package com.example.rehabilitacja.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rehabilitacja.Activities.Validation.Validate;
import com.example.rehabilitacja.R;



public class RegisterActivity extends AppCompatActivity {

    private EditText email ;
    private EditText password ;
    private EditText repeatPassword ;
    private TextView emptyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button register = findViewById(R.id.nextregisbutton);

        register.setOnClickListener(new MoveToMenuActivity());

        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.password_reg);
        repeatPassword = findViewById(R.id.repeatpassword);
        emptyField = findViewById(R.id.emptyfieldtextviex);

    }

    private class MoveToMenuActivity implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            if(Validate.getInstance().notEmptyField(Validate.getInstance().editTextArray(
                    (RelativeLayout) findViewById(R.id.myRegisterLayout)))&&
                    Validate.getInstance().isEmialAndPasswordValid(email.getText().toString(),
                    password.getText().toString(),repeatPassword.getText().toString())){

                moveToMenuActivity();
            }

            if(!Validate.getInstance().notEmptyField(Validate.getInstance().editTextArray(
                    (RelativeLayout) findViewById(R.id.myRegisterLayout)))){
                emptyField.setText("Wszystkie pola powinny być wypełnione");

            }

            else if(!Validate.getInstance().isEmialAndPasswordValid(email.getText().toString(),
                    password.getText().toString(),repeatPassword.getText().toString())){
                emptyField.setText("Hasło powinno być dłuższe niż 8 znaków mieć jedną wielka " +
                        "literę i cyfrę. Sprawdź ormat email");
            }

        }
    }

    private void moveToMenuActivity(){
        Intent intent = new Intent(this, MenuActicity.class);
        startActivity(intent);

    }


}
