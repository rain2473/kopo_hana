package BookManagerDB.system;

import java.sql.*;
import java.util.*;
import BookManagerDB.presentation.*;
import BookManagerDB.utillities.*;

public class LibrarySystem {
	private static LibrarySystem instance;
	private static DataHandler dataHandler = DataHandler.getInstance();
	private static MainView mainView = MainView.getInstance();
	private static BookView bookView = BookView.getInstance();
	private static RentalView rentalView = RentalView.getInstance();

	private LibrarySystem() {
	}

	public static LibrarySystem getInstance() {
		if (instance == null) {
			synchronized (LibrarySystem.class) {
				if (instance == null) {
					instance = new LibrarySystem();
				}
			}
		}
		return instance;
	}

	public void open() throws ClassNotFoundException, SQLException {
		dataHandler.connect();
	}

	public void close() throws SQLException {
		dataHandler.disconnect();
	}

	public void showMain() throws SQLException {
		mainView.showMain();
	}

	public void showMemberList() throws SQLException {
		int selectInput = InputHandler.getInt();
		String sortby;
		switch (selectInput) {
		case 0:
			sortby = "member_id";
			break;
		case 1:
			sortby = "name";
			break;
		case 2:
			sortby = "join_date";
			break;
		case 3:
			sortby = "address";
			break;
		case 4:
			sortby = "contact";
			break;
		case 5:
			sortby = "birthday";
			break;
		case 6:
			sortby = "age";
			break;
		default:
			sortby = "rent_status";
			showMemberList();
			break;
		}
		String sql = "select * from member order by " + sortby;
		dataHandler.printQuery(sql);
	}

	public void showBookList() throws SQLException {
		int selectInput = InputHandler.getInt();
		String sortby;
		switch (selectInput) {
		case 0:
			sortby = "book_id";
			break;
		case 1:
			sortby = "name";
			break;
		case 2:
			sortby = "Store_date";
			break;
		case 3:
			sortby = "author";
			break;
		case 4:
			sortby = "publisher";
			break;
		case 5:
			sortby = "price";
			break;
		case 6:
			sortby = "publishing_date";
			break;
		default:
			sortby = "publishing_date";
			mainView.wrongInput();
			showBookList();
			break;
		}
		bookView.showSortOption();
		int selectInput1 = InputHandler.getInt();
		String filtering = "";
		switch (selectInput1) {
		case 0:
			return;

		case 1:
			filtering = "";
			break;

		case 2:
			filtering = "where rental_status = '대출가능'";
			break;
		default:
			mainView.wrongInput();
			showBookList();
			break;
		}
		String sql = "select * from book " + filtering + " order by " + sortby;
		dataHandler.printQuery(sql);
	}

	public void showRentalList() throws SQLException {
		int selectInput = InputHandler.getInt();
		String sortby;
		switch (selectInput) {
		case 0:
			sortby = "rental_id";
			break;
		case 1:
			sortby = "BOOK_NAME";
			break;
		case 2:
			sortby = "MEMBER_NAME";
			break;
		case 3:
			sortby = "extension";
			break;
		case 4:
			sortby = "rentaldate";
			break;
		case 5:
			sortby = "returndate";
			break;
		case 6:
			sortby = "remaindays";
			break;
		default:
			sortby = "remaindays";
			mainView.wrongInput();
			showRentalList();
			break;
		}
		String sql = "select j.rental_id, j.BOOK_NAME, m.name as MEMBER_NAME, j.EXTENSION, j.RENTALDATE,j.RETURNDATE,j.REMAINDAYS "
				+ "from "
				+ "(select r.*, b.name as BOOK_NAME "
				+ "from rent r, book b "
				+ "where r.book_id = b.book_id) j, member m "
				+ "where j.member_id = m.member_id "
				+ "order by " + sortby;
		dataHandler.printQuery(sql);
	}

	public void getMemberData(String name, String address, String contact, String birthday) throws SQLException {
		// 회원 인스턴스 생성
		String sql = "INSERT INTO Member (rent_status, name, address, contact, birthday, age) VALUES ('대출가능', '" + name
				+ "', '" + address + "', '" + contact + "', TO_DATE('" + birthday
				+ "', 'YYYY-MM-DD'), TRUNC((SYSDATE - TO_DATE('" + birthday + "', 'YYYY-MM-DD')) / 365.25))";
		dataHandler.dmlQuery(sql);
	}

