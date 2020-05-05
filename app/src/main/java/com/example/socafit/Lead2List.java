package com.example.socafit;

public class Lead2List {
    private int id;
    private String name;
    private String handle;
    private String score;
    private int image;
    private int ranking;

    public Lead2List(int id, int ranking, String score, String name, String handle, int image) {
        this.id = id;
        this.ranking = ranking;
        this.score = score;
        this.name = name;
        this.handle = handle;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getRanking() {
        return ranking;
    }
    public String getScore() {
        return score;
    }
    public String getName() {
        return name;
    }

    public String getHandle() {
        return handle;
    }

    public int getImage() {
        return image;
    }
}
