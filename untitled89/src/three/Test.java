package three;

public class Test {
    public static void main(String[] args) {
        Clas clas=new Clas();
        clas.f(1);
        clas.g(1,2);
        clas.h(1);
    }

    public static class Clas implements Interf{
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

    public static interface Interf {
        public abstract void f(int x);
        public abstract void g(int x,int y);
        public abstract double h(double x);
    }
}
