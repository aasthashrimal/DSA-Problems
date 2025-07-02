/* Given an integer k and a queue of integers, we need to reverse the order of the first k elements of the queue, 
leaving the other elements in the same relative order.  
 "If the size of queue is smaller than the given k , then return the original queue." */

import java.util.*;

public class Problem1 {

    public static Queue<Integer> reverse(Queue<Integer> queue, int k){
        if(queue.size()<k) return queue;

        Stack<Integer> s = new Stack<>();
        for(int i =0; i<k; i++){
            s.push(queue.poll());
        }

        Queue<Integer> q = new LinkedList<>();
        while(!s.isEmpty()){
            q.offer(s.pop());
        }

        while(!queue.isEmpty()){
            q.offer(queue.poll());
        }

        return q;
    }

    /* Using Recursion
    public static void reverseRecursion(Queue<Integer> q, int k){
        if(k<=0 || q.isEmpty())
            return;
        int front = q.poll();
        reverseRecursion(q, k-1);
        q.offer(front);
    }
    public void reverseKelements(Queue<Integer> q, int k) {
        int n = q.size();

        reverseRecursion(q, k);

        for(int i=0;i<n-k;i++)
        {
            q.offer(q.poll());
        }
    } */

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        
        q = reverse(q, 3);
        while(!q.isEmpty()){
            System.out.print(q.poll()+" ");
        }
    }
}
