package BookManager.presentation;

import java.io.IOException;
import java.text.ParseException;

import BookManager.system.LibrarySystem;
import BookManager.utillities.InputHandler;

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

    public void start() throws ParseException, IOException, CloneNotSupportedException {
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
                	librarySystem.showMemberList();
                    break;

                case 2: // 회원 등록
                	librarySystem.getMemberData();
                    break;

                case 3: // 회원 수정
                	librarySystem.updateMemberData();
                    break;

                case 4: // 회원 삭제
                	librarySystem.deleteMemberData();
                    break;

                case 5: // 삭제 취소
                	librarySystem.undoDelete();
                    break;
                default:
                    break;
            }
        }
    }
}
