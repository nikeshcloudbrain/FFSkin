package com.fffemote.dances.skins.ffdiamond.Emotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fffemote.dances.skins.ffdiamond.BuildConfig;
import com.fffemote.dances.skins.ffdiamond.R;
import com.fffemote.dances.skins.ffdiamond.adsp.CTCAppLoadAds;

import com.fffemote.dances.skins.ffdiamond.databinding.ActivityEmoteVideoBinding;
import com.fffemote.dances.skins.ffdiamond.favourite.Actor;
import com.fffemote.dances.skins.ffdiamond.favourite.ActorViewModel;
import com.fffemote.dances.skins.ffdiamond.skinTool.ReferActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;

public class EmoteVideoActivity extends AppCompatActivity {
    ActivityEmoteVideoBinding binding;
    String vList;
    int eIcon;
    private ActorViewModel actorViewModal;
int sharePath;
    private ArrayList<Actor> actorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmoteVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CTCAppLoadAds.getInstance().showNativeBottomDynamic(this, binding.frameViewAds);
        binding.tool.Ttext.setText("Emotes");

        actorList = new ArrayList<>();
        vList = getIntent().getStringExtra("eName");
        eIcon = getIntent().getIntExtra("eIcon", R.drawable.affirmative);
        actorViewModal = new ViewModelProvider(this).get(ActorViewModel.class);

