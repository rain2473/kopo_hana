package com.company;

import java.util.*;

public class Book extends TangibleAsset implements Comparable<Book> {
    private String isbn;
    private String title;
    private String comment;
    private Date publishDate;

    public Book(String name, int price, String color, String isbn) {
        super(name, price, color);
        this.isbn = isbn;
    }

    public Book(String title, Date publishDate, String comment) {
        super(title, 10000, "Black");
        this.title = title;
        this.publishDate = publishDate;
        this.comment = comment;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle() {
        this.title = super.getName();
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public int compareTo(Book o) {
        return this.getPublishDate().compareTo(o.getPublishDate());
    }

    @Override
    public int hashCode() {
        int code = 29;
        code = this.getTitle().hashCode() + this.getPublishDate().hashCode() + 29292555 / 3773456;
        return code;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Book))
            return false;
        Book book = (Book) obj;
        if (book.getTitle().equals(this.getTitle())
                && book.getPublishDate().equals(this.getPublishDate()))
            return true;
        return false;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException {
        Book result = new Book(this.getTitle(), this.getPublishDate(), this.getComment());
        return result;
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
    }
}
