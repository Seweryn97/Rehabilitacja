package com.example.rehabilitacja.Activities.Validation;

import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validate {

    /**
     * Singleton
     */
    private static Validate instance = null;

    private Validate(){

    }

    public static Validate getInstance(){
        if(instance == null){
            instance = new Validate();
        }
        return instance;
    }

    public boolean notEmptyField(List<String> inputFields){

        if(inputFields.contains(null) || inputFields.contains("")) return false;
        for (String s:inputFields) {
            if(s.contains(" ")) return false;
        }
        return true;
    }

    public boolean isEmialAndPasswordValid(String email, String password, String repeatPasword){

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        boolean emailFormat = matcher.matches();

        boolean passwordFormat = !password.equals(password.toLowerCase())
                && password.matches(".*\\d.*") && password.length() >8;

        boolean equalsPasswords = password.equals(repeatPasword);

        return emailFormat && passwordFormat && equalsPasswords;

    }

    /**
     *
     * @param myLayout store RealativeLAyout from activity
     *
     * parsing EditText and storing in list
     * @return list which contains EditText values
     */

    public List<String> editTextArray ( RelativeLayout myLayout){
        List<String> entries = new LinkedList<>();

        for (int i = 0; i < myLayout.getChildCount(); i++) {
            if(myLayout.getChildAt(i) instanceof EditText){
                entries.add( ((EditText) myLayout.getChildAt(i)).getText().toString());
            }
        }
        return entries;
    }



}
