package cws;

import java.util.function.Function;
import java.util.stream.IntStream;

public class lambda {
    public static void main(String[] args) {
//        List<Person> personList = List.of(new Person("shayan", 25),
//                new Person("zahra", 22),
//                new Person("kiana ", 29),
//                new Person("hadi", 32));
//https://github.com/shayanxmoradi/lambda.git
        // List<Integer> list = new ArrayList<>();
        // Integer[] values= new Integer[4];
        IntStream stream = IntStream.range(0, 100);

        MyNumber integers = stream.boxed()
                .reduce(new MyNumber(),
                        (x, y) -> {

                            x.setMax(Integer.max(x.getMax(), y));
                            x.setMin(Integer.min(x.getMin(), y));
                            x.setSum(Integer.sum(x.getSum(), y));
                            x.setCount(x.getCount() + 1);
                            x.setAverage(x.getSum() / (double) x.getCount());

                            return x;

                        },
                        (x, y) -> {
                            x.setMax(Integer.max(x.getMax(), y.getMax()));
                            x.setMin(Integer.min(x.getMin(), y.getMin()));
                            x.setSum(Integer.sum(x.getSum(), y.getSum()));
                            x.setCount(y.getCount() + x.getCount());
                            x.setAverage(x.getSum() / (double) x.getCount());

                            return x;
                        });

        System.out.println(integers);

    }

    static class MyNumber {
        int max;
        int min;

        int sum;
        int count;
        double average;

        public MyNumber() {
        }

        public MyNumber(int number) {
            this.max = number;
            this.min = number;
            this.sum = number;
            this.count = 1;
            this.average = number;
        }

        public MyNumber(int max, int min, int sum, int count, double average) {
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

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
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
    }


}
