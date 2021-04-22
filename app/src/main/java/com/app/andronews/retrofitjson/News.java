package com.app.andronews.retrofitjson;

import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("author")
    String author;

    @SerializedName("title")
    String title;

    @SerializedName("description")
    String desc;

    @SerializedName("url")
    String url;

    @SerializedName("urlToImage")
    String urltoimage;

    @SerializedName("publishedAt")
    String pubAt;

    @SerializedName("content")
    String content;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrltoimage() {
        return urltoimage;
    }

    public void setUrltoimage(String urltoimage) {
        this.urltoimage = urltoimage;
    }

    public String getPubAt() {
        return pubAt;
    }

    public void setPubAt(String pubAt) {
        this.pubAt = pubAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
