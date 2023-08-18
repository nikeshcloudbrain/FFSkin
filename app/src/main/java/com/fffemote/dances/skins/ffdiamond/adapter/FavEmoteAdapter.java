package com.fffemote.dances.skins.ffdiamond.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;

import com.fffemote.dances.skins.ffdiamond.databinding.ItemNativeListAdBinding;
import com.fffemote.dances.skins.ffdiamond.databinding.ItemRowBinding;
import com.fffemote.dances.skins.ffdiamond.favourite.Actor;
import com.fffemote.dances.skins.ffdiamond.favourite.FavVideoActivity;

import java.util.ArrayList;
import java.util.Collections;


public class FavEmoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<Actor> contactsList;
    private Context mContext;
    private Activity mactivity;

    public final int VIEW_AD = 100, VIEW_NORMAL = 101;



    public FavEmoteAdapter(ArrayList<Actor> contactsList, Context context, Activity mactivity) {
        this.contactsList = contactsList;
        this.mContext = context;
        this.mactivity = mactivity;
        notifyDataSetChanged();
        setAds(true);
    }

    public void setAds(boolean isCheck) {
        contactsList.removeAll(Collections.singleton(null));
        int PARTICLE_AD_DISPLAY_COUNT = 5 * 3;

        ArrayList<Actor> tempArr = new ArrayList<>();
        for (int i = 0; i < contactsList.size(); i++) {
            if (contactsList.size() > PARTICLE_AD_DISPLAY_COUNT) {
                if (i != 0 && i % PARTICLE_AD_DISPLAY_COUNT == 0) {
                    tempArr.add(null);
                }
                tempArr.add(contactsList.get(i));
            } else {
                tempArr.add(contactsList.get(i));
            }
        }
        if (contactsList.size() > 0) {
            if (contactsList.size() % PARTICLE_AD_DISPLAY_COUNT == 0) {
                tempArr.add(null);
            }
        }

        this.contactsList = tempArr;
        if (isCheck) notifyDataSetChanged();
    }


    public static class AdHolder extends RecyclerView.ViewHolder {
        ItemNativeListAdBinding binding;

        public AdHolder(@NonNull ItemNativeListAdBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemRowBinding binding;

        public ViewHolder(@NonNull ItemRowBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i == VIEW_AD)
            return new AdHolder(ItemNativeListAdBinding.inflate(LayoutInflater.from(mactivity), parent, false));
        else
            return new ViewHolder(ItemRowBinding.inflate(LayoutInflater.from(mactivity), parent, false));

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof AdHolder) {
            CTCAppLoadAds.getInstance().displayListNativeAds(mactivity, ((AdHolder) holder).binding.frameViewAds);
        }else {
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.binding.eIcon.setImageResource(contactsList.get(position).getImage());
            holder1.binding.eText.setText(contactsList.get(position).getName());

            holder1.binding.rvEmote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CTCAppLoadAds.getInstance().showInterstitial(mactivity, new CTCAppLoadAds.AdCompleteListener() {
                        @Override
                        public void onAdCompleted() {
                            Intent intent = new Intent(mContext, FavVideoActivity.class);
                            intent.putExtra("eName", contactsList.get(position).getName());
                            intent.putExtra("eIcon", contactsList.get(position).getImage());
                            mContext.startActivity(intent);
                        }
                    });

                }
            });
        }

    }



    @Override
    public int getItemViewType(int position) {
        if (contactsList.get(position) == null)
            return VIEW_AD;
        else return VIEW_NORMAL;
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }
}