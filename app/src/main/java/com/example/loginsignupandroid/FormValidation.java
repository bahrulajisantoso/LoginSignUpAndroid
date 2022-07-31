package com.example.loginsignupandroid;

import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class FormValidation {

    public static boolean notEmpty(String string, TextInputLayout layout) {
        if (string.isEmpty()) {
            layout.setError("Can't be empty");
            return false;
        } else {
            layout.setError(null);
            return true;
        }
    }

    public static boolean passwordValidate(String string, TextInputLayout layout) {
        if (string.length() < 8) {
            layout.setError("Min 8 character");
            return false;
        } else {
            layout.setError(null);
            return true;
        }
    }

    public static String userInput(EditText editText) {
        return editText.getText().toString().trim();
    }

    public static boolean confirmPassword(String string1, String string2, TextInputLayout layout) {
        if (!string1.equals(string2)) {
            layout.setError("Confirm password not same");
            return false;
        } else {
            layout.setError(null);
            return true;
        }
    }
}
