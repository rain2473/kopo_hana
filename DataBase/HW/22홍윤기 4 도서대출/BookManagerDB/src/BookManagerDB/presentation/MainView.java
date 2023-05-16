package BookManagerDB.presentation;

import java.sql.SQLException;

import BookManagerDB.utillities.InputHandler;

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

	public void showMain() throws SQLException {
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
	
	public void wrongInput() {
		System.out.println("잘못된 입력");
	}
	
	public String getupdate(String Input, String infomation) {
		System.out.println("현재 " + infomation + " : " + Input + "\n수정할 " + infomation + " : ");
		String output = InputHandler.getInput();
		return output;
	}
	
	public void finishUpdate(int input) {
    	switch(input) {
    	case 1 : {System.out.println("수정 사항이 반영되었습니다.\n");break;}
    	case 2 : {System.out.println("모든 수정 사항이 초기화 됩니다.\n수정이 취소되었습니다.");break;}
    	}
    }
}