	public void getBookData(String name, String author, String publisher, String pulishingDate, String price)
			throws SQLException {
		// 책 인스턴스 생성
		String sql = "INSERT INTO book (rental_status, name, author, publisher, publishing_date, price) VALUES ('대출가능', '"
				+ name + "', '" + author + "', '" + publisher + "', to_date('" + pulishingDate + "', 'YYYY-MM-DD'), "
				+ price + ")";
		dataHandler.dmlQuery(sql);
	}

	public void updateMemberData(String updateId) throws SQLException {
		String sql = "select * from member where MEMBER_ID = '" + updateId + "'";
		List<String> updateMember = dataHandler.selectQuery(sql).get(1);
		String name = updateMember.get(2);
		String address = updateMember.get(4);
		String contact = updateMember.get(5);
		String birthday = updateMember.get(6);
		while (true) {
			MemberView.getInstance().showUpdate();
			int memberOptionInput = InputHandler.getInt();
			switch (memberOptionInput) {
			case 0: // 수정 완료
				sql = "update member set name = '" + name + "', address = '" + address + "', contact = '" + contact
						+ "', birthday = TO_DATE('" + birthday + "', 'YYYY-MM-DD'), age = TRUNC((SYSDATE - TO_DATE('"
						+ birthday + "', 'YYYY-MM-DD')) / 365.25) where MEMBER_ID = '" + updateId + "'";
				dataHandler.dmlQuery(sql);
				dataHandler.commit();
				mainView.finishUpdate(1);
				return;

			case 1: // 회원 이름
				name = mainView.getupdate(name, "이름");
				break;

			case 2: // 회원 주소
				address = mainView.getupdate(address, "주소");
				break;

			case 3: // 회원 연락처
				contact = mainView.getupdate(contact, "연락처");
				break;

			case 4: // 회원 생일
				birthday = mainView.getupdate(birthday, "생일");
				break;

			case 5: // 수정 취소
				mainView.finishUpdate(2);
				dataHandler.rollback();
				return;
			default:
				mainView.wrongInput();
				continue;
			}
		}
	}

	public void updateBookData(String updateId) throws SQLException {
		String sql = "select * from book where BOOK_ID = '" + updateId + "'";
		List<String> updateBook = dataHandler.selectQuery(sql).get(1);
		String name = updateBook.get(2);
		String author = updateBook.get(4);
		String publisher = updateBook.get(5);
		String publishingDate = updateBook.get(6);
		String price = updateBook.get(7);
		while (true) {
			BookView.getInstance().showUpdate();
			int BookOptionInput = InputHandler.getInt();

			switch (BookOptionInput) {
			case 0: // 수정 완료
				sql = "update book set name = '" + name + "', author = '" + author + "', publisher = '" + publisher
						+ "', publishing_Date = TO_DATE('" + publishingDate + "', 'YYYY-MM-DD'), price = '" + price
						+ "' where BOOK_ID = '" + updateId + "'";
				dataHandler.dmlQuery(sql);
				dataHandler.commit();
				mainView.finishUpdate(1);
				return;

			case 1: // 회원 이름
				name = mainView.getupdate(name, "이름");
				break;

			case 2: // 회원 주소
				author = mainView.getupdate(author, "작가");
				break;

			case 3: // 회원 연락처
				publisher = mainView.getupdate(publisher, "출판사");
				break;

			case 4: // 회원 생일
				publishingDate = mainView.getupdate(publishingDate, "출판일");
				break;

			case 5: // 회원 생일
				price = mainView.getupdate(price, "가격");
				break;

			case 6: // 수정 취소
				mainView.finishUpdate(2);
				dataHandler.rollback();
				return;
			default:
				mainView.wrongInput();
				continue;
			}
		}
	}

	public void deleteMemberData(String memberId) throws SQLException {
		List<String> sql = new ArrayList<String>();
		sql.add("DELETE FROM resign");
		sql.add("INSERT INTO resign SELECT * FROM member WHERE MEMBER_ID = '" + memberId + "'");
		sql.add("DELETE FROM member WHERE MEMBER_ID = '" + memberId + "'");
		dataHandler.dmlQuery(sql);
	}

	public void deleteBookData(String bookId) throws SQLException {
		String sql = "DELETE FROM book WHERE BOOK_ID = '" + bookId + "'";
		dataHandler.dmlQuery(sql);
	}

