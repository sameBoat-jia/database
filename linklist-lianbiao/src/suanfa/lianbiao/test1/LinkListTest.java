package suanfa.lianbiao.test1;

public class LinkListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        LinkList<String> s1 = new LinkList<>();

        //测试插入
        s1.insert("傻逼");
        s1.insert("傻叉");
        s1.insert("傻屌");
        s1.insert(1,"傻缺");

        for (String s :
                s1) {
            System.out.println(s);
        }
        System.out.println("-------------------------------");
        //测试获取
        String getResult = s1.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
        //测试删除
        String removeResult = s1.remove(0);
        System.out.println("删除的元素是："+removeResult);
        //测试清空
        s1.clear();
        System.out.println("元素个数："+s1.length());

    }
}
