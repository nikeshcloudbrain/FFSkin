package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityTrendingMapsBinding;

public class TrendingMapsActivity extends AppCompatActivity {
    ActivityTrendingMapsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTrendingMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Trending Skins");

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        binding.santa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TrendingMapsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TrendingMapsActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.santa_catarina);
                        intent.putExtra("type", "map");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.bay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TrendingMapsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TrendingMapsActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.bayfront);
                        intent.putExtra("type", "map");

                        startActivity(intent);
                    }
                });
            }
        });
        binding.council.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TrendingMapsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TrendingMapsActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.council_hall);
                        intent.putExtra("type", "map");

                        startActivity(intent);
                    }
                });
            }
        });
        binding.oldHam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TrendingMapsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TrendingMapsActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.old_hampton);
                        intent.putExtra("type", "map");

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