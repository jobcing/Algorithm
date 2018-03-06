package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by ByeongChan on 2018. 3. 5..
 *
 * 백준 알고리즘 1302번 풀이 (https://www.acmicpc.net/problem/1302)
 *
 * !! 문자열 사전순 정렬 o1.compareTo(o2) !!
 */

public class BOJ_1302 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String bookTitle = br.readLine();

            if(hashMap.containsKey(bookTitle)){
                hashMap.put(bookTitle, hashMap.get(bookTitle) + 1);
            } else{
                hashMap.put(bookTitle, 1);
            }
        }

        br.close();

        ArrayList<String> hashList = new ArrayList<>();
        hashList.addAll(hashMap.keySet());

        Collections.sort(hashList, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int v1 = hashMap.get(o1);
                int v2 = hashMap.get(o2);

                // 책 개수에 기준으로 오름차순으로 정렬하고 있으므로, 같을 때 사전순으로 정렬하려면
                // 반대로 a가 가장 뒤에 있어야한다.
                if(v1 == v2){
                    return o2.compareTo(o1);
                }
                else {
                    return v1 - v2;
                }
            }
        });

        System.out.println(hashList.get(hashList.size() - 1));
    }
}
