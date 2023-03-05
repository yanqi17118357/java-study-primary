package com.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        BigDecimal i = BigDecimal.valueOf(10);
        i = i.divide(BigDecimal.valueOf(3), 100, RoundingMode.DOWN);
        //计算10/3的结果，精确到小数点后100位
        //RoundingMode是舍入模式，就是精确到最后一位时，该怎么处理，这里CEILING表示向上取整，FLOOR表示向下取整
        System.out.println(i);
    }
}
