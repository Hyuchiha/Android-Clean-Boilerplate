package com.kodelabs.boilerplate.app.common.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Helper class which provides methods to being, redirect, start and finish activities.
 */
public class ActivityHelper {

    private Class mMainClass = null;

    private static ActivityHelper INSTANCE;

    private ActivityHelper() {

    }

    public static ActivityHelper getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ActivityHelper();
        }
        return INSTANCE;
    }

    public void setMainClass(Class mainClass) {
        this.mMainClass = mainClass;
    }

    /**
     * Stars a activity without finish the current activity caller.
     * @param activity caller activity.
     * @param classTo class of the activity to redirect.
     */
    public void begin(Activity activity, Class classTo) {
        Intent intent = new Intent().setClass(activity, classTo);
        activity.startActivity(intent);
    }

    public void beginForResultFromFragment(Fragment fragment, Activity activityHost, Class classTo, int code) {
        Intent intent = new Intent().setClass(activityHost, classTo);
        fragment.startActivityForResult(intent, code);
    }

    public void beginForResultFromActivity(Activity activityHost, Class classTo, int code, Bundle extras){
        Intent intent = new Intent().setClass(activityHost, classTo);
        intent.putExtras(extras);
        activityHost.startActivityForResult(intent, code);
    }

    /**
     * Stars a activity and finish the current activity caller.
     * @param activity caller activity.
     * @param classTo class of the activity to redirect.
     */
    public void sendAndFinish(Activity activity, Class classTo) {
        Intent intent = new Intent().setClass(activity, classTo);
        activity.startActivity(intent);
        activity.finish();
    }

    public void sendToMainFrom(Activity fromActivity) {
        if(mMainClass != null){
            sendAndFinish(fromActivity, mMainClass);
        }
    }

    /**
     * Creates and configures a indeterminate and not cancelable progress dialog without a
     * text message.
     *
     * @param activity caller activity.
     * @return a {@link ProgressDialog} instance configured to be shown.
     */
    public static ProgressDialog createModalProgressDialog(Activity activity) {
        return createModalProgressDialog(activity, null);
    }

    /**
     * Creates and configures a indeterminate and not cancelable progress dialog with a
     * text message.
     *
     * @param activity caller activity.
     * @param dialogMessage text to show on UI when progress is showing.
     * @return a {@link ProgressDialog} instance configured to be shown.
     */
    public static ProgressDialog createModalProgressDialog(Activity activity, String dialogMessage) {
        final ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(activity);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

        if(dialogMessage != null){
            progressDialog.setMessage(dialogMessage);
        }
        return progressDialog;
    }

    /**
     * Helper method to determine if a object is null.
     * This class throws a {@link NullPointerException} whether the object is null.
     *
     * @param reference object to test
     * @param <T> concrete class of the object to test.
     * @return The {@code reference} if not null.
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    /**
     * The {@code fragment} is added to the container view with id {@code frameId}. The operation is
     * performed by the {@code fragmentManager}.
     *
     */
    public static void addFragmentToActivity(
            @NonNull FragmentManager fragmentManager,
            @NonNull Fragment fragment,
            int frameId
    ) {
        checkNotNull(fragmentManager);
        checkNotNull(fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }

}
