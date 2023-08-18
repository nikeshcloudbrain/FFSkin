package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityGunDetailsBinding;

public class GunDetailsActivity extends AppCompatActivity {
ActivityGunDetailsBinding binding;
String gun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGunDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Gun Skins");

        gun=getIntent().getStringExtra("guns");
        if(gun.equals("Mag - 7")){
            binding.gunI.setImageResource(R.drawable.mag_7_image);
        }else if(gun.equals("Parafal")){
            binding.gunI.setImageResource(R.drawable.mag_7_image);

        }else if(gun.equals("Aug")){
            binding.gunI.setImageResource(R.drawable.mag_7_image);

        }else if(gun.equals("Mp5")){
            binding.gunI.setImageResource(R.drawable.mag_7_image);

        }else if(gun.equals("Vvs")){
            binding.gunI.setImageResource(R.drawable.mag_7_image);

        }else if(gun.equals("M1887")){
            binding.gunI.setImageResource(R.drawable.mag_7_image);

        }

        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GunDetailsActivity.this, MyEmotesActivity.class));
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