package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 12. 14..
 *
 * 합병 정렬 구현 (Java)
 */
public class MergeSort {

    private static int size;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input Array Size : "); // 배열 사이즈 입력
        size = scan.nextInt();

        System.out.print("Input Array Value : "); // 배열 값 입력
        int[] list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = scan.nextInt();
        }

        Msort(list, 0, list.length - 1);

        System.out.println();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static void Msort(int[] list, int L, int R){
        int M;

        // 배열을 나누는 과정
        if(L < R){
            M = (L + R) / 2;
            Msort(list, L, M);
            Msort(list, M + 1, R);
            merge(list, L, M, R);
        }
    }

    public static void merge(int[] list, int L, int M, int R){
        int[] temp = new int[size];

        int i = L;
        int j = M + 1;

        int k = L;

        // 나눠진 array를 정렬하여 합치는 과정
        // 중앙을 기점으로 왼쪽 오른쪽 데이터를 비교하여 정렬한다.
        while(i <= M && j <= R){
            if(list[i] <= list[j]){
                temp[k] = list[i++];
            } else{
                temp[k] = list[j++];
            }

            k++;
        }

        // 오른쪽 데이터가 다 처리되지 않았을 경우
        // 오른쪽 데이터 일부가 왼쪽 데이터들 보다 크기가 크다는 뜻이 된다.
        // 왼쪽 데이터는 모두 처리되었으므로 인덱스가 중앙(M) 이상이다.
        if(i > M){
            for (int l = j; l <= R; l++, k++) {
                temp[k] = list[l];
            }
        }
        // 왼쪽 데이터가 다 처리되지 않았을 경우
        else{
            for (int l = i; l <= M; l++, k++) {
                temp[k] = list[l];
            }
        }

        // 임시로 만든 array를 정렬할 array에 복사
        for (int l = L; l <= R; l++) {
            list[l] = temp[l];
        }

        // merge print
        System.out.print("Merge >> ");
        for (int l = 0; l < list.length; l++) {
            System.out.print(list[l] + " ");
        }
        System.out.println();
    }
}
