package com.fffemote.dances.skins.ffdiamond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.Emotes.MainEmoteActivity;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityMainBinding;
import com.fffemote.dances.skins.ffdiamond.diamond.DiamondOptionActivity;
import com.fffemote.dances.skins.ffdiamond.skinTool.MainSkinToolActivity;
import com.fffemote.dances.skins.ffdiamond.util.Constant;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        binding.diamondGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainActivity.this, () ->
                        startActivity(new Intent(MainActivity.this, DiamondOptionActivity.class)));
            }
        });

        binding.ffSkinTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainActivity.this, () ->
                startActivity(new Intent(MainActivity.this, MainSkinToolActivity.class)));

            }
        });

        binding.ffEmotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainActivity.this, () ->
                startActivity(new Intent(MainActivity.this, MainEmoteActivity.class)));

            }
        });


        binding.header.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (BaseApplication.getAdModel().getExtraScreen().equalsIgnoreCase("Yes")) {
            CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);

        }else{
            Constant.showRateDialog(MainActivity.this, false);

        }
    }

}