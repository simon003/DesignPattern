package com.pattern.agent.statical;

public class CustomerProxy implements Customer{
    private Customer customer;

    public CustomerProxy(Customer customer){
        this.customer = customer;
    }

    @Override
    public void say() {
        customer.say();
        System.out.println("I am a proxy. I deal the rest");
    }
}
