package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 1. 19..
 *
 * 백준 알고리즘 5585번 풀이 (https://www.acmicpc.net/problem/5585)
 *
 * 거스름돈 갯수가 가장 적게 잔돈을 주는 문제
 */
public class BOJ_5585 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine()); // 물건 가격
        int n = 1000;

        int[] coins = {500, 100, 50, 10, 5, 1};

        int m = n - price; // 거스름돈
        int result = 0; // 코인 개수 저장할 변수

        for (int i = 0; i < coins.length; i++) {
            if(m / coins[i] > 0){
                result += m / coins[i];
                m = m % coins[i];
            }
        }

        System.out.println(result);
    }
}
