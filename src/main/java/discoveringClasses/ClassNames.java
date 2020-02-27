package discoveringClasses;

import java.util.Date;

public class ClassNames {
    public static void main(String[] args){
        Date date = new Date();
        Class<?> c1 = date.getClass();
        System.out.println(c1.getName());

        Class<?> c2 = String.class;
        System.out.println(c2.getSimpleName());
    }
}
