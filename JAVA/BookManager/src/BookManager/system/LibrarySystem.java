package BookManager.system;

import java.io.IOException;
import java.text.ParseException;

import BookManager.presentation.MainView;
import BookManager.utillities.DataHandler;
import BookManager.utillities.InputHandler;
import BookManager.domain.model.Book;
import BookManager.domain.model.Library;
import BookManager.domain.model.Member;
import BookManager.domain.model.RentalCase;
import BookManager.domain.table.BookTable;
import BookManager.domain.table.MemberTable;
import BookManager.domain.table.RentalCaseTable;

public class LibrarySystem {
	private static LibrarySystem instance;
	Library library = Library.getInstance();
	BookTable booklist = BookTable.getInstance();
	RentalCaseTable rentalList = RentalCaseTable.getInstance();
	MemberTable memberList = MemberTable.getInstance();

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

	public void open() throws IOException {
		DataHandler.loadFile("BackUpBooklist.csv", this.booklist);
		DataHandler.loadFile("BackUpRentallist.csv", this.rentalList);
		DataHandler.loadFile("BackUpMemberlist.csv", this.memberList);
	}

	public void close() throws IOException {
		DataHandler.saveFile("BackUpBooklist.csv", this.booklist);
		DataHandler.saveFile("BackUpRentallist.csv", this.rentalList);
		DataHandler.saveFile("BackUpMemberlist.csv", this.memberList);
	}

	public void showMain() throws IOException, ParseException, CloneNotSupportedException {
		MainView.getInstance().showMain();
	}

	public void showMemberList() {
		System.out.println("========== 회원 조회 ==========");
		System.out.println(" 0. 기본 조회");
		System.out.println(" 1. 회원 이름순 조회");
		System.out.println(" 2. 회원 가입일순 조회");
		System.out.println(" 3. 회원 주소순 조회");
		System.out.println(" 4. 회원 연락처순 조회");
		System.out.println(" 5. 회원 생년월일순 조회");
		System.out.println(" 6. 회원 생일순 조회");
		System.out.println("===============================");
		int selectInput = InputHandler.getInt();
		String sortby;
		switch (selectInput) {
		case 0:
			sortby = "memberid";
			break;
		case 1:
			sortby = "name";
			break;
		case 2:
			sortby = "joindate";
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
			sortby = "rentstatus";
			break;
		}
		for (Member member : this.memberList.sortedListUp(sortby)) {
			System.out.println(member.toString());
		}
	}

	public void showBookList() {
		System.out.println("========== 도서 조회 ==========");
		System.out.println(" 0. 기본 조회");
		System.out.println(" 1. 도서 이름순 조회");
		System.out.println(" 2. 도서 입고일순 조회");
		System.out.println(" 3. 도서 작가순 조회");
		System.out.println(" 4. 도서 출판사순 조회");
		System.out.println(" 5. 도서 가격순 조회");
		System.out.println(" 6. 도서 출판일순 조회");
		System.out.println("===============================");
		int selectInput = InputHandler.getInt();
		String sortby;
		switch (selectInput) {
		case 0:
			sortby = "bookid";
			break;
		case 1:
			sortby = "bookname";
			break;
		case 2:
			sortby = "Storedate";
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
			sortby = " ";
			break;
		default:
			sortby = " ";
			break;
		}
		System.out.println("========== 도서 조회 ==========");
		System.out.println(" 0. 뒤로");
		System.out.println(" 1. 도서 전체 조회");
		System.out.println(" 2. 대출 가능한 도서 조회");
		System.out.println("===============================");
		int selectInput1 = InputHandler.getInt();

		switch (selectInput1) {
		case 0:
			return;

		case 1:
			for (Book book : this.booklist.sortedListUp(sortby)) {
				System.out.println(book.toString());
			}
			break;

		case 2:
			for (Book book : this.booklist.sortedListUp(sortby)) {
				if (!book.getRentalStatus()) {
					System.out.println(book.toString());
				}
			}
			break;
		default:
			System.out.println("잘못된 입력");
			break;
		}
	}

	public void showRentalList() {
		System.out.println("========== 회원 조회 ==========");
		System.out.println(" 0. 기본 조회");
		System.out.println(" 1. 도서 ID순 조회");
		System.out.println(" 2. 회원 ID순 조회");
		System.out.println(" 3. 연장 여부순 조회");
		System.out.println(" 4. 대여 일자순 조회");
		System.out.println(" 5. 반납 일자순 조회");
		System.out.println(" 6. 남은 기간순 조회");
		System.out.println("===============================");
		int selectInput = InputHandler.getInt();
		String sortby;
		switch (selectInput) {
		case 0:
			sortby = "RentalCaseID";
			break;
		case 1:
			sortby = "bookid";
			break;
		case 2:
			sortby = "mamberid";
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
			break;
		}
		for (RentalCase rental : this.rentalList.sortedListUp(sortby)) {
			System.out.println(rental.toString());
		}
	}

