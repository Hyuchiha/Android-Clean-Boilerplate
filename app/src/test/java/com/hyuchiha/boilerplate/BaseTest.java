package com.hyuchiha.boilerplate;

import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowApplication;

/**
 * Created by hyuchiha on 22/05/17.
 */

public class BaseTest {
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        if(RuntimeEnvironment.application != null){
            ShadowApplication shadowApplication = Shadows.shadowOf(RuntimeEnvironment.application);
            shadowApplication.grantPermissions("android.permission.INTERNET");
            shadowApplication.grantPermissions("android.permission.ACCESS_WIFI_STATE");
            shadowApplication.grantPermissions("android.permission.ACCESS_NETWORK_STATE");
            shadowApplication.grantPermissions("android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

}
