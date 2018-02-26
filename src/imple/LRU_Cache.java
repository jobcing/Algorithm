package imple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ByeongChan on 2018. 2. 26..
 *
 * LRU 캐시 알고리즘 구현 (카카오 블라인드 1차 테스트 3번 문제)
 */

public class LRU_Cache {

    private static final int HIT = 1;
    private static final int MISS = 5;

    public static void main(String[] args) {

    }

    private static int LruSolution(int cacheSize, String[] datas){
        int ans = 0;

        Queue<String> queue = new LinkedList<>();

        for (String data : datas){
            String s = data.toLowerCase();

            // HIT
            if(queue.contains(s)){
                queue.remove(s);
                queue.add(s);

                ans += HIT;
            }

            // MISS
            else{
                if(queue.size() < cacheSize){
                    queue.add(s);
                }
                // 페이지 교체
                else{
                    queue.poll();

                    if(queue.size() < cacheSize) queue.add(s);
                }

                ans += MISS;
            }
        }

        return ans;
    }
}
