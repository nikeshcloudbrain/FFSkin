package com.fffemote.dances.skins.ffdiamond.model;

public class Weapones {
    public String dName;
    public int dIcon;
    public String dDes;

    Weapones(String name, String des, int icon) {
        this.dName = name;
        this.dIcon = icon;
        this.dDes = des;

    }


    public String getdName() {
        return dName;
    }

    public int getdIcon() {
        return dIcon;
    }

    public String getdDes() {
        return dDes;
    }

}
