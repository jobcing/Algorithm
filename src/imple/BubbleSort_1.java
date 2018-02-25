package imple;

/**
 * Created by ByeongChan on 2018. 2. 25..
 *
 * 버블 정렬 구현 2번째 방법
 */

public class BubbleSort_1 {

    public static void main(String[] args) {

    }

    private static void bubbleSort(int[] numbers){
        boolean numberSwitch;

        do{
            numberSwitch = false;

            for (int i = 0; i < numbers.length - 1; i++) {
                if(numbers[i + 1] < numbers[i]){
                    int temp = numbers[i + 1];
                    numbers[i + 1] = numbers[i];
                    numbers[i] = temp;

                    numberSwitch = true;
                }
            }
        } while(numberSwitch);
    }
}