	public void undoDelete() throws SQLException {
		List<String> sql = new ArrayList<String>();
		sql.add("INSERT INTO member SELECT * FROM resign");
		sql.add("DELETE FROM resign");
		dataHandler.dmlQuery(sql);
	}

	public boolean transactionCheck(String memberId, String BookId) throws SQLException {
		// 유효성 검사
		boolean checkMemberId = false;
		if (memberId != null) {
			checkMemberId = true;
		}

		if (checkMemberId == false) {
			RentalView.getInstance().showNotExist("member");
		}

		// 해당 도서 rent 상태 true 처리
		boolean checkBookId = false;
		if (BookId != null) {
			checkBookId = true;
		}

		if (checkBookId == false) {
			RentalView.getInstance().showNotExist("book");
		}
		if (checkBookId && checkMemberId) {
			return true;
		}
		return false;
	}

	public String[] getIDs(String BookName, String memberName) throws SQLException {
		String[] ids = new String[3];
		String rentalId;
		String BookId = dataHandler.selectQuery("select book_id from book where name = '" + BookName + "'").get(1)
				.get(0);
		String memberId = dataHandler.selectQuery("select member_id from member where name = '" + memberName + "'")
				.get(1).get(0);
		if (this.transactionCheck(memberId, BookId)) {
			try {
				rentalId = dataHandler.selectQuery("select rental_id from rent where book_id = '" + BookId
						+ "' and member_id = '" + memberId + "'").get(1).get(0);
			} catch (IndexOutOfBoundsException e) {
				rentalId = "";
			}
			ids[0] = rentalId;
			ids[1] = BookId;
			ids[2] = memberId;
		} else {
			ids = null;
		}
		return ids;
	}

	public void Rent(String BookName, String memberName) throws SQLException {
		String extension = "연장가능";
		int remaindays = 14;
		List<String> sql = new ArrayList<String>();
		String[] ids = this.getIDs(BookName, memberName);
		if (ids == null) {
			return;
		}
		String BookId = ids[1];
		String memberId = ids[2];
		rentalView.showrent();
		String input = InputHandler.getInput().toLowerCase();
		switch (input) {
		case "y": // 연장
			extension = "연장완료";
			remaindays = 21;
			break;
		case "n": // 연장 안함
			extension = "연장가능";
			remaindays = 14;
			break;
		default:
			mainView.wrongInput();
			Rent(BookName, memberName);
		}
		sql.add("INSERT INTO rent (book_id, member_id, extension, returndate, remaindays) VALUES ('" + BookId + "', '"
				+ memberId + "', '" + extension + "', to_char(sysdate + " + remaindays + ", 'YYYY-MM-DD'), "
				+ remaindays + ")");
		sql.add("update member set rent_status = '대출중' where member_id = '" + memberId + "'");
		sql.add("update book set rental_status = '대출중' where book_id = '" + BookId + "'");
		dataHandler.dmlQuery(sql);
	}

	public void extens(String BookName, String memberName) throws SQLException {
		String[] ids = this.getIDs(BookName, memberName);
		if (ids == null) {
			return;
		}
		String rentalId = ids[0];
		String extension = dataHandler.selectQuery("select extension from rent where rental_id = '" + rentalId + "'")
				.get(1).get(0);
		if (extension == "연장완료") {
			rentalView.showextens(2);
		} else {
			dataHandler.dmlQuery("update rent set extension = '연장완료', "
					+ "returndate = to_char(returndate + 7, 'YYYY-MM-DD'), remaindays = remaindays + 7 where rental_id = '" + rentalId
					+ "'");
			rentalView.showextens(1);
		}
	}

	public void returnBook(String BookName, String memberName) throws SQLException {
		String[] ids = this.getIDs(BookName, memberName);
		if (ids == null) {
			return;
		}
		List<String> sql = new ArrayList<String>();
		String rentalId = ids[0];
		String BookId = ids[1];
		String memberId = ids[2];
		sql.add("DELETE FROM rent WHERE rental_id = '" + rentalId + "'");
		sql.add("update member set rent_status = '대출가능' where member_id = '" + memberId + "'");
		sql.add("update book set rental_status = '대출가능' where book_id = '" + BookId + "'");
		dataHandler.dmlQuery(sql);
	}
}
