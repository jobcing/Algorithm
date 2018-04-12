package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ByeongChan on 2018. 4. 12..
 *
 * 백준 알고리즘 2309번 풀이 (https://www.acmicpc.net/problem/2309)
 *
 * 9개의 숫자 중 7개의 숫자를 골라 합 100을 고르는 문제
 *
 * !! 9개 숫자의 합 - 100 = 차이를 구한다. !!
 * !! 9명 중 2명을 골라 합이 차이가 된다면 그 두명을 뺀 나머지가 정답이다. !!
 * !! 모든 경우의 수를 계산해보는 브루트포스 !!
 */

public class BOJ_2309 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[9];
        int allSum = 0;

        for (int i = 0; i < list.length; i++) {
            int num = Integer.parseInt(br.readLine());

            list[i] = num;
            allSum += num;
        }

        br.close();

        int diff = allSum - 100;
        Arrays.sort(list);

        MAIN_LOOP : for (int i = 0; i < list.length - 1; i++) {
            for (int j = i; j < list.length; j++) {

                if(list[i] + list[j] == diff){
                    list[i] = 0;
                    list[j] = 0;

                    break MAIN_LOOP;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.length; i++) {
            if(list[i] == 0) continue;

            sb.append(list[i]).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
