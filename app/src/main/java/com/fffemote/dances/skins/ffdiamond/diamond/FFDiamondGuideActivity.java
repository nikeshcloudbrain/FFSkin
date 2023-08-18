package com.fffemote.dances.skins.ffdiamond.diamond;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityFfdiamondGuideBinding;

public class FFDiamondGuideActivity extends AppCompatActivity {
ActivityFfdiamondGuideBinding binding;
String guide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFfdiamondGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeBottomDynamic(this, binding.frameViewAds);
        binding.tool.Ttext.setText("Diamond Guide");

        guide=getIntent().getStringExtra("Guide");

        if(guide.equals("DiamondGuide")){
            binding.GuideText.setText(R.string.dia_guide);
        }else if(guide.equals("Tips")){
            binding.GuideText.setText(R.string.tips_tricks);
        }

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