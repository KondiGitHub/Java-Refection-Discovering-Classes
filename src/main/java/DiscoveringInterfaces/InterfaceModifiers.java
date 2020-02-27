package DiscoveringInterfaces;

import java.lang.reflect.Modifier;

public class InterfaceModifiers {
    public static void main(String[] args){
        checkInterfaces(Cloneable.class);
    }

    static void checkInterfaces(Class<?>c){
        System.out.println(c.getName() + " is "+ Modifier.toString(c.getModifiers()));
    }
}
