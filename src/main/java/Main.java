import java.util.ArrayList;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
//consumer example
        Consumer<String> printer = (n) -> System.out.println(n + " hi from consumer");
        list.forEach(printer);

    }
}
