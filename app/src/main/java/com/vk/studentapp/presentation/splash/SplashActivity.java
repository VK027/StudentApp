package com.vk.studentapp.presentation.splash;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import com.vk.studentapp.R;
import com.vk.studentapp.presentation.BaseActivity;
import com.vk.studentapp.presentation.login.LoginActivity;
import com.vk.studentapp.util.Constants;
import com.vk.studentapp.util.GlobalMethods;
import com.vk.studentapp.util.RuntimePermissionUtil;

public class SplashActivity extends BaseActivity {

    private final int MULTIPLE_PERMISSIONS = 1010;

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initGUI(Bundle savedInstanceState) {
        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       /* new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    callNextActivity();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        }, 3000);*/

        askPermission();
    }

    private void askPermission() {
        if (!RuntimePermissionUtil.hasPermissions(SplashActivity.this, Constants.PERMISSIONS)) {
            RuntimePermissionUtil.requestPermission(SplashActivity.this, Constants.PERMISSIONS, MULTIPLE_PERMISSIONS);
        } else {
            callNextActivity();
        }
    }

    private void callNextActivity() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    GlobalMethods.callForWordActivity(SplashActivity.this, LoginActivity.class, null, true, true);

                } catch (Exception exp) {
                    exp.printStackTrace();
                }
            }
        }, 2000);
    }

    @Override
    protected void initData() {
        // GlobalMethods.setServiceType(SplashActivity.this, Constants.POINT_DEV);
        GlobalMethods.setServiceType(SplashActivity.this, Constants.POINT_DEV);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MULTIPLE_PERMISSIONS) {
            callNextActivity();
            return;
        }
    }
}

