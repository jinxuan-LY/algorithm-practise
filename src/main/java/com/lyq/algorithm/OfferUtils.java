package com.lyq.algorithm;

/**
 * @author yuanqiang.liao
 * @description TODO
 * @createTime 2023-03-06 18:18:00
 */
public class OfferUtils {

    public static void main(String[] args) {
        jincheng(60);
    }
    public  static void jincheng(int total) {
        System.out.println("base: " + (total * 0.75 + 2.16) / 12);
        System.out.println("年终: " + (total * 0.25));
        System.out.println("年终上浮1.2: " + (total * 0.25 * 1.2)
                + "  合计：" + ((total * 0.75 + 2.16) + total * 0.25 * 1.2));
        System.out.println("公积金（增量）："+ (total * 0.75 + 2.16) * 0.02);
    }
}
