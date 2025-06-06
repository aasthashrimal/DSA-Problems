class Node4{
    int data;
    Node4 next;

    public Node4(int data){
        this.data=data;
        this.next=null;
    }
}

class SinglyReversal{
    int length=0;
    Node4 head;

    void addNode(int data){
        Node4 node = new Node4(data);
        if(head==null){
            head=node;
            length++;
            return;
        }
        Node4 temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        length++;
    }

    void reverseList(){
        if(head==null || head.next==null){
            return;
        }

        Node4 prev = head;
        Node4 curr = head.next;
        Node4 nex = curr.next;
        
        prev.next=null;

        while(nex!=null){
            curr.next=prev;

            prev=curr;
            curr=nex;
            nex=nex.next;
        }

        curr.next=prev;
        head=curr;

    }

    void display(){
        if(head==null){
            return;
        }
        Node4 temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

public class Problem4 {
    public static void main(String[] args) {
        SinglyReversal list = new SinglyReversal();
        list.addNode(10);
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.display();
        list.reverseList();
        list.display();
    }
}