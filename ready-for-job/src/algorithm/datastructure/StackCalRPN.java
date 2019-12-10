package algorithm.datastructure;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author zhiwen.qi@qiwonder@163.com
 * @version 1.0
 * @ClassName StackCalRPN
 * @description 计算逆波兰表达式(后缀表达式的值)，运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @date 2019/10/9 17:27
 * @since JDK 1.8
 */
public class StackCalRPN {



    /**
     * evalRPN : 计算后缀表达式的值
     *题目中其他表达式是啥意思没懂
     * @author zhiwen.qi@hand-china.com
     * @version 1.0
     * @date 2019/10/9 17:30
     * @param tokens  表达式输入数组
     * @return int
     * @since JDK 1.8
     */
    public int evalRPN(String[] tokens) throws Exception { //todo
        if (tokens == null || tokens.length == 0) {
            throw new Exception("illegal expression");
        }
        Stack stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            if (isInteger(tokens[i])){
                stack.push(tokens[i]);
            }
            if ("+".equals(tokens[i]) || "-".equals(tokens[i]) || "*".equals(tokens[i]) || "/".equals(tokens[i])) {
                int result = (int)stack.pop()*(int)stack.pop();
                stack.push(result);
            }
        }
        return (int)stack.pop();
    }

    private boolean isInteger(String str) {
        if (null == str || "".equals(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
