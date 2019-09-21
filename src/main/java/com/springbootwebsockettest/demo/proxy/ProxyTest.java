package com.springbootwebsockettest.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {


    public static void main(String[] args) {


        Object proixd =Proxy.newProxyInstance(ProxyTest.class.getClass().getClassLoader(),new Class[]{ User.class}, new MyInvocationHandler());

    }



    private static class MyInvocationHandler implements InvocationHandler {

        private Object targetObject;
        //绑定关系，也就是关联到哪个接口（与具体的实现类绑定）的哪些方法将被调用时，执行invoke方法。
        public MyInvocationHandler(Object targetObject){
            this.targetObject = targetObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("say")){
                System.out.println("haha 被代理了很爽");
                System.out.println("122");
                System.out.println("0gt");
            }
            return null;
        }
    }


}
