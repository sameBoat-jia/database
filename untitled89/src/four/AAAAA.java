package four;

class MyException extends Exception {
    String message;

    MyException(int n,int m) {
        message = n+"或者"+m + "不是正数";
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class AA {
    public int f(int a, int b) throws MyException {
if(a<0||b<0)
{
    MyException exception=new MyException(a,b);
    throw(exception);
}

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;

    }
}

public class AAAAA {
    public static void main(String[] args) {
        AA aa = new AA();
        try {
            System.out.println(aa.f(28, 4));
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
