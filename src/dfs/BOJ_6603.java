package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 31..
 *
 * 백준 알고리즘 6603번 풀이 (https://www.acmicpc.net/problem/6603)
 *
 * 부분집합 구하는 문제
 * !! 백트래킹 + dfs !!
 * !! 굳이 방문 배열을 쓰지 않아도 백트래킹을 구현할 수 있다. !!
 */

public class BOJ_6603 {

    private static StringBuilder sb = new StringBuilder();
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());

            if(k == 0) break;

            int[] S = new int[k];
            for (int i = 0; i < S.length; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            // 여기서 하나를 선택하고 dfs와 백트래킹으로 5개를 선택할 것이므로
            // k - 5 까지 반복문을 돌린다.
            for (int i = 0; i < k - 5; i++) {
                dfs(i, S, 1, S[i] + " ");
            }

            sb.append(NEW_LINE);
        }

        br.close();
        System.out.println(sb.toString());
    }

    private static void dfs(int i, int[] S, int cnt, String ans){
        // 부분집합 개수가 6개가 되면 버퍼에 추가
        if(cnt == 6){
            sb.append(ans).append(NEW_LINE);
            return;
        }

        // S가 이미 오름차순으로 정렬되있으므로 j는 i보다 큰 수를 탐색한다.
        // 무조건 현재 값보다 큰 값부터 탐색하므로 isVisited 방문 여부 배열이 필요없다.
        for(int j = i + 1; j < S.length; j++){
            dfs(j, S, cnt + 1, ans + S[j] + " ");
        }

        // 백트래킹
        cnt--;
    }
}
