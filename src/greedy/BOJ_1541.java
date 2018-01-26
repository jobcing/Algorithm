package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 1. 26..
 *
 * 백준 알고리즘 1541번 풀이 (https://www.acmicpc.net/problem/1541)
 *
 * 식에 괄호를 만들어 결과값을 최소로 만드는 문제
 *
 * !! - 연산을 나중에 처리해야하므로 먼저 - 기준으로 나눠준다. !!
 */

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        br.close();

        String[] strArr1 = input.split("\\-");

        int minSum = 0;

        for (int i = 0; i < strArr1.length; i++) {

            String[] strArr2 = strArr1[i].split("\\+");

            int tempSum = 0;
            for(String x : strArr2){
                tempSum += Integer.parseInt(x);
            }

            if(i == 0) tempSum *= -1;

            minSum -= tempSum;
        }

        System.out.println(minSum);
    }
}
