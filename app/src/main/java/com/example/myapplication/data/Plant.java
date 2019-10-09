package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Plant implements Serializable {

    @SerializedName("F_Name_Latin")
    private String F_Name_Latin;
    @SerializedName("F_Location")
    private String Location;
    private double rank;
    private String F_Summary;
    @SerializedName("F_Pic01_URL")
    private String PicUrl;
    private String _full_count;
    private Object F_Pic02_URL;
    private String F_Keywords;
    private Object F_Code;
    private String F_Geo;
    private Object F_Pic03_URL;
    private Object F_Voice01_ALT;
    @SerializedName("F_AlsoKnown")
    private String AlsoKnown;
    private Object F_Voice02_ALT;
    @SerializedName("F_Name_Ch")
    private String ChineseName;
    private Object F_Pic04_ALT;
    @SerializedName("F_Name_En")
    private String EnglishName;
    @SerializedName("F_Brief")
    private String Brief;
    private Object F_Pic04_URL;
    private Object F_Voice01_URL;
    @SerializedName("F_Feature")
    private String Feature;
    private Object F_Pic02_ALT;
    @SerializedName("F_Family")
    private String Family;
    private Object F_Voice03_ALT;
    private Object F_Voice02_URL;
    private Object F_Pic03_ALT;
    private Object F_Pic01_ALT;
    private Object F_CID;
    private Object F_pdf01_URL;
    private Object F_Vedio_URL;
    @SerializedName("F_Genus")
    private String Genus;
    private Object F_Voice03_URL;
    private Object F_Update;
    private int _id;
    @SerializedName("F_Function＆Application")
    private String Function;


    public String getLocation() {
        return Location;
    }

    public String getAlsoKnown() {
        return AlsoKnown;
    }

    public String getChineseName() {
        return ChineseName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public String getBrief() {
        return Brief;
    }

    public String getFeature() {
        return Feature;
    }

    public String getFamily() {
        return Family;
    }

    public String getGenus() {
        return Genus;
    }

    public String getFunction() {
        return Function;
    }

    public String getPicUrl() {
        return PicUrl;
    }
}
