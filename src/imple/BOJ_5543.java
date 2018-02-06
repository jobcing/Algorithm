package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 5543번 풀이 (https://www.acmicpc.net/problem/5543)
 */

public class BOJ_5543 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] price = new int[5];

        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        int bugerMin = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            bugerMin = Math.min(bugerMin, price[i]);
        }

        int drinkMin = Integer.MAX_VALUE;
        for (int i = 2; i < price.length; i++) {
            drinkMin = Math.min(drinkMin, price[i]);
        }

        int ans = bugerMin + drinkMin - 50;
        System.out.println(ans);
    }
}
