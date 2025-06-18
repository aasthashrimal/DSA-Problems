// Postfix to Prefix conversion

import java.util.Scanner;
import java.util.Stack;

public class Problem7 {

    public static String postfixToPrefix(String s){

        Stack<String> stack = new Stack<>();

        for(char c: s.toCharArray()){

            if(!String.valueOf(c).matches("[+/*\\-]")){
                stack.push(String.valueOf(c));
            }   

            else{
                if(stack.size()<2) return "Invalid expression";

                String b = stack.pop();
                String a = stack.pop();
                stack.push(c+a+b);
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
        System.out.print("Enter the Postfix expression: ");
        String exp = sc.next();
        System.out.println(postfixToPrefix(exp));
        sc.close();
    }
}