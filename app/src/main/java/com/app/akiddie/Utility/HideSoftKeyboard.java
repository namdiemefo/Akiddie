package com.app.akiddie.Utility;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by namdi on 12/10/18.
 */

public class HideSoftKeyboard {

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }

}
