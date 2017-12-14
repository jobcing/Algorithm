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
        
    }
}
