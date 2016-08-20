package com.semeniuc.dmitrii.remindmeproject.dto;

/**
 * Created by Dmitrii on 8/19/2016.
 */
public class RemindDTO {

    private String title;

    public RemindDTO(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
