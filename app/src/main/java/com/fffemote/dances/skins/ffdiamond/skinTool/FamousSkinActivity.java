package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityFamousSkinBinding;

public class FamousSkinActivity extends AppCompatActivity {
ActivityFamousSkinBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFamousSkinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Famous Skins");

        binding.ic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic1");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.ic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic2");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.ic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic3");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.ic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic4");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.ic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic5");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.ic6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic6");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.ic7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic7");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.ic8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic8");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.ic9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(FamousSkinActivity.this, FamousSkinDetailsActivity.class);
                        intent.putExtra("fskin", "ic9");
                        startActivity(intent);
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