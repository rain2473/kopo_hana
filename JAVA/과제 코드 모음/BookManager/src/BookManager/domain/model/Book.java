package BookManager.domain.model;

import java.util.*;

import BookManager.domain.table.BookTable;

public class Book implements Comparable<Book>, Comparator<Book> {
	private boolean rentalStatus;
	private String bookId;
	private BookInformation informations;

	public Book(boolean rentalStatus, String bookId, String name, String author, String publisher, String pulishingDate,
			String price) {
		this.rentalStatus = rentalStatus;
		this.bookId = bookId;
		this.informations = new BookInformation(name, author, publisher, pulishingDate, price);
	}

	public Book(String bookId, boolean rentalStatus, BookInformation informations) {
		this.rentalStatus = rentalStatus;
		this.bookId = bookId;
		this.informations = informations;
	}

	public Book(String name, String author, String publisher, String pulishingDate, String price) {
		this(false, String.valueOf(BookTable.getInstance().length()), name, author, publisher, pulishingDate, price);
	}

	public void setRentalStatus(boolean status) {
		this.rentalStatus = status;
	}

	public boolean getRentalStatus() {
		return this.rentalStatus;
	}

	public String rentalStatus2String() {
		if (getRentalStatus()) {
			return "대출중";
		} else {
			return "대출가능";
		}
	}

	public String getBookId() {
		return this.bookId;
	}

	public BookInformation getBookInformations() {
		return this.informations;
	}

	public String getBookName() {
		return this.informations.getBookName();
	}

	public String getStoreDate() {
		return this.informations.getStoreDate();
	}

	public String getAuthor() {
		return this.informations.getAuthor();
	}

	public String getPulisher() {
		return this.informations.getPulisher();
	}

	public String getPulishingDate() {
		return this.informations.getPulishingDate();
	}

	public String getPrice() {
		return this.informations.getPrice();
	}

	public void setBookName(String name) {
		this.informations.setBookName(name);
	}

	public void setStoreDate(String storeDate) {
		this.informations.setBookName(storeDate);
	}

	public void setAuthor(String author) {
		this.informations.setBookName(author);
	}

	public void setPulisher(String publisher) {
		this.informations.setBookName(publisher);
	}

	public void setPulishingDate(String publishingDate) {
		this.informations.setBookName(publishingDate);
	}

	public void setPrice(String price) {
		this.informations.setBookName(price);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Book))
			return false;
		Book book = (Book) obj;
		return this.informations.equals(book.getBookInformations());
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(this.bookId + "," + this.rentalStatus2String() + ",");
		result.append(this.informations.toString());
		return result.toString();
	}

	@Override
	public int compareTo(Book o) {
		return this.getPulishingDate().compareTo(o.getPulishingDate());
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
	public int compare(Book o1, Book o2) {
		return o1.getPulishingDate().compareTo(o2.getPulishingDate());
	}
}
