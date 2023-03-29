package BookManager;

public class ScreenView {
    private static ScreenView instance;
    
    private ScreenView() {}
    public static ScreenView getInstance() {
        if (instance == null) {
            synchronized (ScreenView.class) {
                if (instance == null) {
                    instance = new ScreenView();
                }
            }
        }
        return instance;
    }
    
    public void showMain() {
        System.out.printf("1.회원관리\t\t\t2.도서관리\t\t\t3.종료\n");
    }
}
