package com.hr.hrspring.dto;

public class MyBook extends Book{
    int price;

    public MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
