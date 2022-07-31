package com.example.loginsignupandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageButton arrowBack = findViewById(R.id.arrow_back);
        TextInputLayout layoutName = findViewById(R.id.layout_name_signup);
        TextInputLayout layoutEmail = findViewById(R.id.layout_email_signup);
        TextInputLayout layoutPass = findViewById(R.id.layout_pass_signup);
        TextInputLayout layoutConfirmPass = findViewById(R.id.layout_confirm_pass_signup);
        EditText etName = findViewById(R.id.et_name_signup);
        EditText etEmail = findViewById(R.id.et_email_signup);
        EditText etPass = findViewById(R.id.et_pass_signup);
        EditText etConfirmPass = findViewById(R.id.et_confirm_pass_signup);
        Button btnSignUp = findViewById(R.id.btn_signup);
        TextView tvLogin = findViewById(R.id.txt_login);

        arrowBack.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
            finish();
        });

        btnSignUp.setOnClickListener(view -> {
            String name = FormValidation.userInput(etName);
            String email = FormValidation.userInput(etEmail);
            String pass = FormValidation.userInput(etPass);
            String confirmPass = FormValidation.userInput(etConfirmPass);

            if (FormValidation.notEmpty(name, layoutName)
                    && FormValidation.notEmpty(email, layoutEmail)
                    && FormValidation.notEmpty(pass, layoutPass)
                    && FormValidation.notEmpty(confirmPass, layoutConfirmPass)
                    && FormValidation.passwordValidate(pass, layoutPass)
                    && FormValidation.confirmPassword(confirmPass, pass, layoutConfirmPass)
            ) {
                Toast.makeText(getApplication(), "Validate", Toast.LENGTH_SHORT).show();
            }
        });

        tvLogin.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}