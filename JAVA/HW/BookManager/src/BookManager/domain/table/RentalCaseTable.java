package BookManager.domain.table;

import java.text.ParseException;
import java.util.*;
import java.util.stream.*;

import BookManager.domain.model.RentalCase;

public class RentalCaseTable implements DataTable<RentalCase> {
    private static RentalCaseTable instance;
    public static HashMap<String, RentalCase> table = new HashMap<>();

    private RentalCaseTable() {}

    public static RentalCaseTable getInstance() {
        if (instance == null) {
            synchronized (RentalCaseTable.class) {
                if (instance == null) {
                    instance = new RentalCaseTable();
                }
            }
        }
        return instance;
    }
    
    public void setContent(String RentalCaseID) throws ParseException, CloneNotSupportedException {
        RentalCase rental = findById(RentalCaseID);
        rental.makeExtension();
    }

    @Override
    public void loadFromBackup(List<String> informations) {
        informations = new ArrayList<>(informations);
        try {
            String RentalCaseID = informations.get(0);
            RentalCaseTable.table.put(RentalCaseID, new RentalCase(informations));
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToList(RentalCase rent) {
        RentalCaseTable.table.put(rent.getRentalCaseID(), rent);
    }

    @Override
    public List<RentalCase> listUp() {
        return RentalCaseTable.table.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    public List<String> searchByKeyword(String keyword) {
        List<RentalCase> values = this.listUp();
        return values.stream().filter(rent -> rent.contains(keyword)).map(rent -> rent.getRentalCaseID())
                .toList();
    }

    @Override
    public RentalCase findById(String RentalCaseID) {
        return RentalCaseTable.table.get(RentalCaseID);
    }

    @Override
    public void deleteFromList(String RentalCaseID) {
        table.remove(RentalCaseID);
    }

    public List<RentalCase> sortedListUp(String input) {
        List<RentalCase> result = new ArrayList<RentalCase>(this.listUp());
        input = input.toLowerCase();
        if ("RentalCaseID".equals(input)) {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getRentalCaseID().compareTo(c2.getRentalCaseID());
                }
            });
        } else if ("bookid".equals(input)) {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getBookId().compareTo(c2.getBookId());
                }
            });
        } else if ("mamberid".equals(input)) {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getMemberId().compareTo(c2.getMemberId());
                }
            });
        } else if ("extension".equals(input)) {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.Extension2String(c1.getExtension()).compareTo(c2.Extension2String(c2.getExtension()));
                }
            });
        } else if ("rentaldate".equals(input)) {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getRentalDate().compareTo(c2.getRentalDate());
                }
            });
        } else if ("returndate".equals(input)) {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getReturnDate().compareTo(c2.getReturnDate());
                }
            });
        } else if ("remaindays".equals(input)) {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getRemainDays().compareTo(c2.getRemainDays());
                }
            });
        } else {
            Collections.sort(result, new Comparator<RentalCase>() {
                @Override
                public int compare(RentalCase c1, RentalCase c2) {
                    return c1.getRemainDays().compareTo(c2.getRemainDays());
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
        StringBuilder result = new StringBuilder("대출건ID,bookID,회원ID,연장여부,대여일자,반납일자,잔여일수\n");
        return result.toString();
    }

    @Override
    public int length() {
        return this.listUp().size();
    }

}
