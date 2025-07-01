import java.util.Scanner;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data=data;
        this.next=null;
    }
}

class QueueLinked{
    Node front, rear;

    public QueueLinked(){
        front=rear=null;
    }

    public void enqueue(int data){
        if(front==null){
            front = rear = new Node(data);
        }else{
            rear.next = new Node(data);
            rear=rear.next;
        }
        System.out.println("Element has been added");
    }

    public void dequeue(){
        if(front==null){
            System.out.println("Queue underflow");
            return;
        }
        front = front.next;

        if(front==null){
            rear = null;
        }

        System.out.println("Element has been dequeued");
    }

    public void display(){
        if(front==null){
            System.out.println("Queue is empty");
            return;
        }

        Node temp = front;
        while(temp!=rear.next){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

public class SimpleLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueLinked queue = new QueueLinked();
        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Insert a number");
            System.out.println("2. Delete a number");
            System.out.println("3. Display queue");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            int ch = sc.nextInt();

            switch(ch){
                case 1: System.out.print("Enter the number: ");
                        int n = sc.nextInt();
                        queue.enqueue(n);
                        break;
                case 2: queue.dequeue();    break;
                case 3: queue.display();    break;
                case 4: sc.close();
                        System.exit(0);
                default: System.out.println("Invalid choice");
            }
        }
    }
}