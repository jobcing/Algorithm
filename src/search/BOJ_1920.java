package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 12..
 *
 * 백준 알고리즘 1920번 풀이 (https://www.acmicpc.net/problem/1920)
 *
 * 주어진 숫자안에 해당 값이 있는지 탐색하는 이진탐색 문제
 * !! Hash 함수 이용 !!
 */

public class BOJ_1920 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> nlist = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nlist.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(nlist.contains(num)){
                sb.append(1).append(NEW_LINE);
            } else{
                sb.append(0).append(NEW_LINE);
            }
        }

        System.out.println(sb.toString());
    }
}
