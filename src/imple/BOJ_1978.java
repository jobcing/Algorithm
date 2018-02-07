package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 2. 7..
 *
 * 백준 알고리즘 1978번 풀이 (https://www.acmicpc.net/problem/1978)
 *
 * 소수 찾기 문제
 */
public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        br.close();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(isPrime(num)){
                ans += 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPrime(int n){
        boolean flag = true;

        if(n == 1){
            flag = false;
        }

        for (int i = 2; i < n; i++) {
            if(n % i == 0){
                flag = false;
                break;
            }
        }

        return flag;
    }
}
