package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 3. 6..
 *
 * 백준 알고리즘 1075번 풀이 (https://www.acmicpc.net/problem/1075)
 *
 * !! 10의 자리까지 수를 추출하려면 N %= 100 !!
 */

public class BOJ_1075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        // N의 10의 자리까지 00으로 만들기 위한 연산
        N /= 100;
        N *= 100;

        // 00 ~ 99까지 순차적으로 나누어 떨어지는지 확인
        while(N % F != 0) N++;

        // N의 최소값 뽑아낸 뒤 10자리 까지 추출
        N %= 100;

        if(N < 10){
            String ans = "0" + String.valueOf(N);
            System.out.println(ans);
        } else{
            System.out.println(N);
        }
    }
}
