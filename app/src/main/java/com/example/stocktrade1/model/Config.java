package com.example.stocktrade1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Config {

    @SerializedName("app")
    @Expose
    private Integer app;
    @SerializedName("message")
    @Expose
    private Integer message;

    public Integer getApp() {
        return app;
    }

    public void setApp(Integer app) {
        this.app = app;
    }

    public Config withApp(Integer app) {
        this.app = app;
        return this;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Config withMessage(Integer message) {
        this.message = message;
        return this;
    }


}