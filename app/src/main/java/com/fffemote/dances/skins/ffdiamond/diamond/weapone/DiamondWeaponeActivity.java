package com.fffemote.dances.skins.ffdiamond.diamond.weapone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondWeaponeBinding;

public class DiamondWeaponeActivity extends AppCompatActivity {
ActivityDiamondWeaponeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondWeaponeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Emotes Weapones");

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 onBackPressed();
             }
         });
         binding.tool.Ttext.setText("Weapon Details");
        binding.weapons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWeaponeActivity.this, DiamondWeaponeDetailsActivity.class);
                        intent.putExtra("weap", "an94");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.weapons2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWeaponeActivity.this, DiamondWeaponeDetailsActivity.class);
                        intent.putExtra("weap", "m4a1");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.weapons3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWeaponeActivity.this, DiamondWeaponeDetailsActivity.class);
                        intent.putExtra("weap", "m14");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.weapons4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWeaponeActivity.this, DiamondWeaponeDetailsActivity.class);
                        intent.putExtra("weap", "ak");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.weapons5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWeaponeActivity.this, DiamondWeaponeDetailsActivity.class);
                        intent.putExtra("weap", "scar");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.weapons6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWeaponeActivity.this, DiamondWeaponeDetailsActivity.class);
                        intent.putExtra("weap", "groza");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.weapons7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondWeaponeActivity.this, DiamondWeaponeDetailsActivity.class);
                        intent.putExtra("weap", "famas");
                        startActivity(intent);
                    }
                });
            }
        });

    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}