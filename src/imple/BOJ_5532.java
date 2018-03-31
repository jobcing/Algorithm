package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 3. 31..
 *
 * 백준 알고리즘 5532번 풀이 (https://www.acmicpc.net/problem/5532)
 */

public class BOJ_5532 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        while(A > 0 || B > 0){
            A -= C;
            B -= D;
            L--;
        }

        System.out.println(L);
    }
}
