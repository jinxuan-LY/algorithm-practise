package com.lyq.algorithm;

/**
 * @author yuanqiang.liao
 * @description 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @createTime 2023-02-27 22:36:00
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] one = new String[]{"flower", "flow", "flight"};
        String[] two = new String[]{"dog", "racecar", "car"};
        System.out.println(horizontal(one));
        System.out.println(horizontal(two));

        System.out.println(vertical(one));
        System.out.println(vertical(two));
    }

    public static String vertical(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }

        String first = array[0];
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < array.length; j++) {
                // 避免数组越界
                if (array[j].length() == i || first.charAt(i) != array[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }


    // 横向
    public static String horizontal(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        String prefix = array[0];
        for (int i = 0; i < array.length; i++) {
            prefix = horizontal(prefix, array[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private static String horizontal(String first, String second) {
        int i = 0;
        for (; i < first.length() && i < second.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                break;
            }
        }
        return first.substring(0, i);
    }
}
