package com.fffemote.dances.skins.ffdiamond.Emotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.RowEmoteAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityJoeEmoteBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class JoeEmoteActivity extends AppCompatActivity {
ActivityJoeEmoteBinding binding;

    ArrayList<dress> emotList = new ArrayList<>();
    RowEmoteAdapter rowEmoteAdapter;
    GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityJoeEmoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tool.Ttext.setText("Joe Emotes");

        emotList.add(new dress("Hello", R.drawable.hello));
        emotList.add(new dress("Flowers of Love",R.drawable.flowers_of_love));
        emotList.add(new dress("FFWC Throne",R.drawable.ffwc_throne));
        emotList.add(new dress("Top Dj",R.drawable.tops_dj));
        emotList.add(new dress("Power of money",R.drawable.power_of_money));
        emotList.add(new dress("Eat my dust",R.drawable.eat_my_dust));
        emotList.add(new dress( "Kongfu",R.drawable.kong_fu));
        emotList.add(new dress("Tea Time", R.drawable.tea_bagging));

        emotList.add(new dress("LOL",R.drawable.lol));
        emotList.add(new dress("Push up",R.drawable.push_up));
        emotList.add(new dress("Provoke",R.drawable.provoke));
        emotList.add(new dress("Chicken",R.drawable.chicken));
        emotList.add(new dress("Shoot Dance",R.drawable.shoot_dance));
        emotList.add(new dress("Baby Shark",R.drawable.baby_shark));
        emotList.add(new dress("Mummy Dance",R.drawable.mummy_dance));

        emotList.add(new dress("Push-up",R.drawable.push_up));
        emotList.add(new dress("Dangerous Game",R.drawable.dangerous_game));
        emotList.add(new dress("Jaguar Dance", R.drawable.jaguar_dance));
        emotList.add(new dress("Threaten",R.drawable.threaten));
        emotList.add(new dress("Shake With Me",R.drawable.shake_with_me));
        emotList.add(new dress("Furious Slam",R.drawable.furious_slam));
        emotList.add(new dress("Moon Flip",R.drawable.moon_flip));
        emotList.add(new dress("Wiggle walk",R.drawable.wiggle_walk));
        emotList.add(new dress("Provoke",R.drawable.provoke));
        emotList.add(new dress("Battle Dance",R.drawable.battle_dance));
        emotList.add(new dress("High Five",R.drawable.high_five));
        emotList.add(new dress("Shake it Up",R.drawable.shake_it_up));
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
        binding.rvJoe.setLayoutManager(mLayout);
        rowEmoteAdapter = new RowEmoteAdapter(emotList,this,this);
        binding.rvJoe.setAdapter(rowEmoteAdapter);

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