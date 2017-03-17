package com.carllewis14.moviegallery.DataModel;

/**
 * Data model Class
 */

public class Movie {

    private String name;
    private String imageUrl;
    private boolean isFavourite = false;


    public Movie(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public boolean getIsFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public void toggleFavourite(){
        isFavourite = !isFavourite;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
