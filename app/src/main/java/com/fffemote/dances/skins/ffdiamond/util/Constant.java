package com.fffemote.dances.skins.ffdiamond.util;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.fffemote.dances.skins.ffdiamond.BaseApplication;
import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;


public class Constant {





    public static void Log(String message) {
        Log.e("errorLog", message);
    }



    public static int LOADING = 0;
    public static int LOADED = 1;
    public static int FAILED = 2;
    public static int Intervel = 1;



    public static native String getMainApi();

    public static native String getKey1();

    public static native String getKey2();


    public static void showRateDialog(Activity activity, boolean isAds) {
        try {
            Dialog dialog = new Dialog(activity);
            dialog.setContentView(R.layout.dialog_exit);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setGravity(Gravity.CENTER);
            dialog.setOnShowListener(dialogInterface -> {
                if (BaseApplication.getAdModel().getAdsExit().equalsIgnoreCase("YES")) {
                    dialog.findViewById(R.id.cardViewAdsMain).setVisibility(View.VISIBLE);
                    new Handler().postDelayed(() -> CTCAppLoadAds.getInstance().showNativeMediaFix(activity, dialog.findViewById(R.id.frameViewAdsMain)), 500);
                } else {
                    dialog.findViewById(R.id.cardViewAdsMain).setVisibility(View.GONE);
                }
            });
            dialog.findViewById(R.id.btnYes).setOnClickListener(view -> {
                dialog.dismiss();
                activity.finishAffinity();
            });

            dialog.findViewById(R.id.btnNo).setOnClickListener(view -> {
                dialog.dismiss();
            });

            dialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
