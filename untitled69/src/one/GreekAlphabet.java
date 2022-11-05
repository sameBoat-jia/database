package one;



public class GreekAlphabet {
    public static void main(String args[]) {
        int startPosition = 0, endPosition = 0;
        char cStart = 'α', cEnd = 'ω';
        //cStart做int转换运算，并将结果赋值给startPosition
        startPosition=(int)cStart;
        //cEnd做int转换运算，并将结果赋值给endPosition
        endPosition=(int)cEnd;
        System.out.println("希腊字母\'α\'在unicode表的顺序位置：" + startPosition);
        System.out.println("希腊字母表：");

        for (int i = startPosition; i <= endPosition; i++) {
            char c = '\0';
            //i做char型转换运算，并将结果赋值给c
            c=(char)i;
            System.out.print("  " + c);
            if ((i - startPosition + 1) % 10 == 0) {
                System.out.println("");
            }
        }
    }
}

