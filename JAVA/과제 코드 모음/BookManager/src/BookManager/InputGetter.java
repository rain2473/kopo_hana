package BookManager;

import java.util.*;

public class InputGetter {
    private static InputGetter instance;
    private static Scanner scanner;
    private static String input;
    
    private InputGetter() {}
    public static InputGetter getInstance() {
        if (instance == null) {
            synchronized (InputGetter.class) {
                if (instance == null) {
                    instance = new InputGetter();
                    scanner = new Scanner(System.in);
                }
            }
        }
        return instance;
    }
    
    public void getInput() {
        input = scanner.nextLine();
    }
}
