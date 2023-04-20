package BookManagerDB.presentation;

import java.sql.SQLException;

import BookManagerDB.system.LibrarySystem;
import BookManagerDB.utillities.InputHandler;

public class RentalView {
	private static RentalView instance;
	static LibrarySystem librarySystem = LibrarySystem.getInstance();

	private RentalView() {
	}

	public static RentalView getInstance() {
		if (instance == null) {
			synchronized (RentalView.class) {
				if (instance == null) {
					instance = new RentalView();
				}
			}
		}
		return instance;
	}

	public void start() throws SQLException {

		System.out.println("========== 대출 관련 ==========");
		System.out.println(" 0. 뒤로");
		System.out.println(" 1. 대출건 조회");
		System.out.println(" 2. 도서 대출");
		System.out.println(" 3. 도서 대출 연장");
		System.out.println(" 4. 도서 반납");
		System.out.println("===============================");
		int selectInput = InputHandler.getInt();

		switch (selectInput) {
		case 0:
			return;

		case 1: // 대출중 도서 조회
			System.out.println("========== 대출 조회 ==========");
			System.out.println(" 0. 기본 조회");
			System.out.println(" 1. 도서 이름순 조회");
			System.out.println(" 2. 회원 이름순 조회");
			System.out.println(" 3. 연장 여부순 조회");
			System.out.println(" 4. 대여 일자순 조회");
			System.out.println(" 5. 반납 일자순 조회");
			System.out.println(" 6. 남은 기간순 조회");
			System.out.println("===============================");
			librarySystem.showRentalList();
			break;

		case 2: // 도서 대출
			String[] input = this.getTransaction("rent");
			librarySystem.Rent(input[0], input[1]);
			System.out.println("대출 처리 되었습니다.");
			break;
		case 3: // 도서 대출 연장
			String[] inputEx = this.getTransaction("extens");
			librarySystem.extens(inputEx[0], inputEx[1]);
			break;
		case 4: // 도서 반납
			String[] inputRt = this.getTransaction("return");
			librarySystem.returnBook(inputRt[0], inputRt[1]);
			System.out.println("정상 반납처리 되었습니다.");
			break;

		default:
			MainView.getInstance().wrongInput();
			break;
		}

	}

	public void showNotExist(String word) {
		word = word.toLowerCase();
		switch (word) {
		case "book": {
			System.out.println("존재하지 않는 도서입니다.");
			break;
		}
		case "member": {
			System.out.println("존재하지 않는 회원입니다.");
			break;
		}
		}
	}

	public String[] getTransaction(String word) {
		word = word.toLowerCase();
		switch (word) {
		case "rent": {
			System.out.println("=======대출할 도서와 회원의 이름을 입력하세요=======");
			break;
		}
		case "extens": {
			System.out.println("=======연장할 도서와 회원의 이름을 입력하세요=======");
			break;
		}
		case "return": {
			System.out.println("=======반납할 도서와 회원의 이름을 입력하세요=======");
			break;
		}
		
		}
		System.out.print("도서 이름 : ");
		String BookName = InputHandler.getInput();
		System.out.print("회원 이름 : ");
		String memberName = InputHandler.getInput();
		String[] result = {BookName, memberName};
		return result;
 	}
	
	public void showrent() {
		System.out.println("미리 연장해서 대출하시겠습니까? : (y/n)");
	}
	
	public void showextens(int input) {
		switch(input) {
		case 1 : {System.out.println("연장이 완료되었습니다.");break;}
		case 2 : {System.out.println("이미 연장중인 대출 입니다.");break;}
		}
	}
}
