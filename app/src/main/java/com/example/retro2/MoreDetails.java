package com.example.retro2;

public class MoreDetails {


    //Model class for details data

    private String release;
    private String category;
    private String duration;

    public String getRelease() {
        return release;
    }

    public String getCategory() {
        return category;
    }

    public String getDuration() {
        return duration;
    }


    public MoreDetails(String release, String category, String duration) {
        this.release = release;
        this.category = category;
        this.duration = duration;
    }

    public MoreDetails() {
    }
}
