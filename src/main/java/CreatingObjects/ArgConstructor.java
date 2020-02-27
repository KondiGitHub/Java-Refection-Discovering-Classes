package CreatingObjects;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ArgConstructor {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object[] params = {100,"Chary",false};
        Class<?>[] types = {int.class,String.class, boolean.class };
        //Person com = createObject("CreatingObjects.Person", params, types);
        Person com = createObject("CreatingObjects.Person");
        System.out.println(com.getClass().getName());


    }

    private static <T> T createObject(String s, Object[] params, Class<?>[] types) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> classObj = Class.forName(s);
        Constructor<?> ctr = classObj.getConstructor(types);
        T comp = (T) ctr.newInstance(params);
        return comp;
    }

    private static <T> T createObject(String s) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> classObj = Class.forName(s);
        T comp = (T) classObj.newInstance();
        return comp;
    }
}
