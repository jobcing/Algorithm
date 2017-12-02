package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 7. 20..
 *
 * 삽입정렬 구현 (Java)
 */
public class InsertionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input Array Size : "); // 배열 사이즈 입력
        int size = scan.nextInt();

        int[] list = new int[size];

        System.out.print("Input Array Value : "); // 배열 값 입력
        for (int i = 0; i < size; i++) {
            list[i] = scan.nextInt();
        }

        int temp = 0; // 자리를 바꿀 때 임시로 사용되는 변수

        for (int i = 0; i < (list.length - 1); i++) {
            int KEY = list[i + 1];
            int j = i;

            while(j >= 0){ // KEY부터 하나씩 내려가며 값을 비교한다.
                if(list[j] <= KEY){ break; }

                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = KEY;
        }

        /* 처음 코드를 작성할 때 아래와 같이 구현하였는데,
        /* 삽입정렬은 정렬된 배열에 대해서는 한번만 비교해야하는데
        /* 아래 코드는 무조건 O(n2)이 되었다.
        for (int i = 0; i < (list.length - 1); i++) {
            int KEY = i + 1;

            for (int j = i; j > -1; j--) {
                if(list[j] > KEY){
                    temp = list[j];
                    list[j] = KEY;
                    KEY = list[j];
                }
            }
        }
        */

        // print
        for (int i = 0; i < size; i++) {
            System.out.println(list[i]);
        }
    }
}
