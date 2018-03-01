package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2018. 3. 1..
 *
 * 백준 알고리즘 11650번 풀이 (https://www.acmicpc.net/problem/11650)
 */

public class BOJ_11650 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        ArrayList<Point> pointList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            scan.nextLine();

            pointList.add(new Point(x, y));
        }

        Collections.sort(pointList, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x == o2.x){
                    return o1.y - o2.y;
                }

                return o1.x - o2.x;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pointList.size(); i++) {
            sb.append(pointList.get(i).x).append(SPACE);
            sb.append(pointList.get(i).y).append(NEW_LINE);
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
