import java.util.Scanner;

class Stack{
    int[] arr;
    int top, capacity;
    
    public Stack(int capacity){
        arr = new int[capacity];
        top = -1;
        this.capacity = capacity;
    }

    public void push(int val){
        if(isFull()){
            System.out.println("Stack overflow");
            return;
        }
        arr[++top] = val;
        System.out.println("The value "+val+" has been pushed in the stack");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return 0;
        }
        return arr[top--];
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return 0;
        }
        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity - 1;
    }

    public void display(){
        int i = top;
        while(i!=-1){
            System.out.println(arr[i--]);
        }
    }
}

public class StackArray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        Stack s = new Stack(n);

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Push element");
            System.out.println("2. Pop element");
            System.out.println("3. Get the top element");
            System.out.println("4. Check if stack is empty");
            System.out.println("5. Check if stack is full");
            System.out.println("6. Display stack");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice (1-7): ");
            int ch = sc.nextInt();

            switch(ch){
                case 1: System.out.print("Enter value: ");
                        int val = sc.nextInt();
                        s.push(val);
                        break;
                case 2: System.out.println("Popped element is "+s.pop());
                        break;
                case 3: System.out.println("Top element is "+s.peek());
                        break;
                case 4: System.out.println(s.isEmpty());
                        break;
                case 5: System.out.println(s.isFull());
                        break;
                case 6: s.display();
                        break;
                case 7: sc.close();
                        System.exit(0);
                default: System.out.println("Invalid input");
            }
        } 
    }
}