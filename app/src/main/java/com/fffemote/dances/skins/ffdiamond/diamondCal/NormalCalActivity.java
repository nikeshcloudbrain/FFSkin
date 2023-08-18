package com.fffemote.dances.skins.ffdiamond.diamondCal;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityBasicCalBinding;

public class NormalCalActivity extends AppCompatActivity {
ActivityBasicCalBinding binding;
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBasicCalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Diamond Calculator");

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        binding.btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.eTDi.getText().toString().equals("")){
                    binding.eTDi.setError("Please Enter Diamonds");
                }else{
                    total= Integer.parseInt(binding.eTDi.getText().toString());
                    total=total*60;
                    binding.total.setText(String.valueOf(total));
                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}