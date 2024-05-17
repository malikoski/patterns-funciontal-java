package br.com.malikoski.factory;

import java.util.function.Supplier;

public class FactoryPattern {

    public static void main(String[] args) {
        System.out.print("Create Bus....");
        var transBus = TransportType.BUS.factory.get();
        System.out.println(STR."Created -> \{transBus.name()}");

        System.out.print("Create Car....");
        var transCar = TransportType.CAR.factory.get();
        System.out.println(STR."Created -> \{transCar.name()}");

        System.out.print("Create Metro....");
        var transMetro = TransportType.METRO.factory.get();
        System.out.println(STR."Created -> \{transMetro.name()}");

        System.out.print("Create Train....");
        var transTrain = TransportType.TRAIN.factory.get();
        System.out.println(STR."Created -> \{transTrain.name()}");

    }



    static enum TransportType {

        BUS(Bus::new),
        CAR(Car::new),
        METRO(Metro::new),
        TRAIN(Train::new);


        public final Supplier<Transport> factory;

        TransportType(Supplier<Transport> factory) {
            this.factory = factory;
        }
    }


    @FunctionalInterface
    public interface Transport { String name(); };
    static class Bus implements Transport {

        public Bus() {
        }


        @Override
        public String name() {
            return "Bus";
        }
    };
    static class Car implements Transport {
        public Car() {
        }

        @Override
        public String name() {
            return "Car";
        }
    };
    static class Metro implements Transport {
        public Metro() {

        }

        @Override
        public String name() {
            return "Metro";
        }
    };
    static class Train implements Transport {
        public Train() {

        }

        @Override
        public String name() {
            return "Train";
        }
    };

}
