package com.fffemote.dances.skins.ffdiamond.diamond.vehicle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondVehicleDetailsBinding;
import com.fffemote.dances.skins.ffdiamond.diamond.DiamondS2Activity;

public class DiamondVehicleDetailsActivity extends AppCompatActivity {
ActivityDiamondVehicleDetailsBinding binding;

String vehicle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondVehicleDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Vehicle");

        vehicle=getIntent().getStringExtra("veh");
        if(vehicle.equals("Veh1")){
            binding.vehImg.setImageResource(R.drawable.ic_sportscar);
            binding.vehTxt.setText("\n\n\n This car has a very obvious advantage over other cars: it is the fastest car in Free Fire. Indeed, it cannot withstand as many blows as other blows, but the maximum speed it reaches attracts all players who like speed.");
            binding.tool.Ttext.setText("Sports Car");
        }else if(vehicle.equals("Veh2")){
            binding.vehImg.setImageResource(R.drawable.ic_monstercar);
            binding.vehTxt.setText("\n\n\n  Huge truck is the largest and strongest vehicle. It is difficult to destroy it with gunshots and grenades, but the disadvantage is that the speed is a bit slow. Since this is huge, if you manage to reach the enemy with this car, you can usually eliminate it with a single charge.");
            binding.tool.Ttext.setText("Monster Car");

        }else if(vehicle.equals("Veh3")){
            binding.vehImg.setImageResource(R.drawable.ic_moto_bike);
            binding.vehTxt.setText("\n\n\n This motorcycle has a perfect combination of speed and handling, which is why many players like it. However, the disadvantage of this is that it exposes the rider, so if you dont go fast, you can easily become a target.");
            binding.tool.Ttext.setText("Motor Cycle");

        }else if(vehicle.equals("Veh4")){
            binding.vehImg.setImageResource(R.drawable.ic_amphibian);
            binding.vehTxt.setText("\n\n\n If you see this car and need to cross the river, dont even think about it: use this amphibian. Driven by water, this four-wheel bike provides you with all the sporting versatility on two Free Fire maps.");
            binding.tool.Ttext.setText("Ambhibian");

        }else if(vehicle.equals("Veh5")){
            binding.vehImg.setImageResource(R.drawable.ic_militaryjeep);
            binding.vehTxt.setText("\n\n\n This military jeep is one of the most versatile vehicles on the Free Fire map, but it is not very fast. If you are driving on a steep hill, you will notice that it is difficult for the jeep to overcome the slope, in fact, it is common for you to end up downhill.");
            binding.tool.Ttext.setText("Military Jeep");

        }else if(vehicle.equals("Veh6")){
            binding.vehImg.setImageResource(R.drawable.ic_tuktuk);
            binding.vehTxt.setText("\n\n\n  Tuk Tuk is a slow vehicle, weak and abundant in the area. Dont use it unless you want to move quickly in the same village. Because it is a bit narrow, you can shuttle between houses, so even if it sounds ridiculous, it is useful in chasing.");
            binding.tool.Ttext.setText("Tuk Tuk");

        }else if(vehicle.equals("Veh7")){
            binding.vehImg.setImageResource(R.drawable.ic_van);
            binding.vehTxt.setText("\n\n\n The VAN is another vehicle that is very abundant on the map. It has a certain resistance, moderate speed, and provides good protection for the driver. If you dont need to return to a safe area immediately, this is a good choice to get from one town to another.");
            binding.tool.Ttext.setText("Van");

        }


        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DiamondVehicleDetailsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(DiamondVehicleDetailsActivity.this, DiamondS2Activity.class));
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