import java.util.Scanner;

class QueueArray{
    int size, rear, front;
    int[] arr;

    public QueueArray(int capacity){
        this.arr = new int[capacity];
        rear=front=-1;
        size=0;
    }

    public void enqueue(int n){
        if(rear==arr.length-1){
            System.out.println("Queue Overflow");
            return;
        }
        if(size==0){
            front = 0;
        }
        arr[++rear] = n;
        size++;
        System.out.println("Element has been added to the queue");
    }

    public void dequeue(){
        if(size==0){
            System.out.println("Queue Underflow");
            return;
        }
        arr[front++]=-1;
        size--;
        System.out.println("Element has been dequeued");
        if(size==0){
            front=rear=-1;
        }
    }

    public void display(){
        if(size==0){
            System.out.println("Queue is empty");
            return;
        }
        for(int i=front; i<=rear; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class SimpleArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the capacity of the queue: ");
        int cap = sc.nextInt();
        QueueArray queue = new QueueArray(cap);
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