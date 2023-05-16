package BookManager.presentation;

import java.io.IOException;
import java.text.ParseException;

import BookManager.utillities.InputHandler;

public class MainView {
	private static MainView instance;

	private MainView() {
	}

	public static MainView getInstance() {
		if (instance == null) {
			synchronized (MainView.class) {
				if (instance == null) {
					instance = new MainView();
				}
			}
		}
		return instance;
	}

	public void showMain() throws ParseException, IOException, CloneNotSupportedException {
		boolean systemOn = true;
		System.out.println("==================================");
		System.out.println("도서관 관리 프로그램 시작");
		System.out.println("==================================");
		while (systemOn) {
			System.out.println("1. 도서 관리");
			System.out.println("2. 회원 관리");
			System.out.println("3. 대출 관리");
			System.out.println("4. 종료");
			System.out.println("==================================");
			int selectInput = InputHandler.getInt();

			switch (selectInput) {
			case 1: // 도서 관리 프로그램 시작
				BookView.getInstance().start();
				break;

			case 2: // 회원 관리 프로그램 시작
				MemberView.getInstance().start();
				break;

			case 3: // 대출 관리 프로그램 시작
				RentalView.getInstance().start();
				break;

			case 4: // 종료
				System.out.println("프로그램을 종료합니다.");
				systemOn = false;
				break;

			default:
				System.out.println("잘못 입력 했습니다.");
				continue;
			}
		}
	}
}
