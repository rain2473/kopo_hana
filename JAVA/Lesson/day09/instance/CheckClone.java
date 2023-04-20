package Lesson.day09.instance;

import java.util.*;

public class CheckClone {
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
        
        System.out.println(book1.equals(book2));
    }
}
