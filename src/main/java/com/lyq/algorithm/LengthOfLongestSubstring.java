package com.lyq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanqiang.liao
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * @createTime 2023-02-28 15:03:00
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int length = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.clear();
            set.add(str.charAt(i));

            for (int j = i + 1; j < str.length(); j++) {
                if (!set.contains(str.charAt(j))) {
                    set.add(str.charAt(j));
                } else {
                    break;
                }
            }

            length = Math.max(length, set.size());
            if (length >= str.length() - i) {
                break;
            }
        }
        return length;
    }
}
