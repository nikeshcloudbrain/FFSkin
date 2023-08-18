package com.fffemote.dances.skins.ffdiamond.diamond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityMainDiamondGuideBinding;
import com.fffemote.dances.skins.ffdiamond.diamond.character.DiamondCharacterActivity;
import com.fffemote.dances.skins.ffdiamond.diamond.vehicle.DiamondVehicleActivity;
import com.fffemote.dances.skins.ffdiamond.diamond.weapone.DiamondWeaponeActivity;

public class MainDiamondGuideActivity extends AppCompatActivity {
ActivityMainDiamondGuideBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainDiamondGuideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Diamond Guide");

        binding.ffdiamondGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainDiamondGuideActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent=new Intent(MainDiamondGuideActivity.this, FFDiamondGuideActivity.class);
                        intent.putExtra("Guide","DiamondGuide");
                        startActivity(intent);
                    }
                });

            }
        });

        binding.ffTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainDiamondGuideActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(MainDiamondGuideActivity.this, FFDiamondGuideActivity.class);
                        intent.putExtra("Guide", "Tips");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.ffCharacters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainDiamondGuideActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainDiamondGuideActivity.this, DiamondCharacterActivity.class));
                    }
                });
            }
        });



        binding.ffVehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainDiamondGuideActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainDiamondGuideActivity.this, DiamondVehicleActivity.class));
                    }
                });
            }
        });

        binding.ffWeapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainDiamondGuideActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainDiamondGuideActivity.this, DiamondWeaponeActivity.class));
                    }
                });
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