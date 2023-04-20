package BookManager.domain.model;

import java.text.ParseException;
import java.util.*;

import BookManager.domain.table.RentalCaseTable;
import BookManager.utillities.DateHandler;

public class RentalCase implements Comparable<RentalCase>, Comparator<RentalCase> {
    final static int MAXIMUMDAYS = 21;
    final static int BASICDAYS = 14;
    private DateHandler dateHandler = DateHandler.getInstance();
    
    private String RentalCaseID;
    private String bookId;
    private String memberId;
    private boolean extension;
    private String rentalDate;
    private String returnDate;
    private String remainDays;

    public RentalCase(boolean extension, String bookId, String memberId) throws ParseException {
    	dateHandler.init();
    	this.RentalCaseID = String.valueOf(RentalCaseTable.getInstance().length());
    	this.bookId = bookId;
        this.memberId = memberId;
        this.extension = extension;
        this.rentalDate = dateHandler.now();
        setReturnDate();
        setRemainDays();
    }
    
    public RentalCase(List<String> input) throws ParseException {
    	this.RentalCaseID = input.get(0);
    	this.bookId = input.get(1);
        this.memberId = input.get(2);
        this.extension = String2Extension(input.get(3));
        this.rentalDate = input.get(4);
        this.returnDate = input.get(5);
        this.remainDays = input.get(6);
    }
    
    public String getRentalCaseID() {
        return this.RentalCaseID;
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getMemberId() {
        return this.memberId;
    }
    
    public boolean getExtension() {
        return this.extension;
    }

    public String Extension2String(boolean extension) {
        if (extension) {
            return "연장완료";
        } else {
            return "연장가능";
        }
    }

    public static boolean String2Extension(String string) {
        if (string == "연장완료") {
            return true;
        } else {
            return false;
        }
    }
    
    public String getRentalDate() {
        return this.rentalDate;
    }
    
    public String getReturnDate() {
        return this.returnDate;
    }

    public String getRemainDays() {
        return this.remainDays;
    }
    
    public void setExtension(boolean extension) {
        this.extension = extension;
    }
    
    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public void setReturnDate() throws ParseException {
        if (this.extension) {
            this.returnDate = dateHandler.add(this.getRentalDate(), MAXIMUMDAYS);
        } else {
            this.returnDate = dateHandler.add(this.getRentalDate(), BASICDAYS);
        }
        dateHandler.init();
    }

    public void setRemainDays() throws ParseException {
        this.remainDays = dateHandler.sub(this.getReturnDate(), dateHandler.now());
        dateHandler.init();
    }

    public void makeExtension() throws ParseException {
        if (!this.getExtension()) {
            this.setExtension(true);
            this.setReturnDate();
            this.setRemainDays();
            
            System.out.println("연장 완료.");
        }
        else {
        	System.out.println("연장이 불가능합니다 : 이미 연장 했음.");
        }
    }
    
    public ArrayList<String> getInformation() {
    	ArrayList<String> informations = new ArrayList<String>();
    	informations.add(RentalCaseID);
    	informations.add(bookId);
    	informations.add(memberId);
    	informations.add(Extension2String(extension));
    	informations.add(rentalDate);
    	informations.add(returnDate);
    	informations.add(remainDays);
        return informations;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof RentalCase))
            return false;
        RentalCase rentalCase = (RentalCase) obj;
        return this.getInformation().equals(rentalCase.getInformation());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String index : this.getInformation()) {
            result.append(index);
            result.append(",");
        }
        result.deleteCharAt(result.length() - 1);
        result.append("\n");
        return result.toString();
    }

    @Override
    public int compareTo(RentalCase o) {
        return this.getRemainDays().compareTo(o.getRemainDays());
    }

    public boolean contains(String keyword) {
        for (String contents : this.getInformation()) {
            if (contents.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compare(RentalCase o1, RentalCase o2) {
        return o1.getRemainDays().compareTo(o2.getRemainDays());
    }
}
