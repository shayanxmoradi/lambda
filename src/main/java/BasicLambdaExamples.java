import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BasicLambdaExamples {
    public static void main(String[] args) {

        //Functino<T,R> : gets one argument and produces a result
        //Predicate<T> : gets one argument gives boolean
        //Consumer<T> : gets input and returns no result
        // Supplier<T> : Represents a supplier of result
        //BinaryOperator<T> : gets 2 input with same type returns same type
        // UnaryOperator<T> : gets input returns same type output

//basic Arithmetic Operations
        BiFunction<Integer, Integer, Integer> addToNumbers = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> addToNumbersRef = Integer::sum;
        System.out.println(addToNumbers.apply(1, 2));
        ////////
        BiFunction<Integer, Integer, Integer> diffTwoNumbers = (a, b) -> a - b;
        BiFunction<Integer, Integer, Integer> diffTwoNumbersRef = Integer::compare;
        System.out.println(diffTwoNumbersRef.apply(1, 2));

        // String Iperations:
        Function<String, String> convertToUpper = String::toUpperCase;
        System.out.println(convertToUpper.apply("hello"));
        Predicate<String> isStringEmpty = String::isEmpty;
        System.out.println(isStringEmpty.test(""));
//filter
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter((a) -> a % 2 == 0).forEach(System.out::println);
        List<Integer> listOfEvens = numbers.stream().filter((a) -> a % 2 == 0).toList();
        System.out.println(listOfEvens);

        List<String> names = List.of("john", "shayan", "soghra", "hass", "america", "azar");
        Predicate<String> startsWithA = s -> s.startsWith("a");
        names.stream().filter(startsWithA).forEach(System.out::println);

        ////
        System.out.println("harder");
        names.stream().map((a) -> a.length()).toList().forEach(System.out::println);
        names.stream().map(String::length).toList().forEach(System.out::println);

        //sorting
        names.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);

        List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 20), new Person("Charlie", 25));
        people.sort(Comparator.comparingInt(a -> a.age));
        System.out.println(people);


        List<Person> people2 = Arrays.asList(new Person("Alice", 30), new Person("Bob", 20), new Person("Charlie", 25));
        Predicate<Person> startsWithAP = s -> s.name.startsWith("A");

        people2.stream().filter((a) -> a.age > 20).filter(startsWithAP).forEach(System.out::println);
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}
