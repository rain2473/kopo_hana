package BookManagerDB.presentation;

import java.sql.SQLException;

import BookManagerDB.system.LibrarySystem;
import BookManagerDB.utillities.InputHandler;

public class MemberView {
	private static MemberView instance;
	static LibrarySystem librarySystem = LibrarySystem.getInstance();
    
    private MemberView() {}
    public static MemberView getInstance() {
        if (instance == null) {
            synchronized (MemberView.class) {
                if (instance == null) {
                    instance = new MemberView();
                }
            }
        }
        return instance;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("======== 회원관리 프로그램 ========");
            System.out.println(" 0. 뒤로");
            System.out.println(" 1. 회원 조회");
            System.out.println(" 2. 회원 등록");
            System.out.println(" 3. 회원 수정");
            System.out.println(" 4. 회원 삭제");
            System.out.println(" 5. 삭제 취소");
            System.out.println("====================================");
            int memberOptionInput = InputHandler.getInt();

            switch (memberOptionInput) {
                case 0: // 뒤로 (리턴)
                    return;

                case 1: // 회원 조회
                	this.showSort();
                	librarySystem.showMemberList();
                    break;

                case 2: // 회원 등록
                	// 이름 받기
            		System.out.print("이름 : ");
            		String name = InputHandler.getInput();
            		// 주소
            		System.out.print("주소 : ");
            		String address = InputHandler.getInput();
            		// 연락처
            		System.out.print("연락처 : ");
            		String contact = InputHandler.getInput();
            		// 생일
            		System.out.print("생일(yyyy/MM/dd) : ");
            		String birthday = InputHandler.getInput();
                	librarySystem.getMemberData(name, address, contact, birthday);
                	System.out.println("회원이 등록되었습니다.");
                    break;

                case 3: // 회원 수정
                	this.showSort();
                	librarySystem.showMemberList();
            		System.out.println("수정할 회원 ID : ");
            		String updateId = InputHandler.getInput();
                	librarySystem.updateMemberData(updateId);
                	System.out.println("변경할 회원 정보를 저장했습니다.");
                    break;

                case 4: // 회원 삭제
                	this.showSort();
                	librarySystem.showMemberList();
                	System.out.println("삭제할 회원 ID : ");
            		String memberId = InputHandler.getInput();
            		System.out.println("삭제 회원이 백업되었습니다.\n");
                	librarySystem.deleteMemberData(memberId);
                	System.out.println(memberId + "번 회원이 삭제되었습니다.");
                    break;

                case 5: // 삭제 취소
                	librarySystem.undoDelete();
                	System.out.println("가장 최근에 삭제한 회원이 복구되었습니다. ");
                    break;
                default:
                	MainView.getInstance().wrongInput();
                    break;
            }
        }
    }
    
    public void showSort() {
    	System.out.println("========== 회원 조회 ==========");
		System.out.println(" 0. 기본 조회");
		System.out.println(" 1. 회원 이름순 조회");
		System.out.println(" 2. 회원 가입일순 조회");
		System.out.println(" 3. 회원 주소순 조회");
		System.out.println(" 4. 회원 연락처순 조회");
		System.out.println(" 5. 회원 생년월일순 조회");
		System.out.println(" 6. 회원 생일순 조회");
		System.out.println("===============================");
	}
    
    public void showUpdate() {
    	System.out.println("======== 회원 정보 수정 ========");
		System.out.println(" 0. 수정 완료");
		System.out.println(" 1. 회원 이름");
		System.out.println(" 2. 회원 주소");
		System.out.println(" 3. 회원 연락처");
		System.out.println(" 4. 회원 생일");
		System.out.println(" 5. 수정 취소");
		System.out.println("====================================");
    }
}
