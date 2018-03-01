package sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 1..
 *
 * 백준 알고리즘 1427번 풀이 (https://www.acmicpc.net/problem/1427)
 */

public class BOJ_1427 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine();
        int[] nums = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();

        for (int i = (nums.length - 1); i >= 0; i--) {
            sb.append(nums[i]);
        }

        System.out.println(sb.toString());
    }
}
