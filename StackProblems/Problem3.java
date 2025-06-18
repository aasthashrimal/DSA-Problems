// Infix to Postfix Conversion

import java.util.Scanner;
import java.util.Stack;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Infix Expression: ");
        String exp = sc.next();
        System.out.println(infixToPostfix(exp));
        sc.close();
    }

    public static int prec(char c){          // To check the precedence of operator
        return switch (c) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            case '(', '[', '{' -> -1;
            default -> 0;
        };
    }

    public static String infixToPostfix(String s){

        if(!Problem1.checkParentheses(s)){
            return "Invalid expression";                // returns invalid if parenthesis are wrongly ordered
        }

        StringBuilder sb = new StringBuilder();        // sb will be used to store the Postfix expression
        Stack<Character> stack = new Stack<>();        // stack will be used to push and pop the operators

        for(char c: s.toCharArray()){                  

            if(!String.valueOf(c).matches("[+\\-*/()^{}\\[\\]]")){           // to check if the character is an operator or operand
                sb.append(c);
            }

            else{
                if(prec(c)==0){                    // case for closing brackets

                    char b = ' ';

                    switch(c){
                        case ']' -> b = '[';
                        case '}' -> b = '{';
                        case ')' -> b = '(';
                    }  
                    
                    while(stack.peek()!=b){
                        sb.append(stack.pop());          // appends the operators to expression until bracket is encountered
                    }
                    
                    stack.pop();                        // pops out the opening bracket
                } 
                
                else if(stack.isEmpty() || prec(c)>prec(stack.peek()) || prec(c)<0){    // pushes the element in stack if priority is higher
                    stack.push(c);
                } 
                
                else{
                    while(!stack.isEmpty() && (prec(c)<prec(stack.peek()) ||         // until precedence of c is higher
                        (prec(c) == prec(stack.peek()) && c != '^'))){                 // right associativity of ^
                        
                            sb.append(stack.pop());             // pops out the element from stack and adds to expression 
                    }     
                    stack.push(c);                       
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());                    // adds the remining elements from stack to the expression
        }

        return sb.toString();                         // converts sb to string data type and returns final postfix expression
    }   
}