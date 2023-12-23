package com.workshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Library {
    private List<LibraryItem> libraryItems;
    private List<Member> members;

    public Library() {
        this.libraryItems = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<LibraryItem> getItems() {
        return libraryItems;
    }

    public List<Member> getMembers() {
        return members;
    }

    public Member findMemberByName(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (LibraryItem item : libraryItems) {
            if (item instanceof Book && item.getTitle().equalsIgnoreCase(title)) {
                return (Book) item;
            }
        }
        return null;
    }

    public void generateList(List<? extends LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item.getDetails());
        }
    }

    public void generateMember(List<Member> membersList) {
        for (Member member : membersList) {
            System.out.println(member.getDetails());
        }
    }

    public void checkOutBook(Book book, Member member, Date dueDate) {
        libraryItems.add(new Loan(book, member, dueDate, 0));
    }

    public void checkInBook(Book book, Member member) {
        libraryItems.removeIf(
                item -> item instanceof Loan && ((Loan) item).getBook() == book && ((Loan) item).getMember() == member);
    }

    public List<LibraryItem> getCheckedOutItems() {
        List<LibraryItem> checkedOutItems = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item instanceof Loan) {
                checkedOutItems.add(item);
            }
        }
        return checkedOutItems;
    }

    public List<LibraryItem> getOverdueItems() {
        List<LibraryItem> overdueItems = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            if (item instanceof Loan) {
                Loan loan = (Loan) item;
                if (loan.getDueDate().before(new Date())) {
                    loan.overdue = calculateOverdueFines(loan.getMember());
                    overdueItems.add(item);
                }
            }
        }
        return overdueItems;
    }

    public double calculateOverdueFines(Member member) {
        double overdueFines = 0.0;
        for (LibraryItem item : libraryItems) {
            if (item instanceof Loan) {
                Loan loan = (Loan) item;
                if (loan.getMember() == member && loan.getDueDate().before(new Date())) {
                    overdueFines += 5.0;
                }
            }
        }
        return overdueFines;
    }
}