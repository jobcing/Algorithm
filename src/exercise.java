import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ByeongChan on 2017. 12. 4..
 */
public class exercise {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        int[] nums = new int[10];
        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            nums[num]++;
            sum += num;
        }

        if(sum % 3 != 0 || nums[0] == 0){
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            while(nums[i]-- > 0){
                sb.append(i);
            }
        }

        System.out.println(sb.toString());
    }
}
