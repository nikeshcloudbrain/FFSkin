package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityEmoteDetailsBinding;
import com.fffemote.dances.skins.ffdiamond.diamond.DiamondS2Activity;
import com.fffemote.dances.skins.ffdiamond.model.dress;

public class EmoteDetailsActivity extends AppCompatActivity {
ActivityEmoteDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEmoteDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        binding.emotI.setImageResource(getIntent().getIntExtra("eIcon", R.drawable.banner1));


        if(getIntent().getStringExtra("eName").equals("PACK SKIN VIP FFIRE 1.67.3-v28")){
            binding.tool.Ttext.setText("Skin 1.67.3-v28");

        } else if(getIntent().getStringExtra("eName").equals("PACK SKIN VIP FFIRE ON30-v27")){
            binding.tool.Ttext.setText("Skin ON30-v27");

        } else if(getIntent().getStringExtra("eName").equals("PACK SKIN VIP FFIRE ON30-v26")){
            binding.tool.Ttext.setText("Skin ON30-v26");

        }else if(getIntent().getStringExtra("eName").equals("PACK SKIN VIP FFIRE ON30-v25")) {
            binding.tool.Ttext.setText("Skin ON30-v25");

        } else if(getIntent().getStringExtra("eName").equals("PACK SKIN VIP FFIRE ON30-v24")){
            binding.tool.Ttext.setText("Skin ON30-v24");

        }else if(getIntent().getStringExtra("eName").equals("PACK SKIN VIP FFIRE ON30-v23")){
            binding.tool.Ttext.setText("Skin ON30-v23");

        }else if(getIntent().getStringExtra("eName").equals("PACK SKIN VIP FFIRE ON30-v22")){
            binding.tool.Ttext.setText("Skin ON30-v22");

        }else if(getIntent().getStringExtra("eName").equals("DATA ORIGANAL SKIN-FILE RESET")){
            binding.tool.Ttext.setText("Original Skin FILE RESET");

        }
        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.getFreeDiamond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmoteDetailsActivity.this, DiamondS2Activity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}