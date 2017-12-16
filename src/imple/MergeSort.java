package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 12. 14..
 *
 * 합병 정렬 구현 (Java)
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input Array Size : "); // 배열 사이즈 입력
        int size = scan.nextInt();

        System.out.print("Input Array Value : "); // 배열 값 입력
        int[] list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = scan.nextInt();
        }

        Msort(list, 0, list.length - 1);

        System.out.println();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println();
    }

    public static void Msort(int[] list, int L, int R){
        int M;

        if(L < R){
            M = (L + R) / 2;
            Msort(list, L, M);
            Msort(list, M + 1, R);
            merge(list, L, M, R);
        }
    }

    public static void merge(int[] list, int L, int M, int R){
        int[] temp = list;

        int i = L;
        int j = M + 1;

        int k = L;

        while(i <= M && j <= R){
            if(list[i] <= list[j]){
                temp[k] = list[i++];
            } else{
                temp[k] = list[j++];
            }

            k++;
        }

        if(i > M){
            for (int l = j; l <= R; l++, k++) {
                temp[k] = list[l];
            }
        } else{
            for (int l = i; l <= M; l++, k++) {
                temp[k] = list[l];
            }
        }

        for (int l = L; l <= R; l++) {
            list[l] = temp[l];
        }

        System.out.println(">> ");
        for (int l = 0; l < list.length; l++) {
            System.out.print(list[l] + " ");
        }
        System.out.println();
    }
}
