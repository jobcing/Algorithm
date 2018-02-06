package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 5565번 풀이 (https://www.acmicpc.net/problem/5565)
 */

public class BOJ_5565 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());

        for (int i = 0; i < 9; i++) {
            int piecePrice = Integer.parseInt(br.readLine());
            price -= piecePrice;
        }

        br.close();

        System.out.println(price);
    }
}