	public void getMemberData() throws ParseException {
		// 이름 받기
		System.out.print("이름 : ");
		String name = InputHandler.getInput();
		// 주소
		System.out.print("주소 : ");
		String address = InputHandler.getInput();
		// 연락처
		System.out.print("연락처 : ");
		String contect = InputHandler.getInput();
		// 생일
		System.out.print("생일(yyyy/MM/dd) : ");
		String birthday = InputHandler.getInput();
		// 회원 인스턴스 생성
		Member member = new Member(name, address, contect, birthday);
		// 회원 등록!
		this.memberList.addToList(member);
	}

	public void getBookData() throws ParseException {
		System.out.print("도서 제목 : ");
		String name = InputHandler.getInput();
		// 도서 출간일 받기
		System.out.print("저자 : ");
		String author = InputHandler.getInput();
		System.out.print("출판사 : ");
		String publisher = InputHandler.getInput();
		// 도서 출간일 받기
		System.out.print("출간 일(yyyy/MM/dd): ");
		String pulishingDate = InputHandler.getInput();
		System.out.print("도서 가격 : ");
		String price = InputHandler.getInput();
		// 책 인스턴스 생성
		Book book = new Book(name, author, publisher, pulishingDate, price);
		// 책 등록!
		this.booklist.addToList(book); // 등록 결과는 해당 메서드에서 처리
	}

	public void updateMemberData() throws ParseException {
		System.out.println("수정할 회원 ID : ");
		String updateId = InputHandler.getInput();
		Member updateMember = this.memberList.findById(updateId);
		String name = updateMember.getMemberName();
		String address = updateMember.getAddress();
		String contect = updateMember.getContect();
		String birthday = updateMember.getBirthDay();
		while (true) {
			System.out.println("======== 회원 정보 수정 ========");
			System.out.println(" 0. 수정 완료");
			System.out.println(" 1. 회원 이름");
			System.out.println(" 2. 회원 주소");
			System.out.println(" 3. 회원 연락처");
			System.out.println(" 4. 회원 생일");
			System.out.println(" 5. 수정 취소");
			System.out.println("====================================");
			int memberOptionInput = InputHandler.getInt();

			switch (memberOptionInput) {
			case 0: // 수정 완료
				System.out.println("회원 정보가 수정되었습니다.\n");
				this.library.updateMember(updateId, name, address, contect, birthday);
				return;

			case 1: // 회원 이름
				System.out.println("현재 이름 : " + name + "\n수정할 이름 : ");
				name = InputHandler.getInput();
				continue;

			case 2: // 회원 주소
				System.out.println("현재 주소 : " + address + "\n수정할 주소 : ");
				address = InputHandler.getInput();
				continue;

			case 3: // 회원 연락처
				System.out.println("현재 연락처 : " + contect + "\n수정할 연락처 : ");
				contect = InputHandler.getInput();
				continue;

			case 4: // 회원 생일
				System.out.println("현재 생일 : " + birthday + "\n수정할 생일 : ");
				birthday = InputHandler.getInput();
				continue;

			case 5: // 수정 취소
				System.out.println("모든 수정 사항이 초기화 됩니다.\n수정이 취소되었습니다.n");
				break;
			default:
				System.out.println("올바른 값을 입력하세요\n");
				continue;
			}
		}
	}

	public void updateBookData() throws ParseException {
		System.out.println("수정할 도서 ID : ");
		String updateId = InputHandler.getInput();
		Book updateBook = this.booklist.findById(updateId);
		String name = updateBook.getBookName();
		String author = updateBook.getAuthor();
		String publisher = updateBook.getPulisher();
		String publishingDate = updateBook.getPulishingDate();
		String price = updateBook.getPrice();
		while (true) {
			System.out.println("======== 회원 정보 수정 ========");
			System.out.println(" 0. 수정 완료");
			System.out.println(" 1. 책 이름");
			System.out.println(" 2. 책 작가");
			System.out.println(" 3. 책 출판사");
			System.out.println(" 4. 책 출판일");
			System.out.println(" 5. 책 가격");
			System.out.println(" 6. 수정 취소");
			System.out.println("====================================");
			int memberOptionInput = InputHandler.getInt();

			switch (memberOptionInput) {
			case 0: // 수정 완료
				System.out.println(updateId + name + author + publisher + publishingDate + price);
				System.out.println("회원 정보가 수정되었습니다.\n");
				this.library.updateBook(updateId, name, author, publisher, publishingDate, price);
				return;

			case 1: // 회원 이름
				System.out.println("현재 이름 : " + name + "\n수정할 이름 : ");
				name = InputHandler.getInput();
				continue;

			case 2: // 회원 주소
				System.out.println("현재 작가 : " + author + "\n수정할 작가 : ");
				author = InputHandler.getInput();
				continue;

			case 3: // 회원 연락처
				System.out.println("현재 출판사 : " + publisher + "\n수정할 출판사 : ");
				publisher = InputHandler.getInput();
				continue;

			case 4: // 회원 생일
				System.out.println("현재 출판일 : " + publishingDate + "\n수정할 출판일 : ");
				publishingDate = InputHandler.getInput();
				continue;

			case 5: // 회원 생일
				System.out.println("현재 가격 : " + price + "\n수정할 가격 : ");
				price = InputHandler.getInput();
				continue;

			case 6: // 수정 취소
				System.out.println("모든 수정 사항이 초기화 됩니다.\n수정이 취소되었습니다.n");
				break;
			default:
				System.out.println("올바른 값을 입력하세요\n");
				continue;
			}
		}
	}

