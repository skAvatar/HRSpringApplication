package com.hr.hrspring.poo.dto;

 abstract class Book {
    String title;
    String author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    abstract void display();
}

