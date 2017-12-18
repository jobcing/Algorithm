import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ByeongChan on 2017. 12. 4..
 */
public class exercise {

    public class Person implements Comparable<Person>{
        private String name;
        private int age;
        private int point;

        @Override
        public int compareTo(Person p){
            return this.age - p.age; // 오름차순 정렬

            // 내림차순 정렬
            // return p.age - this.age;
        }
    }

    public static void main(String[] args) {
        Person[] person = new Person[10];

        Arrays.sort(person, new Comparator<Person>(){
            public int compare(Person p1, Person p2){ return p1.point - p2.point; }
        });

        ArrayList
    }


}
