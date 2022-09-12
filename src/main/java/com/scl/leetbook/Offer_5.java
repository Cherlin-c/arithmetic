package com.scl.leetbook;

/**
 * 替换空格
 *
 * @author : scl
 * @date :  2022/9/12
 */
public class Offer_5 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println("replaceSpace(s) = " + replaceSpace(s));
    }
    /*
    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    示例 1：
    输入：s = "We are happy."
    输出："We%20are%20happy."
    限制：
    0 <= s 的长度 <= 10000
     */

    public static String replaceSpace(String s) {
//        return s.replaceAll(" ", "%20");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}