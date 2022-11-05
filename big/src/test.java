
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int r = 1;
        do{
            r = a % b ;
            a = b;
            b = r;
        }while(b != 0);
        System.out.print(a);

    }

}
