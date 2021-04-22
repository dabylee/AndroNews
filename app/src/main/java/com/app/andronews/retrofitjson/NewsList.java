package com.app.andronews.retrofitjson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsList {

    @SerializedName("status")
    String status;


    @SerializedName("totalResult")
    String totalResult;

    @SerializedName("articles")
    List<News> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
    }
}
