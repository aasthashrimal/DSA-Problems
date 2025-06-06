
class Node5{
    int data;
    Node5 prev;
    Node5 next;

    public Node5(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

class DoublyReversal{

    int length=0;
    Node5 head;

    void addNode(int data){
        Node5 node = new Node5(data);

        if(head==null){
            head=node;
            length++;
            return;
        }

        Node5 temp = head;

        while(temp.next!=null){
            temp=temp.next;
        }

        node.prev=temp;
        temp.next=node;
        length++;
    }

    void reverseList(){
        if(head==null || head.next==null){
            return;
        }

        Node5 temp = head;

        while(temp.next!=null){
            Node5 nextnode = temp.next;

            Node5 n=temp.prev;
            temp.prev=temp.next;
            temp.next=n;

            temp=nextnode;
        }

        head=temp;
        temp.next=temp.prev;
        temp.prev=null;
        
    }

    void display(){
        if(head==null){
            return;
        }
        Node5 temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

}

public class Problem5 {
    public static void main(String[] args) {
        DoublyReversal list = new DoublyReversal();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.display();
        list.reverseList();
        list.display();
    }
}