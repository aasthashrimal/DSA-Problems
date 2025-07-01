class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class StackL{
    Node head;

    public StackL(){
        this.head = null;
    }

    boolean isEmpty(){
        return head==null;
    }

    void push(int data){
        Node node = new Node(data);
        node.next = head;
        head=node;
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return 0;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return head.data;
    }

    int peek(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return 0;
        }
        return head.data;
    }

    int search(int val){
        Node temp = head;
        int pos=1;
        while(temp!=null){
            if(temp.data==val){
                return pos;
            }
            pos++;
            temp=temp.next;
        }
        return -1;
    }
}

public class StackLinked {
    public static void main(String[] args) {
        StackL st = new StackL();

        // Push elements onto the stack
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);
        System.out.println(st.search(22));

        // Print top element of the stack
        System.out.println("Top element is " + st.peek());

        // removing two elemements from the top
  		System.out.println("Removing two elements...");
        st.pop();
        st.pop();
        System.out.println(st.search(44));
        // Print top element of the stack
        System.out.println("Top element is " + st.peek());
    }
}