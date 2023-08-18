package com.fffemote.dances.skins.ffdiamond.wallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityViewWallpaperBinding;

public class ViewWallpaperActivity extends AppCompatActivity {
    ActivityViewWallpaperBinding binding;
    Boolean isAllFabsVisible;
    int Wall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewWallpaperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeBottomDynamic(this, binding.frameViewAds);

        Wall = getIntent().getIntExtra("wImg", R.drawable.wall1);
        binding.viewimage.setImageResource(Wall);
        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.addHome.setVisibility(View.GONE);
        binding.addPersonFab.setVisibility(View.GONE);
        binding.addHomeText.setVisibility(View.GONE);
        binding.addPersonText.setVisibility(View.GONE);


        isAllFabsVisible = false;


        binding.addFab.setOnClickListener(view -> {
            if (!isAllFabsVisible) {

                binding.addHome.setVisibility(View.VISIBLE);
                binding.addPersonFab.setVisibility(View.VISIBLE);
                binding.addHomeText.setVisibility(View.VISIBLE);
                binding.addPersonText.setVisibility(View.VISIBLE);


                isAllFabsVisible = true;
            } else {

                binding.addHome.setVisibility(View.GONE);
                binding.addPersonFab.setVisibility(View.GONE);
                binding.addHomeText.setVisibility(View.GONE);
                binding.addPersonText.setVisibility(View.GONE);


                isAllFabsVisible = false;
            }
        });

        binding.addHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap icon = BitmapFactory.decodeResource(getResources(), Wall);

                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        wallpaperManager.setBitmap(icon, null, true, WallpaperManager.FLAG_SYSTEM);


                        Toast.makeText(ViewWallpaperActivity.this, "Wallpaper Set", Toast.LENGTH_SHORT).show();

                    } else {
                        wallpaperManager.setBitmap(icon);
                    }
                } catch (Exception e) {
                    Log.e("Tag", "ee", e);
                }

            }
        });

        binding.addPersonFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap icon = BitmapFactory.decodeResource(getResources(), Wall);

                WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                        wallpaperManager.setBitmap(icon, null, true, WallpaperManager.FLAG_LOCK);
                        Toast.makeText(ViewWallpaperActivity.this, "Wallpaper Set", Toast.LENGTH_SHORT).show();

                    } else {
                        wallpaperManager.setBitmap(icon);
                    }
                } catch (Exception e) {
                    Log.e("Tag", "ee", e);
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}