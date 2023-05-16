package BookManager.presentation;

import java.io.IOException;
import java.text.ParseException;

import BookManager.system.LibrarySystem;
import BookManager.utillities.InputHandler;

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

	public void start() throws IOException, ParseException, CloneNotSupportedException {

		System.out.println("========== 대출 관련 ==========");
		System.out.println(" 0. 뒤로");
		System.out.println(" 1. 대출중 도서 조회");
		System.out.println(" 2. 도서 대출");
		System.out.println(" 3. 도서 대출 연장");
		System.out.println(" 4. 도서 반납");
		System.out.println("===============================");
		int selectInput = InputHandler.getInt();

		switch (selectInput) {
		case 0:
			return;

		case 1: // 대출중 도서 조회
			librarySystem.showRentalList();
			break;

		case 2: // 도서 대출
			librarySystem.Rent();
			break;
		case 3: // 도서 대출 연장
			librarySystem.extens();
			break;
		case 4: // 도서 반납
			librarySystem.returnBook();
			break;

		default:
			break;
		}

	}
}
