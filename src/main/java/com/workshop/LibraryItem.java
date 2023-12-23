package com.workshop;

class LibraryItem {
    private String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return "Title: " + getTitle();
    }
}