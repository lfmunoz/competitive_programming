package ref;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import static java.util.Comparator.*;
import static org.assertj.core.api.Assertions.assertThat;

class JavaStreamsApp {
    public static void main(String[] args) {
        // INT
        int[] intArrA = new int[] {1,2,3};
        int[] intArrB = IntStream.of(1, 2, 3, 4, 5).toArray();

        List<Integer> intListA = Arrays.asList(1, 2);
        assertThat(intListA).contains(1,2);

        List<Integer> intListB = Stream.of(intArrA).flatMapToInt(x -> Arrays.stream(x))
                .boxed().collect(Collectors.toList());
        assertThat(intListB).contains(1,2,3);

        // Arrays.stream() method only works for primitive arrays of int[], long[], and double[] type,
        //  and returns IntStream, LongStream and DoubleStream respectively.
        List<Integer> intListC = Arrays.stream(intArrA)
                .boxed().collect(Collectors.toList());
        assertThat(intListC).contains(1,2,3);

        List<Integer> intListD = IntStream.range(1, 5)
                .boxed().collect(Collectors.toList());
        assertThat(intListD).contains(1,2,3,4);

        List<Integer> intListE = IntStream.rangeClosed(0, 4)
                .boxed().collect(Collectors.toList());
        assertThat(intListE).contains(0,1,2,3,4);

        List<Integer> intListF = IntStream.iterate(0, i -> i + 2).limit(6)
                .boxed().collect(Collectors.toList());
        assertThat(intListF).contains(0,2,4,6,8,10);

        List<Integer> intListG = IntStream.generate(() -> { return (int)(Math.random() * 10000); }).limit(10)
                .boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); // descending
        assertThat(intListG.size()).isEqualTo(10);

        List<Integer> intListH = IntStream.rangeClosed(0, 10).boxed()
                .filter( i -> i % 2 == 0).collect(Collectors.toList());
        assertThat(intListH).contains(0, 2, 4, 6, 8, 10);

        // LONG
        List<Long> longListA = LongStream.of(1L, 2L, 3L, 3L).filter(i -> i > 2).collect(ArrayList::new, List::add , List::addAll);
        assertThat(longListA).contains(3L,3L);

        // STRING
        String[] wordsArr = new String[]{"foo", "bar"};
        List<String> wordsListB = Stream.of("foo", "bar").collect(Collectors.toList());
        List <String> wordsListA = Arrays.asList("hello", "bye", "ciao", "bye", "ciao");

        List<String> longWords = wordsListA.stream().filter(w -> w.length() > 12).collect(Collectors.toList());
        List<String> lowercaseWords = wordsListA.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> firstLetters = wordsListA.stream().map(s -> s.substring(0, 1)).collect(Collectors.toList());


        Map<String, Long> wordFrequencyCount =
          wordsListA.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.<String>identity(), Collectors.<String>counting()));
        assertThat(wordFrequencyCount).contains(
                new AbstractMap.SimpleEntry("hello", 1L),
                new AbstractMap.SimpleEntry("ciao", 2L),
                new AbstractMap.SimpleEntry("bye", 2L)
        );
        String wordWithMaxFrequency = wordFrequencyCount.entrySet().stream()
                .sorted(comparing(Map.Entry::getKey))
                .max(comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .get();
        assertThat(wordWithMaxFrequency).isEqualTo("bye");



    }
}
