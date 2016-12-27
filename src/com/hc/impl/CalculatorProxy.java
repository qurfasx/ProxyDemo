package com.hc.impl;

import com.hc.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Administrator on 2016/12/5.
 */
public class CalculatorProxy {

        private Calculator calculator;

        public CalculatorProxy(Calculator calculator) {
            this.calculator = calculator;
        }

        public Calculator getCalculator() {
            Calculator proxy = null;
            //执行代理对象的每个方法时都会执行InvocationHandler对象的invoke()方法
            InvocationHandler handler = new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    int res = 0;
                    System.out.println("前置通知");
                    res = (int) method.invoke(calculator, args);
                    System.out.println("后置通知");

                    return res;
                }
            };
            //代理对象由哪一个类加载器负责加载
            ClassLoader loader = calculator.getClass().getClassLoader();
            //代理对象的类型
            Class<Calculator>[] interfaces = new Class[]{Calculator.class};
            proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, handler); //动态创建目标类的代理对象
            return proxy;
        }


}






