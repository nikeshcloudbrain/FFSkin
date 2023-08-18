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

import com.fffemote.dances.skins.ffdiamond.databinding.ItemEmoteBinding;
import com.fffemote.dances.skins.ffdiamond.databinding.ItemNativeListAdBinding;
import com.fffemote.dances.skins.ffdiamond.skinTool.EmoteDetailsActivity;

import com.fffemote.dances.skins.ffdiamond.model.dress;

import java.util.ArrayList;
import java.util.Collections;


public class EmoteAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<dress> contactsList;
    private Context mContext;
    private Activity mactivity;

    public final int VIEW_AD = 100, VIEW_NORMAL = 101;



    // Counstructor for the Class
    public EmoteAdapter(ArrayList<dress> contactsList, Context context, Activity mactivity) {
        this.contactsList = contactsList;
        this.mContext = context;
        this.mactivity = mactivity;
        setAds(true);
    }

    public void setAds(boolean isCheck) {
        contactsList.removeAll(Collections.singleton(null));
        int PARTICLE_AD_DISPLAY_COUNT = 5;

        ArrayList<dress> tempArr = new ArrayList<>();
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



    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemEmoteBinding binding;

        public ViewHolder(@NonNull ItemEmoteBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }

    public static class AdHolder extends RecyclerView.ViewHolder {
        ItemNativeListAdBinding binding;

        public AdHolder(@NonNull ItemNativeListAdBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i == VIEW_AD)
            return new AdHolder(ItemNativeListAdBinding.inflate(LayoutInflater.from(mactivity), parent, false));
        else
            return new ViewHolder(ItemEmoteBinding.inflate(LayoutInflater.from(mactivity), parent, false));
    }






    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof AdHolder) {
            CTCAppLoadAds.getInstance().displayListNativeAds(mactivity, ((AdHolder) holder).binding.frameViewAds);
        }else {
            ViewHolder holder1 = (ViewHolder) holder;
            holder1.binding.eIcon.setImageResource(contactsList.get(position).getdIcon());
            holder1.binding.eText.setText(contactsList.get(position).getdName());

            holder1.binding.rvEmote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CTCAppLoadAds.getInstance().showInterstitial(mactivity, new CTCAppLoadAds.AdCompleteListener() {
                        @Override
                        public void onAdCompleted() {
                            Intent intent = new Intent(mContext, EmoteDetailsActivity.class);
                            intent.putExtra("eIcon", contactsList.get(position).getdIcon());
                            intent.putExtra("eName", contactsList.get(position).getdName());
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