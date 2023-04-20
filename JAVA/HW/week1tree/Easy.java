package HW.week1tree;

import java.util.*;

public class Easy {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        String[] inputs = scanner.nextLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int R = Integer.parseInt(inputs[2]);
        int N = Integer.parseInt(scanner.nextLine());
        String[] trees = new String[N];

        for (int k = 0; k < N; k++) {
            String[] tmp = scanner.nextLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            if (Math.pow((x - a), 2) + Math.pow((y - b), 2) <= Math.pow(R, 2)) {
                trees[k] = "noisy";
            } else {
                trees[k] = "silent";
            }
        }
        for (String tree : trees) {
            System.out.println(tree);
        }
    }
}
