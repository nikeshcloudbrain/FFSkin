package com.fffemote.dances.skins.ffdiamond.diamond.weapone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondWeaponeDetailsBinding;
import com.fffemote.dances.skins.ffdiamond.diamond.DiamondS2Activity;

public class DiamondWeaponeDetailsActivity extends AppCompatActivity {
ActivityDiamondWeaponeDetailsBinding binding;
String wp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondWeaponeDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);
        binding.tool.Ttext.setText("Emotes Weapones");

        wp=getIntent().getStringExtra("weap");

        if(wp.equals("an94")){
            binding.wIcon.setImageResource(R.drawable.ic_an94);
            binding.wDes.setText("\n\n\n This is the latest assault rifle from Free Fire. it behaves like a kind of M4A1, but in addition to damage, the function is worse. If you choose mid-range combat, this is a good choice because you will be able to cause good damage. Remember that you can add all other features except the silencer.");
        binding.tool.Ttext.setText("An94");
        }else if(wp.equals("m4a1")){
            binding.wIcon.setImageResource(R.drawable.ic_m4a1);
            binding.wDes.setText("\n\n\n M4A1 is one of the most famous weapons in the game and the most powerful assault rifle. Coupled with its good damage and accuracy, it is not surprising that this weapon is the favorite of many players. In addition, it is usually easy to find during the game, especially in military venues.");
            binding.tool.Ttext.setText("M4A1");

        }else if(wp.equals("m14")){
            binding.wIcon.setImageResource(R.drawable.ic_m14);
            binding.wDes.setText("\n\n\n M14 has the highest damage and accuracy of all assault rifles, and is a deadly weapon in the hands of skilled players. In terms of range, it is only 1 point behind the M4A1, so it is useful at long distances.");
            binding.tool.Ttext.setText("M14");

        }else if(wp.equals("ak")){
            binding.wIcon.setImageResource(R.drawable.ic_ak);
            binding.wDes.setText("\n\n\n Not only in the game, but also in the battle royale and shooter world, AK is also another most famous weapon. These features really deserve a reputation, because it is one of the rifles with more damage and range. The downside is that it is the least accurate on the list, although fortunately, it can be solved with additional features");
            binding.tool.Ttext.setText("AK");

        }else if(wp.equals("scar")){
            binding.wIcon.setImageResource(R.drawable.ic_scar);
            binding.wDes.setText("\n\n\n SCAR is not the most accurateweapon in the game. In fact, it is worse than AN94 in almost all functions. Its advantage is that the assault rifle can fire the most bullets per second, so it is very useful in close competitions.");
            binding.tool.Ttext.setText("Scar");

        }else if(wp.equals("groza")){
            binding.wIcon.setImageResource(R.drawable.ic_groza);
            binding.wDes.setText("\n\n\n  The combination of damage and shooting rhythm, as well as long range and good accuracy, make GROZA one of the best assault rifles in Free Fire. If it is already very good, then the fact that we can add various additional features will make your enemies feel terrified");
            binding.tool.Ttext.setText("Groza");

        }else if(wp.equals("famas")){
            binding.wIcon.setImageResource(R.drawable.ic_famas);
            binding.wDes.setText("\n\n\n FAMAS is one of the best assault rifles in this battle royale, but it is also the most difficult rifle to handle. |B {UI | (erksees lee MINCED SMU Rete KO mrs IRN ATL (ee so it is crucial to be targeted to avoid waste. Its long range, coupled with good damage and accuracy, make it the deadliest weapon in short Distances.");
            binding.tool.Ttext.setText("Famas");

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
                CTCAppLoadAds.getInstance().showInterstitial(DiamondWeaponeDetailsActivity.this, new CTCAppLoadAds.AdCompleteListener() {
                    @Override
                    public void onAdCompleted() {
                        startActivity(new Intent(DiamondWeaponeDetailsActivity.this, DiamondS2Activity.class));
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