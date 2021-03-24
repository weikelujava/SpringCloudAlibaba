package com.smart.demo.operator;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: OperatorTest
 * @description:
 * @author: lukewei
 * @date: 2021-02-26 17:03
 * @remark: 修改内容
 */
public class OperatorTest {


    /**
     * main方法  程序入口
     * @param args 参数数组
     */
    public static void main(String[] args) {

        // 1.三元运算符的使用
        ternaryOperator(1,2);
        System.out.println("============华丽分割线=============");
        // 2.i++ ++i的运用
        addition(2,2);
        // 3.测试 1/0 和 0/0
        testDivideByZero();
        // 4.测试instanceof运算符
        testInstanceOf();
    }


    /**
     * 三元运算符
     * @param a 整形参数a
     * @param b 整形参数b
     *
     * 控制条输出 结果：a小于b
     */
    private static void ternaryOperator(int a, int b){
        String msg = a > b ? "a大于b":"a小于b";
        System.out.println("结果："+msg);
    }


    /**
     * i++ ++i的区别
     * @param a 参数a
     * @param b 参数b
     *
     * 控制台输出   2
     * 控制台输出   3
     *
     * 总结：
     *     1.赋值顺序不同，++i表示先加后赋值，i++表示先赋值后加；
     *     2.效率不同，++i比i++的效率要高
     *     3.i++不能作为左值，而++i可以
     */
    private static void addition(int a,int b){
        System.out.println(a++);
        System.out.println(++b);
    }


    /**
     * 测试被不同类型的0整除结果
     *  1/0 -1/0 0/0 均输出报异常
     *  1.0/0    输出 Infinity -1.0/0     输出 -Infinity 0.0/0   输出 NaN
     *  1/0.0    输出 Infinity -1/0.0     输出 -Infinity 0/0.0   输出 NaN
     *  1.0/0.0  输出 Infinity -1.0/0.0   输出 -Infinity 0.0/0.0 输出 NaN
     *
     *  结果：当除以0时，除数和被除数都时int类型时会发生异常
     *       当除数或者被除数有一个为float类型或者double类型的时候不会出现异常
     *
     *  其中 NAN(恒持非数字)表示非数字，它与任何值都不相等，甚至不等于它自己
     *  Infinity：无穷大
     */
    private static void testDivideByZero(){
        System.out.println(1.0/0);
        System.out.println(0.0/0.0);

    }


    /**
     * instanceof 是Java中的一个双目运算符，用来测试一个对象是否为一个类的实例
     */
    private static void testInstanceOf(){
        String param = "Hello word";
//        List<String> param = new ArrayList<>(1);
        if( param instanceof String){
            System.out.println("param是String类的实例");
        }else {
            System.out.println("param是"+param.getClass()+"类的实例");
        }
    }
}
