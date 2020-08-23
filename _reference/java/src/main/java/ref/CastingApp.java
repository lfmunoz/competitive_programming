package ref;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CastingApp {
    public static void main(String[] args) {

        // List<Integer> to int[]
        List<Integer> intListA = Arrays.asList(1, 2);
        int[] intArrA = intListA.stream().mapToInt(i->i).toArray();
        assertThat(intArrA).contains(1,2);

        // int[] to List<Integer>
        int[] intArrB = new int[]{1,2,3};
        List<Integer> intListB = Arrays.stream(intArrB).boxed().collect(Collectors.toList());
        assertThat(intListB).contains(1,2,3);

        // int to Boolean
        int intA = 1;
        Boolean boolA = (intA == 1) ? true : false;
        assertThat(boolA).isTrue();

        // String to int
        int intB = Integer.parseInt("1");
        assertThat(intB).isEqualTo(1);

        // String to double
        double doubleB = Double.parseDouble("1.0");
        assertThat(doubleB).isEqualTo(1.0);

    }
}
