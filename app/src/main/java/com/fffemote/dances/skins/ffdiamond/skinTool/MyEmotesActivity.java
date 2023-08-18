package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.EmoteAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityMyEmotesBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class MyEmotesActivity extends AppCompatActivity {
ActivityMyEmotesBinding binding;
EmoteAdapter emoteAdapter;
ArrayList<dress> eList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyEmotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Emotes");

        eList.add(new dress("PACK SKIN VIP FFIRE 1.67.3-v28", R.drawable.banner2));
        eList.add(new dress("PACK SKIN VIP FFIRE ON30-v27",R.drawable.banner3));
        eList.add(new dress("PACK SKIN VIP FFIRE ON30-v26",R.drawable.banner4));
        eList.add(new dress("PACK SKIN VIP FFIRE ON30-v25",R.drawable.banner5));
        eList.add(new dress("PACK SKIN VIP FFIRE ON30-v24",R.drawable.banner6));
        eList.add(new dress("PACK SKIN VIP FFIRE ON30-v23",R.drawable.banner7));
        eList.add(new dress("PACK SKIN VIP FFIRE ON30-v22",R.drawable.banner8));
        eList.add(new dress("DATA ORIGANAL SKIN-FILE RESET",R.drawable.banner1));

        binding.rvDress.setLayoutManager(new LinearLayoutManager(this));
        emoteAdapter = new EmoteAdapter(eList,this,this);
        binding.rvDress.setAdapter(emoteAdapter);

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