package com.example.stocktrade1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Data {


    @SerializedName("bse")
    @Expose
    private List<BseandNse> bse = null;
    @SerializedName("bseLstUpdteTme")
    @Expose
    private String bseLstUpdteTme;
    @SerializedName("nse")
    @Expose
    private List<BseandNse> nse = null;
    @SerializedName("nseLstUpdteTme")
    @Expose
    private String nseLstUpdteTme;

    public List<BseandNse> getBse() {
        return bse;
    }

    public void setBse(List<BseandNse> bse) {
        this.bse = bse;
    }

    public Data withBse(List<BseandNse> bse) {
        this.bse = bse;
        return this;
    }

    public String getBseLstUpdteTme() {
        return bseLstUpdteTme;
    }

    public void setBseLstUpdteTme(String bseLstUpdteTme) {
        this.bseLstUpdteTme = bseLstUpdteTme;
    }

    public Data withBseLstUpdteTme(String bseLstUpdteTme) {
        this.bseLstUpdteTme = bseLstUpdteTme;
        return this;
    }

    public List<BseandNse> getNse() {
        return nse;
    }

    public void setNse(List<BseandNse> nse) {
        this.nse = nse;
    }

    public Data withNse(List<BseandNse> nse) {
        this.nse = nse;
        return this;
    }

    public String getNseLstUpdteTme() {
        return nseLstUpdteTme;
    }

    public void setNseLstUpdteTme(String nseLstUpdteTme) {
        this.nseLstUpdteTme = nseLstUpdteTme;
    }

    public Data withNseLstUpdteTme(String nseLstUpdteTme) {
        this.nseLstUpdteTme = nseLstUpdteTme;
        return this;
    }
}