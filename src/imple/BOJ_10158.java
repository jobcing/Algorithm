package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 5. 6..
 *
 * 백준 알고리즘 10158번 풀이 (https://www.acmicpc.net/problem/10158)
 */

public class BOJ_10158 {

    private static final int UP_RIGHT = 1;
    private static final int UP_LEFT = 2;
    private static final int DOWN_LEFT = 3;
    private static final int DOWN_RIGHT = 4;

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), SPACE);
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        br.close();

        int dir = UP_RIGHT;
        int moveCnt = 0;

        while(true){
            if(t == 0){
                break;
            }

            switch(dir){
                case UP_RIGHT:
                    moveCnt = Math.min(w - p, h - q);

                    if(moveCnt >= t){
                        p += t;
                        q += t;
                        t = 0;
                    } else{
                        p += moveCnt;
                        q += moveCnt;

                        if(p == w && q == h){
                            dir = DOWN_LEFT;
                        } else if(p == w && q < h){
                            dir = UP_LEFT;
                        } else{
                            dir = DOWN_RIGHT;
                        }

                        t -= moveCnt;
                    }

                    break;

                case UP_LEFT:
                    moveCnt = Math.min(p, h - q);

                    if(moveCnt >= t){
                        p -= t;
                        q += t;
                        t = 0;
                    } else{
                        p -= moveCnt;
                        q += moveCnt;

                        if(q == h && p == 0){
                            dir = DOWN_RIGHT;
                        } else if(q == h && p > 0){
                            dir = DOWN_LEFT;
                        } else{
                            dir = UP_RIGHT;
                        }

                        t -= moveCnt;
                    }

                    break;

                case DOWN_RIGHT:
                    moveCnt = Math.min(w - p, q);

                    if (moveCnt >= t) {
                        p += t;
                        q -= t;
                        t = 0;
                    }

                    else {
                        p += moveCnt;
                        q -= moveCnt;

                        if (q == 0 && p == w){
                            dir = DOWN_LEFT;
                        } else if (q == 0 && p < w) {
                            dir = UP_RIGHT;
                        } else {
                            dir = DOWN_LEFT;
                        }

                        t -= moveCnt;
                    }

                    break;

                case DOWN_LEFT:
                    moveCnt = Math.min(p, q);

                    if (moveCnt >= t) {
                        p -= t;
                        q -= t;
                        t = 0;
                    }

                    else {
                        p -= moveCnt;
                        q -= moveCnt;

                        if (q == 0 && p == 0) {
                            dir = UP_RIGHT;
                        }

                        else if (q == 0 && p > 0) {
                            dir = UP_LEFT;
                        }

                        else {
                            dir = DOWN_RIGHT;
                        }

                        t -= moveCnt;
                    }

                    break;

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(p).append(SPACE).append(q);
        System.out.println(sb.toString());
    }
}
