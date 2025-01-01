package com.example.cartoonfilmapp;

public class Cartoon {
    private String name;
    private int imageResId;
    private String videoUrl;
    private String description;


    public Cartoon(String name, int imageResId, String videoUrl, String description) {
        this.name = name;
        this.imageResId = imageResId;
        this.videoUrl = videoUrl;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getDescription() {
        return description;
    }
}
