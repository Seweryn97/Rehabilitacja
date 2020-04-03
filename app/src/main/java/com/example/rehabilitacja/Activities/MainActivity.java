package com.example.rehabilitacja.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rehabilitacja.R;

/**
 * Obiekt <code>MainActivity</code> reprezentuje pierwsze okno aplikacji mobilnej
 *
 * @author Seweryn Drążek
 * @version 29.0.3 03/04/2020
 */

public class MainActivity extends AppCompatActivity {
    /**
     *Prywatne zmienne typu Button
     *
     *signinbutton obsługuje zdarzenie przenoszące użytkownika do strony z logowaniem
     *
     *registerbutton obsługuje zdarzenie przenoszące użytkownika do strony z rejestracją
     */
    private Button signinbutton;
    private Button registerbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         *
         * @param savedInstanceState odniesienie do obiektu Bundle
         * @super dziedziczy konstruktor onCreate
         *
         * stworzenie MainActivity
         *
         * przypisanie przyciwsków do odpowiadających im id
         *
         * obsługa przycisków
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signinbutton = findViewById(R.id.signinbutton);
        registerbutton = findViewById(R.id.registerbutton);

        signinbutton.setOnClickListener(new MoveToSignInActivity());
        registerbutton.setOnClickListener(new MoveToRegisterActivity());
    }

    private class MoveToSignInActivity implements View.OnClickListener {

        /**
         *
         * @param v przekazuje kliknięty obiekt
         *
         * implementacja interfejsu OnClickListener
         *
         * wywołanie metody openSignInActivity
         */

        @Override
        public void onClick(View v) {
            openSignInActivity();
        }

    }

    private class MoveToRegisterActivity implements View.OnClickListener {

        /**
         *
         * @param v przekazuje kliknięty obiekt
         *
         * implementacja interfejsu OnClickListener
         *
         * wywołanie metody openRegisterActivity
         */

        @Override
        public void onClick(View v) {
            openRegisterActivity();
        }

    }

    private void openSignInActivity(){

        /**
         * metoda odpowiedzialna za wywowłanie SignInActivity
         */

        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);

    }

    private void openRegisterActivity(){

        /**
         * metoda odpowiedzialna za wywowłanie RegisterInActivity
         */

        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);

    }

}
