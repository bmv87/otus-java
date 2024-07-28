package basic.homework.hw21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.otus.java.basic.homework.hw21.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MainTests {
    private Main main;

    @BeforeEach
    public void createMain() {
        main = new Main();
    }


    @ParameterizedTest
    @MethodSource("cutArrayFromTestDataSuccess")
    void cutArrayFromSuccess(int[] array, int startValue) {

        var result = main.cutArrayFrom(array, startValue);

        Assertions.assertTrue(result == null || Arrays.stream(result).noneMatch(val -> val == startValue),
                String.format("result contains startValue %d", startValue));
    }


    @ParameterizedTest
    @MethodSource("cutArrayFromTestDataThrows")
    void cutArrayFromThrows(int[] array, int startValue) {

        Assertions.assertThrows(RuntimeException.class,
                () -> main.cutArrayFrom(array, startValue),
                "Expected cutArrayFrom() to throw, but it didn't");
    }

    @ParameterizedTest
    @MethodSource("arrayContainsOnlyDataTrue")
    void arrayContainsOnlyTrue(int[] array, int[] containsValues) {
        Assertions.assertTrue(main.arrayContainsOnly(array, containsValues),
                "result contains wrong values");
    }

    @ParameterizedTest
    @MethodSource("arrayContainsOnlyDataFalse")
    void arrayContainsOnlyFalse(int[] array, int[] containsValues) {
        Assertions.assertFalse(main.arrayContainsOnly(array, containsValues),
                "result contains valid values");
    }


    private static Stream<Arguments> cutArrayFromTestDataSuccess() {
        List<Arguments> out = new ArrayList<>();
        int cutBound = 1;
        int randomValueBoundMin = 1;
        int randomValueBoundMax = 2;
        var arraySize = 30;
        for (int i = 0; i < 10; i++) {
            var array = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                array[j] = randomValueBoundMin + (int) (Math.random() * ((randomValueBoundMax - randomValueBoundMin) + 1));
            }
            out.add(Arguments.arguments(array, cutBound));
        }
        return out.stream();
    }

    private static Stream<Arguments> cutArrayFromTestDataThrows() {
        List<Arguments> out = new ArrayList<>();
        int cutBound = 3;
        int randomValueBoundMin = 1;
        int randomValueBoundMax = 2;
        var arraySize = 30;
        for (int i = 0; i < 2; i++) {
            var array = new int[arraySize];
            for (int j = 0; j < arraySize; j++) {
                array[j] = randomValueBoundMin + (int) (Math.random() * ((randomValueBoundMax - randomValueBoundMin) + 1));
            }
            out.add(Arguments.arguments(array, cutBound));
        }
        return out.stream();
    }

    private static Stream<Arguments> arrayContainsOnlyDataTrue() {
        List<Arguments> out = new ArrayList<>();

        out.add(Arguments.arguments(new int[]{1, 2, 1, 2, 2, 2, 1}, new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{2, 2, 2, 2, 2, 2, 1}, new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{1, 2, 2, 2, 2, 2, 2}, new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 2, 1}, new int[]{1, 2}));

        return out.stream();
    }

    private static Stream<Arguments> arrayContainsOnlyDataFalse() {
        List<Arguments> out = new ArrayList<>();

        out.add(Arguments.arguments(new int[]{}, new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{5, 2, 2, 2, 2, 2, 1}, new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{2, 2, 2, 2, 2, 2, 2}, new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 3, 1, 2, 1}, new int[]{1, 2}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 2}));

        return out.stream();
    }


}
