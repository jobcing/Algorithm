package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2018. 3. 3..
 *
 * 백준 알고리즘 1068번 풀이 (https://www.acmicpc.net/problem/1068)
 *
 * Tree 자료구조를 ArrayList로 표현하고 리프노드를 확인하는 방법은 ArrayList의 사이즈가 0인지를 파악한다.
 */

public class BOJ_1068 {
    // 노드 방문 여부
    private static boolean[] isChecked;
    // 각 노드들이 가지고 있는 자식 노드를 저장할 list
    private static ArrayList<Integer>[] adjlist = null;
    // 리프노드 개수를 저장할 변수
    private static int leafNodeCnt = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // 리스트 초기화
        adjlist = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjlist[i] = new ArrayList<>();
        }

        // 루트 노드인지 확인 (트리가 한개라는 보장이 없기 때문에)
        boolean[] isRootNode = new boolean[N];

        for (int i = 0; i < N; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            // i번 노드가 가르키는 부모노드 리스트에 i번 노드를 저장
            if(parentNode != -1){
                adjlist[parentNode].add(i);
            }

            else{
                isRootNode[i] = true;
            }
        }
        // 삭제할 노드 번호
        int deleteNode = Integer.parseInt(br.readLine());

        br.close();

        // 리스트를 탐색해서 자식 노드들 중 삭제할 노드 번호가 있다면 삭제한다.
        MAIN_LOOP : for (ArrayList<Integer> list : adjlist){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == deleteNode){
                    list.remove(i);

                    break MAIN_LOOP;
                }
            }
        }

        isChecked = new boolean[N];

        // 노드들 중에 루트 노드를 검색하여 dfs
        for (int i = 0; i < N; i++) {
            if(isRootNode[i] && !isChecked[i] && i != deleteNode){
                isChecked[i] = true;

                dfs(i);
            }
        }

        System.out.println(leafNodeCnt);
    }

    private static void dfs(int i){
        // 사이즈가 0이면 리프노드이다.
        if(adjlist[i].size() == 0){
            leafNodeCnt++;

            return;
        }

        // 자식 노드에 delete node 번호를 삭제했으므로 탐색하여 delete node로 갈 방법이 없다.
        for (int next : adjlist[i]){
            if(!isChecked[next]){
                isChecked[next] = true;

                dfs(next);
            }
        }
    }
}
