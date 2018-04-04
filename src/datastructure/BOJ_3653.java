package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 3..
 *
 * 백준 알고리즘 3653번 풀이 (https://www.acmicpc.net/problem/3653)
 */

public class BOJ_3653 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<Integer> dvdlist = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                dvdlist.add(i);
            }

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < m; i++) {

                int dvd = Integer.parseInt(st.nextToken());
                int idx = dvdlist.indexOf(dvd);

                sb.append(idx).append(SPACE);

                if(idx != 0){
                    dvdlist.remove(idx);
                    dvdlist.addFirst(dvd);
                }
            }

            sb.append(NEW_LINE);
        }

        br.close();

        System.out.println(sb.toString());
    }
}
