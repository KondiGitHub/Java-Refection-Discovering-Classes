package DiscoveringFields;

import java.lang.reflect.Field;

class Thing {
    private boolean flag;
    protected float f;
    public char c;
}

class MyThing extends Thing {
    private int num;
    protected String str;
    public double val;
}

public class ClassFields {

    public static void main(String[] args) {
        try {
              showPublicField(MyThing.class);
              showAnyField(Thing.class);
              showPublicFields(MyThing.class);
              showAllFields(Thing.class);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    static void showPublicFields(Class<?> c){
        System.out.println("Show public fields for  :: "+c.getSimpleName());
        Field[] fields = c.getFields();
        for(Field field: fields){
            System.out.println(field.getName());
        }
    }

    static void showAllFields(Class<?> c){
        System.out.println("All fields for only class :: "+c.getSimpleName());
        Field[] fields = c.getDeclaredFields();
        for(Field field: fields){
            System.out.println(field.getName());
        }
    }

    static void showPublicField(Class<?> c) throws NoSuchFieldException {
        System.out.println("Public Fields for class:: "+c.getSimpleName());
        Field field = c.getField("val");
        System.out.println(field);

        field = c.getField("c");
        System.out.println(field);
    }

    static void showAnyField(Class<?> c) throws NoSuchFieldException {
        System.out.println("Any  Fields for only class:: "+c.getSimpleName());
        Field field = c.getDeclaredField("f");
        System.out.println(field);
    }
}
