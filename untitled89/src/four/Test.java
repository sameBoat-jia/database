package four;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        try {

            System.out.println(b.f(i, j)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class A {
        public void judgment(int i) throws Exception {
            if (i < 0) {
                throw new Exception("负数");
            }
        }
    }
}
