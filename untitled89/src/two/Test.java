package two;

public class Test {
    public static void main(String[] args) {
        Abs abs=new Exten();
        abs.f(1);
        abs.g(1,2);
        abs.h(1);
    }

    public abstract static class Abs {
        public abstract void f(int x);
        public abstract void g(int x,int y);
        public abstract double h(double x);
    }

    public static class Exten extends Abs {
        @Override
        public void f(int x) {
            System.out.println("我是f方法");
        }

        @Override
        public void g(int x, int y) {
            System.out.println("我是g方法");
        }

        @Override
        public double h(double x) {
            System.out.println("我是h方法");
            return x;
        }
    }
}
