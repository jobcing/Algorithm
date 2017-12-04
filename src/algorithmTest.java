import datastructure.Stack;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 12. 2..
 */
public class algorithmTest {
    public static void main(String[] args) {
        Stack st = new Stack(5);

        st.push(10);
        st.push(5);
        st.push(7);
        st.push(6);
        st.push(3);
        st.push(3);

        st.printStack();

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

        st.printStack();
    }
}
