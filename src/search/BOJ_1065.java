package search;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 3..
 *
 * 백준 알고리즘 1065번 풀이 (https://www.acmicpc.net/problem/1065)
 */

public class BOJ_1065 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if(isHansu(i)){
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static boolean isHansu(int num){
        char[] numChars = String.valueOf(num).toCharArray();
        int d = 0;

        if (numChars.length >= 2) {
            d = Character.getNumericValue(numChars[1]) - Character.getNumericValue(numChars[0]);
        }

        for (int i = 1; i < numChars.length - 1; i++) {
            if (d != Character.getNumericValue(numChars[i + 1]) - Character.getNumericValue(numChars[i])) {
                return false;
            }
        }

        return true;
    }
}