        if (vList.equals("Applause")) {
            emoteVideo(R.raw.applause);
            sharePath =R.raw.applause;

        } else if (vList.equals("Baby shark")) {
            emoteVideo(R.raw.baby_shark);
            sharePath =R.raw.baby_shark;

        } else if (vList.equals("Battle dance")) {
            emoteVideo(R.raw.battle_dance);
            sharePath =R.raw.battle_dance;

        } else if (vList.equals("Chicken")) {
            emoteVideo(R.raw.chicken);
            sharePath =R.raw.chicken;

        } else if (vList.equals("Crane kick")) {
            emoteVideo(R.raw.crane_kick);
            sharePath =R.raw.crane_kick;

        } else if (vList.equals("Dab")) {
            emoteVideo(R.raw.dab);
            sharePath =R.raw.dab;

        } else if (vList.equals("Dangerous game")) {
            emoteVideo(R.raw.dangerous_game);
            sharePath =R.raw.dangerous_game;

        } else if (vList.equals("Devils move")) {
            emoteVideo(R.raw.devils_move);
            sharePath =R.raw.devils_move;

        } else if (vList.equals("Ffwc hrone")) {
            emoteVideo(R.raw.ffwc_throne);
            sharePath =R.raw.ffwc_throne;

        } else if (vList.equals("Flowers of love")) {
            emoteVideo(R.raw.flowers_of_love);
            sharePath =R.raw.flowers_of_love;

        } else if (vList.equals("Flushing")) {
            emoteVideo(R.raw.flushing);
            sharePath =R.raw.flushing;

        } else if (vList.equals("Furious slam")) {
            emoteVideo(R.raw.furious_slam);
            sharePath =R.raw.furious_slam;

        } else if (vList.equals("Glorius spin")) {
            emoteVideo(R.raw.glorius_spin);
            sharePath =R.raw.glorius_spin;

        } else if (vList.equals("Hello2")) {
            emoteVideo(R.raw.hello2);
            sharePath =R.raw.hello2;

        } else if (vList.equals("High five")) {
            emoteVideo(R.raw.high_five);
            sharePath =R.raw.high_five;

        } else if (vList.equals("Jaguar dance")) {
            emoteVideo(R.raw.jaguar_dance);
            sharePath =R.raw.jaguar_dance;

        } else if (vList.equals("Lol")) {
            emoteVideo(R.raw.lol);
            sharePath =R.raw.lol;

        } else if (vList.equals("Moon flip")) {
            emoteVideo(R.raw.moon_flip);
            sharePath =R.raw.moon_flip;

        } else if (vList.equals("Mummy dance")) {
            emoteVideo(R.raw.mummy_dance);
            sharePath =R.raw.mummy_dance;

        } else if (vList.equals("Party dance")) {
            emoteVideo(R.raw.party_dance);
            sharePath =R.raw.party_dance;

        } else if (vList.equals("Provoke2")) {
            emoteVideo(R.raw.provoke2);
            sharePath =R.raw.provoke2;

        } else if (vList.equals("Push up")) {
            emoteVideo(R.raw.push_up);
            sharePath =R.raw.push_up;

        } else if (vList.equals("Shake it up")) {
            emoteVideo(R.raw.shake_it_up);
            sharePath =R.raw.shake_it_up;

        } else if (vList.equals("Shake with me")) {
            emoteVideo(R.raw.shake_with_me);
            sharePath =R.raw.shake_with_me;

        } else if (vList.equals("Sharyuken")) {
            emoteVideo(R.raw.sharyuken);
            sharePath =R.raw.sharyuken;

        } else if (vList.equals("Shoot dance")) {
            emoteVideo(R.raw.shoot_dance);
            sharePath =R.raw.shoot_dance;

        } else if (vList.equals("Threaten")) {
            emoteVideo(R.raw.threaten);
            sharePath =R.raw.threaten;

        } else if (vList.equals("Affirmative")) {
            emoteVideo(R.raw.affirmative);
            sharePath =R.raw.affirmative;

        } else if (vList.equals("Air guitar")) {
            emoteVideo(R.raw.air_guitar);
            sharePath =R.raw.air_guitar;

        } else if (vList.equals("Annoying")) {
            emoteVideo(R.raw.annoying);
            sharePath =R.raw.annoying;

        } else if (vList.equals("Beast mode")) {
            emoteVideo(R.raw.beast_mode);
            sharePath =R.raw.beast_mode;

        } else if (vList.equals("Beg")) {
            emoteVideo(R.raw.beg);
            sharePath =R.raw.beg;

        } else if (vList.equals("Boast")) {
            emoteVideo(R.raw.boast);
            sharePath =R.raw.boast;

        } else if (vList.equals("Boast 2")) {
            emoteVideo(R.raw.boast_2);
            sharePath =R.raw.boast_2;

        } else if (vList.equals("Break dance")) {
            emoteVideo(R.raw.break_dance);
            sharePath =R.raw.break_dance;

        } else if (vList.equals("Celebrate")) {
            emoteVideo(R.raw.celebrate);
            sharePath =R.raw.celebrate;

        } else if (vList.equals("Clap")) {
            emoteVideo(R.raw.clap);
            sharePath =R.raw.clap;

        } else if (vList.equals("Clean up")) {
            emoteVideo(R.raw.clean_up);
            sharePath =R.raw.clean_up;

        } else if (vList.equals("Come here")) {
            emoteVideo(R.raw.come_here);
            sharePath =R.raw.come_here;

        } else if (vList.equals("Cower")) {
            emoteVideo(R.raw.cower);
            sharePath =R.raw.cower;

        } else if (vList.equals("Cry")) {
            emoteVideo(R.raw.cry);
            sharePath =R.raw.cry;

        } else if (vList.equals("Dance jixiewu")) {
            emoteVideo(R.raw.dance_jixiewu);
            sharePath =R.raw.dance_jixiewu;

        } else if (vList.equals("Dance panama")) {
            emoteVideo(R.raw.dance_panama);
            sharePath =R.raw.dance_panama;

        } else if (vList.equals("Dance shuaiquan")) {
            emoteVideo(R.raw.dance_shuaiquan);
            sharePath =R.raw.dance_shuaiquan;

        } else if (vList.equals("Dance step")) {
            emoteVideo(R.raw.dance_step);
            sharePath =R.raw.dance_step;

        } else if (vList.equals("Dance taishi")) {
            emoteVideo(R.raw.dance_taishi);
            sharePath =R.raw.dance_taishi;

        } else if (vList.equals("Dance yaolan")) {
            emoteVideo(R.raw.dance_yaolan);
            sharePath =R.raw.dance_yaolan;

        } else if (vList.equals("Threaten")) {
            emoteVideo(R.raw.threaten);
            sharePath =R.raw.threaten;

        } else if (vList.equals("Deaths glare")) {
            emoteVideo(R.raw.deaths_glare);
            sharePath =R.raw.deaths_glare;

        } else if (vList.equals("Dragonlee")) {
            emoteVideo(R.raw.dragonlee);
            sharePath =R.raw.dragonlee;

        } else if (vList.equals("Draw")) {
            emoteVideo(R.raw.draw);
            sharePath =R.raw.draw;

        } else if (vList.equals("Eat my dust")) {
            emoteVideo(R.raw.eat_my_dust);
            sharePath =R.raw.eat_my_dust;

        } else if (vList.equals("Emotion 02")) {
            emoteVideo(R.raw.emotion02);
            sharePath =R.raw.emotion02;

        } else if (vList.equals("Go")) {
            emoteVideo(R.raw.go);
            sharePath =R.raw.go;

        } else if (vList.equals("Good to go")) {
            emoteVideo(R.raw.good_to_go);
            sharePath =R.raw.good_to_go;

        } else if (vList.equals("Gracious bow")) {
            emoteVideo(R.raw.gracious_bow);
            sharePath =R.raw.gracious_bow;

        } else if (vList.equals("Gun show")) {
            emoteVideo(R.raw.gun_show);
            sharePath =R.raw.gun_show;

        } else if (vList.equals("Power of money")) {
            emoteVideo(R.raw.power_of_money);
            sharePath =R.raw.power_of_money;

        }else if (vList.equals("Flowers of Love")) {
            emoteVideo(R.raw.flowers_of_love);
            sharePath =R.raw.flowers_of_love;

        }else if (vList.equals("FFWC Throne")) {
            emoteVideo(R.raw.ffwc_throne);
            sharePath =R.raw.ffwc_throne;

        }else if (vList.equals("Top Dj")) {
            emoteVideo(R.raw.tops_dj);
            sharePath =R.raw.tops_dj;

        }else if (vList.equals("Kongfu")) {
            emoteVideo(R.raw.kong_fu);
            sharePath =R.raw.kong_fu;

        }else if (vList.equals("Tea Time")) {
            emoteVideo(R.raw.tea_bagging);
            sharePath =R.raw.tea_bagging;

        }else if (vList.equals("LOL")) {
            emoteVideo(R.raw.lol);
            sharePath =R.raw.lol;

        }else if (vList.equals("Provoke")) {
            emoteVideo(R.raw.provoke);
            sharePath =R.raw.provoke;

        }else if (vList.equals("Shoot Dance")) {
            emoteVideo(R.raw.shoot_dance);
            sharePath =R.raw.shoot_dance;

        }else if (vList.equals("Baby Shark")) {
            emoteVideo(R.raw.baby_shark);
            sharePath =R.raw.baby_shark;

        }else if (vList.equals("Mummy Dance")) {
            emoteVideo(R.raw.mummy_dance);
            sharePath =R.raw.mummy_dance;

        }else if (vList.equals("Push-up")) {
            emoteVideo(R.raw.push_up);
            sharePath =R.raw.push_up;

        }else if (vList.equals("Dangerous Game")) {
            emoteVideo(R.raw.dangerous_game);
            sharePath =R.raw.dangerous_game;

        }else if (vList.equals("Jaguar Dance")) {
            emoteVideo(R.raw.jaguar_dance);
            sharePath =R.raw.jaguar_dance;

        }else if (vList.equals("Shake With Me")) {
            emoteVideo(R.raw.shake_with_me);
            sharePath =R.raw.shake_with_me;

        }else if (vList.equals("Furious Slam")) {
            emoteVideo(R.raw.furious_slam);
            sharePath =R.raw.furious_slam;

        }else if (vList.equals("Moon Flip")) {
            emoteVideo(R.raw.moon_flip);
            sharePath =R.raw.moon_flip;

        }else if (vList.equals("Wiggle walk")) {
            emoteVideo(R.raw.wiggle_walk);
            sharePath =R.raw.wiggle_walk;

        }else if (vList.equals("Battle Dance")) {
            emoteVideo(R.raw.battle_dance);
            sharePath =R.raw.battle_dance;

        }else if (vList.equals("High Five")) {
            emoteVideo(R.raw.high_five);
            sharePath =R.raw.high_five;

        }else if (vList.equals("Shake it Up")) {
            emoteVideo(R.raw.shake_it_up);
            sharePath =R.raw.shake_it_up;

        } else if (vList.equals("Hello")) {
            emoteVideo(R.raw.hello);
            sharePath =R.raw.hello;

        } else if (vList.equals("Impatient")) {
            emoteVideo(R.raw.impatient);
            sharePath =R.raw.impatient;

        } else if (vList.equals("Jealous")) {
            emoteVideo(R.raw.jealous);
            sharePath =R.raw.jealous;

        } else if (vList.equals("Jig dance")) {
            emoteVideo(R.raw.jig_dance);
            sharePath =R.raw.jig_dance;

        } else if (vList.equals("Keep silent")) {
            emoteVideo(R.raw.keep_silent);
            sharePath =R.raw.keep_silent;

        } else if (vList.equals("Kick")) {
            emoteVideo(R.raw.kick);
            sharePath =R.raw.kick;

        } else if (vList.equals("Kong fu")) {
            emoteVideo(R.raw.kong_fu);
            sharePath =R.raw.kong_fu;

        } else if (vList.equals("Kungfu bow")) {
            emoteVideo(R.raw.kungfu_bow);
            sharePath =R.raw.kungfu_bow;

        } else if (vList.equals("Laugh")) {
            emoteVideo(R.raw.laugh);
            sharePath =R.raw.laugh;

        } else if (vList.equals("Loosen up")) {
            emoteVideo(R.raw.loosen_up);
            sharePath =R.raw.loosen_up;

        } else if (vList.equals("Loyalty")) {
            emoteVideo(R.raw.loyalty);
            sharePath =R.raw.loyalty;

        } else if (vList.equals("Negative")) {
            emoteVideo(R.raw.negative);
            sharePath =R.raw.negative;

        }

