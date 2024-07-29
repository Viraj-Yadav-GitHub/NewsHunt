package com.example.newshunt.Models;

import java.util.ArrayList;

public class Articalclass {

    private String status , totalresult ;

    private ArrayList<Modelclass> articles ;

    public Articalclass(String status, String totalresult, ArrayList<Modelclass> articles) {
        this.status = status;
        this.totalresult = totalresult;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresult() {
        return totalresult;
    }

    public void setTotalresult(String totalresult) {
        this.totalresult = totalresult;
    }

    public ArrayList<Modelclass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Modelclass> articles) {
        this.articles = articles;
    }
}
