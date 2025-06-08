/* Given Circular linked list exchange the first and the last node. The task should be done with only one extra node, 
    you can not declare more than one extra node, and also you are not allowed to declare any other temporary variable. */

class Node7{
    int data;
    Node7 next;
    
    public Node7(int data){
        this.data=data;
        this.next=null;
    }
}

class Circular7{
    Node7 head;

    void exchange(){
        if(head==null || head.next==head){
            return;
        }
        if(head.next.next==head){
            head=head.next;
            return;
        }
        Node7 temp = head;
        while(temp.next.next!=head){
            temp=temp.next;
        }
        temp.next.next=head.next;
        head.next=temp.next;
        temp.next=head;
        head=temp.next.next;
    }

    void display(){
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        Node7 temp=head.next;
        while(temp!=head){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

public class Problem7 {
    public static void main(String[] args) {
        Circular7 list = new Circular7();
        list.head = new Node7(10);
        list.head.next = new Node7(20);
        list.head.next.next = new Node7(30);
        list.head.next.next.next = new Node7(40);
        list.head.next.next.next.next=list.head;
        System.out.println("Before swap:");
        list.display();
        list.exchange();
        System.out.println("After swap:");
        list.display();
    }
}
