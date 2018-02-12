package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 12..
 *
 * 백준 알고리즘 1475번 풀이 (https://www.acmicpc.net/problem/1475)
 *
 * 한 숫자 세트(0 ~ 9)로 입력한 수를 만들 수 있는 최소 세트 갯수 구하기
 * 단, 6과 9는 서로 대치될 수 있다.
 *
 * !! 입력한 수를 카운트해서 가장 최대값을 구하면 된다. !!
 */

public class BOJ_1475 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] input = scan.nextLine().toCharArray();
        int[] cntArr = new int[10];
        int maxCnt = 0;

        for(char c : input){
            cntArr[c - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            // 6과 9는 일단 패스
            if(i == 6 || i == 9){
                continue;
            }

            // 가장 많이 쓰인 숫자 구하기
            maxCnt = maxCnt < cntArr[i] ? cntArr[i] : maxCnt;
        }

        // 6과 9가 쓰인 개수를 세고 2로 나눠준다.
        int cnt = (int) Math.ceil(((double)cntArr[6] + cntArr[9])/ 2.0);

        // 어떤 것이 더 큰지 비교하여 최종적으로 몇개의 세트가 필요한지 구한다.
        maxCnt = maxCnt < cnt ? cnt : maxCnt;
        System.out.println(maxCnt);
    }
}
