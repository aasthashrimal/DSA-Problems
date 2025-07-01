// Implement a Stack using two queues q1 and q2

import java.util.*;

class StackQueue{

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    int pop(){
        if(q1.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        while(q1.size()!=1){
            q2.offer(q1.poll());
        }
        int x = q1.poll();
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        return x;
    }

    void push(int n){
        q1.offer(n);
    }
}

public class Problem4 {
    public static void main(String[] args) {
        StackQueue stack = new StackQueue();
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        System.out.println(stack.pop());
    }
}