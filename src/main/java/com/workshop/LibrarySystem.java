package com.workshop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibrarySystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a Member");
            System.out.println("3. Check Out a Book");
            System.out.println("4. Check In a Book");
            System.out.println("5. Generate Reports");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    checkOutBook();
                    break;
                case 4:
                    checkInBook();
                    break;
                case 5:
                    generateReports();
                    break;
                case 0:
                    System.out.println("Exiting the Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);
    }

    private static void addBook() {
        System.out.println("\nAdding a Book:");
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Number of Pages: ");
        int numberOfPages = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, publisher, genre, numberOfPages);
        library.addItem(book);
        System.out.println("Book added successfully!");
    }

    private static void addMember() {
        System.out.println("\nAdding a Member:");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter Email Address: ");
        String emailAddress = scanner.nextLine();

        Member member = new Member(name, address, phoneNumber, emailAddress);
        library.addMember(member);
        System.out.println("Member added successfully!");
    }

    private static void checkOutBook() {
        System.out.println("\nChecking Out a Book:");
        System.out.print("Enter Member Name: ");
        String memberName = scanner.nextLine();
        Member member = library.findMemberByName(memberName);

        if (member != null) {
            System.out.print("Enter Book Title: ");
            String bookTitle = scanner.nextLine();
            Book book = library.findBookByTitle(bookTitle);

            if (book != null) {
                System.out.print("Enter Due Date (yyyy-MM-dd): ");
                String dueDateString = scanner.nextLine();
                Date dueDate = parseDate(dueDateString);

                if (dueDate != null) {
                    library.checkOutBook(book, member, dueDate);
                    System.out.println("Book checked out successfully!");
                } else {
                    System.out.println("Invalid date format. Please enter a date in the format yyyy-MM-dd.");
                }
            } else {
                System.out.println("Book not found. Please check the title and try again.");
            }
        } else {
            System.out.println("Member not found. Please check the name and try again.");
        }
    }

    private static void checkInBook() {
        System.out.println("\nChecking In a Book:");
        System.out.print("Enter Member Name: ");
        String memberName = scanner.nextLine();
        Member member = library.findMemberByName(memberName);

        if (member != null) {
            System.out.print("Enter Book Title: ");
            String bookTitle = scanner.nextLine();
            Book book = library.findBookByTitle(bookTitle);

            if (book != null) {
                library.checkInBook(book, member);
                System.out.println("Book checked in successfully!");
            } else {
                System.out.println("Book not found. Please check the title and try again.");
            }
        } else {
            System.out.println("Member not found. Please check the name and try again.");
        }
    }

    private static void generateReports() {
        System.out.println("\nGenerating Reports:");
        System.out.println("1. List of all items in the library");
        System.out.println("2. List of all members of the library");
        System.out.println("3. List of all items that are currently checked out");
        System.out.println("4. List of all overdue items");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("List of all items in the library:");
                library.generateList(library.getItems());
                break;
            case 2:
                System.out.println("List of all members of the library:");
                library.generateMember(library.getMembers());

                break;
            case 3:
                System.out.println("List of all items that are currently checked out:");
                library.generateList(library.getCheckedOutItems());
                break;
            case 4:
                System.out.println("List of all overdue items:");
                library.generateList(library.getOverdueItems());
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
