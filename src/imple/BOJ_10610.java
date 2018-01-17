package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 1. 17..
 *
 * 백준 알고리즘 10610번 풀이 (https://www.acmicpc.net/problem/106100)
 *
 * 입력받은 수를 이용해 가장 큰 30의 배수의 값을 구하는 문제
 *
 * !! 각 자리 수의 합이 3의 배수라면 그 수는 3의 배수이다 !!
 * !! 문제는 30의 배수이기 때문에 0이 무조건 존재해야 한다는 조건이 추가된다 !!
 *
 * !! 각 자리의 수를 뽑아낼 때 아스키 코드를 이용해 '0'을 빼줘서 구한다. !!
 * !! 그 후, 배열을 이용하여 연산한다. !!
 */

public class BOJ_10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        StringBuilder sb = new StringBuilder();

        // 각 자리 수의 숫자를 저장할 배열
        int[] num = new int[10];
        int sum = 0;

        // 각 자리 수의 숫자를 추출해내기 위해 Character '0'을 빼준다.
        for (int i = 0; i < N.length(); i++) {
            int n = N.charAt(i) - '0';

            num[n]++;
            sum += n;
        }

        // 3의 배수이거나 0이 없으면 빼준다.
        if(sum % 3 != 0 || num[0] == 0){
            System.out.println(-1);
            return;
        }
        // 이렇게 걸러진 수는 30의 배수이므로
        // 배열을 사용하여 수를 출력하면 된다.
        else{
            for (int i = 9; i >= 0; i--) {
                while(num[i]-- > 0){
                    sb.append(i);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
