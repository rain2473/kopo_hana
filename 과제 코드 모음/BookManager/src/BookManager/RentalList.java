package BookManager;

import java.text.ParseException;
import java.util.*;
import java.util.stream.*;

public class RentalList implements Listable<RentalCase> {
    private static RentalList instance;
    public static HashMap<String, RentalCase> list = new HashMap<>();

    private RentalList() {}

    public static RentalList getInstance() {
        if (instance == null) {
            synchronized (RentalList.class) {
                if (instance == null) {
                    instance = new RentalList();
                }
            }
        }
        return instance;
    }
    
    public void setContent(String bookId) throws ParseException, CloneNotSupportedException {
        RentalCase rental = findById(bookId);
        rental.makeExtension();
    }

    @Override
    public void loadFromBackup(List<String> informations) {
        informations = new ArrayList<>(informations);
        try {
            String bookId = informations.get(0);
            String memberId = informations.get(1);
            boolean extension = RentalCase.String2Extension(informations.get(2));
            RentalList.list.put(bookId, new RentalCase(extension, bookId, memberId, informations));
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToList(RentalCase rent) {
        RentalList.list.put(rent.getBookId(), rent);
    }

    @Override
    public List<RentalCase> listUp() {
        return RentalList.list.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    public List<String> searchByKeyword(String keyword) {
        List<RentalCase> values = this.listUp();
        return values.stream().filter(book -> book.contains(keyword)).map(book -> book.getBookId())
                .toList();
    }

    @Override
    public RentalCase findById(String bookId) {
        return RentalList.list.get(bookId);
    }

    @Override
    public void deleteFromList(String bookId) {
        list.remove(bookId);
    }

    public void sort(String input) {
        input = input.toLowerCase();
        if ("bookid".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getBookId().compareTo(c2.getBookId());
                }
            });
        } else if ("mamberid".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getMemberId().compareTo(c2.getMemberId());
                }
            });
        } else if ("extension".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.Extension2String(c1.getExtension()).compareTo(c2.Extension2String(c2.getExtension()));
                }
            });
        } else if ("rentaldate".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getRentalDate().compareTo(c2.getRentalDate());
                }
            });
        } else if ("returndate".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getReturnDate().compareTo(c2.getReturnDate());
                }
            });
        } else if ("remaindays".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getRemainDays().compareTo(c2.getRemainDays());
                }
            });
        } else {
            this.sort();
        }
    }

    @Override
    public void sort() {
        Collections.sort(this.listUp());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("bookID,회원ID,연장여부,대여일자,반납일자,잔여일수\n");
        return result.toString();
    }

    @Override
    public int length() {
        return this.listUp().size();
    }

}
