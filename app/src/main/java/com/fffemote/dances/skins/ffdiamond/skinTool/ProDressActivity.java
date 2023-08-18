package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.DressAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityProDressBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class ProDressActivity extends AppCompatActivity {
ActivityProDressBinding binding;

ArrayList<dress> dList = new ArrayList<>();
DressAdapter dressAdapter;
GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProDressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Pro Dress Skin");

        dList.add(new dress("Season 1", R.drawable.ic_season1));
        dList.add(new dress("Hip Hop Bundle",R.drawable.ic_hip_hop));
        dList.add(new dress("Season 3",R.drawable.ic_season3));
        dList.add(new dress("Season 4",R.drawable.ic_season4));
        dList.add(new dress("Season 5",R.drawable.ic_season5));
        dList.add(new dress("Season 6",R.drawable.ic_season6));
        dList.add(new dress("D Bee",R.drawable.ic_dbee));
        dList.add(new dress("Dasha",R.drawable.ic_dasha));
        dList.add(new dress("D Jai",R.drawable.ic_djai));
        dList.add(new dress("DK",R.drawable.ic_dk));
        dList.add(new dress("Dluquets",R.drawable.ic_dluquets));
        dList.add(new dress("Dmaro",R.drawable.ic_dmaro));
        dList.add(new dress("Dshirou",R.drawable.ic_dshirou));
        dList.add(new dress("Dxayne",R.drawable.ic_dxayne));
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
        dressAdapter = new DressAdapter(dList,this,this,"other");
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