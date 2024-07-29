package com.example.newshunt.Models;

public class Modelclass {

    private String author , title , description  , url ,urlToImage , publishedAt ;

    public Modelclass(String author, String title, String description, String url, String url_to_img, String time) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = url_to_img;
        this.publishedAt = time;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrltoimg() {
        return urlToImage;
    }

    public void setUrl_to_img(String url_to_img) {
        this.urlToImage = urlToImage;
    }

    public String getTime() {
        return publishedAt;
    }

    public void setTime(String time) {
        this.publishedAt = time;
    }
}
