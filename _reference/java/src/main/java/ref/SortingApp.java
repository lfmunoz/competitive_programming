package ref;


import java.util.*;
import java.util.stream.IntStream;

import static java.util.Comparator.*;
import static org.assertj.core.api.Assertions.assertThat;

class SortingApp {

    // Static nested class
    static class Person {
        String name;
        Integer age;
        Boolean isFemale;

        Person(String _name, Integer _age, Boolean _isFemale) {
            name = _name; age = _age; isFemale = _isFemale;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return "(name=" + name + ",age=" + age + ",isFemale=" + isFemale + ")";
        }
    }

    public static void main(String[] args) {

        // sorts in-place natural order (low to high)
        List<Integer> intListA = Arrays.asList(1,5,7,2);
        Collections.sort(intListA);
        assertThat(intListA).containsExactly(1,2,5,7);

        // sorts in-place reverseOrder (high to low)
        List<Integer> intListB = Arrays.asList(1,5,7,2);
        intListB.sort(reverseOrder());
        assertThat(intListB).containsExactly(7,5,2,1);

        // sorts in-place specifying getter
        List<Person> personListA = Arrays.asList(
                new Person("John", 21, false),
                new Person("Billy", 17, false),
                new Person("Karen", 57, true)
        );
        personListA.sort(comparing(Person::getAge).reversed());
        assertThat(personListA.get(0).age).isEqualTo(57);
        assertThat(personListA.get(1).age).isEqualTo(21);
        assertThat(personListA.get(2).age).isEqualTo(17);

        // sort in-place write your own comparator
        List<Person> personListB = Arrays.asList(
                new Person("John", 21, false),
                new Person("Billy", 17, false),
                new Person("Karen", 57, true)
        );
        personListB.sort( (itemA, itemB) -> {
            if (itemA.age == itemB.age) return 0;
            if (itemA.age > itemB.age) return 1;
            return -1;
         });
        assertThat(personListB.get(0).age).isEqualTo(17);
        assertThat(personListB.get(1).age).isEqualTo(21);
        assertThat(personListB.get(2).age).isEqualTo(57);
    }

}


