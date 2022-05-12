package com.example.myapplication123;

import com.google.gson.annotations.SerializedName;

public class FactResponse {
    @SerializedName("text")
    private String fact;

    public String getFact() {return fact;}
}
