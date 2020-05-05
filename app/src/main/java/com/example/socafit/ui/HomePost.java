package com.example.socafit.ui;

public class HomePost {
    private String name;
    private String userName;
    private String postContent;
    private String imgURL;
    private int likes;
    private String id;


    public HomePost(String name, String userName, String postContent, String imgURL, int likes) {
        this.name = name;
        this.userName = userName;
        this.postContent = postContent;
        this.imgURL = imgURL;
        this.likes = likes;


    }



    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }
}

