package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 2. 25..
 *
 * 문자열 뒤집기
 */
public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        System.out.println(reverse2(str));
    }

    // 첫번째 방법
    private static String reverse1(final String s){
        final StringBuilder sb = new StringBuilder(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    private static String reverse2(final String s){
        final StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length() / 2; i++) {
            final char tmp = sb.charAt(i);
            final int otherEnd = sb.length() - 1 - i;

            sb.setCharAt(i, sb.charAt(otherEnd));
            sb.setCharAt(otherEnd, tmp);
        }

        return sb.toString();
    }
}
