package java.src.test.java.com.itheima;

import java.util.function.Consumer;

public class TestClosure {
    public static void main(String[] args) {
        a().accept(10);
    }

    public static Consumer<Integer> a() {
        int y = 20;
        Consumer<Integer> b =
                x -> System.out.println(x + "," + y);
        return b;
    }
}
