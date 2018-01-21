package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int[] piece = new int[m];
        int[] pack = new int[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), SPACE);

            pack[i] = Integer.parseInt(st.nextToken());
            piece[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        // 최소 가격을 찾기 위해 정렬
        Arrays.sort(piece);
        Arrays.sort(pack);

        int k = n / 6;
        int remainder = n % 6;

        // 기타 줄이 6개 미만이라면 패키지 하나를 사는 것으로 지정해준다.
        if (k == 0) {
            k = 1;
            remainder = 0;
        }

        int packPrice = pack[0] * k;
        // 6개 이상은 패키지로 구매하고 나머지는 패키지를 하나 더 사는 것이 최소금액인지
        // 낱개로 사는 것이 최소금액인지 비교를 한 후에 더해준다.
        packPrice += pack[0] < piece[0] * remainder ? pack[0] : piece[0] * remainder;

        // 패키지를 안사고 오로지 낱개로만 구매했을 경우
        int piecePrice = piece[0] * n;

        // 두 가지 경우를 비교하여 최종적인 최소금액을 뽑아낸다.
        int resultPrice = packPrice > piecePrice ? piecePrice : packPrice;

        System.out.println(resultPrice);
    }
}
