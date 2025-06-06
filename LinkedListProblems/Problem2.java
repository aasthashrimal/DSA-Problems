/*Find Middle of the Linked List */

import java.util.Scanner;

class Node2{

    int data;
    Node2 next;

    public Node2(int data){
        this.data=data;
        this.next=null;
    }
}

class Singly2{
    int length=0;
    Node2 head;

    void addNode(int data){
        Node2 node = new Node2(data);
        node.next=null;
        if(head==null){
            head=node;
            length++;
            return;
        }

        Node2 temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        length++;
    } 

    int middle(){
        if(head==null){
            return -1;
        }
        Node2 temp = head;
        int pos = this.length/2;
        for(int i=0; i<pos; i++){
            temp=temp.next;
        }
        return temp.data;
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Singly2 list = new Singly2();
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        if(n!=0){
            System.out.println("Enter data of each node:");
        }
        for(int i=0; i<n; i++){
            int e = sc.nextInt();
            list.addNode(e);
        }
        if(list.middle() == -1){
            System.out.println("List is empty");
        } else{
            System.out.println("Middle node: "+list.middle());
        }
        sc.close();
    }
}
