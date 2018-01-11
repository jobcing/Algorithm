package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 1. 11..
 *
 * 백준 알고리즘 1931번 풀이 (https://www.acmicpc.net/problem/1931)
 *
 * 최대로 회의를 많이 할 수 있는 개수 구하기
 * 회의가 최대한 빨리끝날수록 다음 선택할 수 있는 범위가 넓어지기 때문에 '종료시간'을 기준으로 정렬한다.
 * 종료 시간이 같다면 스타트를 빨리 하는 것을 우선으로 정렬한다
 *
 * !! 회의시간을 기준으로 정렬하면 안된다 !!
 */
public class BOJ_1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 회의 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 클래스 회의 리스트 생성
        ArrayList<Meet> meets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Meet meet = new Meet(start, end);
            meets.add(meet);
        }

        Collections.sort(meets, new Comparator<Meet>() {
            @Override
            public int compare(Meet o1, Meet o2) {
                if(o1.end == o2.end){
                    return o1.start - o2.start;
                } else{
                    return o1.end - o2.end;
                }
            }
        });

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < meets.size(); i++) {
            if(meets.get(i).start >= end){
                cnt++;
                end = meets.get(i).end;
            }
        }

        System.out.println(cnt);
    }

    private static class Meet{
        private int start;
        private int end;

        public Meet(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
