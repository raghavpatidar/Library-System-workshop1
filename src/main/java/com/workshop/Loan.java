package com.workshop;

import java.util.Date;

public class Loan extends LibraryItem {
    private Book book;
    private Member member;
    private Date dueDate;
    double overdue;

    public Loan(Book book, Member member, Date dueDate, double overdue) {
        super(book.getTitle()); // Inherit title from the book
        this.book = book;
        this.member = member;
        this.dueDate = dueDate;
        this.overdue = overdue;
    }

    // Getters for loan attributes

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public double getOverdue() {
        return overdue;
    }

    // Override getDetails() for custom loan information

    public String getDetails() {
        return super.getDetails() + ", Member: " + member.getName() + ", Due Date: " + dueDate + ", OverDue: "
                + overdue;
    }

}
