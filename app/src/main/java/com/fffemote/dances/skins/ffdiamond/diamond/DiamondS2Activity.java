package com.fffemote.dances.skins.ffdiamond.diamond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondS2Binding;

public class DiamondS2Activity extends AppCompatActivity {
ActivityDiamondS2Binding binding;
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondS2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.d2Apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.d2Apply.setVisibility(View.GONE);
                binding.animationView.setVisibility(View.VISIBLE);
                handler= new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.d2Apply.setVisibility(View.VISIBLE);
                        binding.animationView.setVisibility(View.GONE);
                        CTCAppLoadAds.getInstance().showInterstitial(DiamondS2Activity.this, new CTCAppLoadAds.AdCompleteListener() {
                            @Override
                            public void onAdCompleted() {
                                startActivity(new Intent(DiamondS2Activity.this, DiamondS3Activity.class));
                            }
                        });
                    }
                }, 1500L);
            }
        });

    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}