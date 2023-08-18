package com.fffemote.dances.skins.ffdiamond.diamond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondOptionBinding;
import com.fffemote.dances.skins.ffdiamond.diamondCal.DiamondCalMainActivity;

public class DiamondOptionActivity extends AppCompatActivity {
ActivityDiamondOptionBinding binding;

    @Override
    protected void onResume() {
        super.onResume();
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondOptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Diamond Options");

        binding.ffdiamondGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondOptionActivity.this, () ->
                startActivity(new Intent(DiamondOptionActivity.this,MainDiamondGuideActivity.class)));
            }
        });

        binding.ffcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondOptionActivity.this, () ->
                startActivity(new Intent(DiamondOptionActivity.this, DiamondCalMainActivity.class)));
            }
        });

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }


    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}