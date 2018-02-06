package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 6..
 *
 * 백준 알고리즘 10797번 풀이 (https://www.acmicpc.net/problem/10797)
 */

public class BOJ_10797 {

    private final static String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] carsNum = new int[st.countTokens()];

        br.close();

        for (int i = 0; i < carsNum.length; i++) {
            carsNum[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int j = 0; j < carsNum.length; j++) {
            if(carsNum[j] == n){
                ans++;
            }
        }

        System.out.println(ans);
    }
}
