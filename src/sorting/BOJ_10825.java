package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 4. 4..
 *
 * 백준 알고리즘 10825번 풀이 (https://www.acmicpc.net/problem/10825)
 */

public class BOJ_10825 {
    
    private static final String NEW_LINE = "\n";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        ArrayList<Student> stlist = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            stlist.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(stlist, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.korean == o2.korean && o1.english == o2.english && o1.math == o2.math){
                    return o1.name.compareTo(o2.name);
                } else if(o1.korean == o2.korean && o1.english == o2.english){
                    return o2.math - o1.math;
                } else if(o1.korean == o2.korean){
                    return o1.english - o2.english;
                } else{
                    return o2.korean - o1.korean;
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stlist.size(); i++) {
            sb.append(stlist.get(i).name).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private static class Student{
        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
