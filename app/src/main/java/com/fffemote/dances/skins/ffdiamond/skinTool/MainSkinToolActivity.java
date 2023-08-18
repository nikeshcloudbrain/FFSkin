package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityMainSkinToolBinding;

public class MainSkinToolActivity extends AppCompatActivity {
ActivityMainSkinToolBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainSkinToolBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Skin Options");

        binding.getSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainSkinToolActivity.this, SubSkinToolActivity.class));
                    }
                });
            }
        });
        binding.getProDress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainSkinToolActivity.this, SubSkinToolActivity.class));
                    }
                });

            }
        });
        binding.howTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainSkinToolActivity.this, HowUseActivity.class));
                    }
                });

            }
        });
        binding.TopGun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(MainSkinToolActivity.this, GunSkinActivity.class);
                        intent.putExtra("Goto", "main");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.TopVeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainSkinToolActivity.this, TopVehiclesActivity.class));
                    }
                });

            }
        });
        binding.TreMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainSkinToolActivity.this, TrendingMapsActivity.class));
                    }
                });

            }
        });
        binding.FamSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(MainSkinToolActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(MainSkinToolActivity.this, FamousSkinActivity.class));
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