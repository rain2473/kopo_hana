package BookManager.domain.model;

import java.text.ParseException;
import java.util.*;
import BookManager.utillities.DateHandler;

public class MemberInformation {
	private String name;
	private String joinDate;
	private String address;
	private String contect;
	private String birthday;
	private String age;
	
	public MemberInformation(String name, String address, String contect, String birthday) throws ParseException {
		this.name = name;
		this.joinDate = DateHandler.getInstance().now();
		this.address = address;
		this.contect = contect;
		this.birthday = birthday;
		this.age = DateHandler.getInstance().age(birthday);
	}

	public MemberInformation(List<String> input) {
    	this.name = input.get(0);
        this.joinDate = input.get(1);
        this.address = input.get(2);
        this.contect = input.get(3);
        this.birthday = input.get(4);
        this.age = input.get(5);
    }
	public String getMemberName() {
        return this.name;
    }

    public String getJoinDate() {
        return this.joinDate;
    }

    public String getAddress() {
        return this.address;
    }
    
    public String getContect() {
        return this.contect;
    }

    public String getBirthday() {
        return this.birthday;
    }
    
    public String getAge() {
        return this.age;
    }

    public void setMemberName(String name) {
        this.name = name;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setContect(String contect) {
        this.contect = contect;
    }

    public void setBirthday(String birthday) throws ParseException {
        this.birthday = birthday;
        this.age = DateHandler.getInstance().age(birthday);
    }
    
    public String[] toArray() {
    	String[] result = {this.name, this.joinDate, this.address, this.contect, this.birthday, this.age};
    	return result;
    }
    
    @Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (String data : this.toArray()) {
			result.append(data);
			result.append(",");
		}
		result.deleteCharAt(result.length() - 1);
		result.append("\n");
		return result.toString();
	}
}
