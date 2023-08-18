package com.fffemote.dances.skins.ffdiamond.diamond.vehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondVehicleBinding;

public class DiamondVehicleActivity extends AppCompatActivity {
ActivityDiamondVehicleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondVehicleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        binding.tool.Ttext.setText("Vehicle");

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        binding.vehicle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondVehicleActivity.this, DiamondVehicleDetailsActivity.class);
                        intent.putExtra("veh", "Veh1");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.vehicle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondVehicleActivity.this, DiamondVehicleDetailsActivity.class);
                        intent.putExtra("veh", "Veh2");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.vehicle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondVehicleActivity.this, DiamondVehicleDetailsActivity.class);
                        intent.putExtra("veh", "Veh3");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.vehicle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondVehicleActivity.this, DiamondVehicleDetailsActivity.class);
                        intent.putExtra("veh", "Veh4");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.vehicle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondVehicleActivity.this, DiamondVehicleDetailsActivity.class);
                        intent.putExtra("veh", "Veh5");
                        startActivity(intent);
                    }
                });
            }
        });
        binding.vehicle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondVehicleActivity.this, DiamondVehicleDetailsActivity.class);
                        intent.putExtra("veh", "Veh6");
                        startActivity(intent);
                    }
                });
            }
        });

        binding.vehicle7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        Intent intent = new Intent(DiamondVehicleActivity.this, DiamondVehicleDetailsActivity.class);
                        intent.putExtra("veh", "Veh7");
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