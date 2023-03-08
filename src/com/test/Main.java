package com.test;

import com.test.entity.Study;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Study study = main::lbwnb;   //成员方法因为需要具体对象使用，所以说只能使用 对象::方法名 的形式
        System.out.println(study.lbwnb());
    }

    public String lbwnb(){
        return "卡布奇诺今犹在，不见当年倒茶人。";
    }
}

