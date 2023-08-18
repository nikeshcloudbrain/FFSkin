package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {
ActivityDetailsBinding binding;
String type;
String veh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Vehicles");

        type=getIntent().getStringExtra("type");
        if(type.equals("veh")){
            binding.dTxt.setVisibility(View.VISIBLE);
            veh = getIntent().getStringExtra("vehT");
            if(veh.equals("sports")){
                binding.dTxt.setText("This car has a very clear advantage over the rest: it is the fastest vehicale in Free Diamond.It's true that it can't withstand as many blows as others, but the top speed at which it reaches attracts all players who are speed lovers. Don't hesitate to drive one of these cars as soon as you find one especially if you're away from the safe Zone");
            }else if(veh.equals("mon")){
                binding.dTxt.setText("The Monster Truck is the biggest and toughest vehicle.its hard to destory with gunshots and grenades, but the downside is that its a bit sllow. As it is immense, if you manage to reach an enemy with this vehicle, it is usual to eliminate it from a single charge");

            }else if(veh.equals("moto")){
                binding.dTxt.setText("The Motorcycle has a perfect combination of speed and handling, which is why many players prefer it to other vehicles. However, it has the disadvantage of exposing the rider, so if you don't go fast, you'll be an easy target to hit.");

            }else if(veh.equals("ambhi")){
                binding.dTxt.setText("If you see this vehicle and you need to cross a river, don't even think about it: use this amphibian. Driven by the water, this four-wheeled bike gives you total movement versatillity across both Free Diamond maps. As you might expect , it's often found near areas where there's a river nearby");

            }
        }else{
            binding.dTxt.setVisibility(View.GONE);

        }
        binding.mapI.setImageResource(getIntent().getIntExtra("map", R.drawable.santa_catarina));
        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(DetailsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(DetailsActivity.this, MyEmotesActivity.class));
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