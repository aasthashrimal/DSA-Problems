//Check if a linked list is Circular Linked List

class Node6{

    int data;
    Node6 next;

    public Node6(int data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList6{
    int length=0;
    Node6 head;

    void addNode(int data){
        Node6 node = new Node6(data);
        node.next=null;
        if(head==null){
            head=node;
            length++;
            return;
        }

        Node6 temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        length++;
    }

    boolean checkCircular(){
        if(head==null){
            return false;
        }
        Node6 temp = head;
        while(temp.next!=null && temp.next!=head){
            temp=temp.next;
        }
        return temp.next==head;
    }
}

public class Problem6 {    
    public static void main(String[] args) {
        LinkedList6 list1 = new LinkedList6();
        list1.addNode(10);
        list1.addNode(20);
        list1.addNode(30);

        if(list1.checkCircular()){
            System.out.println("List 1 is circular");
        } else{
            System.out.println("List 1 is not circular");
        }
        
        LinkedList6 list2 = new LinkedList6();
        Node6 temp = new Node6(1);
        list2.head=temp;
        list2.head.next= new Node6(2);
        list2.head.next.next=list2.head;

        if(list2.checkCircular()){
            System.out.println("List 2 is circular");
        } else{
            System.out.println("List 2 is not circular");
        }
    }
}