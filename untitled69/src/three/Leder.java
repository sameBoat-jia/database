package three;

public class Leder extends Picture {
    public double height;
    public double up;
    public double down;

    public Leder(double height, double up, double down) {
        this.height = height;
        this.up = up;
        this.down = down;
    }

    @Override
    public void setArea() {
        this.area = (down + up) * height / 2;
    }

    @Override
    public void setCircumference() {

    }
}
