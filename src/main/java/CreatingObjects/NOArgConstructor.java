package CreatingObjects;

import javax.swing.*;

public class NOArgConstructor {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        JButton com= createObject("javax.swing.JButton");
        System.out.println(com.getClass().getName());
    }

    static <T> T createObject(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class<?> aClass = Class.forName(className);
        return (T) aClass.newInstance();

    }
}
