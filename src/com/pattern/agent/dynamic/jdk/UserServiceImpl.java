package com.pattern.agent.dynamic.jdk;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("增加一个用户。。。");
    }

    @Override
    public void editUser() {
        System.out.println("编辑一个用户。。。");
    }

}
