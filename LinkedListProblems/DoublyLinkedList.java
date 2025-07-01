
import java.util.Scanner;

class NodeD{
    int data;
    NodeD prev, next;

    public NodeD(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}

class Doubly{
    NodeD head;
    int length=0;

    void addNode(int data){
        NodeD node = new NodeD(data);
        if(head==null){
            head=node;
            length++;
            return;
        }
        NodeD temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        node.prev=temp;
        temp.next=node;
        length++;
    }

    void insertion(int data, int pos){
        NodeD node = new NodeD(data);
        if(pos==1){
            if(head!=null){
                node.next=head;
                head.prev=node;
            }
            head=node;
            length++;
            return;
        }
        NodeD temp = head;
        for(int i=1; i<pos-1 && temp!=null; i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Position out of bounds");
            return;
        }
        node.prev=temp;
        node.next=temp.next;

        if(temp.next!=null){
            temp.next.prev=node;
        }

        temp.next=node;
        length++;
    }

    void deletePosition(int pos){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(pos==1){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
            length--;
            return;
        }
        NodeD temp = head;
        for(int i=1; temp!=null && i<pos; i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Position out of bounds");
            return;
        }
        if(temp.next!=null){
            temp.next.prev=temp.prev;
        }
        if(temp.prev!=null){
            temp.prev.next=temp.next;
        }
        length--;
    }

    void deleteValue(int val){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.data==val){
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
            length--;
            return;
        }
        NodeD temp=head;
        while(temp!=null && temp.data!=val){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Node not found");
            return;
        }
        if(temp.next!=null){
                temp.next.prev=temp.prev;
        }
        if(temp.prev!=null){
            temp.prev.next=temp.next;
        }
        length--;
    }

    void displayForward(){
        NodeD temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    void displayBackward(){
        NodeD temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.prev;
        }
        System.out.println();
    }

    int listLength(){
        return length;
    }

    void deleteList(){
        NodeD temp = head;
        while(temp!=null){
            if(temp.prev!=null){
                temp.prev.next=null;
                temp.prev=null;
            }
            temp=temp.next;
        }
        head=null;
        length=0;
    }

    void search(int val){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        NodeD temp=head;
        int pos=1;
        while(temp!=null){
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

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Doubly list = new Doubly();

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
            case 5: System.out.print("Press f to display forward and b to display backward: ");
                    char c = sc.next().charAt(0);
                    switch(c){
                        case 'f' -> list.displayForward();
                        case 'b' -> list.displayBackward();
                        default -> System.out.println("Invalid input"); 
                    }
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