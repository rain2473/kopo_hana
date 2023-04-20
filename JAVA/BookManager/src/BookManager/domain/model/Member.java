package BookManager.domain.model;

import java.text.ParseException;
import java.util.*;

import BookManager.domain.table.MemberTable;

public class Member implements Comparable<Member>, Comparator<Member> {
	private String memberId;
	private boolean rentStatus;
	private MemberInformation informations;

	public Member(boolean rentStatus, String memberId, String name, String address, String contect, String birthday)
			throws ParseException {
		this.memberId = memberId;
		this.rentStatus = rentStatus;
		this.informations = new MemberInformation(name, address, contect, birthday);
	}

	public Member(String memberId, boolean rentStatus, MemberInformation informations) {
		this.memberId = memberId;
		this.rentStatus = rentStatus;
		this.informations = informations;
	}

	public Member(String name, String address, String contect, String birthday) throws ParseException {
		this(false, String.valueOf(MemberTable.getInstance().length()), name, address, contect, birthday);
	}

	public void setRentStatus(boolean status) {
		this.rentStatus = status;
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
	
	public MemberInformation getMemberInformation() {
		return this.informations;
	}

	public String getMemberName() {
		return this.informations.getMemberName();
	}
	
	public String getJoinDate() {
		return this.informations.getJoinDate();
	}

	public String getAddress() {
		return this.informations.getAddress();
	}
	
	public String getContect() {
		return this.informations.getContect();
	}

	public String getBirthDay() {
		return this.informations.getBirthday();
	}
	
	public String getAge() {
		return this.informations.getAge();
	}

	public void setMemberName(String name) {
		this.informations.setMemberName(name);
	}
	
	public void setJoinDate(String storeDate) {
		this.informations.setJoinDate(storeDate);
	}

	public void setAddress(String address) {
		this.informations.setAddress(address);
	}

	public void setContect(String contect) {
		this.informations.setContect(contect);
	}
	
	public void setBirthDay(String birthday) throws ParseException {
		this.informations.setBirthday(birthday);
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
		return this.informations.equals(book.informations);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(this.memberId + "," + this.RentStatus2String() + ",");
		result.append(this.informations.toString());
		return result.toString();
	}

	@Override
	public int compareTo(Member o) {
		return this.getMemberId().compareTo(o.getMemberId());
	}

	public boolean contains(String keyword) {
		for (String contents : this.informations.toArray()) {
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
	public Member clone() throws CloneNotSupportedException {
		StringBuilder parseClone = new StringBuilder(this.toString());
		parseClone.deleteCharAt(parseClone.length() - 1);
		String[] stringClone = parseClone.toString().split(",");
		List<String> infoList = new ArrayList<>();
		for (int i = 2; i < stringClone.length; i++) {
			infoList.add(stringClone[i]);
		}
		MemberInformation informations = new MemberInformation(infoList);
		return new Member(stringClone[0], (stringClone[1] == "대출있음"), informations);
	}
}
