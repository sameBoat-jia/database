package two;

public class Rational {
    private int numerator;//分子
    private int denominator;//分母
    private double num = denominator / numerator;

//    public int getNumerator() {
//        return numerator;
//    }

    public void setNum(double num) {
        this.num = num;
    }

    public double getNum() {
        return num;
    }
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
    public double add(Rational rational) {
        return rational.getNum() + rational.getNum();
    }
}
