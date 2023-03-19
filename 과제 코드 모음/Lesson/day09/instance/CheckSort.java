package Lesson.day09.instance;

import java.util.*;

public class CheckSort {
    public static void main(String[] args) {
        Date publishDate = new Date(54681584451L);
        Date publishDate1 = new Date(54681524451L);
        Date publishDate2 = new Date(54647584451L);

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("해리포터", publishDate, "asdf"));
        bookList.add(new Book("해리포터", publishDate1, "vfvds"));
        bookList.add(new Book("해리포오타아", publishDate, "asdnhjmf"));
        bookList.add(new Book("해리포터", publishDate2, "asddfgf"));
        bookList.add(new Book("해리포터", publishDate, "asdf"));

        for (Book book : bookList) {
            System.out.println(book.getTitle() + " " + book.getPublishDate());
        }
        System.out.println("----------정렬 후----------");

        Collections.sort(bookList);

        for (Book book : bookList) {
            System.out.println(book.getTitle() + " " + book.getPublishDate());
        }
    }
}
