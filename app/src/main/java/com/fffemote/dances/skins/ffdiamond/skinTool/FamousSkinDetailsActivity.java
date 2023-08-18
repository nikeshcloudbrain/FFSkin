package com.fffemote.dances.skins.ffdiamond.skinTool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityFamousSkinDetailsBinding;

public class FamousSkinDetailsActivity extends AppCompatActivity {
ActivityFamousSkinDetailsBinding binding;
String fam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityFamousSkinDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Famous Skins");

        fam=getIntent().getStringExtra("fskin");
        if(fam.equals("ic1")){
            binding.fTitle.setText("Breakdancer Bundle");
            binding.fDes.setText("One of the ongogin Live events of free fire is the breakdancer bundle giveaway.The event is in collaboration with india content creators on YouTube. ");
        }else if(fam.equals("ic2")){
            binding.fTitle.setText("Sakura Bundle");
            binding.fDes.setText("Garena introduced the beautiful sakura Bundle Through the first season of Elite Pass and it rapidly become a famous charcter outfit after.");

        }else if(fam.equals("ic3")){
            binding.fTitle.setText("Hip Hop Bundle");
            binding.fDes.setText("Hip Hop Bundle is one of the most populer and rarest bundle in free fire.It was a part of the Elite Pass in Season2 and Become an uncommon bundle after its first removal");
        }else if(fam.equals("ic4")){
            binding.fTitle.setText("Green Criminal Bundle");
            binding.fDes.setText("Green Criminial is arguably the rarest free Fire Bundle as it was claimed by a small chuk of players when it was introduced in-game.Green Criminal is not available in the Free Fire Store.");

        }else if(fam.equals("ic5")){
            binding.fTitle.setText("Bunny Worriar Bundle");
            binding.fDes.setText("Bunny Warrior is another eye-grabbing Free Fire character outfit that has been one of the most unique bundle.This outfit was a part of the drw a Bunny event that granted a free turn to players daily to drw a bunnyon the mirror.");

        }else if(fam.equals("ic6")){
            binding.fTitle.setText("Red Criminal Bundle");
            binding.fDes.setText("Red Criminal Bundle top criminal fire criminal bundle free fire.The Criminal Bundle is one of the most beloved bundl of all time.");


        }else if(fam.equals("ic7")){
            binding.fTitle.setText("Clove");
            binding.fDes.setText("The Night Clown Bundle is one of the most sought-after bundles in the game.it was initially avaiable in November 2018 as a part of the diamonds royale.");

        }else if(fam.equals("ic8")){
            binding.fTitle.setText("Samurai Bundle");
            binding.fDes.setText("Zombifiend bundle in free Fire.This bundle was released back in 2019 when the game had very less.");

        }else if(fam.equals("ic9")){
            binding.fTitle.setText("King's Sword Bundle");
            binding.fDes.setText("The King Sword bundle has been in the in-game store for quite a while now it was initally added in march 2019,and at the ,It could be obtained by spending diamonds.");

        }


        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTCAppLoadAds.getInstance().showInterstitial(FamousSkinDetailsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(FamousSkinDetailsActivity.this, MyEmotesActivity.class));
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}