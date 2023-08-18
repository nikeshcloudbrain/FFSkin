package com.fffemote.dances.skins.ffdiamond;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adapter.IntroViewPagerAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityIntroScreenBinding;
import com.fffemote.dances.skins.ffdiamond.model.NextScreen;
import com.fffemote.dances.skins.ffdiamond.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class IntroScreenActivity extends AppCompatActivity {
ActivityIntroScreenBinding binding;
    IntroViewPagerAdapter introViewPagerAdapter;
    private ViewPager screenPager;
    int next;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        final List<NextScreen> mList = new ArrayList<>();
        mList.add(new NextScreen("FF", " Screen Emote", "FF Emotes - Dances, Skins - the unlimited free app is easy to use and you can get elite pass bundles, weapon skin, and more rare items.", R.drawable.next1));
        mList.add(new NextScreen("FF", " Skin Tools", "a simple app that allows users to entertain by getting Elite Pass Bundles, Emotes & Gun Skins for entertainment.", R.drawable.next2));

        screenPager = findViewById(R.id.idViewPager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);
        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        screenPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                Log.e("vv", "onPageSelected: " + arg0);
              if (arg0 == 0) {
                    next = 0;
                    binding.btnNext1.setBackgroundTintList(getResources().getColorStateList(R.color.colorMainLight));

                } else if (arg0 == 1) {
                    next = 1;
                    binding.btnNext1.setBackgroundTintList(getResources().getColorStateList(R.color.colorMain));

                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int num) {


            }
        });


        binding.btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (next == 1) {
                    sharedPreferences = getSharedPreferences("intro", MODE_PRIVATE);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();

                    myEdit.putBoolean("iCheck", true);
                    myEdit.commit();

                        startActivity(new Intent(IntroScreenActivity.this, StartActivity.class));


                } else {

                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Constant.showRateDialog(IntroScreenActivity.this, false);

    }

}