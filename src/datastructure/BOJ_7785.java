package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 7785번 풀이 (https://www.acmicpc.net/problem/7785)
 */

public class BOJ_7785 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String name = st.nextToken();
            String commute = st.nextToken();

            if(commute.equals("enter")){
                list.add(name);
            } else{
                list.remove(name);
            }
        }

        br.close();

        StringBuilder sb = new StringBuilder();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
