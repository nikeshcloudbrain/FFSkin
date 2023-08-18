package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityTopVehiclesBinding;

public class TopVehiclesActivity extends AppCompatActivity {
ActivityTopVehiclesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTopVehiclesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Top Vehicle Skins");

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        binding.sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TopVehiclesActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TopVehiclesActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.ic_sport_car);
                        intent.putExtra("type", "veh");
                        intent.putExtra("vehT", "sports");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.monster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TopVehiclesActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TopVehiclesActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.ic_monster_car);
                        intent.putExtra("type", "veh");
                        intent.putExtra("vehT", "mon");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.motocycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TopVehiclesActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TopVehiclesActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.ic_moto);
                        intent.putExtra("type", "veh");
                        intent.putExtra("vehT", "moto");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.ambhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(TopVehiclesActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(TopVehiclesActivity.this, DetailsActivity.class);
                        intent.putExtra("map", R.drawable.ic_ambhibiam);
                        intent.putExtra("type", "veh");
                        intent.putExtra("vehT", "ambhi");
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