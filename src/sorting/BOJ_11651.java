package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 20..
 *
 * 백준 알고리즘 11651번 풀이 (https://www.acmicpc.net/problem/11651)
 */

public class BOJ_11651 {
    
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> pointlist = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pointlist.add(new Point(x, y));
        }

        Collections.sort(pointlist, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y == o2.y){
                    return o1.x - o2.x;
                }

                return o1.y - o2.y;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pointlist.size(); i++) {
            Point p = pointlist.get(i);

            sb.append(p.x).append(SPACE);
            sb.append(p.y).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
