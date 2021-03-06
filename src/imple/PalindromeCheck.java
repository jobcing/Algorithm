package imple;

/**
 * Created by ByeongChan on 2018. 2. 25..
 *
 * 팰린드롬 확인 메소드 구현
 *
 * !! 만약 공백이 없는 문자열 팰린드롬 체크라면 (문자열길이 / 2 + 문자열길이 % 2)까지 체크하면된다.
 * !! 하지만 공백이 있는 문자열이라면 left, right 변수를 이용해 공백은 무시하며 비교해야한다. !!
 */

public class PalindromeCheck {
    public static void main(String[] args) {

    }

    private static boolean isPalindrome(final String s){
        final String toCheck = s.toLowerCase();
        int left = 0;
        int right = toCheck.length() - 1;

        while(left <= right){

            // 공백이라면 무시
            while(left < toCheck.length() && !Character.isLetter(toCheck.charAt(left))){
                left++;
            }
            while(right > 0 && !Character.isLetter(toCheck.charAt(right))){
                right++;
            }

            // 범위 확인
            if(left > toCheck.length() || right < 0){
                return false;
            }

            // 문자 비교
            if(toCheck.charAt(left) != toCheck.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
