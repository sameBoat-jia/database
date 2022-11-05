package three;

public class test {
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Leder leder = new Leder(2,2,3);
        Trangle trangle = new Trangle(33,4,5);
        circle.setArea();
        circle.setCircumference();
        trangle.setArea();
        trangle.setCircumference();
        leder.setArea();
        System.out.println("圆的周长" +circle.circumference+
                "圆的面积" +circle.area+
                "三角形周长" +trangle.circumference+
                "三角形的面积" +trangle.area+
                "梯形面积" +leder.area+          "");
    }
}
