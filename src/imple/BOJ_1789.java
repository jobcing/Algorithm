package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 2. 8..
 *
 * 백준 알고리즘 1789번 풀이 (https://www.acmicpc.net/problem/1789)
 *
 * 서로 다른 N개의 자연수의 합이 S라고 한다. S를 알 때, 자연수 N의 최대값은 얼마일까?
 */

public class BOJ_1789 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 조건에서 약 43억 이하가 입력으로 long 타입 사용
        long n = Long.parseLong(br.readLine());

        /** 방법 1.
        long cumul = 2;
        long i = 2;

        while(true){
            if(n <= cumul){
                break;
            }

            i++;
            cumul += i;
        }
        */

        /**
         *  방법 2.
         */

        // 규칙성을 통해 i 값을 찾음
        //   N : 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ....
        // 갯수 : 1, 1, 2, 2, 2, 3, 3, 3, 3, 4 ....

        // 즉, 누적합을 이용해서 N의 위치를 찾고 i를 반환하면 된다

        long sum = 0;
        int i = 1;

        for (; i + sum <= n; i++) {
            sum += i;
        }

        System.out.println(i - 1);
    }
}
