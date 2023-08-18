package com.fffemote.dances.skins.ffdiamond.diamond.character;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;
import com.fffemote.dances.skins.ffdiamond.databinding.ActivityDiamondCharacterDetailsBinding;
import com.fffemote.dances.skins.ffdiamond.diamond.DiamondS2Activity;

public class DiamondCharacterDetailsActivity extends AppCompatActivity {
ActivityDiamondCharacterDetailsBinding binding;
String character;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDiamondCharacterDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeMediaFix(this, binding.frameViewAdsMain);

        character=getIntent().getStringExtra("ch");

        binding.tool.Ttext.setText("Character");


        if (character.equals("SHIMADA HAYATO")) {
            binding.text11.setText("\t\t\tSpecial ability: The less life, the Stronger his attack power will be.\n");
            binding.text12.setText("\t\tPrice, 1999 diamonds (currently only packaging).\n\n\t\t Shimada Hayato comes from an anicient samurai family. He has a deep sense of honor and proudly carries the blood, tradition and curse of his family. He is willing to do anything to protect his greatest secret, and no matter who the opponent is, he will use the katana.\n\n\t\t\tThis role is very useful for duel lovers. if you try to use a weapon with a large magazine, even if you have the same weapon, a long-distance exchange will eventully cause more damage then your opponent.\n");
            binding.image12.setImageResource(R.drawable.ic_hayato);
        } else if (character.equals("MOCO")) {
            binding.text11.setText("\t\t Special ability: in a few seconds, let your teammates see where the enemy your are shoothing.\n");
        binding.text12.setText("\t\t Price: 499 diamonds.\n\n\t\t Moco is one known as an internet legend. She is skilled and very smart,able to get information from anywhere whitout levaving a trace-the ghost of the internet!\n\n\t\t if you like to play with other people, the character is very helpful in the task of ambushing the enemy because of the ability of the enemy to be marked or identified.\n");
            binding.image12.setImageResource(R.drawable.ic_moco);
        } else if (character.equals("WUKONG")) {
            binding.text11.setText("\t\t Special ability: Become a bush, charging time is several minnutes.\n");
            binding.text12.setText("\t\t Price:499 diamonds.\n\n\t\t Wukong is like a person who looks like a monkey. Or a monkey that looks like a human. We dont know, because he is so mysterious, no one knows his past or age. This character is a good idea for those who want to play the game in a more passive way. These characters are awlays hidden and redy to cause death scares to enemies passing by. Shotgun is your best friend!\n");
            binding.image12.setImageResource(R.drawable.ic_wukong);
        } else if (character.equals("ANTONIO")) {
        binding.text11.setText("\t\t Special ability: The game has more lives than other characters.\n");
            binding.text12.setText("\t\t Price: 499 diamonds.\n\n\t\t Antonio is an orphan, he created his own street gang. He grew up to become the gang boss and got rid of all his opponents in seven years. if somone wants to threaten his family. plase prepar him: even if it may be life-threatening, he will do everything he can to protect them.\n\n\t\t This role is the best if we want to take advantage of the first encounter. He increased the initial lifespan,thus showing higher durability at the beginning of the game.\n");
            binding.image12.setImageResource(R.drawable.ic_antonio);
        } else if (character.equals("ANDREW")) {
        binding.text11.setText("\t\t Special ability: Bulletproof vest is more resistant, so playing with Andrew will take longer to rest.\n");
            binding.text12.setText("\t\t Price: 1000 coins (if you log in from the main menu, Andrew is a free character).\n\n\t\t Andrew is a former policeman who has spent most of hs life chasing criminals in prison. Because of his experisence, he became an expert in survival and armed combat. in addition, Andrew is extremely resistant to damage.\n\n\t\t is a useful role for us who seek defense rather than aggressive style.\n");
            binding.image12.setImageResource(R.drawable.ic_andrew);
        } else if (character.equals("KELLY")) {
        binding.text11.setText("\t\tSpecial ability: Kellys sprint speed is faster then usual, which allows us to reach the enemy, rob or escape danger in front of others\n");
            binding.text12.setText("\t\t Price: 2000 coins or 399\n\n\t\t Kellys real name is Shimada Kiriko. She is a teenager or a student. She is an elite athlete and will not stop trading in truck and field or academy, so she has become the fastest character in Free Fire.\n\n\t\t If we want to enter the site earlier then others, or have an advantage in chasing on foot, playing kelly will be the best choice.\n");
            binding.image12.setImageResource(R.drawable.ic_kelly);
        } else if (character.equals("OLIVIA")) {
        binding.text11.setText("\t\t Special ability: Companion gains more live through Olivias revival.\n");
            binding.text12.setText("\t\t Price: 2000 coins or 399 diamonds.\n\n\t\t Olivia is a professional nurse and an expert in taking care of others. She always said that helping others is her happinesst thing whether they are friends or enemies, no matter if it is dangerous to her.\n\n\t\t She is a good character in duo and squad mode because she can heal teammates quickly and effectively.However,if we choose her as the solo mode, it is like playing with Eve and Adam, because it does not bring us any personl benefits.\n");
            binding.image12.setImageResource(R.drawable.ic_olivia);
        } else if (character.equals("FORD")) {
        binding.text11.setText("\t\tSpecial ability: Compared with other characters, Ford suffers less damage in the radioactive area.\n");
            binding.text12.setText("\t\t Price : 2000 coins or 399 precious stones.\n\n\t\t Ford is a sailor. The harsh life of the ocean has increased their resistance and survivability. He is the most mysterious character, he doesnt want to reveal his secrets.\n\n\t\tThis person is a good choice if we want to land in the most extreme place on the map and explore quietly. Hide in the radioactivity area for a short time and surprise our opponents by ambushing, but be carful!\n");
            binding.image12.setImageResource(R.drawable.ic_ford);
        } else if (character.equals("NIKITA")) {
        binding.text11.setText("\t\t Special ability: Nikita can change the submachine gun faster, which is a real advantage in one-to-one situations.\n");
            binding.text12.setText("\t\t Price: 2500 coins or 499 diamonds.\n\n\t\t Nikita is the professional bodyguard of Carolyn, the chairman of FreeFire. She learned to use different weapons since she was a child and become the champion of varios competitions.\n\n\t\t This is useful for those of us who want to make full use of the shoothing rhythm and magazine of the shoothing rhythm and magazine of the submachine gun but pay attention to the ammunition!\n");
            binding.image12.setImageResource(R.drawable.ic_nikita);
        } else if (character.equals("MISHA")) {
        binding.text11.setText("\t\tSpecial ability: All vehicles driven by Misha can reach higher speeds and suffer less damage.\n");
            binding.text12.setText("\t\tPrice: 800 coins or 499\n\n\t\t Misha is a racing expert and very breve girl. she loves speed and likes to keep all her opponents in the dust. For her,there are no corners, only straights.\n\n\t\t She is a suitable role for those who often use vehicles and are speed lovers. hold on!.\n");
            binding.image12.setImageResource(R.drawable.ic_misha);
        } else if (character.equals("MAXIM")) {
        binding.text11.setText("\t\tSpecial ability: Maxim spends less time healing or eating mushrooms to gain EP points.\n\n");
            binding.text12.setText("\t\tPrice: 8000 coins or 499 diamonds.\n\n\t\tMaxim is a regular player in the game, eating more ,plus a very funny and smiling player. He likes streaming when playing against players from all over the world. But please dont be fooled: if you think you are older then him and will beat him in a food competition, you are wrong.\n\n\t\t For those of us who are based on inventory supplies, Maxim is the most suitable.");
            binding.image12.setImageResource(R.drawable.ic_maxim);
        } else if (character.equals("KLA")) {
        binding.text11.setText("\t\tSpecial ability: Carats punches caus the most damage to the entire game, which is crucial for the first few minutes of each game.\n");
            binding.text12.setText("\t\t Price: 8000 coins or 499 diamonds.\n\n\t\tKla is a lonely person and an experienced Muay Thai wrestler. He disappeared for many years, albeit completely changed: he decided to avenge himself with his hands.\n\n\t\tFor those who like to land in places full of players, this person is the best; but beware of being surrounded by bullets at the end!.\n");
            binding.image12.setImageResource(R.drawable.ic_kla);
        } else if (character.equals("PALOMA")) {
        binding.text11.setText("Special ability: Ability to carry more AR bullets, because not all bullets will take up space in our inventory\n");
            binding.text12.setText("\t\tPrice: 8000 coins or 499 diamonds.\n\n\t\tPaloma is an arms dealer, beautiful but deadly. Years ago, she was a model women that all girls admired, until one day, she wanted to become an expert in arms sales. if there is an illegal business somewhere, palomar will seek profit there in every possible way.\n\n\t\t For those who want to have the upper hand in ammunition and be able to use it for a longer period of time in shooting exchanges, there is nothing better then paloma.");
            binding.image12.setImageResource(R.drawable.ic_paloma);
        } else if (character.equals("MLGUEL")) {
        binding.text11.setText("\t\tSpecial ability: Every time an enemy is eliminated, Miguel will gaid EP points, and other characters can only gain EP points by eating mushrooms.\n\n");
            binding.text12.setText("\t\t Price: 8000 coins or 499 diamonds.\n\n\t\t Miguel is a very deadly and welltrained special forces soldier. Throughout his career, together with his comrades in the battalion, he successfully raised justice for terrorists. Until one day, everything went wrong.\n\n\t\t Some of us like to be aggressive and hunt down many enemies. This is our character.\n");
            binding.image12.setImageResource(R.drawable.ic_miguel);
        } else if (character.equals("CAROLINE")) {
        binding.text11.setText("\t\tSpecial ability: It can move faster when holding a carrying bullet gun.\n\n");
            binding.text12.setText("\t\tPrice:499 diamonds.\n\n\t\t Caroline is a very, very rice girl. She has been surrounded by fans and many bodyguards all her father and brothers very close to here father and brothers and like to role-play.\n\n\t\t If we choose to fight at close quarters and explore buildings,this young woman will become our best ally, one of the last members of the free shooting army.");
            binding.image12.setImageResource(R.drawable.ic_carroline);
        } else {
            return;
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
                startActivity(new Intent(DiamondCharacterDetailsActivity.this, DiamondS2Activity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }
}