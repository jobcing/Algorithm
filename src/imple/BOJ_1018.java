package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 27..
 * <p>
 * 백준 알고리즘 1018번 풀이 (https://www.acmicpc.net/problem/1018)
 *
 * 완성된 8*8 체스판 만드는 문제
 *
 * !! 입력값의 maximum값이 낮으므로 브루트포스(모든 경우의 수를 다 해보는 것)을 고려해본다.
 * !! 우선 완성된 체스판 2개(왼쪽 위가 흰색으로 시작하는 체스판, 검은색으로 시작하는 체스판)을 만들고
 * !! 완성된 체스판과 입력된 체스판을 비교해보며 다를 경우 카운트해준다. 계속해서 최소값을 저장해가며 결과를 도출
 */

public class BOJ_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] chessboard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                chessboard[i][j] = line.charAt(j);
            }
        }

        br.close();

        // 색이 완벽히 칠해진 체스판 2개 만들기
        char[][] whiteCompleteBoard = new char[8][8];
        char[][] blackCompleteBoard = new char[8][8];

        for (int i = 0; i < whiteCompleteBoard.length; i++) {
            if(i % 2 == 0){
                String whiteline = "WBWBWBWB";
                String blackline = "BWBWBWBW";

                whiteCompleteBoard[i] = whiteline.toCharArray();
                blackCompleteBoard[i] = blackline.toCharArray();
            } else{
                String whiteline = "BWBWBWBW";
                String blackline = "WBWBWBWB";

                whiteCompleteBoard[i] = whiteline.toCharArray();
                blackCompleteBoard[i] = blackline.toCharArray();
            }
        }

        // 결과값을 저장할 변수
        int minVal = Integer.MAX_VALUE;

        // 가로 세로 +8 만큼 이동할 수 있는지 체크 후 반복문 진입
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {

                // 카운트를 해줄 변수
                int whiteCnt = 0;
                int blackCnt = 0;

                // 가로 세로 +8 만큼 이동하며 완벽한 체스판과 문자 비교
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {

                        if(chessboard[k][l] != whiteCompleteBoard[k - i][l - j]) whiteCnt++;
                        if(chessboard[k][l] != blackCompleteBoard[k - i][l - j]) blackCnt++;
                    }
                }

                // black체스판과 white체스판 중 최소값 도출
                int minColor = Math.min(whiteCnt, blackCnt);
                // 최종 최소값 저장
                minVal = Math.min(minVal, minColor);
            }
        }

        System.out.println(minVal);
    }
}
