package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PavilionResponse implements Serializable {

    @SerializedName("result")
    private Result result;

    public Result getResult() {
        return result;
    }
}
