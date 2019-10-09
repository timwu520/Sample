package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PavilionData implements Serializable {

    @SerializedName("E_Pic_URL")
    private String picURL;
    @SerializedName("E_Geo")
    private String geo;
    @SerializedName("E_Info")
    private String info;
    @SerializedName("E_no")
    private String no;
    @SerializedName("E_Category")
    private String category;
    @SerializedName("E_Name")
    private String name;
    @SerializedName("E_Memo")
    private String memo;
    @SerializedName("_id")
    private int id;
    @SerializedName("E_URL")
    private String url;

    public String getPicURL() {
        return picURL;
    }

    public String getGeo() {
        return geo;
    }

    public String getInfo() {
        return info;
    }

    public String getNo() {
        return no;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getMemo() {
        return memo;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
