package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ByeongChan on 2017. 9. 22..
 *
 * 백준 알고리즘 11403번 풀이 (https://www.acmicpc.net/problem/11403)
 *
 * 경로 찾기 문제
 * 방향 그래프에서 경로가 존재하는지 안하는지 구하는 문제
 * 각 정점이 다른 정점과의 관계를 찾을 때는 bfs보다 dfs를 이용하는 것이 쉽게 구현할 수 있다.
 */
public class BOJ_11403 {
    // 문자 상수
    private static final char SPACE = ' ';
    private static final char NEW_LINE = '\n';

    // 정점 갯수 저장 변수
    private static int N = 0;

    // 인접 행렬
    private static int[][] matrix = null;

    // 방문 여부
    private static int[] isVisited = null;

    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 인접 행렬 초기화
        matrix = new int[N][N];

        // 방문 여부 초기화
        isVisited = new int[N];

        // 방향 그래프 입력받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 결과값 저장 배열 초기화
        int[][] result = new int[N][N];

        for (int u = 0; u < N; u++) {
            dfs(u, true);

            for (int v = 0; v < N; v++) {
                // 결과 저장
                result[u][v] = isVisited[v];

                // 다음 시작 지점 탐색을 위해 방문 여부 초기화
                isVisited[v] = 0;
            }
        }

        // 버퍼를 통해 결과값 생성
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(SPACE);
            }

            sb.append(NEW_LINE);
        }

        // 결과값 출력
        System.out.println(sb.toString());
    }

    private static void dfs(int u, boolean isStartPoint){
        // 무조건 자기 자신은 경로가 있다고 구현되므로
        // 시작점이 된 노드는 방문했다고 표시하면 안된다.
        if(!isStartPoint){
            isVisited[u] = 1;
        }

        for (int v = 0; v < N; v++) {
            if(matrix[u][v] == 1 && isVisited[v] == 0){
                dfs(v, false);
            }
        }
    }
}
