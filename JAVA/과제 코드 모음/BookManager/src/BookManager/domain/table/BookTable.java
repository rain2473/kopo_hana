package BookManager.domain.table;

import java.util.*;
import java.util.stream.*;

import BookManager.domain.model.Book;
import BookManager.domain.model.BookInformation;

public class BookTable implements DataTable<Book> {
    private static BookTable instance;
    private static int numberOfBooks = 0;
    public static HashMap<String, Book> table = new HashMap<>();

    private BookTable() {}

    public static BookTable getInstance() {
        if (instance == null) {
            synchronized (BookTable.class) {
                if (instance == null) {
                    instance = new BookTable();
                }
            }
        }
        return instance;
    }

    @Override
    public void loadFromBackup(List<String> input) throws UnsupportedOperationException {
    	input = new ArrayList<>(input);
        try {
            String bookId = input.get(0);
            input.remove(0);
            boolean rentalStatus = false;
            switch (input.get(0)) {
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
            input.remove(0);
            BookInformation informations = new BookInformation(input);
            BookTable.table.put(bookId, new Book(bookId, rentalStatus, informations));
            BookTable.numberOfBooks++;
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToList(Book book) {
        BookTable.table.put(book.getBookId(), book);
        BookTable.numberOfBooks++;
    }

    @Override
    public List<Book> listUp() {
        return BookTable.table.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    public List<String> searchByKeyword(String keyword) {
        List<Book> values = this.listUp();
        return values.stream().filter(book -> book.contains(keyword)).map(book -> book.getBookId())
                .toList();
    }

    @Override
    public Book findById(String bookId) {
        return BookTable.table.get(bookId);
    }

    @Override
    public void deleteFromList(String bookId) {
        table.remove(bookId);
        BookTable.numberOfBooks--;
    }

    @Override
    public int length() {
        return BookTable.numberOfBooks;
    }

    public List<Book> sortedListUp(String input) {
        List<Book> result = new ArrayList<Book>(this.listUp());
        input = input.toLowerCase();
        if ("rentalstatus".equals(input)) {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.rentalStatus2String().compareTo(c2.rentalStatus2String());
                }
            });
        } else if ("bookid".equals(input)) {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getBookId().compareTo(c2.getBookId());
                }
            });
        } else if ("bookname".equals(input)) {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getBookName().compareTo(c2.getBookName());
                }
            });
        } else if ("Storedate".equals(input)) {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getStoreDate().compareTo(c2.getStoreDate());
                }
            });
        } else if ("author".equals(input)) {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getAuthor().compareTo(c2.getAuthor());
                }
            });
        } else if ("publisher".equals(input)) {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getPulisher().compareTo(c2.getPulisher());
                }
            });
        } else if ("price".equals(input)) {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getPrice().compareTo(c2.getPrice());
                }
            });
        } else {
            Collections.sort(result, new Comparator<Book>() {
                @Override
                public int compare(Book c1, Book c2) {
                    return c1.getPulishingDate().compareTo(c2.getPulishingDate());
                }
            });
        }
        return result;
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
