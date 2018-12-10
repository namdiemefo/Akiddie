package com.app.akiddie;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.akiddie.Utility.HideSoftKeyboard;

public class SignUpActivity extends AppCompatActivity {
private TextInputLayout fullNameLayout;
private TextInputLayout emailLayout;
private TextInputLayout passwordLayout;
private TextInputLayout verifyPasswordLayout;
private TextInputEditText fullNameField;
private TextInputEditText emailField;
private TextInputEditText passwordField;
private TextInputEditText verifyPasswordField;
private Button signUpButton;
//private static final String emailPattern = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\\\"(),:;<>@\\\\[\\\\]\\\\\\\\]+@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*$";
//private Pattern pattern = Pattern.compile(emailPattern);
//private Matcher matcher;
int attempts_stop = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setUpUI(findViewById(R.id.parent_layout));
        signUp();

    }

   // public boolean validateEmail(String email) {
       // matcher = pattern.matcher(email);
        //return matcher.matches();
    //}

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

    public boolean validateBothPassword(String password1, String password2) {
        password1 = passwordField.getText().toString();
        password2 = verifyPasswordField.getText().toString();
        return password1.equals(password2);
    }

    private void hideKeyBoard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /* touch listener for views outside the editText to enable the hide keyboard method */
    public void setUpUI(View view) {
        if (!(view instanceof TextInputEditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    HideSoftKeyboard.hideSoftKeyboard(SignUpActivity.this);
                    return false;
                }
            });
        }


        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setUpUI(innerView);
            }
        }
    }

    public void signUp() {
        fullNameField = findViewById(R.id.name_field);
        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);
        verifyPasswordField = findViewById(R.id.verify_password_field);
        signUpButton = findViewById(R.id.sign_up_btn);
        fullNameLayout = findViewById(R.id.name_layout);
        emailLayout = findViewById(R.id.email_layout);
        passwordLayout = findViewById(R.id.password_layout);
        verifyPasswordLayout = findViewById(R.id.verify_password_layout);
        final String fullName = fullNameLayout.getEditText().toString();
        final String email = emailLayout.getEditText().toString();
        final String password = passwordLayout.getEditText().toString();
        final String verifyPassword = verifyPasswordLayout.getEditText().toString();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if (!validateEmail(email)) {
                 //   emailLayout.setErrorEnabled(true);
                 //  emailLayout.setError("invalid email address");}
                // if (!validatePassword(password)) {
                  //  emailLayout.setErrorEnabled(true);
                   // passwordLayout.setError("password must be more than 5 characters");}
                if (!validateBothPassword(password, verifyPassword)) {
                    Toast.makeText(SignUpActivity.this, "passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    //emailLayout.setErrorEnabled(false);
                   // passwordLayout.setErrorEnabled(false);
                   // emailLayout.setError(null);
                   // passwordLayout.setError(null);
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                hideKeyBoard();
            }
        });
    }


}
