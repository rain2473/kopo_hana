package BookManager;

import java.text.ParseException;
import java.util.*;

public class Member implements Comparable<Member>, Comparator<Member> {
    private String memberId;
    private boolean rentStatus;
    private List<String> informations = new ArrayList<>();

    public Member(boolean rentStatus, String memberId, String name, String address, String contect,
            String birthday) throws ParseException {
        this.memberId = memberId;
        informations.add(name);
        informations.add(DateHandler.getInstance().now());
        informations.add(address);
        informations.add(contect);
        informations.add(birthday);
        informations.add(DateHandler.getInstance().age(birthday));
        this.rentStatus = rentStatus;
        informations.add(this.RentStatus2String());
    }

    public Member(String memberId, boolean rentStatus, List<String> informations) {
        this.memberId = memberId;
        this.rentStatus = rentStatus;
        this.informations = informations;
    }

    public Member(String name, String address, String contect, String birthday)
            throws ParseException {
        this(false, String.valueOf(MemberList.getInstance().length()), name, address, contect,
                birthday);
    }

    public void setRentStatus(boolean status) {
        this.rentStatus = status;
        this.informations.set(6, RentStatus2String());
    }

    public boolean getRentStatus() {
        return this.rentStatus;
    }

    public String RentStatus2String() {
        if (getRentStatus()) {
            return "대출있음";
        } else {
            return "대출가능";
        }
    }

    public String getMemberId() {
        return this.memberId;
    }

    public String getName() {
        return this.informations.get(0);
    }

    public String setName(String name) {
        return this.informations.set(0, name);
    }

    public String getJoinDate() {
        return this.informations.get(1);
    }

    public String getAddress() {
        return this.informations.get(2);
    }

    public String setAddress(String address) {
        return this.informations.set(2, address);
    }

    public String getContect() {
        return this.informations.get(3);
    }

    public String setContect(String contect) {
        return this.informations.set(3, contect);
    }

    public String getBirthDay() {
        return this.informations.get(4);
    }

    public String setBirthDay(String birthday) {
        return this.informations.set(4, birthday);
    }

    public String getAge() {
        return this.informations.get(5);
    }

    public List<String> getInformations() {
        return this.informations;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Member))
            return false;
        Member book = (Member) obj;
        return this.getInformations().equals(book.getInformations());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.memberId + ",");
        for (String index : this.informations) {
            result.append(index);
            result.append(",");
        }
        result.deleteCharAt(result.length() - 1);
        result.append("\n");
        return result.toString();
    }

    @Override
    public int compareTo(Member o) {
        return this.getMemberId().compareTo(o.getMemberId());
    }

    public boolean contains(String keyword) {
        for (String contents : this.getInformations()) {
            if (contents.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compare(Member o1, Member o2) {
        return o1.getMemberId().compareTo(o2.getMemberId());
    }

    @Override
    protected Member clone() throws CloneNotSupportedException {
        StringBuilder parseClone = new StringBuilder(this.toString());
        parseClone.deleteCharAt(parseClone.length() - 1);
        String[] stringClone = parseClone.toString().split(",");
        List<String> informations = new ArrayList<>();
        for (int i = 0; i < stringClone.length; i++) {
            if (i == 0) {
                String memberId = stringClone[0];
                continue;
            } else if (i == stringClone.length - 1) {
                if (stringClone[i] == "대출있음") {
                    boolean rentStatus = true;
                } else {
                    rentStatus = false;
                }
            }
            informations.add(stringClone[i]);
        }
        return new Member(memberId, rentStatus, informations);
    }
}
