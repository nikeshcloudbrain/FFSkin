package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.DressAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityTrendingBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class TrendingActivity extends AppCompatActivity {
ActivityTrendingBinding binding;
ArrayList<dress> tList = new ArrayList<>();
DressAdapter dressAdapter;
GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityTrendingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Trending Skins");

        tList.add(new dress("Red Crime", R.drawable.ic_red_criminal));
        tList.add(new dress("Hip Hop Bundle", R.drawable.ic_hip_hop));
        tList.add(new dress("Blue Criminal", R.drawable.ic_blue_criminal));
        tList.add(new dress("Throne Emote", R.drawable.ic_throne_emote));
        tList.add(new dress("Titan Scar", R.drawable.ic_titanscar));
        tList.add(new dress("Golden Mp40", R.drawable.ic_golden_mp40));

        mLayout=new GridLayoutManager(this, 2);

        mLayout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(dressAdapter.getItemViewType(position)){
                    case 100:
                        return 2;
                    case 101:
                        return 1;
                    default:
                        return -1;
                }
            }
        });
        binding.rvDress.setLayoutManager( mLayout);
        dressAdapter = new DressAdapter(tList,this,this,"other");
        binding.rvDress.setAdapter(dressAdapter);

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