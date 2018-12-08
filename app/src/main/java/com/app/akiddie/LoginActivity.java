package com.app.akiddie;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout1;
    private TextInputEditText emailField;
    private TextInputEditText passwordField;
    private TextView forgotPassword;
    private Button loginButton;
    private TextView signUp;
    private static final String emailPattern = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\\\"(),:;<>@\\\\[\\\\]\\\\\\\\]+@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(emailPattern);
    private Matcher matcher;
    int attempts_stop = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
        signUp();

        textInputLayout.setHint("Username");
        textInputLayout1.setHint("Password");

    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

    public void login() {

        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        forgotPassword = findViewById(R.id.forgot_password);
        loginButton = findViewById(R.id.login_button);
        signUp = findViewById(R.id.sign_up);
        textInputLayout = findViewById(R.id.email_layout);
        textInputLayout1 = findViewById(R.id.password_layout);
        final String userEmail = textInputLayout.getEditText().getText().toString();
        final String userPassword = textInputLayout1.getEditText().getText().toString();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailField.getText().toString().equals("user") && passwordField.getText().toString().equals("password")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                } if (attempts_stop == 0) {
                    signUp.setEnabled(false);
                    signUp.setVisibility(View.INVISIBLE);
                }
                if (!validateEmail(userEmail)) {
                    textInputLayout.setError("Not a valid Email");
                } else if (!validatePassword(userPassword)) {
                    textInputLayout1.setError("Password must be more than 5 characters");
                } else {
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout1.setErrorEnabled(false);
                }

                hideKeyBoard();
            }
        });

    }



    private void hideKeyBoard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void signUp() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);

            }
        });
    }


}
