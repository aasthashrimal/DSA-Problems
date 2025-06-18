//Infix to Prefix

import java.util.Scanner;

public class Problem8 {

    public static String reverse(String exp){
        StringBuilder sb = new StringBuilder(exp);
        exp=sb.reverse().toString();
        StringBuilder s = new StringBuilder();
        for(char c: exp.toCharArray()){
            switch (c) {
                case '(' -> s.append(')');
                case '[' -> s.append(']');
                case '{' -> s.append('}');
                case ')' -> s.append('(');
                case ']' -> s.append('[');
                case '}' -> s.append('{');
                default -> s.append(c);
            }
        }
        return s.toString();
    }

    public static String infixToPrefix(String s){
        s=reverse(s);
        s=Problem3.infixToPostfix(s);
        return reverse(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String exp = sc.next();
        System.out.println(infixToPrefix(exp));
        sc.close();
    }
}