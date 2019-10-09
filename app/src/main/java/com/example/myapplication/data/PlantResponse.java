package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PlantResponse implements Serializable {

    @SerializedName("result")
    private PlantData result;

    public PlantData getResult() {
        return result;
    }
}
