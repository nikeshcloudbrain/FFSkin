package com.fffemote.dances.skins.ffdiamond;




import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppOpenManager;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCModelAd;
import com.fffemote.dances.skins.ffdiamond.api.RenClient;
import com.fffemote.dances.skins.ffdiamond.applovin.MainAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivitySplashBinding;
import com.fffemote.dances.skins.ffdiamond.encrypt.EasyAES;
import com.google.android.gms.ads.MobileAds;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SplashActivity extends AppCompatActivity {

    SharedPreferences sh;
    boolean InCheck;
    ActivitySplashBinding binding;
    int VERSION = 0;


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivitySplashBinding inflate = ActivitySplashBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView(inflate.getRoot());

        sh = getSharedPreferences("intro", Context.MODE_PRIVATE);


        InCheck = sh.getBoolean("iCheck", false);
      CTCAppLoadAds.putBoolean("isFirstTime", true);
        CTCAppLoadAds.putBoolean("isBackFirstTime", true);

        startSplash();


    }


    public void startSplash() {
        PackageManager manager = getPackageManager();
        PackageInfo info = null;

        try {
            info = manager.getPackageInfo(getPackageName(), 0);
            VERSION = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            VERSION = BuildConfig.VERSION_CODE;
        }
        callUpdateApi();
    }

    private void callUpdateApi() {

        String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        JsonObject object = new JsonObject();
        try {
            object.addProperty("AndroidId", android_id);
            object.addProperty("VersionCode", 1);
            object.addProperty("PkgName", BuildConfig.APPLICATION_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RenClient.getInstance().getApi().getUpdatesResponse(EasyAES.encryptString(object.toString()))
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            BaseApplication.adModel = null;
                            JSONObject jsonObject = new JSONObject(EasyAES.decryptString(response.body().string()));
//                            Log.e("TAG", "onResponse: "+jsonObject.toString() );
                            CTCModelAd model = new Gson().fromJson(jsonObject.toString(), CTCModelAd.class);
                            CTCAppLoadAds.setModelAd(model);
                            CTCAppLoadAds.putInt(BaseApplication.ADS_COUNT_SHOW, 0);
                            CTCAppLoadAds.putInt(BaseApplication.ADS_COUNT_BACK_SHOW, 0);
                            AppLovinSdk.getInstance(SplashActivity.this).setMediationProvider(AppLovinMediationProvider.MAX);
                            AppLovinSdk.getInstance(SplashActivity.this).initializeSdk(new AppLovinSdk.SdkInitializationListener() {
                                @Override
                                public void onSdkInitialized(AppLovinSdkConfiguration config) {
                                    Log.e("TAG", "initialized");
                                    new CTCAppOpenManager(BaseApplication.getInstance());
                                }
                            });
                            try {
                                ApplicationInfo ai = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
                                Bundle bundle = ai.metaData;
                                ai.metaData.putString("applovin.sdk.key",model.getAdsApplovinSdkKey());//you can replace your key APPLICATION_ID here
                            } catch (PackageManager.NameNotFoundException e) {
                                Log.e("TAG", "Failed to load meta-data, NameNotFound: " + e.getMessage());
                            } catch (NullPointerException e) {
                                Log.e("TAG", "Failed to load meta-data, NullPointer: " + e.getMessage());
                            }

                            if (BaseApplication.getAdModel().getAdsAppUpDate().equalsIgnoreCase("Yes")) {
                                showUpdateDialog();
                            } else {
                                gotoSkip();
                            }
                        } catch (Exception e) {
                            Log.e("TAG", e.toString());
                            e.printStackTrace();
                            gotoSkip();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("TAG", t.getMessage());
                        gotoSkip();
                    }
                });
    }


    public void gotoSkip() {

        if (BaseApplication.getAdModel().getAdsNative().equalsIgnoreCase("Google")) {
            CTCAppLoadAds.getInstance().setApplicationId(this);

            MobileAds.initialize(getApplicationContext(), initializationStatus -> {
            });

            CTCAppLoadAds.getInstance().preloadNativeGoogleOne(SplashActivity.this);

            CTCAppLoadAds.getInstance().loadInterstitial(SplashActivity.this);

            CTCAppLoadAds.getInstance().showOpenAdIfAvailable(this, this::goNext);
        } else {

            CTCAppLoadAds.getInstance().loadInterstitial(SplashActivity.this);
            if (BaseApplication.getAdModel().getAdsSplash().equalsIgnoreCase("AppOpen")) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CTCAppLoadAds.getInstance().splashAlInter(SplashActivity.this, SplashActivity.this::goNext);
                    }
                }, 3000);

            }else{
                            new Handler().postDelayed(this::goNext, 2000);

            }

        }
    }


    public void showUpdateDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
        dialog.findViewById(R.id.btnUpdate)
                .setOnClickListener(v -> {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(BaseApplication.getAdModel().getAdsAppUpDateLink())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    public void goNext() {
        if (BaseApplication.getAdModel().getExtraScreen().equalsIgnoreCase("Yes")) {
            if (InCheck) {
                startActivity(new Intent(SplashActivity.this, StartActivity.class));

            } else {
                startActivity(new Intent(SplashActivity.this, IntroScreenActivity.class));

            }

        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));

        }

    }




}
