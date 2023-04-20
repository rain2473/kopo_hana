package com.example;

import java.io.*;
import java.util.*;

public class CodingTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferreader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringtokenizer = new StringTokenizer(bufferreader.readLine());
        
        int n = Integer.parseInt(stringtokenizer.nextToken());
        int m = Integer.parseInt(stringtokenizer.nextToken());
        long[] inputs = new long[n + 1];
        long[] count = new long[m];
        stringtokenizer = new StringTokenizer(bufferreader.readLine());
        for (int i = 1; i < n + 1; i++) {
            inputs[i] = (inputs[i - 1] + Integer.parseInt(stringtokenizer.nextToken())) % m;
            count[(int) inputs[i]]++;
        }
        long answer = count[0];
        for (int j = 0; j < m; j++) {
            answer += ((count[j] * (count[j] - 1)) / 2);
        }
        System.out.println(answer);
    }
}
