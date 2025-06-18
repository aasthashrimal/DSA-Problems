// Postfix to Infix conversion

import java.util.Scanner;
import java.util.Stack;

public class Problem4 {

    public static String postfixToInfix(String s){

        Stack<String> stack = new Stack<>();

        for(char c: s.toCharArray()){

            if(!String.valueOf(c).matches("[+/*\\-]")){
                stack.push(String.valueOf(c));
            }   

            else{
                if(stack.size()<2) return "Invalid expression";

                String b = stack.pop();
                String a = stack.pop();
                stack.push("("+a+c+b+")");
            }
        }

        if(stack.size()==1){
            return stack.pop();
        } else{
            return "Invalid expression";
        }
    }
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Postfix expression: ");
        String exp = sc.next();
        System.out.println(postfixToInfix(exp));
        sc.close();
    }
}