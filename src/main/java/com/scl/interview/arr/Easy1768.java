package com.scl.interview.arr;

/**
 * 交替合并字符串
 *
 * @author : scl
 * @date :  26/8/2023
 */
public class Easy1768 {
    public static void main(String[] args) {
        String word1 = "cdf";
        String word2 = "a";
        String result = mergeAlternately(word1, word2);
        System.out.println("mergeAlternately(word1, word2) = " + result);
    }
    /*
    给你两个字符串 word1 和 word2 。
    请你从 word1 开始，通过交替添加字母来合并字符串。
    如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
    返回 合并后的字符串 。

    示例 1：
    输入：word1 = "abc", word2 = "pqr"
    输出："apbqcr"
    解释：字符串合并情况如下所示：
    word1：  a   b   c
    word2：    p   q   r
    合并后：  a p b q c r

    示例 2：
    输入：word1 = "ab", word2 = "pqrs"
    输出："apbqrs"
    解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
    word1：  a   b
    word2：    p   q   r   s
    合并后：  a p b q   r   s

    示例 3：
    输入：word1 = "abcd", word2 = "pq"
    输出："apbqcd"
    解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
    word1：  a   b   c   d
    word2：    p   q
    合并后：  a p b q c   d

    提示：
    1 <= word1.length, word2.length <= 100
    word1 和 word2 由小写英文字母组成
    */

    public static String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int length = length1 - length2;
        if (length > 0) {
            for (int i = 0; i < length2; i++) {
                sb.append(word1.charAt(i)).append(word2.charAt(i));
            }
            sb.append(word1.substring(length2));
        } else {
            for (int i = 0; i < length1; i++) {
                sb.append(word1.charAt(i)).append(word2.charAt(i));
            }
            sb.append(word2.substring(length1));
        }
        return sb.toString();
    }
}