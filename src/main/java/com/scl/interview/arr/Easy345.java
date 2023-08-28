package com.scl.interview.arr;

/**
 * 反转字符串中的元音字母
 *
 * @author : scl
 * @date :  28/8/2023
 */
public class Easy345 {
    public static void main(String[] args) {
        String s = "AaaUjhgGuo";
        System.out.println("reverseVowels(s) = " + reverseVowels(s));
    }

    /*
    给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
    元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。

    示例 1：
    输入：s = "hello"
    输出："holle"
    示例 2：
    输入：s = "leetcode"
    输出："leotcede"

    提示：
    1 <= s.length <= 3 * 105
    s 由 可打印的 ASCII 字符组成
    */

    public static String reverseVowels(String s) {
        String yy = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int right = chars.length - 1;
        for (int left = 0; left < right; ) {
            if (yy.indexOf(chars[left]) >= 0) {
                if (yy.indexOf(chars[right]) >= 0) {
                    char temp = chars[left];
                    chars[left++] = chars[right];
                    chars[right--] = temp;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return new String(chars);
    }
}