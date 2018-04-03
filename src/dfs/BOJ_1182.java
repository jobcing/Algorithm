package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 3..
 *
 * 백준 알고리즘 1182번 풀이 (https://www.acmicpc.net/problem/1182)
 *
 * 부분집합의 합이 S가 되는 부분집합 개수를 구하는 문제
 *
 * !! 모든 경우의 수를 체크하기 위해 dfs 사용 !!
 */

public class BOJ_1182 {

    private static int ans = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] list = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        // 0 ~ 부터 끝까지 시작
        for (int i = 0; i < N; i++) {
            dfs(i, list, S, list[i]);
        }

        br.close();

        System.out.println(ans);
    }

    private static void dfs(int i, int[] list, int S, int curS){
        // 현재까지의 부분집합의 합이 S와 같을 시 카운트
        // 하지만 같다고 return 시키진 않는다. 끝까지 깊이 탐색을 해본다. (뒤의 원소가 예를 들어 0 일수도 있으니)
        if(S == curS){
            ans++;
        }

        // 입력값보다 인덱스가 큰 것만 탐색하므로 isVisited배열이 따로 필요x
        for (int j = i + 1; j < list.length; j++) {
            dfs(j, list, S, curS + list[j]);
        }
    }
}
