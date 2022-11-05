import java.util.Stack;

public class l {

    public static void main(String[] args) {
        Stack stack = new Stack();
        //1.empty()栈是否为空
        System.out.println(stack.empty());

        //2.peek()栈顶值 3.进栈push()

        stack.push(1);
        stack.push("b");
        System.out.println(stack.peek());

        //4.pop()出栈
        stack.pop();//b 出栈了
        System.out.println(stack);
        System.out.println(stack.peek());

    }
}

