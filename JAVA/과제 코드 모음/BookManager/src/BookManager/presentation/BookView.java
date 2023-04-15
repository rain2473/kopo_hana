package BookManager.presentation;

import java.io.IOException;
import java.text.ParseException;
import BookManager.domain.LibrarySystem;
import BookManager.utillities.InputHandler;

public class BookView {
	private static BookView instance;
	static LibrarySystem librarySystem = LibrarySystem.getInstance();
    
    private BookView() {}
    public static BookView getInstance() {
        if (instance == null) {
            synchronized (MainView.class) {
                if (instance == null) {
                    instance = new BookView();
                }
            }
        }
        return instance;
    }

    public void start() throws IOException, ParseException, CloneNotSupportedException {
        while (true) {
            System.out.println("======== 도서관리 프로그램 ========");
            System.out.println(" 0. 뒤로");
            System.out.println(" 1. 도서 조회");
            System.out.println(" 2. 도서 등록");
            System.out.println(" 3. 도서 수정");
            System.out.println(" 4. 도서 삭제");
            System.out.println("====================================");
            int bookOptionInput = InputHandler.getInt();

            switch (bookOptionInput) {
                case 0: // 뒤로 (리턴)
                    return;

                case 1: // 도서 조회 -> 1) 전체 도서, 2) 대출 가능한 도서 (최근 출간된 순서)
                	librarySystem.showBookList();
                    break;

                case 2: // 도서 등록
                    // 도서 제목 받기
                	librarySystem.getBookData();
                    break;

                case 3: // 도서 수정
                    librarySystem.updateBookData();
                    break;

                case 4: // 도서 삭제
                    librarySystem.deleteBookData();
                    break;
                    
                default:
                    break;
            }
        }
    }
}
