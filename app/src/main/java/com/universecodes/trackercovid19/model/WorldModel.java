package com.universecodes.trackercovid19.model;

import com.google.gson.annotations.SerializedName;

public class WorldModel {
    @SerializedName("cases")
    private Integer cases;
    @SerializedName("active")
    private Integer active;
    @SerializedName("deaths")
    private Integer deaths;
    @SerializedName("recovered")
    private Integer recovered;
    public WorldModel(Integer cases, Integer active, Integer deaths, Integer recovered) {
        this.cases = cases;
        this.active = active;
        this.deaths = deaths;
        this.recovered = recovered;
    }

    public Integer getLastCases() {
        return cases;
    }
    public void setLastCases(Integer cases) {
        this.cases = cases;
    }
    public Integer getLastActive() {
        return active;
    }
    public void setLastActive(Integer active) {
        this.active = active;
    }
    public Integer getLastDeaths() {
        return deaths;
    }
    public void setLastDeaths(Integer deaths) {
        this.deaths = deaths;
    }
    public Integer getLastRevocered() {
        return recovered;
    }
    public void setLastRecovered(Integer recovered) {
        this.recovered = recovered;
    }
}
