package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 7. 19..
 *
 * 선택 정렬 구현 (Java)
 */
public class SelectionSort {
    public static void main(String[] ar) throws Exception {
        Scanner scan = new Scanner(System.in);

        System.out.print("Input Array Size : "); // 배열 사이즈 입력
        int size = scan.nextInt();

        int[] items = new int[size];

        System.out.print("Input Array Value : "); // 배열 값 입력
        for (int i = 0; i < size; i++) {
            items[i] = scan.nextInt();
        }

        int temp; // 자리를 바꿀 때 임시로 사용되는 변수

        // SelectionSort
        for (int i = 0; i < (items.length - 1); i++) {
            for (int j = (i + 1); j < items.length; j++) {
                if (items[i] > items[j]) {
                    temp = items[i];
                    items[i] = items[j];
                    items[j] = temp;
                }
            }
        }

        // print
        System.out.println("-------------------------------------------");
        System.out.print("Result : ");
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }
}
