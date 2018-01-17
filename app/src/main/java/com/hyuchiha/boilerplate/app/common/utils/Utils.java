package com.hyuchiha.boilerplate.app.common.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Build;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;

/**
 * Orphan utility methods.
 */
public class Utils {

    public static String getFloatRounded(final float value){
        return String.format(Locale.US, "%.2f", value);
    }

    public static String getFloatRounded(final String value) {
        return getFloatRounded(new BigDecimal(value).floatValue());
    }

    public static boolean supportsAnimations() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean isAnEmail(String email) {
        //TODO: Verify regex.
        String emailRegex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        return email.matches(emailRegex);
    }

    public static boolean isAPhoneNumber(String phone) {
        //TODO: Verify regex.
        String phoneRegex = "^[0-9]{10}$";
        return phone.matches(phoneRegex);
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void setVisibility(boolean makeVisible, View... views) {
        for (View view : views) {
            view.setVisibility(makeVisible ? View.VISIBLE : View.INVISIBLE);
        }
    }

    public static boolean isADate(String date) {
        return true; //TODO: Verify
    }

    public static boolean isAnImei(String imei){
        return true; //TODO: Verify
    }

    public static void makeTextViewClickable(final TextView textView, final ClickableSpan action){
        SpannableString textViewText = new SpannableString(textView.getText());
        textViewText.setSpan(action, 0, textViewText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(textViewText);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(Color.TRANSPARENT);
    }
}

