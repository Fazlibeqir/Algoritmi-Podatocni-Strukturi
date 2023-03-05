import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka
        Stack<Integer> numbers=new Stack<Integer>();
        Stack<Character> operators=new Stack<Character>();
        String[] asterix=expression.split("\\+|\\*");
        String[] plus=expression.split("\\d+");
        for (int i=1;i<plus.length;i++){
            numbers.push(Integer.parseInt(asterix[i-1]));
            operators.push(plus[i].charAt(0));
        }
        numbers.push(Integer.parseInt(asterix[asterix.length-1]));
        while (!operators.empty()){
            int number1=numbers.pop();
            int number2=numbers.pop();
            char op= operators.pop();
            if (op=='*'){
                numbers.push(number1*number2);
            }
            else {
                if(operators.empty()){
                    numbers.push(number1+number2);
                    break;
                }
                if(operators.peek()=='+'){
                    numbers.push(number1+number2);
                }
                else {
                    int number3=numbers.pop();
                    operators.pop();
                    numbers.push(number2*number3);
                    numbers.push(number1);
                    operators.push('+');
                }
            }
        }
        return numbers.pop();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}