import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class BasicLambdaExamples {
    public static void main(String[] args) {

        //Functino<T,R> : gets one argument and produces a result
        //Predicate<T> : gets one argument gives boolean
        //Consumer<T> : gets input and returns no result
        // Supplier<T> : Represents a supplier of result
        //BinaryOperator<T> : gets to input with same type returns same type
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


    }
}
