package com.fffemote.dances.skins.ffdiamond.adsp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.applovin.sdk.AppLovinSdkUtils;
import com.fffemote.dances.skins.ffdiamond.BaseApplication;

import com.fffemote.dances.skins.ffdiamond.BuildConfig;
import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.applovin.Inter;
import com.fffemote.dances.skins.ffdiamond.util.Constant;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CTCAppLoadAds {
    public final static int ARRAY_SIZE = 3;
    public static CTCAppLoadAds instance;

    //Interstitial
    private boolean isInterstitialAdLoading = false;
    private InterstitialAd interstitialGoogle = null;


    private NativeAd nativeOneGoogle = null;
    private NativeAd nativeTwoGoogle = null;

    //Native List


    //appLovin

    public static int isAlloaded = Constant.FAILED;
    private static ArrayList<MaxNativeAdView> alNativeAd = new ArrayList<>();
    private MaxAd nativeAd;

    boolean showAd;

    public static MaxInterstitialAd alInterAd;
    private int retryAttempt;
    public static MaxAdView alBannerAd;


    private final ArrayList<com.google.android.gms.ads.nativead.NativeAd> nativeAdsGoogle = new ArrayList<>();

    public static CTCAppLoadAds getInstance() {
        if (instance == null) {
            instance = new CTCAppLoadAds();
        }
        return instance;
    }

    public void setApplicationId(Activity activity) {
        try {
            ApplicationInfo ai = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), PackageManager.GET_META_DATA);
            ai.metaData.putString("com.google.android.gms.ads.APPLICATION_ID", BaseApplication.getAdModel().getAdsAppId());
        } catch (Exception e) {
            Log.e("Failed to load", e.getMessage());
        }
    }

    public void showOpenAdIfAvailable(Activity activity, AdCompleteListener listener) {
        Log.e("TAG", "showOpenAdIfAvailable: First");
        if (BaseApplication.getAdModel().getAdsSplash().equalsIgnoreCase("AppOpen")) {
            Log.e("TAG", "showOpenAdIfAvailable: Sec");

            BaseApplication.getInstance().showAdIfAvailable(activity, () -> {
                BaseApplication.booleanSplashAds = false;
                listener.onAdCompleted();
            });
        } else {
            Log.e("TAG", "showOpenAdIfAvailable: Third");

            BaseApplication.booleanSplashAds = false;
            listener.onAdCompleted();
        }
    }

    public interface AdCompleteListener {
        void onAdCompleted();
    }

    //Interstitial
    public void loadInterstitial(final Activity context) {
        if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("AppLovin")) {
            Log.d("TAG_onAdLoaded", "onAdLoaded: AppLovin1");
            loadInterstitialAppLovin(context);
        } else if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("Google")) {
            Log.d("TAG_onAdLoaded", "onAdLoaded: google1");
            loadInterstitialGoogle(context);
        }
    }

    public void loadInterstitialAppLovin(Activity activity) {
        if (Constant.Intervel > 0) {
            isAlloaded = Constant.LOADING;


            alInterAd = new MaxInterstitialAd(BaseApplication.getAdModel().getAdsApplovinInterId(), activity);
            alInterAd.setListener(new MaxAdListener() {
                @Override
                public void onAdLoaded(MaxAd ad) {
                    retryAttempt = 0;

                    isAlloaded = Constant.LOADED;
                    Log.e("TAG", "onAdLoad Loaded: 1");

                }

                @Override
                public void onAdDisplayed(MaxAd ad) {
                    showAd = true;
                    Log.e("TAG", "onAdLoad Display: 1");

                }

                @Override
                public void onAdHidden(MaxAd ad) {
                    loadInterstitial(activity);
                    Log.e("TAG", "onAdLoad Hidden: 1");
                    if (listener != null) {
                        listener.onAdCompleted();
                    }

                }

                @Override
                public void onAdClicked(MaxAd ad) {

                }

                @Override
                public void onAdLoadFailed(String adUnitId, MaxError error) {
                    // Interstitial ad failed to load
                    // AppLovin recommends that you retry with exponentially higher delays up to a maximum delay (in this case 64 seconds)
                    Log.e("TAG", "onAdLoad Faild: 1");


                    if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("AppLovin")) {
                        loadInterstitialGoogle(activity);
                    }

                }

                @Override
                public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                    // Interstitial ad failed to display. AppLovin recommends that you load the next ad.
                    Log.e("TAG", "onAdLoad Display Faild: 1");

                    loadInterstitialAppLovin(activity);
                }
            });

            alInterAd.loadAd();

        }
    }


    private void loadInterstitialGoogle(final Activity context) {
        if (interstitialGoogle == null && !isInterstitialAdLoading) {
            isInterstitialAdLoading = true;
            AdRequest adRequest = new AdRequest.Builder().build();
            com.google.android.gms.ads.interstitial.InterstitialAd.load(context, BaseApplication.getAdModel().getAdsInterstitialId(), adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd) {
                    interstitialGoogle = interstitialAd;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    interstitialGoogle = null;
                    isInterstitialAdLoading = false;

                }
            });
        }
    }

    public void showInterstitial(Activity context, AdCompleteListener listener) {
        this.listener = listener;
        if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("AppLovin")) {
            if (getInt(BaseApplication.ADS_COUNT_SHOW, 0) == (getBoolean("isFirstTime", false) ? BaseApplication.getAdModel().getAdsInterstitialCountShow() : BaseApplication.getAdModel().getAdsInterstitialCount())) {

                if (alInterAd.isReady()) {
                    Log.e("show", "Ads Show");
                    putBoolean("isFirstTime", false);
                    putInt(BaseApplication.ADS_COUNT_SHOW, 0);


                    alInterAd.showAd();


                } else {
                    if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("AppLovin")) {
                        loadInterstitialAppLovin(context);
                    }
                    if (listener != null) {
                        listener.onAdCompleted();
                    }
                }

            } else {
                putInt(BaseApplication.ADS_COUNT_SHOW, getInt(BaseApplication.ADS_COUNT_SHOW, 0) + 1);
                if (listener != null) {
                    listener.onAdCompleted();
                }
            }

        } else if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("Google")) {
            if (getInt(BaseApplication.ADS_COUNT_SHOW, 0) == (getBoolean("isFirstTime", false) ? BaseApplication.getAdModel().getAdsInterstitialCountShow() : BaseApplication.getAdModel().getAdsInterstitialCount())) {
                if (interstitialGoogle != null) {
                    interstitialGoogle.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            interstitialGoogle = null;
                            isInterstitialAdLoading = false;
                            putBoolean("isFirstTime", false);
                            putInt(BaseApplication.ADS_COUNT_SHOW, 0);
                            if (listener != null) {
                                listener.onAdCompleted();
                            }
                            if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("Google")) {
                                loadInterstitialGoogle(context);
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            interstitialGoogle = null;
                            isInterstitialAdLoading = false;
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            interstitialGoogle = null;
                        }
                    });
                    interstitialGoogle.show(context);
                } else {
                    loadInterstitial(context);
                    if (listener != null) {
                        listener.onAdCompleted();
                    }
                }
            } else {
                putInt(BaseApplication.ADS_COUNT_SHOW, getInt(BaseApplication.ADS_COUNT_SHOW, 0) + 1);
                if (listener != null) {
                    listener.onAdCompleted();
                }
            }
        }
    }

    public void splashAlInter(Activity activity, AdCompleteListener listener1) {
        listener = listener1;
        if (alInterAd.isReady()) {
            Log.e("show", "Ads Show");
            alInterAd.showAd();
        } else {
            loadInterstitialAppLovin(activity);
            if (listener != null) {
                listener.onAdCompleted();
            }
        }
    }

    AdCompleteListener listener;

    public void showInterstitialBack(Activity context, AdCompleteListener listener) {
        this.listener = listener;
        if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("AppLovin")) {
            if (getInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0) == (getBoolean("isBackFirstTime", false) ? BaseApplication.getAdModel().getAdsInterstitialBackCountShow() : BaseApplication.getAdModel().getAdsInterstitialBackCount())) {
                putBoolean("isBackFirstTime", false);


                if (alInterAd.isReady()) {
                    Log.e("show", "Ads Show");
                    putBoolean("isBackFirstTime", false);
                    putInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0);


                    alInterAd.showAd();


                } else {
                    if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("AppLovin")) {
                        loadInterstitialAppLovin(context);
                    }
                    if (listener != null) {
                        listener.onAdCompleted();
                    }
                }

            } else {
                putInt(BaseApplication.ADS_COUNT_BACK_SHOW, getInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0) + 1);
                if (listener != null) {
                    listener.onAdCompleted();
                }
            }
        } else if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("Google")) {
            if (getInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0) == (getBoolean("isBackFirstTime", false) ? BaseApplication.getAdModel().getAdsInterstitialBackCountShow() : BaseApplication.getAdModel().getAdsInterstitialBackCount())) {
                putBoolean("isBackFirstTime", false);
                if (interstitialGoogle != null) {
                    putInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0);
                    interstitialGoogle.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            interstitialGoogle = null;
                            isInterstitialAdLoading = false;
                            putBoolean("isBackFirstTime", false);
                            putInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0);
                            if (listener != null) {
                                listener.onAdCompleted();
                            }
                            if (BaseApplication.getAdModel().getAdsInterstitial().equalsIgnoreCase("Google")) {
                                loadInterstitialGoogle(context);
                            }
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            interstitialGoogle = null;
                            isInterstitialAdLoading = false;
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            interstitialGoogle = null;
                        }
                    });
                    interstitialGoogle.show(context);
                } else {
                    loadInterstitial(context);
                    if (listener != null) {
                        listener.onAdCompleted();
                    }
                }
            } else {
                putInt(BaseApplication.ADS_COUNT_BACK_SHOW, getInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0) + 1);
                if (listener != null) {
                    listener.onAdCompleted();
                }
            }

        }
    }

    //Banner
    public void showBanner(final Activity activity, final LinearLayout linearLayout) {

        if (BaseApplication.getAdModel().getAdsBanner().equalsIgnoreCase("AppLovin")) {
            loadAlBannerAds(activity, linearLayout);
        } else if (BaseApplication.getAdModel().getAdsBanner().equalsIgnoreCase("Google")) {
            loadBannerGoogle(activity, linearLayout);
        }
    }

    //Banner Google
    private void loadBannerGoogle(final Activity activity, final LinearLayout linearLayout) {
        com.google.android.gms.ads.AdView adView = new com.google.android.gms.ads.AdView(activity);
        adView.setAdUnitId(BaseApplication.getAdModel().getAdsBannerId());
        com.google.android.gms.ads.AdSize adSize = getAdSize(activity);
        adView.setAdSize(adSize);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdListener(new com.google.android.gms.ads.AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                linearLayout.removeAllViews();
                linearLayout.addView(adView);
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                loadBannerGoogle(activity, linearLayout);
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);

            }
        });
    }

    public void loadAlBannerAds(Activity activity, final LinearLayout linearLayout) {
        Log.e("TAG", "alBannerLoad");


        alBannerAd = new MaxAdView(BaseApplication.getAdModel().getAdsApplovinBannerId(), MaxAdFormat.BANNER, activity);

        int width = ViewGroup.LayoutParams.MATCH_PARENT;

        int heightDp = MaxAdFormat.BANNER.getAdaptiveSize(activity).getHeight();
        int heightPx = AppLovinSdkUtils.dpToPx(activity, heightDp);

        alBannerAd.setBackgroundColor(Color.BLACK);
        alBannerAd.setLayoutParams(new FrameLayout.LayoutParams(width, heightPx));
        alBannerAd.setExtraParameter("adaptive_banner", "true");

        alBannerAd.setListener(new MaxAdViewAdListener() {
            @Override
            public void onAdExpanded(MaxAd ad) {

            }

            @Override
            public void onAdCollapsed(MaxAd ad) {

            }

            @Override
            public void onAdLoaded(MaxAd ad) {
                isAlloaded = Constant.LOADED;
            }

            @Override
            public void onAdDisplayed(MaxAd ad) {

            }

            @Override
            public void onAdHidden(MaxAd ad) {

            }

            @Override
            public void onAdClicked(MaxAd ad) {

            }

            @Override
            public void onAdLoadFailed(String adUnitId, MaxError error) {

                if (BaseApplication.getAdModel().getAdsBanner().equalsIgnoreCase("AppLovin")) {
                    loadBannerGoogle(activity, linearLayout);
                }
            }

            @Override
            public void onAdDisplayFailed(MaxAd ad, MaxError error) {

            }
        });

        alBannerAd.loadAd();
        showAlBannerAds(activity, linearLayout);
    }

    public void showAlBannerAds(Activity activity, LinearLayout linearLayout) {
        if (alBannerAd != null && isAlloaded == Constant.LOADED) {
            linearLayout.removeAllViews();
            linearLayout.addView(alBannerAd);

            isAlloaded = Constant.FAILED;
//            loadAlBannerAds(activity);
        } else {
            Log.e("TAG", "showAlBannerAds: Not Show");
            if (BaseApplication.getAdModel().getAdsBanner().equalsIgnoreCase("AppLovin")) {
                loadBannerGoogle(activity, linearLayout);
            }
        }
    }


    private com.google.android.gms.ads.AdSize getAdSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);
        return com.google.android.gms.ads.AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }

    //Native
    public void showNativeMediaFix(Activity activity, FrameLayout frameViewAds) {
        showNative(activity, frameViewAds, "Fix");
    }

    public void showNativeBottomDynamic(Activity activity, FrameLayout frameViewAds) {
        showNative(activity, frameViewAds, "No");
    }

    public void showNativeMediaMatch(Activity activity, FrameLayout frameViewAds) {
        showNative(activity, frameViewAds, "Yes");
    }


    public void displayListNativeAds(Activity activity, FrameLayout frameViewAds) {
        if (BaseApplication.getAdModel().getAdsNative().equalsIgnoreCase("Google")) {

            showAdmobList(activity, frameViewAds);

        } else if (BaseApplication.getAdModel().getAdsNative().equalsIgnoreCase("AppLovin")) {
            showAlList(activity, frameViewAds);

        }
    }


    private void showAdmobList(Activity activity, FrameLayout frameViewAds) {
        if (nativeAdsGoogle.size() > 0) {
            Collections.shuffle(nativeAdsGoogle);
            frameViewAds.setVisibility(View.VISIBLE);
            frameViewAds.removeAllViews();
            NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_fix, null);
            inflateNativeGoogle(activity, nativeAdsGoogle.get(0), adView);
            frameViewAds.addView(adView);
        }
    }

    private void showAlList(Activity activity, FrameLayout frameViewAds) {
        if (alNativeAd.size() > 0) {
            Collections.shuffle(alNativeAd);
            frameViewAds.setVisibility(View.VISIBLE);
            frameViewAds.removeAllViews();
            NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_fix, null);
            if (alNativeAd.get(0).getParent() != null) {
                ((ViewGroup) alNativeAd.get(0).getParent()).removeView(alNativeAd.get(0)); // <- fix
            }
            frameViewAds.addView(alNativeAd.get(0));
            loadAlNativeAds(activity, frameViewAds, "Fix");
        }
    }

    private void showNative(Activity activity, FrameLayout frameViewAds, String showMedia) {
        if (BaseApplication.getAdModel().getAdsNative().equalsIgnoreCase("AppLovin")) {

            showALNativeAds(activity, null, frameViewAds, showMedia);
        } else if (BaseApplication.getAdModel().getAdsNative().equalsIgnoreCase("Google")) {
            showNativeGoogle(activity, frameViewAds, showMedia);
        }
    }

    //Native Google
    public void preloadNativeGoogleOne(Activity activity) {
        if (BaseApplication.getAdModel().getAdsNativePreload().equalsIgnoreCase("Yes")) {
            loadNativeGoogleOne(activity);

        }
    }

    private void loadNativeGoogleOne(Activity activity) {
        nativeTwoGoogle = null;
        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(true).build();
        NativeAdOptions adOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();
        AdLoader appLoaderNativeOne = new AdLoader.Builder(activity, BaseApplication.getAdModel().getAdsNativeId()).forNativeAd(nativeAd -> {
            nativeOneGoogle = nativeAd;
            if (nativeAdsGoogle.size() < ARRAY_SIZE) {
                nativeAdsGoogle.add(nativeOneGoogle);
            }
        }).withAdListener(new com.google.android.gms.ads.AdListener() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError adError) {
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        }).withNativeAdOptions(adOptions).build();

        AdRequest adRequest = new AdRequest.Builder().build();
        appLoaderNativeOne.loadAd(adRequest);

    }

    private void loadNativeGoogleTwo(Activity activity) {
        nativeOneGoogle = null;
        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(true).build();

        NativeAdOptions adOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();

        AdLoader appLoaderNativeTwo = new AdLoader.Builder(activity, BaseApplication.getAdModel().getAdsNativeId()).forNativeAd(nativeAd -> {
            nativeTwoGoogle = nativeAd;
            if (nativeAdsGoogle.size() < ARRAY_SIZE) {
                nativeAdsGoogle.add(nativeTwoGoogle);
            }
        }).withAdListener(new com.google.android.gms.ads.AdListener() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError adError) {

            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        }).withNativeAdOptions(adOptions).build();
        AdRequest adRequest = new AdRequest.Builder().build();
        appLoaderNativeTwo.loadAd(adRequest);
    }

    @SuppressLint("InflateParams")
    private void showNativeGoogle(Activity activity, FrameLayout frameViewAds, String showMedia) {
        if (nativeOneGoogle != null) {
            frameViewAds.setVisibility(View.VISIBLE);
            frameViewAds.removeAllViews();
            NativeAdView adView = null;

            if (showMedia.equalsIgnoreCase("Yes")) {
                adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native, null);
            } else if (showMedia.equalsIgnoreCase("No")) {
                if (BaseApplication.getAdModel().getAdsNativeViewId() == 1) {
                    adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_small, null);
                } else if (BaseApplication.getAdModel().getAdsNativeViewId() == 2) {
                    adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_small_2, null);
                }
            } else if (showMedia.equalsIgnoreCase("Fix")) {
                adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_fix, null);
            }

            inflateNativeGoogle(activity, nativeOneGoogle, adView);
            frameViewAds.addView(adView);

            if (!BaseApplication.IS_NATIVE_AD_LAST) {
                nativeTwoGoogle = null;
                loadNativeGoogleTwo(activity);
            }

        } else if (nativeTwoGoogle != null) {
            frameViewAds.setVisibility(View.VISIBLE);
            frameViewAds.removeAllViews();

            NativeAdView adView = null;

            if (showMedia.equalsIgnoreCase("Yes")) {
                adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native, null);
            } else if (showMedia.equalsIgnoreCase("No")) {
                if (BaseApplication.getAdModel().getAdsNativeViewId() == 1) {
                    adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_small, null);
                } else if (BaseApplication.getAdModel().getAdsNativeViewId() == 2) {
                    adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_small_2, null);
                }
            } else if (showMedia.equalsIgnoreCase("Fix")) {
                adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_fix, null);
            }

            inflateNativeGoogle(activity, nativeTwoGoogle, adView);
            frameViewAds.addView(adView);

            if (!BaseApplication.IS_NATIVE_AD_LAST) {
                nativeOneGoogle = null;
                loadNativeGoogleOne(activity);
            }
        } else {
            showNativeGoogleDefault(activity, frameViewAds, showMedia);
        }
    }

    private void showNativeGoogleDefault(Activity activity, FrameLayout frameViewAds, String showMedia) {
        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(true).build();
        NativeAdOptions adOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();

        @SuppressLint("InflateParams") AdLoader adLoaderNativeOne = new AdLoader.Builder(activity, BaseApplication.getAdModel().getAdsNativeId()).forNativeAd(nativeAd -> {
            frameViewAds.setVisibility(View.VISIBLE);
            frameViewAds.removeAllViews();

            if (nativeAdsGoogle.size() < ARRAY_SIZE) {
                nativeAdsGoogle.add(nativeAd);
            }

            NativeAdView adView = null;
            if (showMedia.equalsIgnoreCase("Yes")) {
                adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native, null);
            } else if (showMedia.equalsIgnoreCase("No")) {
                if (BaseApplication.getAdModel().getAdsNativeViewId() == 1) {
                    adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_small, null);
                } else if (BaseApplication.getAdModel().getAdsNativeViewId() == 2) {
                    adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_small_2, null);
                }
            } else if (showMedia.equalsIgnoreCase("Fix")) {
                adView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.google_native_fix, null);
            }

            inflateNativeGoogle(activity, nativeAd, adView);
            frameViewAds.addView(adView);

        }).withAdListener(new com.google.android.gms.ads.AdListener() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                showALNativeAds(activity, null, frameViewAds, null);
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                showNative(activity, frameViewAds, showMedia);
            }
        }).withNativeAdOptions(adOptions).build();

        AdRequest adRequest = new AdRequest.Builder().build();
        adLoaderNativeOne.loadAd(adRequest);
    }

    private void inflateNativeGoogle(Activity activity, com.google.android.gms.ads.nativead.NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView(adView.findViewById(R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        //adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        AppCompatButton install = adView.findViewById(R.id.ad_call_to_action);
        install.setText(nativeAd.getCallToAction());
        if (BaseApplication.getAdModel().getAdsNativeColor().equalsIgnoreCase("Yes")) {
            install.getBackground().setColorFilter(activity.getColor(R.color.color_1), PorterDuff.Mode.SRC_ATOP);
        } else if (BaseApplication.getAdModel().getAdsNativeColor().equalsIgnoreCase("No")) {
            install.getBackground().setColorFilter(activity.getColor(R.color.color_2), PorterDuff.Mode.SRC_ATOP);
        } else {
            install.getBackground().setColorFilter(activity.getColor(R.color.color_1), PorterDuff.Mode.SRC_ATOP);
        }

        adView.setCallToActionView(install);

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.GONE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.GONE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
            CardView ad_app_icon_cards = adView.findViewById(R.id.ad_app_icon_cards);
            ad_app_icon_cards.setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
            CardView ad_app_icon_cards = adView.findViewById(R.id.ad_app_icon_cards);
            ad_app_icon_cards.setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.GONE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.GONE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.GONE);
        } else {
            ((RatingBar) adView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.GONE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        adView.setNativeAd(nativeAd);

        VideoController vc = nativeAd.getMediaContent().getVideoController();
        if (nativeAd.getMediaContent() != null && nativeAd.getMediaContent().hasVideoContent()) {
            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
    }


    //Shared preference added at 24-06-2023
    private static SharedPreferences getPreference() {
        return BaseApplication.getInstance().getSharedPreferences("DEFAULT_PREFERENCE" + BuildConfig.VERSION_CODE, Context.MODE_PRIVATE);
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences sharedPreferences = getPreference();
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    private boolean getBoolean(String key, boolean defaultValue) {
        try {
            SharedPreferences sharedPreferences = getPreference();
            return sharedPreferences.getBoolean(key, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static void putInt(String key, int value) {
        SharedPreferences sharedPreferences = getPreference();
        sharedPreferences.edit().putInt(key, value).apply();
    }

    private int getInt(String key, int defaultValue) {
        try {
            SharedPreferences sharedPreferences = getPreference();
            return sharedPreferences.getInt(key, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static void setModelAd(CTCModelAd modelAd) {
        if (modelAd != null) {
            SharedPreferences sharedPreferences = getPreference();
            sharedPreferences.edit().putString(BaseApplication.TAG, new Gson().toJson(modelAd)).apply();
        }
    }

    public static CTCModelAd getModelAd(CTCModelAd defaultModelAd) {
        try {
            SharedPreferences sharedPreferences = getPreference();
            String data = sharedPreferences.getString(BaseApplication.TAG, null);
            if (data == null || data.trim().equals("")) {
                return defaultModelAd;
            }
            return new Gson().fromJson(data, CTCModelAd.class);
        } catch (Exception e) {
            return defaultModelAd;
        }
    }


    public void showAlNativeAds(Activity activity, FrameLayout adContainer, String showMedia) {
        if (alNativeAd.size() > 0) {


            adContainer.removeAllViews();

            if (alNativeAd.get(0).getParent() != null) {
                ((ViewGroup) alNativeAd.get(0).getParent()).removeView(alNativeAd.get(0)); // <- fix
            }


            adContainer.addView(alNativeAd.get(0));


            isAlloaded = Constant.FAILED;
        } else {
            //googleshow
            Log.e("TAG", "showAlNativeAds: Not Show");
            showNativeGoogleDefault(activity, adContainer, showMedia);

        }
    }

    public void loadAlNativeAds(Activity activity, FrameLayout nativeAdContainer, String showmedia) {

        MaxNativeAdView adView = null;

        if (showmedia.equalsIgnoreCase("Yes")) {
            MaxNativeAdViewBinder binder = new MaxNativeAdViewBinder.Builder(R.layout.google_native)
                    .setTitleTextViewId(R.id.ad_headline)
                    .setBodyTextViewId(R.id.ad_body)
                    .setIconImageViewId(R.id.ad_app_icon)
                    .setMediaContentViewGroupId(R.id.ad_media)
                    .setCallToActionButtonId(R.id.ad_call_to_action)
                    .build();
            adView = new MaxNativeAdView(binder, activity);
        } else if (showmedia.equalsIgnoreCase("No")) {
            if (BaseApplication.getAdModel().getAdsNativeViewId() == 1) {
                MaxNativeAdViewBinder binder = new MaxNativeAdViewBinder.Builder(R.layout.google_native_small)
                        .setTitleTextViewId(R.id.ad_headline)
                        .setBodyTextViewId(R.id.ad_body)
                        .setIconImageViewId(R.id.ad_app_icon)
                        .setMediaContentViewGroupId(R.id.ad_media)
                        .setCallToActionButtonId(R.id.ad_call_to_action)
                        .build();
                adView = new MaxNativeAdView(binder, activity);
            } else if (BaseApplication.getAdModel().getAdsNativeViewId() == 2) {
                MaxNativeAdViewBinder binder = new MaxNativeAdViewBinder.Builder(R.layout.google_native_small_2)
                        .setTitleTextViewId(R.id.ad_headline)
                        .setBodyTextViewId(R.id.ad_body)
                        .setIconImageViewId(R.id.ad_app_icon)
                        .setMediaContentViewGroupId(R.id.ad_media)
                        .setCallToActionButtonId(R.id.ad_call_to_action)
                        .build();
                adView = new MaxNativeAdView(binder, activity);
            }
        } else if (showmedia.equalsIgnoreCase("Fix")) {
            MaxNativeAdViewBinder binder = new MaxNativeAdViewBinder.Builder(R.layout.google_native_fix)
                    .setTitleTextViewId(R.id.ad_headline)
                    .setBodyTextViewId(R.id.ad_body)
                    .setIconImageViewId(R.id.ad_app_icon)
                    .setMediaContentViewGroupId(R.id.ad_media)
                    .setCallToActionButtonId(R.id.ad_call_to_action)
                    .build();
            adView = new MaxNativeAdView(binder, activity);
        }
        AppCompatButton install = adView.findViewById(R.id.ad_call_to_action);
        if (BaseApplication.getAdModel().getAdsNativeColor().equalsIgnoreCase("Yes")) {
            install.getBackground().setColorFilter(activity.getColor(R.color.color_1), PorterDuff.Mode.SRC_ATOP);
        } else if (BaseApplication.getAdModel().getAdsNativeColor().equalsIgnoreCase("No")) {
            install.getBackground().setColorFilter(activity.getColor(R.color.color_2), PorterDuff.Mode.SRC_ATOP);
        } else {
            install.getBackground().setColorFilter(activity.getColor(R.color.color_1), PorterDuff.Mode.SRC_ATOP);
        }


        MaxNativeAdLoader adLoader = new MaxNativeAdLoader(BaseApplication.getAdModel().getAdsApplovinNativeId(), activity);
        adLoader.setNativeAdListener(new MaxNativeAdListener() {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                Log.e("TAG", "onNativeAdLoad: ");

                // Clean up any pre-existing native ad to prevent memory leaks.
                if (nativeAd != null) {
                    adLoader.destroy(nativeAd);
                }
                alNativeAd.add(nativeAdView);

                // Save ad for cleanup.
                nativeAd = ad;

                // Add ad view to view.
                nativeAdContainer.setVisibility(View.VISIBLE);
                nativeAdContainer.removeAllViews();
                nativeAdContainer.addView(nativeAdView);
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                // We recommend retrying with exponentially higher delays up to a maximum delay
                Log.e("TAG", "onNativeAdLoadFailed: " + error.getMessage());
                if (BaseApplication.getAdModel().getAdsBanner().equalsIgnoreCase("AppLovin")) {
                    showNativeGoogleDefault(activity, nativeAdContainer, showmedia);
                }

            }

            @Override
            public void onNativeAdClicked(final MaxAd ad) {
                // Optional click callback
            }
        });

        adLoader.loadAd(adView);
    }

    public void showALNativeAds(Activity activity, Dialog dialog, FrameLayout adLayout, String showMedia
    ) {


        loadAlNativeAds(activity, adLayout, showMedia);


        if (adLayout == null) {
            adLayout = getFrameLayout(activity, dialog);
        }

        if (adLayout == null)
            return;


        showAlNativeAds(activity, adLayout, showMedia);


    }

    public FrameLayout getFrameLayout(Activity activity, Dialog dialog) {
        if (dialog != null) {
            return dialog.findViewById(R.id.adFrameLarge);
        } else {
            return activity.findViewById(R.id.adFrameLarge);
        }
    }


    public TextView getTextLayout(Activity activity, Dialog dialog) {
        if (dialog != null) {
            return dialog.findViewById(R.id.adSpaceLarge);
        } else {
            return activity.findViewById(R.id.adSpaceLarge);
        }
    }


}
