package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by ByeongChan on 2018. 2. 27..
 *
 * 백준 알고리즘 1181번 풀이 (https://www.acmicpc.net/problem/1181)
 *
 * 중복된 문자열 제거하고 길이가 짧은 순, 같다면 사전순으로 출력하는 문제
 *
 * !! HashSet으로 중복된 문자열을 제거하고 List로 만든다. !!
 * !! HashSet.toArray(new String[size]) !!
 */

public class BOJ_1181 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> wordsHashSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            wordsHashSet.add(br.readLine());
        }

        String[] words = wordsHashSet.toArray(new String[wordsHashSet.size()]);

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }

                return o1.length() - o2.length();
            }
        });

        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }
}
