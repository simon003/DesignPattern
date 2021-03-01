package com.pattern.agent.dynamic.jdk;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    /**
     * jdk动态代理会生成一个动态代理类，生成相应的字节码，然后通过ClassLoader加载字节码；
     *
     * 该实例继承了Proxy类，并实现了业务接口，在实现的方法里通过反射调用了InvocationHandler接口实现类的invoke()回调方法；
     *
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
         UserService userService = new  UserServiceImpl();
         ServiceInvocationHandler handler = new  ServiceInvocationHandler(userService);

        // 根据目标生成代理对象
         UserService proxy = ( UserService) handler.getProxy();
        proxy.addUser();

        createProxyClassFile();
    }

    private static void createProxyClassFile(){
        String name = "ProxyUserService";
        byte[] data = ProxyGenerator.generateProxyClass(name,new Class[]{ UserService.class});
        FileOutputStream out =null;
        try {
            out = new FileOutputStream(name+".class");
            System.out.println((new File("hello")).getAbsolutePath());
            out.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=out) try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
