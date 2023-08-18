package com.fffemote.dances.skins.ffdiamond;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.multidex.MultiDex;

import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppOpenManager;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCModelAd;
import com.google.android.gms.ads.MobileAds;



public class BaseApplication extends Application {
    private static BaseApplication mInstance;
    private Activity activity;
    private Context context;

    public static final String ADS_COUNT_SHOW = "ads_count_show";
    public static final String ADS_COUNT_BACK_SHOW = "ads_count_back_show";

    public static final boolean IS_APP_OPEN_SHOWING = true;
    public static final boolean IS_NATIVE_AD_LAST = false;

    public static boolean booleanSplashAds = false;
    public CTCAppOpenManager openManager;
    public static final String TAG = BaseApplication.class.getSimpleName();

    public static CTCModelAd adModel;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        MobileAds.initialize(this, initializationStatus -> {
        });


        openManager=new CTCAppOpenManager(this);
    }

    public static synchronized BaseApplication getInstance() {
        BaseApplication baseApplication;

        baseApplication = mInstance;
             return baseApplication;
    }

    public static CTCModelAd getAdModel() {
        if (adModel == null) {
            adModel = CTCAppLoadAds.getModelAd(new CTCModelAd());
        }
        return adModel;
    }



    @Override
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    public void showAdIfAvailable(@NonNull Activity activity, @NonNull OnShowAdCompleteListener onShowAdCompleteListener) {
        openManager.showAdIfSplashAvailable(activity, onShowAdCompleteListener);
    }
    public interface OnShowAdCompleteListener {
        void onShowAdComplete();
    }

    static {

        System.loadLibrary("native-lib");
    }
}
