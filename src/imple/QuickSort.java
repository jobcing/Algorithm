package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 8. 8..
 *
 * 퀵 정렬 구현 (Java)
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input Array Size : "); // 배열 사이즈 입력
        int size = scan.nextInt();

        System.out.print("Input Array Value : "); // 배열 값 입력
        int[] list = new int[size];

        for (int i = 0; i < size; i++) {
            list[i] = scan.nextInt();
        }

        Qsort(list, 0, list.length - 1);

        System.out.println();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println();
    }

    public static void Qsort(int[] list, int L, int R){
        int temp;

        if(L >= R) return;

        int P = list[L]; // pivot
        int i = L + 1;
        int j = R;

        while(i <= j){
            while(P > list[i] && i < R) i++;
            while(P < list[j] && j > L) j--;

            if(i >= j) break;

            temp = list[i];
            list[i] = list[j];
            list[j] = temp;
        }

        // pivot을 중앙으로 이동
        temp = list[j];
        list[j] = list[L];
        list[L] = temp;

        // pivot을 중심으로 quick sort
        Qsort(list, L, j - 1);
        Qsort(list, j + 1, R);
    }
}
