package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Date publishDate = new Date(54681584451L);

        Book book1 = new Book("해리포터", publishDate, "asdf");
        Book book2 = book1.clone();

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        for (Book book : bookList) {
            System.out.println(book.getTitle() + " " + book.getPublishDate());
        }
    }
}
