package BookManager;

import java.util.*;

public class Book implements Comparable<Book>, Comparator<Book> {
    private boolean rentalStatus;
    private String bookId;

    private List<String> informations = new ArrayList<>();

    public Book(boolean rentalStatus, String bookId, String name, String author, String publisher,
            String pulishingDate, String price) {
        this.rentalStatus = rentalStatus;
        this.bookId = bookId;
        informations.add(name);
        informations.add(DateHandler.getInstance().now());
        informations.add(author);
        informations.add(publisher);
        informations.add(pulishingDate);
        informations.add(price);
    }

    public Book(String bookId, boolean rentalStatus, List<String> informations) {
        this.rentalStatus = rentalStatus;
        this.bookId = bookId;
        this.informations = informations;
    }

    public Book(String name, String author, String publisher, String pulishingDate, String price) {
        this(false, String.valueOf(BookList.getInstance().length()), name, author, publisher,
                pulishingDate, price);
    }

    public void setRentalStatus(boolean status) {
        this.rentalStatus = status;
    }

    public boolean getRentalStatus() {
        return this.rentalStatus;
    }

    public String rentalStatus2String() {
        if (getRentalStatus()) {
            return "대출중";
        } else {
            return "대출가능";
        }
    }

    public String getBookId() {
        return this.bookId;
    }

    public List<String> getBookInformations() {
        return this.informations;
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
        return this.informations.equals(book.getBookInformations());
    }

    public String getPrice() {
        return this.informations.get(5);
    }

    public String getStoreDate() {
        return this.informations.get(1);
    }

    public String getAuthor() {
        return this.informations.get(2);
    }

    public String getPulishingDate() {
        return this.informations.get(4);
    }

    public String getPulisher() {
        return this.informations.get(3);
    }

    public String getBookName() {
        return this.informations.get(0);
    }

    @Override
    public String toString() {
        StringBuilder result =
                new StringBuilder(this.bookId + "," + this.rentalStatus2String() + ",");
        for (String index : this.informations) {
            result.append(index);
            result.append(",");
        }
        result.deleteCharAt(result.length() - 1);
        result.append("\n");
        return result.toString();
    }

    @Override
    public int compareTo(Book o) {
        return this.getPulishingDate().compareTo(o.getPulishingDate());
    }

    public boolean contains(String keyword) {
        for (String contents : this.getBookInformations()) {
            if (contents.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPulishingDate().compareTo(o2.getPulishingDate());
    }
}
