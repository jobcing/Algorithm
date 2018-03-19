package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 19..
 *
 * 백준 알고리즘 1373번 풀이 (https://www.acmicpc.net/problem/1373)
 *
 * 2진수 -> 8진수 변환 문제
 *
 * !! 2진수를 8진수로 바꾸는 문제이므로 3자리씩 끊어서 계산해주면 된다.
 * !! 하지만 맨 앞 3자리는 3자리가 아닐 수도 있으니 3으로 나눠보고 나머지를 계산해준다.
 */

public class BOJ_1373 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputBinary = scan.nextLine();
        StringBuilder sb = new StringBuilder();

        // 2진수 맨 앞 3자리가 3자리가 맞는지 검사
        int remainder = inputBinary.length() % 3;
        int sum = 0;

        for (int i = remainder - 1; i >= 0; i--) {
            sum += ((inputBinary.charAt(i) - '0') * Math.pow(2, remainder - i - 1));
        }

        // 모두 3자리로 떨어진다면 위의 작업은 이뤄지지 않으므로 결과값에 추가하면 안된다.
        if(remainder != 0) sb.append(sum);

        // 3자리씩 계산
        for (int i = remainder; i < inputBinary.length(); i += 3) {
            sum = 0;

            for (int j = 2; j >= 0; j--) {
                sum += (inputBinary.charAt(i + j) - '0') * Math.pow(2, 2 - j);
            }

            sb.append(sum);
        }

        System.out.println(sb.toString());
    }
}
