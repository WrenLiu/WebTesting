import java.util.*;

/**
 *  中缀变前缀操作
 */
public class HJ54 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        // 中缀变前缀操作
        toPolishNotation(str);

    }






    private static void toPolishNotation(String input) {
        Stack<Character> signal = new Stack<>();
        Stack<Integer> number = new Stack<>();
        Stack<Object> expression = new Stack<>();


        Integer lastIndex = -1;
        Integer num  =0;
        Character c ,tempChar;
        for (int i = input.length() - 1; i >= 0; i--) {

            c = input.charAt(i);
            if (Character.isDigit(c)) {
                lastIndex = readIntegerReverse(input, i);

                num = Integer.parseInt(input.substring(lastIndex,i+1));
                // 将“数”依次压入栈中
                number.push(num);
                i = lastIndex ;
                expression.push((int) num);


            } else if (isOperator(c)) {

                // 通俗来讲，在这一步就是将眼下可以运算的操作全部运算完，只有没有运算符、碰到")"或者运算级别比自己高的情况 才停止
                // (4-1) 如果signal为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
                // (4-2) 否则，若优先级比栈顶运算符的较高或相等，也将运算符压入S1；
                // (4-3) 否则，将S1栈顶的运算符弹出并压入到S2中，再次转到(4-1)与S1中新的栈顶运算符相比较；
                while (!signal.isEmpty() && signal.peek() != ')' && priorityCompare(c,signal.peek()) < 0 ){
                    // 进入这个循环就相当于进行“运算”
                    expression.push(signal.peek());
                    number.push(calc(number.pop(),number.pop(),signal.pop()));
                }
                signal.push(c);



            } else if (c == ')') {
                signal.push(c);
            } else if (c == '(') {

                // 遇到"("意味着有大量的运算可以进行，知道遇到")"停止
                // (5-2) 如果是左括号“(”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到右括号为止，此时将这一对括号丢弃；
                while ((tempChar = signal.pop()) != ')') {
                    expression.push(tempChar);
                    number.push(calc(number.pop(), number.pop(), tempChar));
                    if (signal.isEmpty()) {
                        // 只看到 "(" 没看到 "）"
                        throw new IllegalArgumentException(
                                "bracket dosen't match, missing right bracket ')'.");
                    }
                }


            }else {
                // Do nothing
            }


        }

        // 到这里，输入的字符串已经读完，"(" ")" 操作也全部结束
        while(!signal.isEmpty()){
            tempChar = signal.pop();
            expression.push(tempChar);
            number.push(calc(number.pop(),number.pop(),tempChar));
        }

        System.out.println(number.pop());


    }

    private static  int calc(int left_num ,int right_num ,char oper){
        switch (oper) {
            case '+':
                return left_num + right_num;
            case '-':
                return left_num - right_num;
            case '*':
                return left_num * right_num;
            case '/':
                if(right_num == 0){
                    throw new IllegalArgumentException("divisor can't be 0");
                }
                return left_num /right_num;
            default:
                return 0;
        }
    }

    private static int priorityCompare(char op1 ,char op2){
        switch (op1){
            case '+':
            case '-':
                return (op2 == '*' || op2 == '/' ? -1 : 0);
            case '*':
            case '/':
                return (op2 == '+' || op2 == '-' ? 1 : 0);
        }
        return 1;
    }

    private  static int readIntegerReverse(String input ,int start){
        char c  ;
        for(int i = start ; i>=0; i--){
            c = input.charAt(i);
            if(! Character.isDigit(c)){
                return i +1;
            }
            else if(i==0){
                return 0;
            }
        }
        throw new IllegalArgumentException("not a number.");

    }


    public static boolean isOperator(char c){
        return ( c == '+'||c == '-'||c == '*' || c =='/' );
    }

}
