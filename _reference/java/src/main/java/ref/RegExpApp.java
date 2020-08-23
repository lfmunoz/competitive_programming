package ref;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RegExpApp {

    public static void main(String[] args) {
        String pattern = ".*a-b-.+-c-d.*";
        Pattern regexpA = Pattern.compile(pattern);

        assertThat(regexpA.asPredicate().test("a-b-x-y-e-c-d")).isTrue();
        assertThat(regexpA.asPredicate().test("a-b-e-c-d")).isTrue();
        assertThat(regexpA.asPredicate().test("a-b-c-d")).isFalse();
        assertThat(regexpA.asPredicate().test("a-b")).isFalse();
        assertThat(regexpA.asPredicate().test("x-a-b-c-d")).isFalse();
        assertThat(regexpA.asPredicate().test("x-a-b-e-c-d")).isTrue();

        Matcher m = regexpA.matcher("a-b-x-y-e-c-d");
        // find() true if at least one match found
        // match() true only if the entire input matches
        assertThat(m.matches()).isTrue();
        assertThat("a-b-x-y-e-c-d").isEqualTo(m.group(0));
    }
}
