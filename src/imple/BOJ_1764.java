package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ByeongChan on 2018. 2. 19..
 *
 * 백준 알고리즘 1764번 풀이 (https://www.acmicpc.net/problem/1764)
 *
 * 중복된 문자열 찾는 문제
 * !! ArrayList 탐색보다 HashMap or HashSet 탐색이 더 빠르다 !!
 */

public class BOJ_1764 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 결과값을 저장할 버퍼
        StringBuilder sb = new StringBuilder();
        // 문자열을 HashSet에 저장
        HashSet<String> nstr = new HashSet<>();

        for (int i = 0; i < N; i++) {
            nstr.add(br.readLine());
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String mstr = br.readLine();

            // 중복된 값 있는지 탐색
            if(nstr.contains(mstr)){
                ans.add(mstr);
            }
        }

        // 문자열 정렬
        Collections.sort(ans);

        // 결과값을 버퍼에 저장함
        sb.append(ans.size()).append(NEW_LINE);
        for(String name : ans){
            sb.append(name).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
