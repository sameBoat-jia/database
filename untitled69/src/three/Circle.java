package three;

public class Circle extends Picture {
    public double banJing;

    public Circle(double banJing) {
        this.banJing = banJing;
    }

    @Override
    public void setArea() {
        this.area = 3.14 * banJing * banJing;
    }

    @Override
    public void setCircumference() {
        this.circumference = 2 * banJing * 3.14;
    }
}
