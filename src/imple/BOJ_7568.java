package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 14..
 *
 * 백준 알고리즘 7568번 풀이 (https://www.acmicpc.net/problem/7568)
 */

public class BOJ_7568 {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Person[] list = new Person[N];

        StringTokenizer st = null;

        for (int i = 0; i < list.length; i++) {
            st = new StringTokenizer(br.readLine(), SPACE);

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list[i] = new Person(w, h);
        }

        for (Person p1 : list){
            for(Person p2 : list){
                if(p1.w < p2.w && p1.h < p2.h){
                    p1.rank++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Person p : list){
            sb.append(p.rank).append(SPACE);
        }

        System.out.println(sb.toString());
    }

    private static class Person{
        int w;
        int h;
        int rank;

        public Person(int w, int h){
            this.w = w;
            this.h = h;
            this.rank = 1;
        }
    }
}
