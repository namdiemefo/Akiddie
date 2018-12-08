package com.app.akiddie;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {
    private TextInputLayout fullNameLayout;
    private TextInputLayout emailLayout;
    private TextInputLayout passwordLayout;
    private TextInputLayout verifyPasswordLayout;
    private TextInputEditText fullNameField;
    private TextInputEditText emailField;
    private TextInputEditText passwordField;
    private TextInputEditText verifyPasswordField;
    private static final String emailPattern = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\\\"(),:;<>@\\\\[\\\\]\\\\\\\\]+@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(emailPattern);
    private Button signUpButton;
    final String userEmail = emailLayout.getEditText().getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public boolean validateEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    boolean isEmpty(TextInputEditText textInputEditText) {
     CharSequence charSequence = textInputEditText.getText().toString();
     return TextUtils.isEmpty(charSequence);
    }

    public void signUp() {
        fullNameLayout = findViewById(R.id.name_layout);
        emailLayout = findViewById(R.id.email_layout);
        passwordLayout = findViewById(R.id.password_layout);
        verifyPasswordLayout = findViewById(R.id.verify_password_layout);
        fullNameField = findViewById(R.id.name_field);
        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        verifyPasswordField = findViewById(R.id.verify_password_field);
        signUpButton = findViewById(R.id.sign_up_btn);



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckDataEntered();
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                }
            });
        }

    private void onCheckDataEntered() {
        boolean temp = true;
        String pass = passwordField.getText().toString();
        String verPass = verifyPasswordField.getText().toString();
        if (!pass.equals(verPass)) {
            Toast.makeText(this, "passwords do not match", Toast.LENGTH_SHORT).show();
            temp = false;
        }
        if (isEmpty(fullNameField)) {
            signUpButton.setEnabled(false);
            fullNameLayout.setError("field is empty");
    } else {
            signUpButton.setEnabled(true);
        } if (!validateEmail(userEmail)) {
            Toast.makeText(this, "incorrect email", Toast.LENGTH_SHORT).show();
            temp = false;
        }

    }
}
