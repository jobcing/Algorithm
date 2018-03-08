package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 8..
 *
 * 백준 알고리즘 1547번 풀이 (https://www.acmicpc.net/problem/1547)
 */

public class BOJ_1547 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int ans = 1;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(ans == a){
                ans = b;
            } else if(ans == b){
                ans = a;
            } else{
                continue;
            }
        }

        System.out.println(ans);
    }
}
