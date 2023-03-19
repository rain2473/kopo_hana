package Lesson.day09.instance;

import java.util.*;

public class CheckEquals {

    public static void main(String[] args) {
        Date publishDate = new Date(54681584451L);
        Date publishDate1 = new Date(54681524451L);
        Date publishDate2 = new Date(54647584451L);

        Book book1 = new Book("해리포터", publishDate, "asdf");
        Book book2 = new Book("해리포터", publishDate1, "vfvds");
        Book book3 = new Book("해리포오타아", publishDate, "asdnhjmf");
        Book book4 = new Book("해리포터", publishDate2, "asddfgf");
        Book book5 = new Book("해리포터", publishDate, "asdf");

        String print = "다릅니다";
        if (book1.equals(book5)) {
            print = "같습니다";
        }
        System.out.println("equals 사용 결과 : book1과 book5는 " + print);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

        System.out.println("리스트");
        for (Book book : bookList) {
            System.out.println(book.getTitle() + " " + book.getPublishDate());
        }
        System.out.println("셋");

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);
        for (Book book : bookSet) {
            System.out.println(book.getTitle() + " " + book.getPublishDate());
        }
    }
}