	public void deleteMemberData() throws IOException, ParseException, CloneNotSupportedException {
		System.out.println("삭제할 회원 ID : ");
		String memberId = InputHandler.getInput();
		this.library.DeleteMember(memberId);
		System.out.println(memberId + "번 회원이 삭제되었습니다.");
	}

	public void deleteBookData() throws IOException, ParseException, CloneNotSupportedException {
		System.out.println("삭제할 책 ID : ");
		String bookId = InputHandler.getInput();
		this.library.DeleteBook(bookId);
		System.out.println(bookId + "번 책이 삭제되었습니다.");
	}

	public void undoDelete() {
		this.library.undoDelete();
		System.out.println("복구한 회원 : " + this.memberList.resigner.toString());
	}

	public void Rent() throws IOException, ParseException {
		boolean extension = false;
		// 대출할 도서 선택
		System.out.print("대출할 도서 ID : ");
		String BookId = InputHandler.getInput();

		// 어떤 회원이 대출했는지 선택
		System.out.print("대출 회원 ID : ");
		String memberId = InputHandler.getInput();

		// 유효성 검사
		boolean checkMemberId = false;
		if (this.memberList.findById(memberId) != null) {
			checkMemberId = true;
		}

		if (checkMemberId == false) {
			System.out.println("존재하지 않는 회원입니다.");
			return;
		}

		// 해당 도서 rent 상태 true 처리
		boolean checkBookId = false;
		if (this.booklist.findById(BookId) != null) {
			checkBookId = true;
		}

		if (checkBookId == false) {
			System.out.println("존재하지 않는 도서입니다.");
			return;
		}

		if (checkBookId == true) {
			System.out.println("미리 연장해서 대출하시겠습니까? : (y/n)");
			String input = InputHandler.getInput().toLowerCase();

			switch (input) {
			case "y": // 연장
				extension = true;
				break;

			case "n": // 연장 안함
				extension = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			this.library.rent(memberId, BookId, extension);
			System.out.println("대출 처리 되었습니다.");
			return;
		} else {
			System.out.println("잘못된 입력입니다.");
			return;
		}
	}

	public void extens() throws IOException, ParseException, CloneNotSupportedException {
		boolean checkmember = false;
		System.out.println("연장 할 회원 ID : ");
		String memberId = InputHandler.getInput();
		for (Member member : this.memberList.listUp()) {
			if (member.getMemberId() == memberId) {
				checkmember = true;
				break;
			}
		}
		if (checkmember == false) {
			System.out.println("존재하지 않는 회원입니다.");
			return;
		}
		boolean checkbook = false;
		System.out.println("연장 할 책 ID : ");
		String bookId = InputHandler.getInput();
		for (Book book : this.booklist.listUp()) {
			if (book.getBookId() == bookId) {
				checkbook = true;
				break;
			}
		}
		if (checkbook == false) {
			System.out.println("존재하지 않는 책입니다.");
			return;
		}

		boolean checkextension = false;
		String rentalId = null;
		for (RentalCase rental : this.rentalList.listUp()) {
			if (rental.getBookId() == bookId && rental.getMemberId() == memberId) {
				rentalId = rental.getRentalCaseID();
				checkextension = true;
				break;
			}
		}
		if (rentalId == null) {
			System.out.println("연장할 대출건이 없습니다.");
		} else if (checkextension == false) {
			System.out.println("대출중인 도서가 아닙니다.");
			return;
		} else {
			library.extens(rentalId);
		}
	}

	public void returnBook() throws IOException, ParseException {
		System.out.print("반납할 대출 ID : ");
		String rentalId = InputHandler.getInput();
		boolean check = false;
		if (this.rentalList.findById(rentalId) != null) {
			check = true;
			return;
		}
		if (check == false) {
			System.out.println("잘못된 입력입니다.");
		} else {
			this.library.returnBook(rentalId);
			System.out.println("정상 반납처리 되었습니다.");
		}
	}

}
