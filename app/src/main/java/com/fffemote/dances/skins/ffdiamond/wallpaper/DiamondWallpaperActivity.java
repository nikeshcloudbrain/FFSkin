package com.fffemote.dances.skins.ffdiamond.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.StartActivity;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondWallpaperBinding;

public class DiamondWallpaperActivity extends AppCompatActivity {
    ActivityDiamondWallpaperBinding binding;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiamondWallpaperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.wa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getWall(R.drawable.wall1);
            }
        });

        binding.wa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getWall(R.drawable.wall2);

            }
        });
        binding.wa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall3);


            }
        });
        binding.wa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getWall(R.drawable.wall4);

            }
        });
        binding.wa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getWall(R.drawable.wall5);

            }
        });
        binding.wa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall6);


            }
        });
        binding.wa7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall7);


            }
        });
        binding.wa8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getWall(R.drawable.wall8);

            }
        });
        binding.wa9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall9);


            }
        });
        binding.wa10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall10);


            }
        });
        binding.wa11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall11);


            }
        });
        binding.wa12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall12);


            }
        });
        binding.wa13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall13);


            }
        });
        binding.wa14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWall(R.drawable.wall14);


            }
        });


    }

    public void getWall(int img) {
        CTCAppLoadAds.getInstance().showInterstitial(DiamondWallpaperActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWallpaperActivity.this, ViewWallpaperActivity.class);
                        intent.putExtra("wImg", img);
                        startActivity(intent);
                    }
                });

    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}