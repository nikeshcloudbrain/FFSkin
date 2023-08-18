package com.fffemote.dances.skins.ffdiamond.favourite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.adapter.FavEmoteAdapter;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityFavoriteEmoteBinding;

import java.util.ArrayList;
import java.util.List;

public class FavoriteEmoteActivity extends AppCompatActivity {
ActivityFavoriteEmoteBinding binding;
    private ActorViewModel actorViewModal;
FavEmoteAdapter rowEmoteAdapter;
GridLayoutManager mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFavoriteEmoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tool.Ttext.setText("Favourite Emotes");

        actorViewModal=new ViewModelProvider(this).get(ActorViewModel.class);
        actorViewModal.getAllActor().observe(this, new Observer<List<Actor>>() {
            @Override
            public void onChanged(List<Actor> actorList) {
                if(actorList.size()==0){
                    binding.noData.setVisibility(View.VISIBLE);
                }else{

                    binding.noData.setVisibility(View.GONE);
                    mLayout=new GridLayoutManager(FavoriteEmoteActivity.this, 3);

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
                    binding.rvFav.setLayoutManager( mLayout);
                    rowEmoteAdapter = new FavEmoteAdapter((ArrayList<Actor>) actorList,FavoriteEmoteActivity.this,FavoriteEmoteActivity.this);
                    binding.rvFav.setAdapter(rowEmoteAdapter);
                }



                Log.d("main", "onChanged: "+actorList);
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