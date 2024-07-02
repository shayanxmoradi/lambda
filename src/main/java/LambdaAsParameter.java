public class LambdaAsParameter {
    public static void main(String[] args) {
        StringFunctinoInterface tajaaob = (s) -> s + "!";
        StringFunctinoInterface soal = (s) -> s + "?";
        shayanPrinter("salam dayosa", tajaaob);
        shayanPrinter("dayousa kojain", soal);

    }

    public static void shayanPrinter(String input, StringFunctinoInterface formater) {
        String result = formater.runner(input);
        System.out.println(result);
    }
}
