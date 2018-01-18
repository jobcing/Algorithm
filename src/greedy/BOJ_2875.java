package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 17..
 *
 * 백준 알고리즘 2875번 풀이 (https://www.acmicpc.net/problem/2875)
 *
 * Greedy Algorithm
 */

public class BOJ_2875 {
    // 공백 문자열 지정
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // k를 하나씩 빼가며 그때마다 최선의 선택을 한다.
        // 여자를 기준으로 팀을 이룰 수 있는 수는 n / 2 이고 남자를 기준으로 팀을 이룰 수 있는 수는 m이다.
        // 따라서 n/2이 m보다 크면 여자를 빼준다.
        // 같을 경우에도 여자를 줄이는 것이 경우의 수를 높일 수 있기 때문에 여자를 빼준다.
        while(k > 0){
            if(n / 2 >= m){
                n--;
            } else{
                m--;
            }

            k--;
        }

        // 남은 인원을 가지고 만들 수 있는 팀 수를 계산하여 출력
        int result = n / 2 > m ? m : n / 2;

        System.out.println(result);
    }
}
