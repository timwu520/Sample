package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlantData {

    @SerializedName("limit")
    private int limit;
    @SerializedName("offset")
    private int offset;
    @SerializedName("count")
    private int count;
    @SerializedName("sort")
    private String sort;
    @SerializedName("results")
    private List<Plant> results;

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getCount() {
        return count;
    }

    public String getSort() {
        return sort;
    }

    public List<Plant> getResults() {
        return results;
    }
}
