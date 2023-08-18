package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.RareAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityRareEmotesBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class RareEmotesActivity extends AppCompatActivity {
ActivityRareEmotesBinding binding;
ArrayList<dress> rList = new ArrayList<>();
RareAdapter rareAdapter;
GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRareEmotesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Rare Emote Skins");

        rList.add(new dress("Hello", R.drawable.hello2));
        rList.add(new dress("Flower of Love", R.drawable.flowers_of_love));
        rList.add(new dress("Selfie", R.drawable.selfie));
        rList.add(new dress("Pirates's Flag", R.drawable.pirates_flag));
        rList.add(new dress("Top DJ", R.drawable.tops_dj));
        rList.add(new dress("Power of Money", R.drawable.power_of_money));
        rList.add(new dress("Kongfu", R.drawable.kong_fu));
        rList.add(new dress("provoke", R.drawable.provoke2));
        rList.add(new dress("Shoot Dance", R.drawable.shoot_dance));
        rList.add(new dress("Baby Dark", R.drawable.mummy_dance));
        rList.add(new dress("Mummy Dance", R.drawable.mummy_dance));
        rList.add(new dress("Mummy Dance", R.drawable.mummy_dance));
        rList.add(new dress("Mummy Dance", R.drawable.mummy_dance));
        rList.add(new dress("Push-up", R.drawable.push_up));
        rList.add(new dress("Devil's Move", R.drawable.devils_move));
        rList.add(new dress("Faurious Slam", R.drawable.furious_slam));
        rList.add(new dress("Moon Flip", R.drawable.moon_flip));
        rList.add(new dress("Wiggle Walk", R.drawable.wiggle_walk));
        rList.add(new dress("High five", R.drawable.high_five));
        rList.add(new dress("shake Up", R.drawable.shake_it_up));
        rList.add(new dress("Glorious Spin", R.drawable.glorius_spin));
        rList.add(new dress("Crane Kick", R.drawable.crane_kick));
        rList.add(new dress("Jig Dance", R.drawable.jig_dance));
        rList.add(new dress("Solu Shaking", R.drawable.soul_shaking));
        rList.add(new dress("Death Glare", R.drawable.deaths_glare));
        rList.add(new dress("Break Dance", R.drawable.break_dance));
        mLayout=new GridLayoutManager(RareEmotesActivity.this, 2);

        mLayout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(rareAdapter.getItemViewType(position)){
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
        rareAdapter = new RareAdapter(rList,this,this);
        binding.rvDress.setAdapter(rareAdapter);

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