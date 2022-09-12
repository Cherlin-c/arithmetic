package com.scl.leetbook;

/**
 * 左旋转字符串
 *
 * @author : scl
 * @date :  2022/9/12
 */
public class Offer_58 {
    public static void main(String[] args) {
        String s = "abcdeewfg";
        System.out.println("reverseLeftWords(s,3) = " + reverseLeftWords(s, 8));
    }
    /*
    字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    请定义一个函数实现字符串左旋转操作的功能。
    比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
    示例 1：
    输入: s = "abcdefg", k = 2
    输出:"cdefgab"
    示例 2：
    输入: s = "lrloseumgh", k = 6
    输出:"umghlrlose"
    限制：
    1 <= k < s.length <= 10000
     */

    public static String reverseLeftWords(String s, int n) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(s.substring(n)).append(s, 0, n);
//        return sb.toString();

//        int length = s.length();
//        char[] arr = new char[length];
//        for (int i = 0; i < length; i++) {
//            if (i<n){
//                arr[length-n+i]=s.charAt(i);
//                continue;
//            }
//            arr[i-n]=s.charAt(i);
//        }
//        return String.valueOf(arr);

        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++) {
            //取余
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}