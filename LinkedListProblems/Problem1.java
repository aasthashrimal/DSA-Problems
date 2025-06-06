/*Given a singly linked list, the task is to remove every kth node of the linked list. Assume that k is always less than or equal to the length of the Linked List. */

import java.util.Scanner;

class Node1{
    int data;
    Node1 next;

    public Node1(int data){
        this.data=data;
        this.next=null;
    }
}

class Singly1{

    int length=0;
    Node1 head;

    void addNode(int data){
        Node1 node = new Node1(data);
        if(head==null){
            head=node;
            length++;
            return;
        }
        Node1 temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        length++;
    }

    void deleteNode(int k){
        if(head==null || k<=0){
            return;
        }

        if(k==1){
            head=null;
            length=0;
            return;
        }

        Node1 temp = head;

        for(int i=0; i<(k-2) && temp.next!=null; i++){
            temp=temp.next;
        }
        while(temp.next!=null){
            Node1 del = temp.next;
            temp.next=del.next;
            del.next=null;
            length--;

            for(int i=0; i<(k-1) && temp.next!=null; i++){
                temp=temp.next;
            }
        }
    }

    void display(){
        if(head==null){
            return;
        }
        Node1 temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}   

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Singly1 list = new Singly1();
        for(int i=1; i<11; i++){
            list.addNode(i);
        }
        System.out.println("Before deleting:");
        list.display();

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        list.deleteNode(k);
        System.out.println("After deleting");
        list.display();

        sc.close();
    }
}
