package DiscoveringFields;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

class Thing1 {
    private char c = 'x';
    public int num = 12;
    public final double val =34.5;
    public static String s = "abc";
}
public class ClassFields2 {

    public static void main(String[]args) {
        ArrayList<Field> nonStaticPublicFields = showNonStaticPublicFields(Thing1.class);
        System.out.println(nonStaticPublicFields);
        Point point = new Point();
        for(Field field: showNonStaticPublicFields(point.getClass())){
            System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType().getName()+ " " + field.getDeclaringClass().getName() + " "+ field.getName());
        }


    }

    static ArrayList<Field> showNonStaticPublicFields(Class<?> obj){
        ArrayList<Field> nonStaticPublicFields = new ArrayList<Field>();
        Field[] fields = obj.getFields();
        for(Field field: fields){
            if(!Modifier.isStatic(field.getModifiers())){
                nonStaticPublicFields.add(field);
            }
        }

        return nonStaticPublicFields;

    }
}
