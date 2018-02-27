package search;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 27..
 *
 * 백준 알고리즘 1100번 풀이 (https://www.acmicpc.net/problem/1100)
 */

public class BOJ_1100 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int ans = 0;
        for (int i = 0; i < 8; i++) {
            String s = scan.nextLine();

            for (int j = 0; j < s.length(); j++) {
                if((i + j) % 2 == 0){
                    if(s.charAt(j) == 'F'){
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
