package suanfa.lianbiao.test1;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {
    //记录头节点
    private Node head;
    private int N;


    //结点类
    private class Node {
        //存储数据
        T item;
        //]
        Node next;
        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        //初始化头节点
        this.head = new Node(null, null);
        //初始化元素个数
        this.N = 0;
    }

    //清空链表
    public void clear() {
        head.next = null;
        this.N = 0;
    }

    //获取链表的长度
    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //获取指定位置i处的元素
    public T get(int i) {
        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.item;
    }

    //向链表中添加元素t
    public void insert(T t) {
        //找到当前最后一个节点
        Node n = head;
        Node newNode = new Node(t, null);
        //当前最后一个结点指向新节点
        n.next = newNode;
        //元素个数+1
        N++;
    }

    public void insert(int i, T t) {
        //找到i位置前一个结点
        Node pre = head;
        for (int index = 0; index <= i - 1; index++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node newNode = new Node(t, curr);
        pre.next = newNode;
        N++;
    }

    public T remove(int i) {
        Node pre = head;
        for (int index = 0; index <= i - 1; i++) {
            pre = pre.next;
        }
        Node curr = pre.next;
        Node nextNode = curr.next;
        pre.next = nextNode;
        N--;
        return curr.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator {
        private Node n;

        private LIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }
}
