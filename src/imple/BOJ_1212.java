package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 19..
 *
 * 백준 알고리즘 1212번 풀이 (https://www.acmicpc.net/problem/1212)
 *
 * 8진수 -> 2진수 변환 문제
 *
 * !! 8진수를 2진수로 바꿀땐 8진수 한자리가 2진수 세자리가 된다. !!
 * !! 16진수를 2진수로 바꿀땐 16진수 한자리가 2진수 네자리가 된다. !!
 * !! 즉, 8진수를 2진수로 변환하는 것을 묻는 문제이므로 한자리씩 뽑아서 2진수 세자리로 만들면된다. !!
 *
 * !! 해결방법에는 두가지 방법이 있는데 첫번째 방법은 한자리씩 뽑아서 2로 계속 나눠 몫과 나머지를 이용하는 방법과
 * !! 두번쨰 방법으로는 8진수 -> 2진수 변환 값을 미리 배열에 저장하는 방법이 존재한다.
 */

public class BOJ_1212 {

    // 2진수로 변환했을 경우 맨 앞자리에 0이 올 순 없으므로 배열을 두개 생성해준다.
    private static final String[] OCT_STR1 = {"0", "1", "10", "11", "100", "101", "110", "111"};
    private static final String[] OCT_STR2 = {"000", "001", "010", "011", "100", "101", "110", "111"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputOct = scan.nextLine();
        StringBuilder sb = new StringBuilder();

        sb.append(OCT_STR1[inputOct.charAt(0) - '0']);

        for (int i = 1; i < inputOct.length(); i++) {
            sb.append(OCT_STR2[inputOct.charAt(i) -'0']);
        }

        System.out.println(sb.toString());
    }
}
