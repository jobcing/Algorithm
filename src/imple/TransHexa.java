package imple;

/**
 * Created by ByeongChan on 2017. 8. 8..
 *
 * 16진수 변환 구현 (Java)
 */
public class TransHexa {
    public static void main(String[] args) {
        char H[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    'A', 'B', 'C', 'D', 'E', 'F'};
        char result[] = new char[20];

        int D = 1017; // 임의의 수
        int i = 0; // 인덱스
        int M, N;

        do{
            M = D / 16;
            N = D % 16;
            result[i] = H[N];

            i++;
            D = M;
        } while(M >= 16);

        result[i] = H[M];
        int K = i;

        while(K >= 0){
            System.out.println(result[K]);
            K--;
        }
    }
}
