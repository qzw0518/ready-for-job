package algorithm.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhiwen.qi
 * @description 求包含+，-，*，/，(，)，以及整数，求表达式的值。可能输入非有效字符，需要自行判断
 * 例子：字符串1+2*3-(2*5-2)/2，表达式计算值为3
 * 思路：先转换为后缀表达式，再根据后缀表达式求值。
 * 例子转为为后缀表达式为123*+25*2-2/-
 * @date 2020/2/13 20:52
 */
public class SimpleExpressionValue {

    public static void main(String[] args) {
//        System.out.println(calBackExpression("123*+25*2-2/-"));
        String in = "1+2*3-(2*5-2)/2";
        String back = transferToBack(in);
        System.out.println(back);
        System.out.println(calBackExpression(back));
    }

    /**
     * 计算后缀表达式的值
     * @param expression 表达式
     * @return 表达式计算后的结果
     */
    public static int calBackExpression(String expression) {
        if (expression == null || expression.length() == 0) {
            throw new RuntimeException("null or empty expression!");
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            String e = expression.charAt(i) + "";
            if (e.matches("[0-9]*")) {  //为数字的情况(Integer.valueOf()会处理类似0012这种情况)直接入栈
                stack.push(e);
            }else if (e.matches("[\\+\\-\\*\\/]")) {    //为四则运算符号将数出栈并将计算后的结果入栈
                String n2 = stack.pop();
                String n1 = stack.pop();
                //
                int res = calValue(n1, n2, e);
                stack.push(res + "");
            }
        }
        return Integer.valueOf(stack.pop());
    }

    /**
     * 根据运算符计算结果
     * @param n1 次顶元素
     * @param n2 顶元素
     * @param operator 运算符
     * @return 计算结果
     */
    private static int calValue(String n1, String n2, String operator) {
        switch (operator) {
            case "+":
                return Integer.valueOf(n1) + Integer.valueOf(n2);
            case "-":
                return Integer.valueOf(n1) - Integer.valueOf(n2);
            case "*":
                return Integer.valueOf(n1) * Integer.valueOf(n2);
            case "/":
                return Integer.valueOf(n1) / Integer.valueOf(n2);
            default:
                throw new RuntimeException("无该类型运算符!");
        }
    }

    /**
     * 中缀表达式转换成后缀表达式
     * @param inExpression
     * @return
     */
    public static String transferToBack(String inExpression) {
        //栈用来处理运算符和括号
        Stack<String> stack = new Stack<>();
        //队列用于存储后缀表达式每个元素
        List<String> list = new ArrayList<>();
        for (int i = 0; i < inExpression.length(); i++) {
            String e = inExpression.charAt(i) + "";
            if (e.matches("[0-9]*")) {
                list.add(e);
            }else if (e.matches("[\\+\\-\\*\\/]")) {
                if (!stack.isEmpty()) {  //当栈不为空时
                    //将优先级大于或等于当前运算符的元素出栈入列
                    while (!stack.isEmpty() && !"(".equals(stack.lastElement()) && !comparePriority(e, stack.lastElement())) {
                        list.add(stack.pop());
                    }
                }
                //处理完后推入元素
                stack.push(e);
            }else if ("(".equals(e)) {
                stack.push(e);
            }
            else if (")".equals(e)) {
                //遇到右括号，则找上一个左括号。然后把中间的运算符全部放入队列中
                while (!"(".equals(stack.lastElement())) {
                    list.add(stack.pop());
                }
                //循环结束后，栈顶元素必定为"("
                stack.pop();
            }
        }
        //剩余元素加入到队列中
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        StringBuffer bf = new StringBuffer();
        for (String s : list) {
            bf.append(s);
        }
        return bf.toString();
    }

    private static boolean comparePriority(String o1, String o2) {
        return getPriority(o1) > getPriority(o2);
    }

    private static int getPriority(String str) {
        switch (str) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                throw new RuntimeException("没有该类型的运算符！");
        }
    }

}
