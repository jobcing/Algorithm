package imple;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 10..
 *
 * 백준 알고리즘 2161번 풀이 (https://www.acmicpc.net/problem/2161)
 */

public class BOJ_2161 {

    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            sb.append(q.poll()).append(SPACE);

            if(!q.isEmpty()){
                q.offer(q.poll());
            }
        }

        System.out.println(sb.toString());
    }
}
