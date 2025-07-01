
import java.util.Scanner;

//The class Node contains the two attributes of a node(element) i.e data and pointer to next node
//This is used to create the nodes
class Node{

    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }

    //We can have getter setter methods for both the parameters if required
}


//This class consists of all operations on a singly linked list
class LinkedList{

    Node head;
    int length=0;

    //1. Traversing the Linked List 

    //This function displays all the nodes in the list
    public void displayList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* 2. Singly Linked List Insertion 
          -> Insertion at beginning of list
          -> Insertion at end of the list
          -> Insertion at a random position 
          */

    void addNode(int data){
        Node node = new Node(data);
        node.next=null;
        if(head==null){
            head=node;
            length++;
            return;
        }

        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        length++;
    } 

    void insertPosition(int data, int pos){
        Node node = new Node(data);
        if(pos==1){
            node.next=head;
            head=node;
            length++;
            return;
        }
        Node temp = head;
        for(int i=1; i<pos-1 && temp!=null; i++){
            temp=temp.next;
        }

        if(temp==null){
            System.out.println("Position out of bounds");
            return;
        }

        node.next=temp.next;
        temp.next=node;
        length++;
    }

    //3. Displaying length of the list
    public int listLength(){
        return length;
    }

    /*4. Deleting a node
        -> Deleting the first node
        -> Deleting the last node
        -> Deleting an intermediate node
        */


    public void deletePosition(int pos){
        if(pos<=0 || head==null){
            System.out.println("List is empty or invalid position");
            return;
        }
        if(pos==1){
            Node del=head;
            head=head.next;
            del.next=null;
            length--;
            return;
        }
        Node temp = head;
        for(int i=1; i<pos-1 && temp.next!=null; i++){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Position out of bounds");
            return;
        }
        Node del=temp.next;
        temp.next=del.next;
        del.next=null;
        length--;
    }

    //5. Delete by value
    public void deleteValue(int val){
        if(head.data==val){
            Node del=head;
            head=head.next;
            del.next=null;
            length--;
            return;
        }
        Node temp=head;
        while(temp.next!=null && temp.next.data!=val){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Node not found!");
            return;
        }
        Node del=temp.next;
        temp.next=temp.next.next;
        del.next=null;
        length--;
    }

    //6. Delete entire list
    public void deleteList(){
        Node temp=head;
        while(temp!=null){
            Node current = temp;
            temp=temp.next;
            current.next=null;
        }
        head=null;
        length=0;
    }   
    
    //7. To search for an element
    public void search(int val){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        int pos=1;
        while(temp!=null && temp.data!=val){
            temp=temp.next;
            pos++;
        }
        if(temp==null){
            System.out.println("Node not found!");
            return;
        }
        System.out.println("Node found at position "+pos);
    }
}    

//This is the main class to create obejects of linked lists and use the methods
public class SinglyLinkedList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Add node");
            System.out.println("2. Delete at position");
            System.out.println("3. Display List");
            System.out.println("4. Length of list");
            System.out.println("5. Insertion");
            System.out.println("6. Delete by value");
            System.out.println("7. Delete list");
            System.out.println("8. Searching");
            System.out.println("-1: Exit");

            System.out.print("\nEnter choice: ");
            int ch = sc.nextInt();

            switch(ch){
                case 1: System.out.print("Enter data: ");
                        int data = sc.nextInt();
                        list.addNode(data);
                        break;
                case 2: System.out.print("Enter position: ");
                        int p = sc.nextInt();
                        list.deletePosition(p);
                        break;
                case 3: list.displayList();
                        break;
                case 4: System.out.println("Length: "+list.listLength());
                        break;
                case 5: System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        System.out.print("Enter data: ");
                        data = sc.nextInt();
                        list.insertPosition(data, pos);
                        break;
                case 6: System.out.print("Enter value: ");
                        int val = sc.nextInt();
                        list.deleteValue(val);
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