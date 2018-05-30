package com.example.kavin.wantedxtickets.ModelClasses;

public class PostsInformation {
    String title;
    String description;
    String genre;
    String location;
    int price;
    int date;

    public PostsInformation() {
    }

    public PostsInformation(String title, String description, String genre, String location, int price, int date) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.location = location;
        this.price = price;
        this.date = date;
    }
}
