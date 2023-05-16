package BookManager.domain.model;

import java.util.List;

import BookManager.utillities.DateHandler;

public class BookInformation {
	private String name;
	private String storeDate;
	private String author;
	private String publisher;
	private String publishingDate;
	private String price;
	
    public BookInformation(String name, String author, String publisher, String publishingDate, String price) {
        this.name = name;
        this.storeDate = DateHandler.getInstance().now();
        this.author = author;
        this.publisher = publisher;
        this.publishingDate = publishingDate;
        this.price = price;
    }
    
    public BookInformation(List<String> input) {
    	this.name = input.get(0);
        this.storeDate = input.get(1);
        this.author = input.get(2);
        this.publisher = input.get(3);
        this.publishingDate = input.get(4);
        this.price = input.get(5);
    }
    
    public String getBookName() {
        return this.name;
    }

    public String getStoreDate() {
        return this.storeDate;
    }

    public String getAuthor() {
        return this.author;
    }
    
    public String getPulisher() {
        return this.publisher;
    }

    public String getPulishingDate() {
        return this.publishingDate;
    }
    
    public String getPrice() {
        return this.price;
    }

    public void setBookName(String name) {
        this.name = name;
    }

    public void setStoreDate(String storeDate) {
        this.storeDate = storeDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setPulisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPulishingDate(String publishingDate) {
        this.publishingDate = publishingDate;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public String[] toArray() {
    	String[] result = {this.name, this.storeDate, this.author, this.publisher, this.publishingDate, this.price};
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
