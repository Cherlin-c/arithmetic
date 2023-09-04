package com.scl.interview.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 确定两个字符串是否接近
 *
 * @author : scl
 * @date :  4/9/2023
 */
public class Mid1657 {
    public static void main(String[] args) {
        String a = "cabbba";
        String b = "abbccc";
        System.out.println("closeStrings(a,b) = " + closeStrings2(a, b));
    }
    /*
    如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
    操作 1：交换任意两个 现有 字符。
    例如，abcde -> aecdb
    操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
    例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
    你可以根据需要对任意一个字符串多次使用这两种操作。
    给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。

    示例 1：
    输入：word1 = "abc", word2 = "bca"
    输出：true
    解释：2 次操作从 word1 获得 word2 。
    执行操作 1："abc" -> "acb"
    执行操作 1："acb" -> "bca"
    示例 2：
    输入：word1 = "a", word2 = "aa"
    输出：false
    解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
    示例 3：
    输入：word1 = "cabbba", word2 = "abbccc"
    输出：true
    解释：3 次操作从 word1 获得 word2 。
    执行操作 1："cabbba" -> "caabbb"
    执行操作 2："caabbb" -> "baaccc"
    执行操作 2："baaccc" -> "abbccc"
    示例 4：
    输入：word1 = "cabbba", word2 = "aabbss"
    输出：false
    解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。


    提示：

    1 <= word1.length, word2.length <= 105
    word1 和 word2 仅包含小写英文字母
    */

    public static boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        List<Integer> list1 = map1.values().stream().sorted().collect(Collectors.toList());
        List<Integer> list2 = map2.values().stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;
    }

    public static boolean closeStrings2(String s1, String s2) {
        int[] c1 = new int[26], c2 = new int[26];
        for (char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            c2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (c1[i] + c2[i] == 0) continue;
            if (c1[i] == 0 || c2[i] == 0) return false;
        }
        Arrays.sort(c1); Arrays.sort(c2);
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}