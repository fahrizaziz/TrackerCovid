package com.universecodes.trackercovid19.model.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {
    @SerializedName("articles")
    private List<NewsModel> getArticles;

    public NewsResponse(List<NewsModel> getArticles) {
        this.getArticles = getArticles;
    }

    public List<NewsModel> getGetArticles() {
        return getArticles;
    }

    public void setGetArticles(List<NewsModel> getArticles) {
        this.getArticles = getArticles;
    }
}
