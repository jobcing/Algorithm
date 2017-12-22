package datastructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ByeongChan on 2017. 9. 22..
 *
 * 백준 알고리즘 9012번 풀이 (
 *
 * Stack 이용한 괄호 문제
 */
public class BOJ_9012 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();
        String[] vps = new String[n];

        for (int i = 0; i < vps.length; i++) {
            vps[i] = scan.nextLine();
        }

        for (int i = 0; i < n; i++) {
            Stack s = new Stack<Character>();

            char[] c = vps[i].toCharArray();
            int flag = 0;

            for (int j = 0; j < c.length; j++) {
                if(c[j] == '('){
                    s.push(c[j]);
                } else if(c[j] == ')'){
                    if(s.isEmpty()){ // 끝나지 않았는데 스택이 비어있다면 NO
                        flag = 1;
                        break;
                    }
                    s.pop();
                }
            }

            if(s.isEmpty() && flag == 0){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }
    }
}
