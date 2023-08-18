package com.fffemote.dances.skins.ffdiamond.diamond;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondS3Binding;

public class DiamondS3Activity extends AppCompatActivity {
ActivityDiamondS3Binding binding;
Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondS3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.d3Apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.d3Apply.setVisibility(View.GONE);
                binding.animationView.setVisibility(View.VISIBLE);
                handler= new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.d3Apply.setVisibility(View.VISIBLE);
                        binding.animationView.setVisibility(View.GONE);
                        Toast.makeText(DiamondS3Activity.this, "Package Active after 24 Hours", Toast.LENGTH_SHORT).show();
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