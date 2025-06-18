//Evaluation of postfix expression with single digit numbers

import java.util.Scanner;
import java.util.Stack;

public class Problem2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        System.out.print("Enter the postfix expression: ");
        char[] exp = sc.next().toCharArray();                // String array can be used for more than one digit integers

        int res = 0;
        for(char c : exp){

           if(Character.isDigit(c)) {                          // For string array check s.matches(-?\\d+)
                int i = Integer.parseInt(String.valueOf(c));    // Integer.parseInt(s) for string        
                stack.push(i);
            } 
            
            else {
                if(stack.size()<2){
                    System.out.println("Invalid expression");
                    sc.close(); System.exit(0);
                }

                int a = stack.pop(); 
                int b = stack.pop();

                switch(c){
                    case '+' -> res = b+a;
                    case '-' -> res = b-a;
                    case '*' -> res = b*a;
                    case '/' -> { 
                        if(a==0) {
                        System.out.println("Divison by zero error"); 
                        sc.close();
                        System.exit(0);
                        }

                        res = b/a;
                    }

                    default -> System.out.println("Invalud character in expression");
                }
            }
        }

        if(stack.size()==1){
            System.out.println("Result of the given postfix expression is "+res);
        } else{
            System.out.println("Invalid expression");
        }
    }
}