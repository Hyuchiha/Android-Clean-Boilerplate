package com.kodelabs.boilerplate.app;

import android.app.Application;

import com.kodelabs.boilerplate.app.common.utils.ActivityHelper;
import com.kodelabs.boilerplate.presentation.ui.activities.MainActivity;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;


public class AndroidApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ActivityHelper.getInstance().setMainClass(MainActivity.class);

        initDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void initDB() {
        FlowManager.init(new FlowConfig.Builder(this)
                .openDatabasesOnInit(true).build());
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }
}
