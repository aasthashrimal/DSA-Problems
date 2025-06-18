// Prefix to Infix

import java.util.Scanner;
import java.util.Stack;

public class Problem5 {

    public static String prefixToInfix(String s){
        
        Stack<String> stack = new Stack<>();
        
        for(int i=s.length()-1; i>=0; i--){

            String c = String.valueOf(s.charAt(i));

            if("+-*/".contains(c)){

                if(stack.size()<2){
                    return "Invalid Expression";
                }

                String a = stack.pop();
                String b = stack.pop();

                stack.push("("+a+c+b+")");

            } 
            
            else{
                stack.push(c);
            }
        }

        if(stack.size()==1){
             return stack.pop();
        } else{
            return "Invalid expression";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Prefix Expression: ");
        String exp = sc.next();
        System.out.println(prefixToInfix(exp));
        sc.close();
    }
}