package com.fffemote.dances.skins.ffdiamond.favourite;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "actor", indices = @Index(value = {"actorId"},unique = true))
public class Actor {
    @PrimaryKey(autoGenerate = true)
    @SerializedName("actorId")
    @ColumnInfo(name = "actorId")
    private int actorId;


    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("image")
    @ColumnInfo(name = "image")
    private int image;




    public Actor( String name, int image) {
//        this.id = id;
        this.name = name;
        this.image = image;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", name='" + name + '\'' +
                ", image='" + image +
                '}';
    }
}