package imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 6..
 * <p>
 * 백준 알고리즘 1021번 풀이 (https://www.acmicpc.net/problem/1021)
 *
 * !! 회전하는 큐를 구현. 데이터는 head에서만 추출이 가능하고 데이터를 추출하기 위해 !!
 * !! 오른쪽, 왼쪽으로 회전이 가능하다. !!
 */

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // init rotate queue
        LinkedList<Integer> rotateQueue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            rotateQueue.add(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int opCount = 0;

        // init find data list
        int[] findDatas = new int[M];

        for (int i = 0; i < M; i++) {
            findDatas[i] = Integer.parseInt(st.nextToken());
        }

        // rotate
        for (int findData : findDatas) {

            while(true){
                int pos = rotateQueue.indexOf(findData);
                int size = rotateQueue.size();
                int left = pos;
                int right = size - pos - 1;

                // 찾으려는 데이터가 인덱스 0으로 올때까지 루프
                if(left == 0){
                    rotateQueue.remove(pos);
                    break;
                }

                if(left <= right){
                    rotateQueue.addLast(rotateQueue.removeFirst());
                    opCount++;
                } else{
                    rotateQueue.addFirst(rotateQueue.removeLast());
                    opCount++;
                }
            }
        }

        br.close();

        System.out.println(opCount);
    }
}
