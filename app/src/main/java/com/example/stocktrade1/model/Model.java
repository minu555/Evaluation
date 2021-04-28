package com.example.stocktrade1.model;

import com.android.volley.Response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Model {


    @SerializedName("config")
    @Expose
    private Config config;
    @SerializedName("response")
    @Expose
    private com.android.volley.Response response;

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Model withConfig(Config config) {
        this.config = config;
        return this;
    }

    public com.android.volley.Response getResponse() {
        return response;
    }

    public void setResponse(com.android.volley.Response response) {
        this.response = response;
    }

    public Model withResponse(Response response) {
        this.response = response;
        return this;
    }


}