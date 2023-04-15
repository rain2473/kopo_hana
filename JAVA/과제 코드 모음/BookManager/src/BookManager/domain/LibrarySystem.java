package BookManager.domain;

import java.io.IOException;
import java.text.ParseException;

import BookManager.presentation.MainView;
import BookManager.utillities.InputHandler;
import BookManager.domain.model.Book;
import BookManager.domain.model.Member;
import BookManager.domain.model.RentalCase;
import BookManager.domain.table.BookTable;
import BookManager.domain.table.MemberTable;
import BookManager.domain.table.RentalCaseTable;

public class LibrarySystem {
	static LibrarySystem instance;
	static Library library = Library.getInstance();
	static BookTable booklist = BookTable.getInstance();
	static RentalCaseTable rentalList = RentalCaseTable.getInstance();
	static MemberTable memberList = MemberTable.getInstance();

	public static void main(String[] args) throws IOException, ParseException, CloneNotSupportedException {
		library.open();
		System.out.println("정상적으로 로딩 되었습니다.");
		showMain();
		library.close();
		System.out.println("정상적으로 저장 되었습니다.");
		System.exit(1);
	}

	private LibrarySystem() {
	}

	public static LibrarySystem getInstance() {
		if (instance == null) {
			synchronized (BookTable.class) {
				if (instance == null) {
					instance = new LibrarySystem();
				}
			}
		}
		return instance;
	}

	public static void showMain() throws IOException, ParseException, CloneNotSupportedException {
		MainView.getInstance().showMain();
	}

	public void showMemberList() {
		for (Member member : memberList.listUp()) {
			System.out.println(member.toString());
		}
	}

	public void showBookList() {
		System.out.println("========== 도서 조회 ==========");
		System.out.println(" 0. 뒤로");
		System.out.println(" 1. 도서 전체 조회");
		System.out.println(" 2. 대출 가능한 도서 조회");
		System.out.println("===============================");
		int selectInput = InputHandler.getInt();

		switch (selectInput) {
		case 0:
			return;

		case 1:
			for (Book book : booklist.listUp()) {
				System.out.println(book.toString());
			}
			break;

		case 2:
			for (Book book : booklist.listUp()) {
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
		for (RentalCase rental : rentalList.listUp()) {
			Book book = booklist.findById(rental.getBookId());
			if (!book.getRentalStatus()) {
				System.out.println(book.toString());
			}
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
		memberList.addToList(member);
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
		booklist.addToList(book); // 등록 결과는 해당 메서드에서 처리
	}

	public void updateMemberData() throws ParseException {
		System.out.println("수정할 회원 ID : ");
		String updateId = InputHandler.getInput();
		Member updateMember = memberList.findById(updateId);
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
				library.updateMember(updateId, name, address, contect, birthday);
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
		Book updateBook = booklist.findById(updateId);
		String name = updateBook.getBookName();
		String author = updateBook.getAuthor();
		String publisher = updateBook.getPulisher();
		String publishingDate = updateBook.getPulishingDate();
		String price = updateBook.getPrice();
		while (true) {
			System.out.println("======== 회원 정보 수정 ========");
			System.out.println(" 0. 수정 완료");
			System.out.println(" 1. 책 이름");
			System.out.println(" 2. 책 주소");
			System.out.println(" 3. 책 연락처");
			System.out.println(" 4. 책 생일");
			System.out.println(" 5. 수정 취소");
			System.out.println("====================================");
			int memberOptionInput = InputHandler.getInt();

			switch (memberOptionInput) {
			case 0: // 수정 완료
				System.out.println("회원 정보가 수정되었습니다.\n");
				library.updateBook(updateId, name, author, publisher, publishingDate, price);
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
		library.DeleteMember(memberId);
		System.out.println(memberId + "번 회원이 삭제되었습니다.");
	}

	public void deleteBookData() throws IOException, ParseException, CloneNotSupportedException {
		System.out.println("삭제할 책 ID : ");
		String bookId = InputHandler.getInput();
		library.DeleteBook(bookId);
		System.out.println(bookId + "번 책이 삭제되었습니다.");
	}

	public void undoDelete() {
		library.undoDelete();
		System.out.println("복구한 회원 : " + memberList.resigner.toString());
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
        if (memberList.findById(memberId) != null) {
            checkMemberId = true;
        }
        
        if (checkMemberId == false) {
        	System.out.println("존재하지 않는 회원입니다.");
        	return;
        }

        // 해당 도서 rent 상태 true 처리
        boolean checkBookId = false;
        if (booklist.findById(BookId) != null) {
        	checkBookId = true;
        }
        
        if (checkBookId == true) {
        	System.out.println("미리 연장해서 대출하시겠습니까? : (y/n)");
        	String input = InputHandler.getInput().toLowerCase();

			switch (input) {
			case "y" : // 연장
				extension = true;
				break;

			case "n" : // 연장 안함
				extension = false;
				break;
			default : 
				System.out.println("잘못된 입력입니다.");
			library.rent(memberId, BookId, extension);
            System.out.println("대출 처리 되었습니다.");
            return;
			}
        } else {
            System.out.println("잘못된 입력입니다.");
            return;
        }
	}

	public void extens() throws IOException, ParseException, CloneNotSupportedException {
		boolean checkmember = false;
		System.out.println("연장 할 회원 ID : ");
		String memberId = InputHandler.getInput();
		for (Member member : memberList.listUp()) {
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
		for (Book book : booklist.listUp()) {
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
		for (RentalCase rental : rentalList.listUp()) {
			if (rental.getBookId() == bookId && rental.getMemberId() == memberId) {
				rentalId = rental.getRentalCaseID();
				checkextension = true;
				break;
			}
		}
		if (checkextension == false) {
			System.out.println("대출중인 도서가 아닙니다.");
			return;
		} else if (rentalId == null) {
			System.out.println("연장할 대출건이 없습니다.");
		}
		else {
			library.extens(rentalId);
		}
	}

	public void returnBook() throws IOException, ParseException {
		System.out.print("반납할 대출 ID : ");
		String rentalId = InputHandler.getInput();
		boolean check = false;
		if (rentalList.findById(rentalId) != null) {
			check = true;
			return;
		}
		if (check == false) {
			System.out.println("잘못된 입력입니다.");
		} else {
			library.returnBook(rentalId);
			System.out.println("정상 반납처리 되었습니다.");
		}
	}

}
