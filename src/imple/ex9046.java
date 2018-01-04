package imple;

import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 9. 22..
 *
 */
public class ex9046 {

    private static final int ALPHA = 26;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        scan.nextLine();
        for (int i = 0; i < n; i++) {
            String inputStr = scan.nextLine();
            solve(inputStr);
        }
    }

    private static void solve(String str){
        int[] alphabet = new int[ALPHA];
        int[] index = new int[ALPHA];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == ' '){
                continue;
            } else {
                alphabet[c - 97]++;
            }
        }

        for (int i = 0; i < ALPHA; i++) {
            index[i] = i;
        }

        // 삽입정렬 사용
        // alphabet 배열에 저장되어 있는 빈도 수를 value 값으로 생각하고
        // value 값을 기준으로 알파벳(index 배열)을 정렬한다.
        for (int i = 0; i < ALPHA - 1; i++) {
            int KEY = alphabet[index[i + 1]];
            int j = i;

            while(j >= 0){
                if(alphabet[index[j]] <= KEY){ break; }

                index[j + 1] = index[j];
                j--;
            }
            index[j + 1] = index[i + 1];
        }

        for (int i = 0; i < ALPHA; i++) {
            System.out.println(alphabet[i]);
        }

        if(alphabet[index[ALPHA - 1]] == alphabet[index[ALPHA - 2]]){
            System.out.println("?");
        } else{
            System.out.println((char)(97 + index[ALPHA - 1]));
        }
    }
}
