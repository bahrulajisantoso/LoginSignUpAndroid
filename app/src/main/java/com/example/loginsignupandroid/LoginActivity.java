package com.example.loginsignupandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextInputLayout layoutEmail = findViewById(R.id.layout_email);
        TextInputLayout layoutPass = findViewById(R.id.layout_pass);
        EditText etEmail = findViewById(R.id.et_email);
        EditText etPass = findViewById(R.id.et_pass);
        Button btnLogin = findViewById(R.id.btn_login);
        TextView tvSignUp = findViewById(R.id.txt_signup);

        btnLogin.setOnClickListener(view -> {
            String email = FormValidation.userInput(etEmail);
            String password = FormValidation.userInput(etPass);

            if (FormValidation.notEmpty(email, layoutEmail)
                    && FormValidation.notEmpty(password, layoutPass)
            ) {
                Toast.makeText(getApplicationContext(), "Validate", Toast.LENGTH_SHORT).show();
            }
        });

        tvSignUp.setOnClickListener(view -> {
            Intent intent = new Intent(getApplication(), SignUpActivity.class);
            startActivity(intent);
        });
    }
}