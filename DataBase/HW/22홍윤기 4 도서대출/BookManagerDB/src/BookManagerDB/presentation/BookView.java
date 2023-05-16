package BookManagerDB.presentation;

import java.sql.SQLException;

import BookManagerDB.system.LibrarySystem;
import BookManagerDB.utillities.InputHandler;

public class BookView {
	private static BookView instance;
	static LibrarySystem librarySystem = LibrarySystem.getInstance();
    
    private BookView() {}
    public static BookView getInstance() {
        if (instance == null) {
            synchronized (BookView.class) {
                if (instance == null) {
                    instance = new BookView();
                }
            }
        }
        return instance;
    }

    public void start() throws SQLException {
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
                	this.showSort();
                	librarySystem.showBookList();
                    break;

                case 2: // 도서 등록
                    // 도서 제목 받기
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
                	librarySystem.getBookData(name, author, publisher, pulishingDate, price);
                	System.out.println("도서가 등록되었습니다.");
                    break;

                case 3: // 도서 수정
                	this.showSort();
                	librarySystem.showBookList();
            		System.out.println("수정할 도서 ID : ");
            		String updateId = InputHandler.getInput();
                    librarySystem.updateBookData(updateId);
                    System.out.println("변경할 도서 정보를 저장했습니다.");
                    break;

                case 4: // 도서 삭제
                	this.showSort();
                	librarySystem.showBookList();
            		System.out.println("삭제할 책 ID : ");
            		String bookId = InputHandler.getInput();
                    librarySystem.deleteBookData(bookId);
                    System.out.println(bookId + "번 책이 삭제되었습니다.");
                    break;
                    
                default:
                	MainView.getInstance().wrongInput();
                    break;
            }
        }
    }
    
    public void showSort() {
    	System.out.println("========== 도서 조회 ==========");
		System.out.println(" 0. 기본 조회");
		System.out.println(" 1. 도서 이름순 조회");
		System.out.println(" 2. 도서 입고일순 조회");
		System.out.println(" 3. 도서 작가순 조회");
		System.out.println(" 4. 도서 출판사순 조회");
		System.out.println(" 5. 도서 가격순 조회");
		System.out.println(" 6. 도서 출판일순 조회");
		System.out.println("===============================");
    }
    
    public void showSortOption() {
    	System.out.println("========== 도서 조회 ==========");
		System.out.println(" 0. 뒤로");
		System.out.println(" 1. 도서 전체 조회");
		System.out.println(" 2. 대출 가능한 도서 조회");
		System.out.println("===============================");
    }
    
    public void showUpdate() {
    	System.out.println("======== 도서 정보 수정 ========");
		System.out.println(" 0. 수정 완료");
		System.out.println(" 1. 책 이름");
		System.out.println(" 2. 책 작가");
		System.out.println(" 3. 책 출판사");
		System.out.println(" 4. 책 출판일");
		System.out.println(" 5. 책 가격");
		System.out.println(" 6. 수정 취소");
		System.out.println("====================================");
    }
}
