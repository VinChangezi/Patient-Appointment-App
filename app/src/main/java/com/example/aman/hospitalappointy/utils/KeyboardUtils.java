package com.example.aman.hospitalappointy.utils;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardUtils {

    public static void hideKeyboard(AppCompatActivity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE);
            View currentFocusedView = activity.getCurrentFocus();
            if (currentFocusedView != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), 0);
            }
        } catch (Exception e) {
            Log.e("hideKeyboard", "hideKeyboard: Couldn't hide keyboard");
        }
    }

}
