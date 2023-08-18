package com.fffemote.dances.skins.ffdiamond.Emotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.RowEmoteAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityFfireBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class FfireActivity extends AppCompatActivity {
ActivityFfireBinding binding;
ArrayList<dress> emotList = new ArrayList<>();
RowEmoteAdapter rowEmoteAdapter;
GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFfireBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("FFire Emotes");

        emotList.add(new dress("Applause", R.drawable.applause));
        emotList.add(new dress("Baby shark", R.drawable.baby_shark));
        emotList.add(new dress("Battle dance", R.drawable.battle_dance));
        emotList.add(new dress("Chicken",R.drawable.chicken));
        emotList.add(new dress("Crane kick",R.drawable.crane_kick));
        emotList.add(new dress("Dab",R.drawable.dab));
        emotList.add(new dress("Dangerous game",R.drawable.dangerous_game));
        emotList.add(new dress("Devils move",R.drawable.devils_move));
        emotList.add(new dress( "Ffwc hrone",R.drawable.ffwc_throne));
        emotList.add(new dress("Flowers of love",R.drawable.flowers_of_love));
        emotList.add(new dress("Flushing", R.drawable.flushing));
        emotList.add(new dress("Furious slam",R.drawable.furious_slam));
        emotList.add(new dress("Glorius spin",R.drawable.glorius_spin));
        emotList.add(new dress("Hello2",R.drawable.hello2));
        emotList.add(new dress("High five",R.drawable.high_five));
        emotList.add(new dress("Jaguar dance",R.drawable.jaguar_dance));
        emotList.add(new dress("Lol", R.drawable.lol));
        emotList.add(new dress("Moon flip",R.drawable.moon_flip));
        emotList.add(new dress("Mummy dance",R.drawable.mummy_dance));
        emotList.add(new dress("Party dance",R.drawable.party_dance));
        emotList.add(new dress("Provoke2",R.drawable.provoke2));
        emotList.add(new dress("Push up",R.drawable.push_up));
        emotList.add(new dress("Shake it up",R.drawable.shake_it_up));
        emotList.add(new dress("Shake with me",R.drawable.shake_with_me));
        emotList.add(new dress("Sharyuken",R.drawable.sharyuken));
        emotList.add(new dress("Shoot dance",R.drawable.shoot_dance));
        emotList.add(new dress("Threaten",R.drawable.threaten));
        mLayout=new GridLayoutManager(this, 3);

        mLayout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(rowEmoteAdapter.getItemViewType(position)){
                    case 100:
                        return 3;
                    case 101:
                        return 1;
                    default:
                        return -1;
                }
            }
        });
        binding.rvfire.setLayoutManager( mLayout);

        rowEmoteAdapter = new RowEmoteAdapter(emotList,this,this);
        binding.rvfire.setAdapter(rowEmoteAdapter);

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
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