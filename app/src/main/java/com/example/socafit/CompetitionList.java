package com.example.socafit;

public class CompetitionList {
    private int id;
    private String title;
    private String shortdesc;
    private String date;
    private int image;

    public CompetitionList(int id, String title, String shortdesc, String date, int image) {
        this.id = id;
        this.title = title;
        this.shortdesc = shortdesc;
        this.date = date;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getDate() {
        return date;
    }

    public int getImage() {
        return image;
    }
}
