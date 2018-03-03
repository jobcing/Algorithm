package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ByeongChan on 2018. 3. 3..
 *
 * 백준 알고리즘 10989번 풀이 (https://www.acmicpc.net/problem/10989)
 */

public class BOJ_10989 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
