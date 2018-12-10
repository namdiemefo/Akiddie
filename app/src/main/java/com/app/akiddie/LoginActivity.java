package com.app.akiddie;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.akiddie.Utility.HideSoftKeyboard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputLayout;
    private TextInputLayout textInputLayout1;
    private TextInputEditText emailField;
    private TextInputEditText passwordField;
    private TextView forgotPassword;
    private Button loginButton;
    private Button signUp;
   // private static final String emailPattern = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\\\"(),:;<>@\\\\[\\\\]\\\\\\\\]+@[a-zA-Z0-9-]+(\\\\.[a-zA-Z0-9-]+)*$";
   // private Pattern pattern = Pattern.compile(emailPattern);
    private Matcher matcher;
    int attempts_stop = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
        signUp();
        setUpUI(findViewById(R.id.parent_layout));

        textInputLayout.setHint("Username");
        textInputLayout1.setHint("Password");
        textInputLayout1.setPasswordVisibilityToggleEnabled(true);
        textInputLayout1.setEnabled(true);
        textInputLayout1.isPasswordVisibilityToggleEnabled();

    }

   // public boolean validateEmail(String email) {
     //   matcher = pattern.matcher(email);
       // return matcher.matches();

    //}

    public boolean validatePassword(String password) {
        int i = 5;
        return password.length() > i;
    }

    public void setUpUI(View view) {
        if (!(view instanceof TextInputEditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    HideSoftKeyboard.hideSoftKeyboard(LoginActivity.this);
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


        /* i need to fix the textinputlayouterror */
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if (emailField.getText().toString().equals("user") && passwordField.getText().toString().equals("password")) {

               // } else {
                 //   Toast.makeText(LoginActivity.this, "Invalid Username and Password", Toast.LENGTH_SHORT).show();}
                 if (attempts_stop == 0) {
                    signUp.setEnabled(false);
                    signUp.setVisibility(View.INVISIBLE);
                }
                //if (!validateEmail(userEmail)) {
                  // Toast.makeText(LoginActivity.this, "not a valid email address", Toast.LENGTH_SHORT).show();}
                //if (!validatePassword(userPassword)){
                    //Toast.makeText(LoginActivity.this, "Password must be more than 5 characters", Toast.LENGTH_SHORT).show();

                //} else {
                  //  textInputLayout.setErrorEnabled(false);
                    // textInputLayout1.setErrorEnabled(false);
                   // textInputLayout.setError(null);
                   // textInputLayout1.setError(null);
               // } else {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
               // }

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
        signUp = findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });
    }


}
