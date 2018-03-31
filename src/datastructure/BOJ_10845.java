package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 31..
 *
 * 백준 알고리즘 10845번 풀이 (https://www.acmicpc.net/problem/10845)
 */

public class BOJ_10845 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            if(cmd.equals("push")) {

                int val = Integer.parseInt(st.nextToken());

                q.add(val);
            } else if(cmd.equals("pop")){

                if(!q.isEmpty()){
                    int val = q.poll();

                    sb.append(val);
                } else{
                    sb.append(-1);
                }

                sb.append(NEW_LINE);
            } else if(cmd.equals("size")) {

                sb.append(q.size()).append(NEW_LINE);
            } else if(cmd.equals("empty")){

                if(q.isEmpty()){
                    sb.append(1);
                } else{
                    sb.append(0);
                }

                sb.append(NEW_LINE);
            } else if(cmd.equals("front")){

                if(!q.isEmpty()){
                    int val = q.peekFirst();

                    sb.append(val);
                } else{
                    sb.append(-1);
                }

                sb.append(NEW_LINE);
            } else if(cmd.equals("back")){

                if(!q.isEmpty()) {
                    int val = q.peekLast();

                    sb.append(val);
                } else{
                    sb.append(-1);
                }

                sb.append(NEW_LINE);
            } else{
                continue;
            }
        }

        br.close();

        System.out.println(sb.toString());
    }
}
