package BookManager;

import java.text.ParseException;
import java.util.*;

public class RentalCase implements Comparable<RentalCase>, Comparator<RentalCase> {
    final static int MAXIMUMDAYS = 21;
    final static int BASICDAYS = 14;
    private DateHandler dateHandler = DateHandler.getInstance();
    private List<String> informations = new ArrayList<>();

    private String bookId;
    private String memberId;
    private boolean extension;
    private String showExtension;
    private String rentalDate;
    private String returnDate;
    private String remainDays;

    public RentalCase(boolean extension, String bookId, String memberId) throws ParseException {
        informations.add(this.bookId = bookId);
        informations.add(this.memberId = memberId);
        this.rentalDate = dateHandler.now();
        dateHandler.init();
        this.setInformation(extension);
    }
    
    public RentalCase(boolean extension, String bookId, String memberId, List<String> informations) throws ParseException {
        this.informations = informations;
        informations.add(this.memberId = memberId);
        this.rentalDate = dateHandler.now();
        dateHandler.init();
        this.setInformation(extension);
    }

    public String getBookId() {
        return this.bookId;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setExtension(boolean extension) {
        this.extension = extension;
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

    public void makeExtension() throws ParseException {
        if (!this.getExtension()) {
            this.setExtension(true);
            setInformation(true);
        }
    }
    
    public String getshowString() {
        return this.showExtension;
        
    }
    
    public String getRentalDate() {
        return this.rentalDate;
    }

    public void setReturnDate() throws ParseException {
        if (this.extension) {
            this.returnDate = dateHandler.add(this.getRentalDate(), MAXIMUMDAYS);
        } else {
            this.returnDate = dateHandler.add(this.getRentalDate(), BASICDAYS);
        }
        dateHandler.init();
    }

    public String getReturnDate() {
        return this.returnDate;
    }

    public String getRemainDays() {
        return this.remainDays;
    }

    public void setRemainDays() throws ParseException {
        this.remainDays = dateHandler.sub(this.getReturnDate(), dateHandler.now());
        dateHandler.init();
    }

    public List<String> getInformation() {
        return this.informations;
    }

    public void setInformation(boolean extension) throws ParseException {
        rentalDate = getRentalDate();
        informations.clear();
        informations.add(this.bookId);
        informations.add(this.memberId);
        this.extension = extension;
        informations.add(this.showExtension = this.Extension2String(extension));
        informations.add(this.rentalDate);
        this.setReturnDate();
        informations.add(this.returnDate);
        this.setRemainDays();
        informations.add(this.remainDays);
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
        for (String index : this.informations) {
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

    @Override
    protected RentalCase clone() throws CloneNotSupportedException {
        RentalCase clone = null;
        try {
            clone = new RentalCase(this.extension, this.bookId, this.memberId, this.informations);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
