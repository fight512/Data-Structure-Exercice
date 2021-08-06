package list;

import java.util.LinkedList;

/**
 * @author zdk 双向循环链表
 * @date 2021/7/4 16:03
 */
public class DoubleList<T> {
    private class Node{
        T data;
        Node previous;
        Node next;
        public Node(T data, Node previous, Node next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }
    int size=0;
    /**
     * 头结点
     */
    Node head;
    /**
     * 尾节点
     */
    Node tail;

    public DoubleList() {
        tail = new Node(null, null, null);
        head = new Node(null,null,tail);
        tail.previous=head;
        tail.next=head;
    }

    public DoubleList(T val) {
        tail = new Node(null, null, null);
        head = new Node(val,null,tail);
        tail.previous=head;
        tail.next=head;
    }

    /**
     * 获取长度
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取第几个节点结点
     * @param index 从0开始
     * @return
     */
    public Node getNode(int index){
        Node node;
        if(index>=size/2){
            node=tail;
            for (int i = size; i > index; i--) {
                node=node.previous;
            }
        }else{
            node=head;
            for (int i = 0; i <=index; i++) {
                node=node.next;
            }
        }
        return node;
    }


    /**
     * 增加一个值为val的结点在链表头部
     * @param val
     */
    public void addAtHead(T val){
        insertAtIndex(0, val);
    }

    /**
     * 增加一个值为val的结点在链表尾部
     * @param val
     */
    public void addAtTail(T val){
        Node node = new Node(val, getNode(size - 1), tail);
        node.previous.next=node;
        node.next.previous=node;
        size++;
    }

    public boolean indexIllegal(int index){
        return index<0||index>=size;
    }

    /**
     * 插入元素到指定位置
     * @param index 从0开始
     * @param val
     */
    public void insertAtIndex(int index, T val){
        if(indexIllegal(index)){
            return;
        }
        Node node = getNode(index);
        Node newNode = new Node(val, node.previous, node);
        node.previous.next=newNode;
        node.previous=newNode;
        size++;
    }

    /**
     * 对index下标的重新赋值
     * @param index 从0开始
     * @param val
     * @return
     */
    public T set(int index,T val){
        if(indexIllegal(index)){
            return null;
        }
        Node node = getNode(index);
        node.data=val;
        return val;
    }

    /**
     * 删除指定位置的元素
     * @param index 从0开始
     * @return 返回删除的值
     */
    public T deleteByIndex(int index){
        if(indexIllegal(index)){
            return null;
        }
        Node node = getNode(index);
        T value=node.data;
        node.previous.next=node.next;
        node.next.previous=node.previous;
        size--;
        return value;
    }

    /**
     * 删除指定值的结点
     * @param val
     * @return
     */
    public boolean deleteByValue(T val){
        if(size<=0){
            return false;
        }
        for (int i = 0; i < size; i++) {
            Node node = getNode(i);
            if(node.data==val){
                node.previous.next=node.next;
                node.next.previous=node.previous;
                size--;
                return true;
            }
        }
        return false;
    }



    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.println("i:"+i+" "+getNode(i).data);
        }
    }


    public static void main(String[] args) {
        DoubleList<Integer> list = new DoubleList<>();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtHead(0);
        list.show();
    }

}
