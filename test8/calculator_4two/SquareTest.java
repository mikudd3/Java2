package com.lanqiao.javalearn.java2.test8.calculator_4two;

/**
 * @project:
 * @author: mikudd3
 * @version: 1.0
 */

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//要为这个测试指定一个运行机，因为特殊的功能要用特殊运行机
@RunWith(Parameterized.class)
//为参数化测试专门生成一个新的类，不能与其他测试共用同一个类
public class SquareTest {
    Calculator calc;
    private int param;
    private int result;

    //构造函数，其功能是对先前定义的两个参数进行初始化
    public SquareTest(int param, int result) {
        this.param = param;
        this.result = result;
    }

    /*
    定义测试数据集合，使用@Parameters 注解标注。
    该方法会在执行单元测试时自动执行。在返回值中，最内层一维数组的第 0 个元素
    会传给构造方法的第 0 个参数，第 1 个元素会传给构造方法的第一个参数。例如以下程序，
    {2,4}中的“2”会传给构造方法的 param 参数，“4”会传给构造方法的 result 参数。
    运行机会反复利用数组中的数据实例化本类，并在实例上运行测试方法。
    */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{2, 4}, {0, 0}, {-3, 9}});
    }

    @Before
    public void setUp() throws Exception {
        // 创建 Calculator 对象
        calc = new Calculator();
        System.out.println("测试前初始值置零！");
        calc.clear();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试后...");
        calc = null;
    }

    @Test
    public void square() {
        calc.square(param);
        assertEquals(result, calc.getResult());
    }
}