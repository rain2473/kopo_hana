package BookManager;

import java.util.*;

public class InputHandler {
    private static InputHandler instance;
    private static Scanner scanner;
    
    private InputHandler() {}
    public static InputHandler getInstance() {
        if (instance == null) {
            synchronized (InputHandler.class) {
                if (instance == null) {
                    instance = new InputHandler();
                    scanner = new Scanner(System.in);
                }
            }
        }
        return instance;
    }
    
    public String getInput() {
        return scanner.nextLine();
    }
}
