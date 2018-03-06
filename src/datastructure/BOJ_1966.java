package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 6..
 *
 * 백준 알고리즘 1966번 풀이 (https://www.acmicpc.net/problem/1966)
 *
 * !! 우선 순위 큐 구현 !!
 * !! 빼낸 데이터보다 큐 안에 우선순위가 높은 데이터가 있다면 다시 데이터를 큐 맨 뒤로 offer한다 !!
 */

public class BOJ_1966 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트케이스 입력
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- != 0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            Queue<Docu> q = new LinkedList<>();

            for (int i = 0; i < N; i++) {
                q.offer(new Docu(i, Integer.parseInt(st.nextToken())));
            }
            // 문서 출력 순서 변수 초기화
            int seq = 0;

            MAIN_LOOP: while(!q.isEmpty()){
                Docu docu = q.poll();

                Iterator<Docu> iterator = q.iterator();
                // 큐 안에 지금 빼낸 문서보다 우선순위가 높은 문서가 있다면 다시 맨 뒤로 문서를 큐에 삽입한다.
                while(iterator.hasNext()){
                    if(docu.impo < iterator.next().impo){
                        q.offer(docu);

                        continue MAIN_LOOP;
                    }
                }
                // 만일 지금 빼낸 문서의 우선순위가 가장 높다면 순서가 증가한다.
                seq++;

                if(docu.idx == M){
                    break;
                }
            }

            sb.append(seq).append(NEW_LINE);
        }

        br.close();

        System.out.println(sb.toString());
    }

    private static class Docu{
        int idx;
        int impo;

        public Docu(int idx, int impo){
            this.idx = idx;
            this.impo = impo;
        }
    }
}
