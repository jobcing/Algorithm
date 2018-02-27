package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 27..
 *
 * 백준 알고리즘 10815번 풀이 (https://www.acmicpc.net/problem/10815)
 */

public class BOJ_10815 {

    private final static String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            hashSet.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        int[] ans = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int cardNum = Integer.parseInt(st.nextToken());

            if(hashSet.contains(cardNum)){
                ans[i] = 1;
            } else{
                ans[i] = 0;
            }
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(SPACE);
        }

        System.out.println(sb.toString());
    }
}
