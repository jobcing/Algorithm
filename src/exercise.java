import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ByeongChan on 2017. 12. 4..
 */
public class exercise {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputstr = br.readLine();

        String[] plusop = inputstr.split("\\-");

        int result = 0;

        for (int i = 0; i < plusop.length; i++) {
            String[] minusop = plusop[i].split("\\+");

            for (int j = 0; j < minusop.length; j++) {
                result += Integer.parseInt(minusop[j]);
            }
        }

        br.close();
    }
}
