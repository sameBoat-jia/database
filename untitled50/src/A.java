import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<list> lists = new LinkedList<list>();
        System.out.println("输入一组数：");
        String inputString = sc.nextLine();
        System.out.println("你要测试的组数：");
        int T = sc.nextInt();
        //整数len定义链表长度
        System.out.println("链表的长度是？");
        int len = sc.nextInt();
        System.out.println("由小到大的顺序是：");
//        System.out.println(T+len+q+type);
        String stringArray[] = inputString.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            lists.add(new list(Double.parseDouble(stringArray[i])));
        }
        Collections.sort(lists);
        for (list a :
                lists) {
//            if(max<a.list)
//            {
//                max=a.list;
//            }
            System.out.println(a.list);
        }
        //正整数q，表示进行q次操作
        System.out.println("你要进行几次操作?(由于系统正在维护，这里只能进行一次操作！请输入1，谢谢配合)");
        int q = sc.nextInt();
        //整数type表示操作类型
        System.out.println("操作类型是1还是2");
        int type = sc.nextInt();
//        max=lists.get(0).list;

        while (type == 1) {
            int i = 0;
            for (list a :
                    lists) {
                i++;
                System.out.println(a.list);
                if (i == len) {
                    return;
                }
            }
        }
        while (type == 2) {
            System.out.println("你想删除那两个数之间的数？(先输入大的数)");
            int max = sc.nextInt();
            int min = sc.nextInt();

            for (int size = lists.size(), i = 0; i < size; i++) {


                if (lists.get(i).list < max && lists.get(i).list > min) {
                    lists.remove();
                }
//                System.out.println("现在数组还剩：");
                System.out.println(lists.get(i).list);
                if (max == lists.get(i).list)
                    return;
            }

        }
    }
//    public void Type(int type){
//        list lists;
//        while (type==1)
//        {
//            for (list a :
//                    lists)
//                System.out.println(a.list);
//        }
//    }
}

class list implements Comparable<list> {
    public double list;

    public list(double list) {
        this.list = list;
    }

    public list() {
    }

    @Override
    public int compareTo(dataStruct.experimentOne.test1.list o) {
        return (int) (this.list - o.list);
    }

    @Override
    public int compareTo(list o) {
        return 0;
    }

//    @Override
//    public String toString() {
//        return "list{" +
//                "list=" + list +
//                '}';
//    }
}


