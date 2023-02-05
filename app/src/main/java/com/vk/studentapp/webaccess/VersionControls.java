package com.vk.studentapp.webaccess;

import android.content.Context;

import com.vk.studentapp.util.Constants;
import com.vk.studentapp.util.GlobalMethods;

public class VersionControls {

    private static VersionControls instance = null;

    private String Url = URLS.Development.getBaseURL();

    public VersionControls(Context context) {

    }

    public static VersionControls getVersionControls(Context context) {
        if (instance == null)
            instance = new VersionControls(context);
        setUrls(context);
        return instance;
    }

    private static void setUrls(Context context) {
        if (GlobalMethods.isNull(GlobalMethods.getServiceType(context))) {
            if (instance != null) {
                switch (GlobalMethods.getServiceType(context)) {
                    case Constants.POINT_PRODUCTION:
                        instance.setBaseUrl(URLS.Production.getBaseURL());
                        break;
                    default:
                    case Constants.POINT_DEV:
                        instance.setBaseUrl(URLS.Development.getBaseURL());
                        break;

                }
            }
        }
    }

    enum URLS {
        Development("https://www.app_dev_abc.com/"),
        Production("https://www.dev_abc.com/");
        String URL;
        URLS(String URL) {
            this.URL = URL;
        }
        String getBaseURL() {
            return this.URL;
        }
    }

    public String getBaseURL() {
        return Url;
    }

    private void setBaseUrl(String url) {
        Url = url;
    }
}