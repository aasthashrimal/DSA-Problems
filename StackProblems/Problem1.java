import java.util.Scanner;
import java.util.Stack;

class Brackets{
    public static char getOpen(char ch){
        return switch (ch) {
            case ']' -> '[';
            case '}' -> '{';
            case ')' -> '(';
            default -> ' ';
        };
    }
}

public class Problem1 {

    public static Boolean checkParentheses(String s){

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==']' || s.charAt(i)=='}' || s.charAt(i)==')'){
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.pop()!=Brackets.getOpen(s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the expression: ");
        String exp = sc.next();

        if(checkParentheses(exp)){
            System.out.println("The given expression is balanced");
        } else{
            System.out.println("The given expression is not balanced");
        }

        sc.close();
    }
}