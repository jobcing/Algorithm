package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 7. 19..
 *
 * 버블정렬 구현 (Java)
 */
public class BubbleSort {
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

        // bubble sort
        for (int i = 0; i < (list.length - 1); i++) {
            for (int j = 1; j < (list.length - i); j++) {
                if(list[j - 1] > list[j]){
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
        }

        // print
        for (int i = 0; i < size; i++) {
            System.out.println(list[i]);
        }
    }
}
