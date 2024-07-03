package streams;

import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        // -----intermediate Operation---------
        //.map -> transfroms each element
        // .filter -> filters elements base on a predicate
        // .sorted -> sorts elemensts.
        // ---- termina Operation ----
        // collect: puts elements into a collection
        // foreach : does action for each element.
        // reduce: reduces elements into single value.
        //findFirst
        //---- parallel streams

        ////convert to uppercase
        List<String> list = List.of("a", "b", "c", "d", "e", "f", "g", "h");
        List<String> uppsercaseList = list.stream().map((a) -> a.toUpperCase()).toList();
        List<String> uppsercaseList2 = list.stream().map(String::toUpperCase).toList();
        List<String> upperlist3 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppsercaseList);
        System.out.println(uppsercaseList2);
        //// find first element
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = numbers.stream().reduce((a, b) -> a);
        System.out.println("reduce" + reduce.get());
        Optional<Integer> first = numbers.stream().findFirst();
        System.out.println(first.get());
        // numbers.stream().filter((a)-> numbers.getFirst().equals(a)).;
        //filter out even numbers
        System.out.println("not even");
        numbers.stream().filter((a) -> a % 2 != 0).toList().forEach(System.out::println);

        System.out.println(numbers.stream().reduce(Integer::sum).get());
        System.out.println(numbers.stream().reduce((a, b) -> a > b ? a : b).get());
// convert string to list of lenghts
        List<String> names = List.of("shayan", "asghar", "xsd", "zari", "exe", "fxv", "gsf", "h");
        List<Integer> sizeList = names.stream().map((input) -> input.length()).toList();
        System.out.println("sizeList" + sizeList);

        Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(String::length)); //???
        System.out.println("collect" + collect);
        // converting to Map , seprating odds and evens
        Map<Boolean, List<Integer>> oddAndEvens = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(oddAndEvens);

        ////
        System.out.println(names.stream().map((input) -> input.length()).distinct().toList());


        class Person {
            final String name;
            final int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return name + " (" + age + ")";
            }
        }

// List of Person objects
        List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 20), new Person("Charlie", 25));

        System.out.println(people.stream().sorted(Comparator.comparing(person -> person.age)).map(person -> person.name).toList());

    }

}
