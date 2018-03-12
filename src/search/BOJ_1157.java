package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2018. 3. 12..
 *
 * 백준 알고리즘 1157번 풀이 (https://www.acmicpc.net/problem/1157)
 *
 * 입력받은 문자열 중에 가장 많이 쓰인 알파벳을 출력하는 문제
 *
 * !! 배열 두개 사용하여 삽입정렬 !!
 */

public class BOJ_1157 {

    private static final int ALPHA = 26;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine().toUpperCase();

        int[] alphaCnt = new int[ALPHA];
        int[] alphaIndex = new int[ALPHA];

        // alpha index init
        for (int i = 0; i < alphaIndex.length; i++) {
            alphaIndex[i] = i;
        }

        for (int i = 0; i < inputStr.length(); i++) {
            alphaCnt[inputStr.charAt(i) - 'A']++;
        }

        for (int i = 0; i < alphaCnt.length - 1; i++) {
            int VALUE = alphaCnt[i + 1];
            int KEY = alphaIndex[i + 1];
            int j = i;

            while(j >= 0){
                if(VALUE >= alphaCnt[alphaIndex[j]]) break;

                alphaIndex[j + 1] = alphaIndex[j];
                j--;
            }

            alphaIndex[j + 1] = KEY;
        }

        int maxWord = alphaIndex[alphaIndex.length - 1];
        int secondWord = alphaIndex[alphaIndex.length - 2];

        if(alphaCnt[maxWord] == alphaCnt[secondWord]){
            System.out.println("?");
        } else{
            System.out.println((char) (maxWord + 'A'));
        }
    }
}
