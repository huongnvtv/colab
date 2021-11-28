package com.example.appgmail;

public class AppEntity {
    private String name;
    private String description;
    private String title;
    private char imageChar;
    private String dataSend;

    public AppEntity(String name, String description,String title,String dateSend) {
        this.name = name;
        this.description = description;
        this.title = title;
        this.dataSend = dateSend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getImage() {
        return imageChar;
    }

    public void setImage(char image) {
        this.imageChar = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataSend() {
        return dataSend;
    }

    public void setDataSend(String dataSend) {
        this.dataSend = dataSend;
    }
}
