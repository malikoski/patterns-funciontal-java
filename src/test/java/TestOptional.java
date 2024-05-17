import java.util.Optional;

import static java.util.Optional.ofNullable;

public class TestOptional {

    public static void main(String[] args) {
        var value = "teste";

        System.out.println(isEmpty(value));

        value = null;

        System.out.println(isEmpty(value));

        value = "";
        System.out.println(isEmpty(value));

        value = " ";
        System.out.println(isEmpty(value));


    }

    static boolean isEmpty(String value) {
        return ofNullable(value).filter(s -> !s.isEmpty()  && !s.isBlank()).isEmpty();
    }

}
