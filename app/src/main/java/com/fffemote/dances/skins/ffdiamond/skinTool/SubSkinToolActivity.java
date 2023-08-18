package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivitySubSkinToolBinding;

public class SubSkinToolActivity extends AppCompatActivity {
    ActivitySubSkinToolBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySubSkinToolBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Sub Skins Options");

        binding.gunSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(SubSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(SubSkinToolActivity.this, GunSkinActivity.class);
                        intent.putExtra("Goto", "sub");
                        startActivity(intent);
                    }
                });

            }
        });
        binding.rareEmotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(SubSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(SubSkinToolActivity.this, RareEmotesActivity.class));
                    }
                });
            }
        });
        binding.proDress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(SubSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(SubSkinToolActivity.this, ProDressActivity.class));
                    }
                });
            }
        });
        binding.refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(SubSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(SubSkinToolActivity.this, ReferActivity.class));
                    }
                });
            }
        });
        binding.Trending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(SubSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(SubSkinToolActivity.this, TrendingActivity.class));
                    }
                });

            }
        });
        binding.how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(SubSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(SubSkinToolActivity.this, HowUseActivity.class));
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