package com.workshop;

public class Book extends LibraryItem {

    private String author;
    private String publisher;
    private String genre;
    private int numberOfPages;

    public Book(String title, String author, String publisher, String genre, int numberOfPages) {
        super(title);
        this.author = author;
        this.publisher = publisher;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Author: " + author + ", Genre: " + genre;
    }

}
