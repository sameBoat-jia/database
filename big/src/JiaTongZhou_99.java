import java.util.Scanner;

public class JiaTongZhou_99 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int r = 1;
    }

    public static class Max() {
        int r;
     do
        {
            r = a % b;
            a = b;
            b = r;
        }while(b !=0);
    }
}