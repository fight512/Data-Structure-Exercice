package stack;

import list.MySingleLinkedList;

import java.util.Scanner;

/**
 * @author zdk
 * @date 2021/7/4 10:45
 */
public class MyLinkedStack<T> {
    MySingleLinkedList<T> list = new MySingleLinkedList<>();

    public void push(T val)//入栈
    {
        list.addAtTail(val);
    }

    public T pop()//获取并移除栈中的第一个元素
    {
        T temp = list.getTail();
        list.deleteAtIndex(list.getListLength());
        return temp;
    }

    public boolean isEmpty()//判断栈是否为空
    {
        return list.getListLength() == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyLinkedStack<String> stack = new MyLinkedStack<>();
        System.out.println("请输入数据(quit 结束):");
        while (true) {
            String input = sc.next();
            if (input.equals("quit")) {
                break;
            } else {
                stack.push(input);
            }
        }
        System.out.println("先进后出的顺序为:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
