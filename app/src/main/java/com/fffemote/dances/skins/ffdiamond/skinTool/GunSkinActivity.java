package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.DressAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityGunSkinBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class GunSkinActivity extends AppCompatActivity {
ActivityGunSkinBinding binding;
ArrayList<dress> gList = new ArrayList<>();
DressAdapter dressAdapter;
String Go;
GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityGunSkinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Gun Skins");

        Go=getIntent().getStringExtra("Goto");
        gList.add(new dress("Mag - 7", R.drawable.ic_mag7));
        gList.add(new dress("Parafal",R.drawable.ic_parafal));
        gList.add(new dress("Aug",R.drawable.ic_aug));
        gList.add(new dress("Mp5",R.drawable.ic_mp5));
        gList.add(new dress("Vvs",R.drawable.ic_vvs));
        gList.add(new dress("M1887",R.drawable.ic_m1887));
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
        dressAdapter = new DressAdapter(gList,this,this,Go);
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