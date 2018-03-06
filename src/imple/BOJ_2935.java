package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/**
 * Created by ByeongChan on 2018. 3. 6..
 *
 * 백준 알고리즘 2935번 풀이 (https://www.acmicpc.net/problem/2935)
 */

public class BOJ_2935 {
    public static void main(String[] args) throws IOException{
        // 버퍼를 통해 입력 값을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigDecimal A = new BigDecimal(br.readLine());
        String operator = br.readLine();
        BigDecimal B = new BigDecimal(br.readLine());
        br.close();

        if (operator.equals("+")) {
            System.out.println(A.add(B));
        } else {
            System.out.println(A.multiply(B));
        }
    }
}
