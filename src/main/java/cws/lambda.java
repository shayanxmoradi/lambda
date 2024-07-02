package cws;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class lambda {
    public static void main(String[] args) {
//        List<Person> personList = List.of(new Person("shayan", 25),
//                new Person("zahra", 22),
//                new Person("kiana ", 29),
//                new Person("hadi", 32));
//https://github.com/shayanxmoradi/lambda.git
        // List<Integer> list = new ArrayList<>();
        // Integer[] values= new Integer[4];
        List<Integer> numerList = new ArrayList<>();
        IntStream stream = numerList.stream().mapToInt(x -> x);


        System.out.println(" Enter your number");
        Scanner scanner = new Scanner(System.in);



        Summary integers = Stream.generate(()->{
                    System.out.println("Enter an integer");
                    return scanner.nextInt();
                }).limit(10)
               .parallel()
                .collect(() -> {// this is terminal operator and will start the stream
                            System.out.println("new");
                            return new Summary(); //put stream values in this Summary
                        },
                        (summary, number) -> {

                            summary.setMax(summary.getMax() == null ? number : Integer.max(summary.getMax(), number));//is greater than max
                            summary.setMin(summary.getMin() == null ? number :
                                    Integer.min(summary.getMin(), number));

                            summary.setSum(Integer.sum(summary.getSum(), number));
                            summary.setCount(summary.getCount() + 1);
                            summary.setAverage(summary.getSum() / (double) summary.getCount());
                            System.out.println(summary);


                        },
                        (x, y) -> {
                    // this will  be only used , when we're using .parallel
                            x.setMax(Integer.max(x.getMax(), y.getMax()));
                            x.setMin(Integer.min(x.getMin(), y.getMin()));
                            x.setSum(Integer.sum(x.getSum(), y.getSum()));
                            x.setCount(y.getCount() + x.getCount());
                            x.setAverage(x.getSum() / (double) x.getCount());

                            System.out.println(" combine");

                        });

        System.out.println(integers);

    }


    static class Summary {
        Integer max;
        Integer min;

        int sum;
        int count;
        double average;

        public Summary() {
        }

        public Summary(int number) {
            this.max = number;
            this.min = number;
            this.sum = number;
            this.count = 1;
            this.average = number;
        }

        public Summary(int max, int min, int sum, int count, double average) {
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.count = count;
            this.average = average;
        }


        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {

            this.min = min;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Integer getMax() {
            return max;
        }

        public void setMax(Integer max) {
            this.max = max;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "MyNumber{" +
                   "max=" + max +
                   ", min=" + min +
                   ", sum=" + sum +
                   ", count=" + count +
                   ", average=" + average +
                   '}';
        }
    }}



