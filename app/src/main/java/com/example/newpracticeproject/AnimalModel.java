package com.example.newpracticeproject;

public class AnimalModel {
    private int imageResourceId;
    private String name;
    private int soundResourceId;

    public AnimalModel(int imageResourceId, String name, int soundResourceId){
        this.imageResourceId = imageResourceId;
        this.name = name;
        this.soundResourceId = soundResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoundResourceId() {
        return soundResourceId;
    }

    public void setSoundResourceId(int soundResourceId) {
        this.soundResourceId = soundResourceId;
    }
}
