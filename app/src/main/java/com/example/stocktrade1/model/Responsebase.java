package com.example.stocktrade1.model;

public class Responsebase {
    private Config config;

    private Response response;

    public void setConfig(Config config){
        this.config = config;
    }
    public Config getConfig(){
        return this.config;
    }
    public void setResponse(Response response){
        this.response = response;
    }
    public Response getResponse(){
        return this.response;
    }

}
