package BookManager.utillities;

import java.util.*;

public class InputHandler {
    private static InputHandler instance;
    Scanner scanner;
    
    private InputHandler() {
    	this.scanner = new Scanner(System.in);
    }
    public static InputHandler getInstance() {
        if (instance == null) {
            synchronized (InputHandler.class) {
                if (instance == null) {
                    instance = new InputHandler();
                }
            }
        }
        return instance;
    }
    
    public static String getInput() {
        return getInstance().scanner.nextLine();
    }
    
    public static int getInt() {
        return Integer.parseInt(getInput());
    }
}
