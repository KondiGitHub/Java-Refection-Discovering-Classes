package DiscoveringInterfaces;

import javax.naming.directory.Attributes;

public class Interfaces {
    public static void main(String[] args){
        //showInterfaceName(String.class);
        showInterfaceName(Attributes.class);
    }
    static void showInterfaceName(Class<?> c){
        Class<?>[] interfaces = c.getInterfaces();
        for(Class<?> intf: interfaces){
            System.out.println(intf.getName());
        }
    }
}
