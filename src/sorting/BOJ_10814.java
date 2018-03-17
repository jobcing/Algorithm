package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 17..
 *
 * 백준 알고리즘 10814번 풀이 (https://www.acmicpc.net/problem/10814)
 *
 * 나이 순 정렬 문제. 단 나이가 같을 시 입력받은 순서를 유지할 것.
 *
 * !! 입력받은 순서를 유지하려면 아무런 조건을 추가하지 않으면 된다. !!
 */

public class BOJ_10814 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<JudgeMember> memberlist = new ArrayList<>();
        StringTokenizer st = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            memberlist.add(new JudgeMember(name, age));
        }

        Collections.sort(memberlist, new Comparator<JudgeMember>() {
            @Override
            public int compare(JudgeMember o1, JudgeMember o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < memberlist.size(); i++) {
            JudgeMember member = memberlist.get(i);

            sb.append(member.age).append(SPACE);
            sb.append(member.name).append(NEW_LINE);
        }

        System.out.println(sb.toString());
    }

    private static class JudgeMember{
        String name;
        int age;

        public JudgeMember(String name, int age){
            this.name = name;
            this.age = age;
        }
    }
}
