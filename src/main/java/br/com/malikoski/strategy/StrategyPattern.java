package br.com.malikoski.strategy;
import java.util.Arrays;
import java.util.function.Function;
import static br.com.malikoski.strategy.StrategyPattern.PaymentType.*;

public class StrategyPattern {

 static Function<Order, Number> bankBillStrategy = order -> order.value + (order.value * 0.01);
 static Function<Order, Number> creditCardStrategy = order -> order.value + (order.value * 0.03);
 static Function<Order, Number> pixStrategy = order -> order.value - (order.value * 0.05);

    public static void main(String[] args) {

        var orders = Arrays.asList(new Order(1, 5000, BANKBILL),
                new Order(2, 15000, CREDITCARD),
                new Order(2, 1000, PIX));

        orders.forEach(o -> System.out.println(STR."Order: id: \{o.id}, payment: \{o.type}, total: \{calcOrder(o)}"));
    }

    private static double calcOrder(Order order) {
        return switch (order.type) {
            case BANKBILL -> bankBillStrategy.apply(order).doubleValue();
            case CREDITCARD -> creditCardStrategy.apply(order).doubleValue();
            case PIX -> pixStrategy.apply(order).doubleValue();
        };
    }

    record Order(int id, double value, PaymentType type) {
    }

    enum PaymentType {BANKBILL, CREDITCARD, PIX}
}
