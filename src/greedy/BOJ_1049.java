package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 20..
 *
 * 백준 알고리즘 1049번 풀이 (https://www.acmicpc.net/problem/1049)
 *
 * 기타 줄 N개를 최소 가격으로 구매하기
 */
public class BOJ_1049 {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 기타줄 패키지 가격과 낱개 가격을 저장할 2차원 배열
        int[][] guitarStrings = new int[m][2];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), SPACE);

            guitarStrings[i][0] = Integer.parseInt(st.nextToken()); // 패키지 가격
            guitarStrings[i][1] = Integer.parseInt(st.nextToken()); // 낱개 가격
        }

        br.close();

        Arrays.sort(guitarStrings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int resultPrice = 0;

        for (int i = 0; i < m; i++) {
            int packPrice = guitarStrings[i][0];
            int piecePrice = guitarStrings[i][1];

            if(n >= 6){
                resultPrice += packPrice;
                n -= 6;
            } else{
                if(packPrice < piecePrice * n){
                    resultPrice += packPrice;
                } else{
                    resultPrice += piecePrice * n;
                }
            }
        }

        System.out.println(resultPrice);
    }
}
