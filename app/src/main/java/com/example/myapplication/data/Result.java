package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    @SerializedName("limit")
    private int limit;
    @SerializedName("offset")
    private int offset;
    @SerializedName("count")
    private int count;
    @SerializedName("sort")
    private String sort;
    @SerializedName("results")
    private List<PavilionData> results;

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

    public List<PavilionData> getResults() {
        return results;
    }
}
