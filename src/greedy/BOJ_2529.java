package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ByeongChan on 2018. 3. 8..
 *
 * 백준 알고리즘 2529번 풀이 (https://www.acmicpc.net/problem/2529)
 *
 * 부등호가 입력으로 들어오고 이에 만족하는 수(0~9)를 구하는 문제.
 *
 * !! 백트래킹과 dfs 이용 (모든 경우의 수를 따져서 최소값과 최대값을 구함) !!
 */

public class BOJ_2529 {

    private static boolean[] isVisited = new boolean[10];
    private static ArrayList<String> resultList = new ArrayList<>();
    private static int k;
    private static String[] inputlist;

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        inputlist = br.readLine().split(" ");

        for (int i = 0; i <= 9; i++) {
            isVisited[i] = true;
            dfs(i, 0, i + "");
        }

        StringBuilder sb = new StringBuilder();

        sb.append(resultList.get(resultList.size() - 1)).append(NEW_LINE);
        sb.append(resultList.get(0));

        System.out.println(sb.toString());
    }

    private static void dfs(int v, int cnt, String str){
        if(cnt == k){
            resultList.add(str);
        } else{
            for (int i = 0; i <= 9; i++) {
                if(!isVisited[i]){
                    if(inputlist[cnt].equals("<")){
                        if(i <= v){ // 조건에 맞지 않으므로 그 다음 수로 넘어간다.
                            continue;
                        }
                    } else{
                        if(i >= v){
                            continue;
                        }
                    }

                    // 조건에 해당하면 해당 수를 true로 바꾸고 부등호 개수와 일치할때까지 탐색한다.
                    isVisited[i] = true;
                    dfs(i, cnt + 1, str + i);
                }
            }
        }

        // backtracking
        isVisited[v] = false;
    }
}
