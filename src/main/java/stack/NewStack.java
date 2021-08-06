package stack;

/**
 * @author zdk
 * @date 2021/7/4 13:56
 * 链栈
 */
public class NewStack<T> {
    class Node{
        T data;
        Node next;
        public Node(T data){
            this.data=data;
        }
    }

    /**
     * 栈顶节点
     */
    Node top;

    /**
     * 出栈
     * @return
     */
    public T pop(){
        T data=top.data;
        top=top.next;
        return data;
    }

    /**
     * 入栈
     * @return
     */
    public void push(T data){
        Node node = new Node(data);
        node.next=top;
        top=node;
    }

    /**
     * 获取栈顶元素的值
     */
    public T peek(){
        return top.data;
    }

    /**
     * 获取栈size
     * @return
     */
    public int size(){
        int size=0;
        Node start=top;
        while (start!=null){
            size++;
            start=start.next;
        }
        return size;
    }


    /**
     * 打印栈
     */
    public void showStack(){
        Node start=top;
        while (start!=null){
            System.out.println(start.data);
            start=start.next;
        }
    }


    public static void main(String[] args) {
        NewStack<Integer> stack = new NewStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println("top"+stack.peek());
        System.out.println("pop-top"+stack.pop());
        System.out.println("top"+stack.peek());
        stack.showStack();
    }
}
