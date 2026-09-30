import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class BasicJavaTest {

    @BeforeEach
    void logStart() {
        System.out.println("===================Test method start");
    }

    @Test
    public void testIsEven() {
        Random random = new Random();

        int n = random.nextInt(1, 101);

        boolean expected = (n % 2 == 0);

        boolean actual = Main.isEven(n);

        if (expected == actual) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @RepeatedTest(20)
    public void testCheckAccess() {
        Random random = new Random();

        int age = random.nextInt(100);

        String expected;
        if (age > 18) {
            expected = "Allowed";
        } else {
            expected = "Denied";
        }

        String actual = Main.checkAccess(age);

        if (actual.equals(expected)) {
            System.out.println("TEST PASSED: " + actual);
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 18, 0, -1, 99, -1000})
    public void testIsPositive(int n) {

        boolean expected = (n >= 0);

        boolean actual = Main.isPositive(n);

        if (expected == actual) {
            System.out.println("TEST PASSED: " + actual);
        } else {
            System.out.println("TEST FAILED: " + actual);
        }
    }

    @ParameterizedTest
    @CsvSource({
            "15,  E",
            "30,  D",
            "55,  C",
            "70,  B",
            "95,  A",
            "-5,  Error",
            "105, Error"
    })
    public void testGetGradeWithCsv(int score, String expectedGrade) {

        String actualGrade = Main.getGrade(score);

        if (actualGrade.equals(expectedGrade)) {
            System.out.println("Балл " + score + ": TEST PASSED (Оценка: " + actualGrade + ")");
        } else {
            System.out.println("Балл " + score + ": TEST FAILED");
        }
    }

    @RepeatedTest(3)
    public void testBlastOff() {
        Random random = new Random();

        int start = random.nextInt(0, 13);

        String expected = "";
        for (int i = start; i >= 1; i--) {
            expected = expected + i + " ";
        }
        expected = expected + "Поехали!";

        String actual = Main.blastOff(start);

        if (actual.equals(expected)) {
            System.out.println("Стартуем с " + start + ": TEST PASSED");
            System.out.println("Результат: " + actual);
        } else {
            System.out.println("Стартуем с " + start + ": TEST FAILED");

        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "3, 6",
            "4, 10",
            "5, 15"
    })
    public void testSumToN(int n, int expected) {

        int actual = Main.sumToN(n);

        if (actual == expected) {
            System.out.println("n = " + n + ": TEST PASSED (Сумма: " + actual + ")");
        } else {
            System.out.println("n = " + n + ": TEST FAILED");
        }
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    public void testHasBug(Status status) {
        String word = status.name();

        String[] messages = new String[]{word};

        boolean expected;
        if (word.equals("BUG")) {
            expected = true;
        } else {
            expected = false;
        }

        boolean actual = Main.hasBug(messages);

        if (actual == expected) {
            System.out.println("Слово '" + word + "': TEST PASSED");
        } else {
            System.out.println("Слово '" + word + "': TEST FAILED");
        }
    }

    @RepeatedTest(5)
    public void testGetEvenInRange() {
        Random random = new Random();

        int start = random.nextInt(1, 20);
        int end = start + random.nextInt(1, 15);

        String expected = "";
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                expected = expected + i + " ";
            }
        }
        expected = expected.trim();

        String actual = Main.getEvenInRange(start, end);

        if (actual.equals(expected)) {
            System.out.println("TEST PASSED: В диапазоне " + start + "-" + end + " четные числа: " + actual);
        } else {
            System.out.println("TEST FAILED: В диапазоне " + start + "-" + end);
        }
    }

    @RepeatedTest(6)
    public void testFindMax() {
        Random random = new Random();

        int[] arr = new int[5];
        int expected = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) - 50;

            if (arr[i] > expected) {
                expected = arr[i];
            }
        }

        int actual = Main.findMax(arr);

        if (actual == expected) {
            System.out.println("TEST PASSED (Max: " + actual + ")");
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    public void testReverse() {
        String[] arr = {"One", "Two", "Zero"};

        String[] actual = Main.reverse(arr);

        String[] expected = {"Zero", "Two", "One"};

        if (Arrays.equals(actual, expected)) {
            System.out.println("TEST PASSED: " + Arrays.toString(actual));
        } else {
            System.out.println("TEST FAILED");
        }
    }

    @Test
    public void testCalcAverage() {
        Random random = new Random();

        int a = random.nextInt(1, 11);
        int b = random.nextInt(1, 11);
        int c = random.nextInt(1, 11);

        List<Integer> list = List.of(a, b, c);

        double expected = (a + b + c) / 3.0;

        double actual = Main.calcAverage(list);

        if (actual == expected) {
            System.out.println("TEST PASSED: " + actual);
        } else {
            System.out.println("TEST FAILED: " + actual);
        }
    }

    @Test
    public void testRemoveSpecificName() {
        List<String> list = List.of("Пьер", "Андрей", "Наташа", "Андрей");
        String nameToRemove = "Андрей";

        List<String> actual = Main.removeSpecificName(list, nameToRemove);

        List<String> expected = List.of("Пьер", "Наташа");

        if (actual.equals(expected)) {
            System.out.println("TEST PASSED: парочка без Андрея " + actual);
        } else {
            System.out.println("TEST FAILED");
        }


    }

    @AfterEach
    void logEnd() {
        System.out.println("Test method end");
        System.out.println("===================");

    }
}