package cws;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Nummbers {
    public static void main(String[] args) {
//        record OtpRequest(String phone, LocalTime time) {
//        }
//        Stream.of(
//                        new OtpRequest("09123456789", LocalTime.of(12, 1)),
//                        new OtpRequest("09132456789", LocalTime.of(12, 1)),
//                        new OtpRequest("09123456789", LocalTime.of(12, 2)),
//                        new OtpRequest("09123456789", LocalTime.of(12, 3)),
//                        new OtpRequest("09123456789", LocalTime.of(12, 4)),
//                        new OtpRequest("09123456789", LocalTime.of(12, 7))
//                )
//                .forEach(otpRequest -> System.out.printf("Send otp to: %s [%s]%n", otpRequest.phone(), otpRequest.time()));
//
//

        Map<String, List<LocalTime>> requests = Stream.of(
                        new OtpRequest("09123456789", LocalTime.of(12, 1)),
                        new OtpRequest("09132456789", LocalTime.of(12, 1)),
                        new OtpRequest("09123456789", LocalTime.of(12, 2)),
                        new OtpRequest("09123456789", LocalTime.of(12, 3)),
                        new OtpRequest("09123456789", LocalTime.of(12, 4)),
                        new OtpRequest("09123456789", LocalTime.of(12, 7))
                )
                .peek(otpRequest -> System.out.printf("Request to: %s [%s]%n", otpRequest.phone(), otpRequest.time()))

                .filter(distinctBy(OtpRequest::phone,
                        (otpRequest, otpRequest2) -> {
                            if (otpRequest2.time().isBefore(otpRequest.time()))
                                return false;
                            long diff = ChronoUnit.MINUTES.between(otpRequest.time(), otpRequest2.time());
                            return diff >= 2;
                        }))
                .limit(5)
                .peek(otpRequest -> System.out.printf("Send otp to: %s [%s]%n", otpRequest.phone(), otpRequest.time())) // use for print, has no Effect on our Stream
                .collect(Collectors.groupingBy(
                        OtpRequest::phone,
                        Collectors.mapping(OtpRequest::time, Collectors.toList())
                ));
        System.out.println("=====Summary=====");
        requests.forEach((phone, times) -> System.out.printf(
                "Phone: %s %s%n", phone, times
        ));

    }
    record OtpRequest(String phone, LocalTime time) {
    }
    public static <T, U> Predicate<T> distinctBy(Function<T, U> identifier,
                                                 BiPredicate<T, T> condition) {
        Map<U, T> seen = new ConcurrentHashMap<>();
        return t -> {
            U key = identifier.apply(t);
            T old = seen.putIfAbsent(key, t);
            if (old == null) return true;
            boolean ok = condition.test(old, t);
            if (ok) seen.put(key, t);
            return ok;
        };
    }
}
