// Implement a Queue using two stack s1 and s2

import java.util.Stack;

class QueueStack{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int n){
        s1.push(n);
    }

    int dequeue(){
        if(!s2.isEmpty()){
            return s2.pop();
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
}

public class Problem3 {
    public static void main(String[] args) {
        QueueStack queue = new QueueStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        System.out.println(queue.dequeue());
    }
}