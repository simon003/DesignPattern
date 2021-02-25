package com.pattern.agent.statical;

public class StaticProxyTest {
    public static void main(String[] args) {
        CustomerProxy customerProxy = new CustomerProxy(new Man());
        customerProxy.say();
    }
}
