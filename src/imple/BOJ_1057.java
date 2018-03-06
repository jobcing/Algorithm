package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 6..
 *
 * 백준 알고리즘 1057번 풀이 (https://www.acmicpc.net/problem/1057)
 *
 * 토너먼트에서 두 상대가 언제 만날지를 묻는 문제
 */

public class BOJ_1057 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int kim = scan.nextInt();
        int lim = scan.nextInt();

        int ans = 0;

        // ex) kim = 8 -> 4 -> 2 -> 1
        //     lim = 9 -> 5 -> 3 -> 1
        while(kim != lim){
            kim = kim / 2 + kim % 2;
            lim = lim / 2 + lim % 2;
            ans++;
        }

        System.out.println(ans);
    }
}
