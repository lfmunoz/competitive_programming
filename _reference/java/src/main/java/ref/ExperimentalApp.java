package ref;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import static java.util.Comparator.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ExperimentalApp {
    static private String GAP = "gap";

    public static void main(String[] args) {

        List <String> wordsListA = Arrays.asList("hello", "bye", "ciao", "bye", "ciao");

        Map<String, Long> freqCount = wordsListA.stream()
                .collect(Collectors.groupingBy(Function.<String>identity(), Collectors.<String>counting()));
        System.out.println(freqCount);
        assertThat(freqCount).contains(
                new AbstractMap.SimpleEntry("hello", 1L),
                new AbstractMap.SimpleEntry("ciao", 2L),
                new AbstractMap.SimpleEntry("bye", 2L)
        );

        String wordWithMaxCount = freqCount.entrySet().stream()
                .sorted(comparing(Map.Entry::getKey))
                .max(comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .get();
        assertThat(wordWithMaxCount).isEqualTo("bye");
    }



}

