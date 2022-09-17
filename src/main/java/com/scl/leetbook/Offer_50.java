package com.scl.leetbook;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *
 * @author : scl
 * @date :  2022/9/17
 */
public class Offer_50 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println("firstUniqChar(s) = " + firstUniqChar(s));
    }

    /*
    在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
    示例 1:
    输入：s = "abaccdeff"
    输出：'b'
    示例 2:
    输入：s = ""
    输出：' '
    限制：
    0 <= s 的长度 <= 50000
     */

    public static char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new LinkedHashMap<Character, Boolean>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}