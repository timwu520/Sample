package com.example.myapplication.data;

import com.google.gson.annotations.SerializedName;

public class PavilionResponse {

    @SerializedName("result")
    private Result result;

    public Result getResult() {
        return result;
    }
}
