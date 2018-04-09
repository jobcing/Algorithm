package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 4. 9..
 *
 * 백준 알고리즘 10988번 풀이 (https://www.acmicpc.net/problem/10988)
 */

public class BOJ_10988 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String word = scan.nextLine();
        String reverse = new StringBuffer(word).reverse().toString();

        if(word.equals(reverse)){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }
}
