package com.fffemote.dances.skins.ffdiamond.Emotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adapter.RowEmoteAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityPbgEmoteBinding;
import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;

public class PbgEmoteActivity extends AppCompatActivity {
ActivityPbgEmoteBinding binding;
    ArrayList<dress> emotList = new ArrayList<>();
    RowEmoteAdapter rowEmoteAdapter;
    GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPbgEmoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tool.Ttext.setText("Pbg Emotes");


        emotList.add(new dress("Affirmative", R.drawable.affirmative));
        emotList.add(new dress("Air guitar", R.drawable.air_guitar));
        emotList.add(new dress("Annoying", R.drawable.annoying));
        emotList.add(new dress("Beast mode",R.drawable.beast_mode));
        emotList.add(new dress("Beg",R.drawable.beg));
        emotList.add(new dress("Boast",R.drawable.boast));
        emotList.add(new dress("Boast 2",R.drawable.boast_2));
        emotList.add(new dress("Break dance",R.drawable.break_dance));
        emotList.add(new dress( "Celebrate",R.drawable.celebrate));
        emotList.add(new dress("Clap",R.drawable.clap));
        emotList.add(new dress("Clean up", R.drawable.clean_up));
        emotList.add(new dress("Come here",R.drawable.come_here));
        emotList.add(new dress("Cower",R.drawable.cower));
        emotList.add(new dress("Cry",R.drawable.cry));
        emotList.add(new dress("Dance jixiewu",R.drawable.dance_jixiewu));
        emotList.add(new dress("Dance panama",R.drawable.dance_panama));
        emotList.add(new dress("Dance shuaiquan", R.drawable.dance_shuaiquan));
        emotList.add(new dress("Dance step",R.drawable.dance_step));
        emotList.add(new dress("Dance taishi",R.drawable.dance_taishi));
        emotList.add(new dress("Dance yaolan",R.drawable.dance_yaolan));
        emotList.add(new dress("Deaths glare",R.drawable.deaths_glare));
        emotList.add(new dress("Dragonlee",R.drawable.dragonlee));
        emotList.add(new dress("Draw",R.drawable.draw));
        emotList.add(new dress("Eat my dust",R.drawable.eat_my_dust));
        emotList.add(new dress("Emotion 02",R.drawable.emotion02));
        emotList.add(new dress("Go",R.drawable.go));
        emotList.add(new dress("Good to go",R.drawable.good_to_go));
        emotList.add(new dress("Gracious bow",R.drawable.gracious_bow));
        emotList.add(new dress("Gun show",R.drawable.gun_show));
        emotList.add(new dress("Hello",R.drawable.hello));
        emotList.add(new dress("Impatient",R.drawable.impatient));
        emotList.add(new dress("Jealous",R.drawable.jealous));
        emotList.add(new dress("Jig dance",R.drawable.jig_dance));
        emotList.add(new dress("Keep silent",R.drawable.keep_silent));
        emotList.add(new dress("Kick",R.drawable.kick));
        emotList.add(new dress("Kong fu",R.drawable.kong_fu));
        emotList.add(new dress("Kungfu bow",R.drawable.kungfu_bow));
        emotList.add(new dress("Laugh",R.drawable.laugh));
        emotList.add(new dress("Loosen up",R.drawable.loosen_up));
        emotList.add(new dress("Loyalty",R.drawable.loyalty));
        emotList.add(new dress("Negative",R.drawable.negative));
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
        binding.rvpbg.setLayoutManager( mLayout);
        rowEmoteAdapter = new RowEmoteAdapter(emotList,this,this);
        binding.rvpbg.setAdapter(rowEmoteAdapter);

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