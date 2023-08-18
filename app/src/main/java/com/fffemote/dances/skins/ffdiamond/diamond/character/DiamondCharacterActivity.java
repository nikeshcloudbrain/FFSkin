package com.fffemote.dances.skins.ffdiamond.diamond.character;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.CharacterAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondCharacterBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class DiamondCharacterActivity extends AppCompatActivity {
ActivityDiamondCharacterBinding binding;

ArrayList<dress> mList = new ArrayList<>();
CharacterAdapter characterAdapter;
GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondCharacterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mList.add(new dress("SHIMADA HAYATO", R.drawable.ic_hayato));
        mList.add(new dress("MOCO",R.drawable.ic_moco));
        mList.add(new dress("WUKONG",R.drawable.ic_wukong));
        mList.add(new dress("ANTONIO",R.drawable.ic_antonio));
        mList.add(new dress("ANDREW",R.drawable.ic_andrew));
        mList.add(new dress("KELLY",R.drawable.ic_kelly));
        mList.add(new dress("OLIVIA",R.drawable.ic_olivia));
        mList.add(new dress("FORD",R.drawable.ic_ford));
        mList.add(new dress("NIKITA",R.drawable.ic_nikita));
        mList.add(new dress("MISHA",R.drawable.ic_misha));
        mList.add(new dress( "MAXIM",R.drawable.ic_maxim));
        mList.add(new dress("KLA",R.drawable.ic_kla));
        mList.add(new dress("PALOMA",R.drawable.ic_paloma));
        mList.add(new dress( "MLGUEL",R.drawable.ic_miguel));
        mList.add(new dress("CAROLINE",R.drawable.ic_carroline));
        mLayout=new GridLayoutManager(this, 2);

        mLayout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(characterAdapter.getItemViewType(position)){
                    case 100:
                        return 2;
                    case 101:
                        return 1;
                    default:
                        return -1;
                }
            }
        });

        binding.tool.Ttext.setText("Character");
        binding.rvCh.setLayoutManager(mLayout);
        characterAdapter = new CharacterAdapter(mList,this,this);
        binding.rvCh.setAdapter(characterAdapter);


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