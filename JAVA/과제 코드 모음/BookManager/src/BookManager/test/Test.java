package BookManager.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import BookManager.data.DataHandler;
import BookManager.domain.Library;
import BookManager.domain.model.Book;
import BookManager.domain.model.Member;
import BookManager.domain.model.RentalCase;
import BookManager.domain.table.BookTable;
import BookManager.domain.table.MemberTable;
import BookManager.domain.table.RentalCaseTable;

public class Test {
	public static void main(String[] args) throws IOException, ParseException, CloneNotSupportedException {
		Library library = Library.getInstance();
		BookTable booklist = BookTable.getInstance();
		RentalCaseTable rentalList = RentalCaseTable.getInstance();
		MemberTable memberList = MemberTable.getInstance();
//		DataHandler.loadFile("BackUpBooklist.csv", booklist);
//		DataHandler.loadFile("BackUpMemberlist.csv", memberList);
//		DataHandler.loadFile("BackUpRentallist.csv", rentalList);
		Book book1 = new Book("해리포터", "J.K.롤링", "블룸즈버리 퍼블리싱", "1997/06/25", "10000");
		booklist.addToList(book1);
		Book book2 = new Book("반지의 제왕", "J. R. R. 톨킨", "앨런 & 언윈", "1950/02/18", "15000");
		booklist.addToList(book2);
		Book book3 = new Book("판다의 엄지", "스티븐 제이 굴드", "랜덤하우스", "1980/02/19", "12000");
		booklist.addToList(book3);
		Book book4 = new Book("만들어진 신", "리처드 도킨스", "랜덤하우스", "1995/02/02", "18000");
		booklist.addToList(book4);
		Book book5 = new Book("코스모스", "칼 세이건", "랜덤하우스", "1980/04/23", "20000");
		booklist.addToList(book5);
		Member member1 = new Member("홍길동", "서울시", "010-1237-4568", "1501/02/13");
		memberList.addToList(member1);
		Member member2 = new Member("전우치", "평양시", "010-9876-4568", "1550/12/18");
		memberList.addToList(member2);
		Member member3 = new Member("김첨지", "부산시", "010-4562-9876", "1894/05/06");
		memberList.addToList(member3);
		for (Book book : booklist.listUp()) {
			System.out.println(book.toString());
		}


		library.rent("0", "3", true);
		library.rent("2", "2", false);
		library.rent("1", "4", false);

		for (Book book : booklist.listUp()) {
			System.out.println(book.toString());
		}

		for (RentalCase rent : rentalList.listUp()) {
			System.out.println(rent.toString());
		}

		library.extens("2");

		for (RentalCase rent : rentalList.listUp()) {
			System.out.println(rent.toString());
		}

		System.out.println("멤버 삭제");
		System.out.println(library.DeleteMember("2"));
		
		System.out.println("멤버 삭제 이후");
		for (Member member : memberList.listUp()) {
			System.out.println(member.toString());
		}

		library.undoDelete();
		System.out.println("멤버 삭제 취소");

		for (Member member : memberList.listUp()) {
			System.out.println(member.toString());
		}

		List<Book> sortedbooklist = booklist.sortedListUp("pulishingdate");

		for (Book book : sortedbooklist) {
			System.out.println(book.toString());
		}

		List<Member> sortedmemberlist = memberList.sortedListUp("address");

		for (Member book : sortedmemberlist) {
			System.out.println(book.toString());
		}

		List<RentalCase> sortedrentallist = rentalList.sortedListUp("remaindays");

		for (RentalCase book : sortedrentallist) {
			System.out.println(book.toString());
		}

		DataHandler.saveFile("BackUpRentallist.csv", rentalList);
		DataHandler.saveFile("BackUpMemberlist.csv", memberList);
		DataHandler.saveFile("BackUpBooklist.csv", booklist);
	}
}
