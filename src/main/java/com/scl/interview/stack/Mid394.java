package com.scl.interview.stack;

import java.util.Stack;

/**
 * 字符串解码
 *
 * @author : scl
 * @date :  7/9/2023
 */
public class Mid394 {
    /*
    给定一个经过编码的字符串，返回它解码后的字符串。
    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

    示例 1：
    输入：s = "3[a]2[bc]"
    输出："aaabcbc"
    示例 2：
    输入：s = "3[a2[c]]"
    输出："accaccacc"
    示例 3：
    输入：s = "2[abc]3[cd]ef"
    输出："abcabccdcdcdef"
    示例 4：
    输入：s = "abc3[cd]xyz"
    输出："abccdcdcdxyz"
    提示：

    1 <= s.length <= 30
    s 由小写英文字母、数字和方括号 '[]' 组成
    s 保证是一个 有效 的输入。
    s 中所有整数的取值范围为 [1, 300]
    */

    final static String nums = "0123456789";

    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
//        System.out.println("decodeString(s) = " + decodeString(s));
        char c = '1';
        int k = c - '0';
        int k2 = Character.getNumericValue(c);
        System.out.println("k = " + k);
        System.out.println("k2 = " + k2);
    }


    public static String decodeString2(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int length = s.length();
        int num = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (nums.indexOf(c) >= 0) {
                //数字
                num = 10 * num + Character.getNumericValue(c);
            } else if (c == '[') {
                numStack.add(num);
                strStack.add("[");
                num = 0;
            } else if (c == ']') {
                if (!numStack.isEmpty()) {
                    int popNum = numStack.pop();
                    String popStr = "";
                    String str = "";
                    String pop;
                    do {
                        pop = strStack.pop();
                        popStr = pop + popStr;
                    } while (!"[".equals(pop));
                    popStr = popStr.substring(1);
                    for (int j = 0; j < popNum; j++) {
                        str += popStr;
                    }
                    if (numStack.isEmpty()) {
                        result.append(str);
                    } else {
                        strStack.add(str);
                    }
                }
            } else {
                strStack.add(c + "");
                if (numStack.isEmpty()) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    /**
     * 辅助栈法
     * 本题难点在于括号内嵌套括号，需要从内向外生成与拼接字符串，这与栈的先入后出特性对应
     * 思路：构建辅助栈 stack
     * 1.当 c 为数字时，将数字字符转化为数字 k，用于后续倍数计算
     * 2.当 c 为字母时，在 res 尾部添加 c；
     * k为[]前面的倍数
     **/
    public static String decodeString(String s) {

        int k = 0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> kstack = new Stack<>();
        Stack<StringBuilder> restack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[') {
                //碰到括号，记录K和当前res，归零。
                kstack.push(k);
                restack.push(res);//如果res为空，也会入栈空字符串""
                k = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                //出最近的一个左括号入的k,当前res进行计算不入栈
                int curk = kstack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < curk; i++) {
                    temp.append(res);
                }
                //与括号外合并
                res = restack.pop().append(temp);

            } else if (c >= '0' && c <= '9') {
                k = c - '0' + k * 10;
                //如果k是多位数需要x10
            } else {
                res.append(c);
                //如果是字母则缓慢添加
            }
        }
        return res.toString();
    }
}