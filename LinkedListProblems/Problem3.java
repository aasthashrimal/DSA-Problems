/*Given a singly linked list and a key, the task is to count the number of occurrences 
of the given key in the linked list. */

import java.util.Scanner;

class Node3{

    int data;
    Node3 next;

    public Node3(int data){
        this.data=data;
        this.next=null;
    }
}

class Singly3{
    int length=0;
    Node3 head;

    void addNode(int data){
        Node3 node = new Node3(data);
        node.next=null;
        if(head==null){
            head=node;
            length++;
            return;
        }

        Node3 temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        length++;
    } 

    int count(int val){
        int count=0;
        if(head==null){
            return 0;
        }
        Node3 temp = head;
        while(temp!=null){
            if(temp.data==val){
                count++;
            }
            temp=temp.next;
        }
        return count;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Singly3 list = new Singly3();
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        System.out.println("Enter data of each node:");
        for(int i=0; i<n; i++){
            int e = sc.nextInt();
            list.addNode(e);
        }
        System.out.print("Enter the value to count: ");
        int val = sc.nextInt();
        System.out.println("No of occurences: "+list.count(val));
        sc.close();
    }
}