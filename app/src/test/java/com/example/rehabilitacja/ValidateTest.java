package com.example.rehabilitacja;

import com.example.rehabilitacja.Activities.Validation.Validate;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class ValidateTest {

     private List<String> inputFields = new LinkedList<>();

     @Test
     public void isFieldEmptyTest(){

         inputFields.add("Imie1");
         inputFields.add("cos");
         inputFields.add(null);

         Assert.assertFalse(Validate.getInstance().notEmptyField(inputFields));
     }

     @Test
     public void isEmailAndPasswordInValidTest(){
         String incorrectPasword = "haslo";
         String incorrectEmial = "email";
         String incorrectRepeatPassword = "haslo2";

         Assert.assertFalse(Validate.getInstance().isEmialAndPasswordValid(incorrectEmial,
                 incorrectPasword,incorrectRepeatPassword));

     }

    @Test
    public void isEmailAndPasswordValidTest(){
        String correctPassword = "Haselko123";
        String correctEmail = "sewerusek97@op.pl";
        String correctRepeatPassword = "Haselko123";

        Assert.assertTrue(Validate.getInstance().isEmialAndPasswordValid(correctEmail,
                correctPassword,correctRepeatPassword));

    }




}