        binding.favE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actorList.add(new Actor(vList, eIcon));
                actorViewModal.insert(actorList);
                Toast.makeText(EmoteVideoActivity.this, "Emotes Add To Favourite", Toast.LENGTH_SHORT).show();
            }
        });

        binding.tool.icBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                File file = new File(getExternalCacheDir() + "/" + getResources().getString(R.string.app_name) + ".mp4" );
                Uri imageUri = FileProvider.getUriForFile(
                        EmoteVideoActivity.this,
                        "com.fffemote.dances.skins.ffdiamond.provider",
                        file);
                InputStream inputStream;
                FileOutputStream fileOutputStream;

                try {
                    inputStream = getResources().openRawResource(sharePath);
                    fileOutputStream = new FileOutputStream(file);

                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = inputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, length);
                    }

                    inputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_STREAM,
                        imageUri);
                intent.setType("video/*");
                startActivity(Intent.createChooser(intent, "Share video"));
            }
        });

    }

    @Override
    public void onBackPressed() {
        CTCAppLoadAds.getInstance().showInterstitialBack(this, this::finish);
    }

    public void emoteVideo(int videoLink) {
        String path = "android.resource://" + getPackageName() + "/" + videoLink;
        binding.videoView.setVideoURI(Uri.parse(path));
        binding.videoView.start();
    }


}