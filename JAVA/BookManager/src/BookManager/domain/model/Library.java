package BookManager.domain.model;

import java.io.IOException;
import java.text.ParseException;

import BookManager.domain.table.BookTable;
import BookManager.domain.table.MemberTable;
import BookManager.domain.table.RentalCaseTable;

public class Library {
	private static Library instance;
	BookTable booklist = BookTable.getInstance();
	RentalCaseTable rentalList = RentalCaseTable.getInstance();
	MemberTable memberList = MemberTable.getInstance();

	private Library() {
	}

	public static Library getInstance() {
		if (instance == null) {
			synchronized (Library.class) {
				if (instance == null) {
					instance = new Library();
				}
			}
		}
		return instance;
	}

	public void rent(String memberId, String BookId, boolean extension) throws IOException, ParseException {
		RentalCase rental = new RentalCase(extension, BookId, memberId);
		rentalList.addToList(rental);
		Book book = booklist.findById(BookId);
		Member member = memberList.findById(memberId);
		book.setRentalStatus(true);
		member.setRentStatus(true);
	}

	public void returnBook(String RentalCaseID) throws IOException, ParseException {
		String BookId = rentalList.findById(RentalCaseID).getInformation().get(0);
		String memberId = rentalList.findById(RentalCaseID).getInformation().get(1);
		rentalList.deleteFromList(RentalCaseID);
		Book book = booklist.findById(BookId);
		Member member = memberList.findById(memberId);
		book.setRentalStatus(false);
		member.setRentStatus(false);
	}

	public void extens(String RentalCaseID) throws IOException, ParseException, CloneNotSupportedException {
		rentalList.setContent(RentalCaseID);
	}

	public Member DeleteMember(String memberId) throws IOException, ParseException, CloneNotSupportedException {
		memberList.deleteFromList(memberId);
		return memberList.resigner;
	}
	
	public void DeleteBook(String bookId) {
		booklist.deleteFromList(bookId);
	}

	public void undoDelete() throws NullPointerException {
		memberList.addToList(memberList.resigner);
	}

	public void updateMember(String updateId, String name, String address, String contect, String birthday) throws ParseException {
		Member updateMember = memberList.findById(updateId);
		updateMember.setMemberName(name);
		updateMember.setAddress(address);
		updateMember.setContect(contect);
		updateMember.setBirthDay(birthday);
	}
	
	public void updateBook(String updateId, String name, String author, String publisher, String publishingDate, String price) throws ParseException {
		Book updateBook = booklist.findById(updateId);
		updateBook.setBookName(name);
		updateBook.setAuthor(author);
		updateBook.setPulishingDate(publishingDate);
		updateBook.setPulisher(publisher);
		updateBook.setPrice(price);
	}
}
