package list;

import java.util.Scanner;

/**
 * @Description 泛型单链表实现
 * @Author zdk
 * @Date 2020/9/27 21:08
 */

public class MySingleLinkedList<T> {
    /**
     * 节点类
     */
    class Node {
        T val;
        Node next;
        public Node(T val) {
            this.val = val;
        }
    }

    /**
     * 头结点
     */
    Node head;

    /**
     * 尾节点
     */
    Node tail;

    /**
     * 初始化
     */
    public MySingleLinkedList() {
        head = new Node(null);
        tail=head;
    }

    /**
     * 创建链表同时添加第一个数据
     */
    public MySingleLinkedList(T val){
        head=new Node(val);
        //此时头结点与尾节点相同
        tail=head;
    }


    /**
     * 增加一个值为val的节点在链表的头部
     */
    public void addAtHead(T val) {
        Node node = new Node(val);
        if (head == null) {
            head=node;
            tail=head;
        }else{
            node.next=head;
            head=node;
        }
    }

    /**
     * 增加一个值为val的节点在链表的尾部
     */
    public void addAtTail(T val) {
        /**
         * 原方式
         * Node node = new Node(val);
         *         Node p;
         *         p = head;
         *         int cnt = 0;
         *         while (p.next != null && cnt != this.getListLength()) {
         *             p = p.next;
         *         }
         *         p.next = node;
         */
        if(head==null){
            head=new Node(val);
            tail=head;
        }else{
            Node newNode = new Node(val);
            tail.next=newNode;
            tail=newNode;
        }
    }

    /**
     * 获得第index个节点的值
     */
    public T get(int index) {
        if (index <= 0 || index > this.getListLength()) {
            return null;
        } else {
            Node p;
            p = head;
            int cnt = 0;
            while (p.next != null && cnt != index) {
                p = p.next;
                cnt++;
            }
            return p.val;
        }
    }

    /**
     * 在第index个节点之前添加值为val的节点
     */
    public void addAtIndex(int index, T val) {
        Node p;
        p = head;
        int cnt = 0;
        while (p.next != null && cnt != index - 1) {
            p = p.next;
            cnt++;
        }
        Node n = new Node(val);
        n.next = p.next;
        p.next = n;
    }

    /**
     * 如果索引index 有效，则删除链表中的第index 个节点
     */
    public void deleteAtIndex(int index) {
        if(head==null){
            return;
        }
        if (index > this.getListLength() || index <= 0) {
            System.out.println("输入无效");
        } else {
            Node q;
            q = head;
            int cnt = 0;
            while (q.next != null && cnt != index - 1) {
                q = q.next;
                cnt++;
            }
            q.next = q.next.next;
        }
    }

    /**
     * 获取链表的第一个
     */
    public T getHead() {
        return head.next.val;
    }

    /**
     * 获取链表的最后一个元素
     */
    public T getTail() {
        /**
         * 原方法
         *         Node p;
         *         p = head;
         *         int cnt = 0;
         *         while (p.next != null && cnt != this.getListLength()) {
         *             p = p.next;
         *         }
         *         return p.val;
         */
        return tail.val;
    }

    /**
     * 删除指定值的节点
     */
    public void deleteAtValue(T val) {
        boolean flag = false;
        Node p;
        p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                flag = true;
                if (p.next.next == null) {
                    p.next = null;
                    break;
                } else {
                    p.next = p.next.next;
                }
            }
            p = p.next;
        }
        if (!flag) {
            System.out.printf("链表中无值为%d的节点\n", val);
        }
    }

    /**
     * 获得链表的长度
     */
    public int getListLength() {
        int length = 0;
        Node p;
        p = head;
        while (p.next != null) {
            p = p.next;
            length++;
        }
        return length;
    }

    /**
     * 将链表输出展示
     */
    public void showList() {
        Node p;
        p = head;
        while (p.next != null) {
            System.out.print(p.next.val + "->");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySingleLinkedList<Integer> test = new MySingleLinkedList<>();
        test.addAtTail(11);
        test.addAtTail(12);
        test.addAtTail(13);
        test.addAtTail(14);
        test.addAtTail(15);
        test.addAtTail(16);
        test.addAtTail(17);
        test.addAtIndex(1, 20);
        System.out.println("head："+test.getHead());
        System.out.println("tail："+test.getTail());
        test.showList();
        System.out.printf("链表的长度为:%d\n", test.getListLength());

        System.out.print("请输入要查询链表第几个节点的值:");
        int index = new Scanner(System.in).nextInt();

        if (test.get(index) != null) {
            System.out.printf("链表中第%d个节点的值为:%d\n", index, test.get(index));
        } else {
            System.out.println("输入无效");
        }

        System.out.print("请输入要删除第几个节点的值:");
        test.deleteAtIndex(new Scanner(System.in).nextInt());
        test.showList();

        System.out.print("请输入要删除的链表节点的值:");
        test.deleteAtValue(new Scanner(System.in).nextInt());
        test.showList();
    }
}
