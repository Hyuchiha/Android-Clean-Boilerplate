package com.hyuchiha.boilerplate.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by luisburgos on 1/27/17.
 */
public abstract class SessionManager<Entity> {

    protected SharedPreferences mPreferences;
    protected SharedPreferences.Editor mEditor;

    private Context mContext;

    private final int PRIVATE_MODE = 0;

    public SessionManager(Context context){
        this.mContext = context;
        mPreferences = mContext.getSharedPreferences(getSessionStorageName(), PRIVATE_MODE);
        mEditor = mPreferences.edit();
    }

    public abstract void saveSession(Entity toSave);
    public abstract void clearSession();

    public abstract Entity getSession();
    public abstract boolean isSessionSaved();

    public abstract String getSessionStorageName();
}
