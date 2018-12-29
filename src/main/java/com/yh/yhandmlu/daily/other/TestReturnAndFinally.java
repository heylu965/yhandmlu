package com.yh.yhandmlu.daily.other;

public class TestReturnAndFinally {


    public static void main(String[] arg){
        /**
         *
         try...
         finally block
         b>25, b = 90
         90
         */
        System.out.println(test1());
    }

    /**
     * 说明return语句已经执行了再去执行finally语句，不过并没有直接返回，而是等finally语句执行完了再返回结果。
     * @return
     */
    public static int test1(){
        int b = 10;
        try {
            System.out.println("try...");
            b += 80;
            return b;
        }catch (Exception e){
            System.out.println("catch...");
        }finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }
        return b;
    }


}
