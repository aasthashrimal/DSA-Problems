//Given a number n. The task is to generate all binary numbers with decimal values from 1 to n.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2 {

    public static void binary(int n){
        Queue<String> q = new LinkedList<>();
        q.offer("1");
        for(int i=0; i<n; i++){
            String s = q.peek();
            System.out.println(q.poll());
            q.offer(s+"0");
            q.offer(s+"1");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        binary(n);
        sc.close();
    }
}