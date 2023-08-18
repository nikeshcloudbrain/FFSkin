package com.fffemote.dances.skins.ffdiamond.adsp;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.fffemote.dances.skins.ffdiamond.BaseApplication;
import com.fffemote.dances.skins.ffdiamond.SplashActivity;
import com.fffemote.dances.skins.ffdiamond.util.Constant;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;


import java.util.Date;

public class CTCAppOpenManager implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    public AppOpenAd appOpenAd = null;
    public AppOpenAd.AppOpenAdLoadCallback appCallback;
    public final BaseApplication appMyApp;
    public static boolean appIsShowingAd = false;
    public Activity appCurrentActivity;
    public long appLoadTime = 0;

    public MaxAppOpenAd ALappOpenAd;


    public CTCAppOpenManager(BaseApplication myApplication) {
        this.appMyApp = myApplication;
        this.appMyApp.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

        fetchAl();

    }


    public void fetchAl(){
        ALappOpenAd = new MaxAppOpenAd( BaseApplication.getAdModel().getAdsApplovinAppopenId(), appMyApp);
        ALappOpenAd.setListener(new MaxAdListener() {
            @Override
            public void onAdLoaded(MaxAd maxAd) {
                Log.e("TAG", "onSplashAdLoaded: " );

            }

            @Override
            public void onAdDisplayed(MaxAd maxAd) {

            }

            @Override
            public void onAdHidden(MaxAd maxAd) {
                ALappOpenAd.loadAd();
                Log.e("TAG", "onAdHidden: " );
            }

            @Override
            public void onAdClicked(MaxAd maxAd) {

            }

            @Override
            public void onAdLoadFailed(String s, MaxError maxError) {
//                showAdIfAvailable();
                ALappOpenAd.loadAd();

                Log.e("TAG", "onAdLoadFailed: "+maxError.getMessage() );

            }

            @Override
            public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                Log.e("TAG", "onAdDisplayFailed: "+maxError.getMessage() );

            }
        });
        ALappOpenAd.loadAd();
    }

    public void fetchAd() {

        if (isAdAvailable()) {
            return;
        }

        appCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAdLoaded(AppOpenAd ad) {
                CTCAppOpenManager.this.appOpenAd = ad;
                CTCAppOpenManager.this.appLoadTime = (new Date()).getTime();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {

            }
        };
        AdRequest request = getAdRequest();
        AppOpenAd.load(appMyApp, BaseApplication.getAdModel().getAdsAppOpenId(), request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, appCallback);
    }


    public AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    public boolean isAdAvailable() {
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
    }

    public void showAdIfAvailable() {
        if (BaseApplication.getAdModel().getAdsAppOpen().equalsIgnoreCase("Google")) {
            if (!appIsShowingAd && isAdAvailable()) {
                if (BaseApplication.IS_APP_OPEN_SHOWING) {
                    FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            CTCAppOpenManager.this.appOpenAd = null;
                            appIsShowingAd = false;
                            fetchAd();
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            appIsShowingAd = true;
                        }
                    };

                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                    appOpenAd.show(appCurrentActivity);
                }
            } else {
                fetchAd();
            }
        }else if (BaseApplication.getAdModel().getAdsAppOpen().equalsIgnoreCase("AppLovin")) {

            if ( ALappOpenAd == null || !AppLovinSdk.getInstance( appMyApp ).isInitialized() ) return;

            if ( ALappOpenAd.isReady() )
            {
                Log.e("TAG", "showAdIfAvailable:");
                ALappOpenAd.showAd( );
            }
            else
            {
                ALappOpenAd.loadAd();
            }
        }
    }

    public void showAdIfSplashAvailable(@NonNull final Activity activity, @NonNull BaseApplication.OnShowAdCompleteListener onShowAdCompleteListener) {
        Log.e("TAG", "showAdIfSplashAvailable: 1" );

        if (BaseApplication.getAdModel().getAdsAppOpen().equalsIgnoreCase("Google")) {
            Log.e("TAG", "showAdIfSplashAvailable: Google 1" );
            if (!appIsShowingAd && isAdAvailable()) {
                Log.e("TAG", "showAdIfSplashAvailable: Google 2" );

                FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        CTCAppOpenManager.this.appOpenAd = null;
                        appIsShowingAd = false;
                        fetchAd();
                        onShowAdCompleteListener.onShowAdComplete();
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        onShowAdCompleteListener.onShowAdComplete();
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {
                        appIsShowingAd = true;
                    }
                };
                appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                appOpenAd.show(activity);
            } else {
                Log.e("TAG", "showAdIfSplashAvailable: Google 3" );

                appCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                    @Override
                    public void onAdLoaded(AppOpenAd ad) {
                        CTCAppOpenManager.this.appOpenAd = ad;
                        CTCAppOpenManager.this.appLoadTime = (new Date()).getTime();

                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                CTCAppOpenManager.this.appOpenAd = null;
                                appIsShowingAd = false;
                                fetchAd();
                                onShowAdCompleteListener.onShowAdComplete();
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                onShowAdCompleteListener.onShowAdComplete();
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                appIsShowingAd = true;
                            }
                        };
                        appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                        appOpenAd.show(appCurrentActivity);
                    }

                    @Override
                    public void onAdFailedToLoad(LoadAdError loadAdError) {
                        Log.e("TAG", "showAdIfSplashAvailable: Google 4 failed" );

                        onShowAdCompleteListener.onShowAdComplete();
                    }
                };
                AdRequest request = getAdRequest();
                AppOpenAd.load(appMyApp, BaseApplication.getAdModel().getAdsAppOpenId(), request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, appCallback);
            }
        }else {
            onShowAdCompleteListener.onShowAdComplete();
        }
    }





    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityStarted(Activity activity) {
        appCurrentActivity = activity;
    }

    @Override
    public void onActivityResumed(Activity activity) {
        appCurrentActivity = activity;
    }

    @Override
    public void onActivityStopped(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        appCurrentActivity = null;
    }

    @OnLifecycleEvent(ON_START)
    public void onStart() {
        if (BaseApplication.booleanSplashAds || !(appCurrentActivity instanceof SplashActivity)) {
             showAdIfAvailable();
        }
    }

    public boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
        long dateDifference = (new Date()).getTime() - this.appLoadTime;
        long numMilliSecondsPerHour = 3600000;
        return (dateDifference < (numMilliSecondsPerHour * numHours));
    }
}