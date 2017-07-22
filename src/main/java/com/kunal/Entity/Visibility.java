package com.kunal.Entity;

public enum Visibility {

    Public("Public"),
    Private("Private");

    public String visibility;

    Visibility(String visibility) {
        this.visibility =getVisibility(visibility);
    }

    static String getVisibility(String visibility){
        return visibility;
    }
}
