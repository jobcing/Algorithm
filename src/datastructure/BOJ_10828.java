package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 10828번 풀이 (https://www.acmicpc.net/problem/10828)
 */

public class BOJ_10828 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Stack<Integer> s = new Stack();
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();

            if(cmd.equals("push")){
                s.push(Integer.parseInt(st.nextToken()));

            } else if(cmd.equals("pop")){

                if(!s.isEmpty()){
                    sb.append(s.pop()).append(NEW_LINE);
                } else{
                    sb.append(-1).append(NEW_LINE);
                }
            } else if(cmd.equals("size")){

                sb.append(s.size()).append(NEW_LINE);
            } else if(cmd.equals("empty")){

                if(!s.isEmpty()){
                    sb.append(0).append(NEW_LINE);
                } else{
                    sb.append(1).append(NEW_LINE);
                }
            } else if(cmd.equals("top")){

                if(!s.isEmpty()){
                    sb.append(s.peek()).append(NEW_LINE);
                } else{
                    sb.append(-1).append(NEW_LINE);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
