
import java.util.Scanner;

class NodeC{
    int data;
    NodeC next;

    public NodeC(int data){
        this.data=data;
        this.next=null;
    }
}

class Circular{
    NodeC head;
    int length=0;

    void addNode(int data){
        NodeC node = new NodeC(data);
        if(head==null){
            head=node;
            node.next=node;
            length++;
            return;
        }
        NodeC temp=head;
        while(temp.next!=head){
            temp=temp.next;
        }
        temp.next=node;
        node.next=head;
        length++;
    }

    void insertion(int data, int pos){
        NodeC node = new NodeC(data);
        if(pos==1){
            if(head==null){
                head=node;
                node.next=node;
                length++;
                return;
            }
            node.next=head;
            NodeC temp = head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=node;
            head=node;
            length++;
            return;
        }

        if(head==null){
            System.out.println("Position out of bounds: empty list");
            return;
        }

        NodeC temp = head;
        int i;
        for(i=1; i<pos-1 && temp.next!=head; i++){
            temp=temp.next;
        }
        if(i<pos-1){
            System.out.println("Position out of bounds");
            return;
        }
        node.next=temp.next;
        temp.next=node;
        length++;
    } 

    void deletePosition(int pos){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(pos==1){
            if(length==1){
                head=null;
                length--;
                return;
            }
            NodeC temp = head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=head.next;
            NodeC del = head;
            head=head.next;
            del.next=null;
            length--;
            return;
        }
        NodeC temp =head;
        for(int i=1; i<pos-1 && temp.next!=head; i++){
            temp=temp.next;
        }
        if(temp.next==head){
            System.out.println("Position out of bounds");
            return;
        }
        NodeC del = temp.next;
        temp.next=del.next;
        del.next=null;
        length--;
    }

    void deleteValue(int val){
         if(head==null){
            System.out.println("List is empty");
            return;
         }
         if(head.data==val){
            deletePosition(1);
            return;
         }
         NodeC temp = head;
         while(temp.next!=head){
            if(temp.next.data==val){
                NodeC del = temp.next;
                temp.next=del.next;
                del.next=null;
                length--;
                return;
            }
            temp=temp.next;
         }
         System.out.println("Node not found");
    }

    void display(){
        if(head==null){
            return;
        }
        System.out.print(head.data+" ");
        NodeC temp=head.next;
        while(temp!=head){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    int listLength(){
        return length;
    }

    void deleteList(){
        head=null;
        length=0;
        
    }

    void search(int val){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.data==val){
            System.out.println("Node found at position 1");
            return;
        }
        int pos=2;
        NodeC temp = head.next;
        while(temp!=head){
            if(temp.data==val){
                System.out.println("Node found at position "+pos);
                return;
            }
            temp=temp.next;
            pos++;
        }
        System.out.println("Node not found");
    }

}

public class CircularLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circular list = new Circular();

        while (true) { 
            System.out.println("\nMenu:");
        System.out.println("1. Add node");
        System.out.println("2. Insertion");
        System.out.println("3. Delete by position");
        System.out.println("4. Delete by value");
        System.out.println("5. Display list");
        System.out.println("6. Length of list");
        System.out.println("7. Delete List");
        System.out.println("8. Searching");
        System.out.println("-1: Exit");

        System.out.print("\nEnter choice: ");
        int ch = sc.nextInt();

        switch(ch){
            case 1: System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    list.addNode(data);
                    break;
            case 2: System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    list.insertion(data, pos);
                    break;
            case 3: System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    list.deletePosition(pos);
                    break;
            case 4: System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    list.deleteValue(val);
                    break;
            case 5: list.display();
                    break;
            case 6: System.out.println("Length: "+list.listLength());
                    break;
            case 7: list.deleteList();
                    break;
            case 8: System.out.print("Enter value: ");
                    val = sc.nextInt();
                    list.search(val);
                    break;
            case -1: sc.close();
                    System.exit(0);
            default: System.out.println("Invalid input");
        }
        } 
    }
}
