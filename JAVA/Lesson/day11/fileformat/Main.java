package Lesson.day11.fileformat;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String str = "홍길동, 한석봉, 신사임당";
        // 콤마를 기준으로 자를 준비
        StringTokenizer st = new StringTokenizer(str, ", ");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
