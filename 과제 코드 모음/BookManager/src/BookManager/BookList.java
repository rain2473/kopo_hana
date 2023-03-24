package BookManager;

import java.util.*;
import java.util.stream.*;

public class BookList implements Listable<Book> {
    private static BookList instance;
    private static int numberOfBooks = 0;
    public static HashMap<String, Book> list = new HashMap<>();

    private BookList() {}

    public static BookList getInstance() {
        if (instance == null) {
            synchronized (BookList.class) {
                if (instance == null) {
                    instance = new BookList();
                }
            }
        }
        return instance;
    }

    @Override
    public void loadFromBackup(List<String> informations) throws UnsupportedOperationException {
        informations = new ArrayList<>(informations);
        try {
            String bookId = informations.get(0);
            informations.remove(0);
            boolean rentalStatus = false;
            switch (informations.get(0)) {
                case "대출가능": {
                    rentalStatus = false;
                }
                case "대출중": {
                    rentalStatus = true;
                }
                default: {
                    rentalStatus = false;
                }
            }
            informations.remove(0);
            BookList.list.put(bookId, new Book(bookId, rentalStatus, informations));
            BookList.numberOfBooks++;
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToList(Book book) {
        BookList.list.put(book.getBookId(), book);
        BookList.numberOfBooks++;
    }

    @Override
    public List<Book> listUp() {
        return BookList.list.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    public List<String> searchByKeyword(String keyword) {
        List<Book> values = this.listUp();
        return values.stream().filter(book -> book.contains(keyword)).map(book -> book.getBookId())
                .toList();
    }

    @Override
    public Book findById(String bookId) {
        return BookList.list.get(bookId);
    }

    @Override
    public void deleteFromList(String bookId) {
        list.remove(bookId);
        BookList.numberOfBooks--;
    }

    @Override
    public int length() {
        return BookList.numberOfBooks;
    }

    public List<Book> sortedListUp(String input) {
        input = input.toLowerCase();
        if ("rentalstatus".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.rentalStatus2String().compareTo(c2.rentalStatus2String());
                }
            });
        } else if ("bookid".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getBookId().compareTo(c2.getBookId());
                }
            });
        } else if ("bookname".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getBookName().compareTo(c2.getBookName());
                }
            });
        } else if ("Storedate".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getStoreDate().compareTo(c2.getStoreDate());
                }
            });
        } else if ("author".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getAuthor().compareTo(c2.getAuthor());
                }
            });
        } else if ("publisher".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getPulisher().compareTo(c2.getPulisher());
                }
            });
        } else if ("price".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getPrice().compareTo(c2.getPrice());
                }
            });
        } else {
            Collections.sort(this.listUp(), new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getPrice().compareTo(c2.getPrice());
                }
            });
        }
        return this.listUp();
    }
    
    @Override
    public void sort() {
        Collections.sort(this.listUp());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("bookId,대출가능여부,이름,입고일자,저자,출판사,출판일,가격\n");
        return result.toString();
    }

}
