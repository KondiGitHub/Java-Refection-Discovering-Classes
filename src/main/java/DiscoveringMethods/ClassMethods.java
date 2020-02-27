package DiscoveringMethods;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Thing{
    private double data;
    private void add(double v) {}
    protected void sub(int s) {}
    public double getData() throws IOException { return data;}
}

class MyThing extends Thing {
    private String name;
    private void mult(int val) {
    }
    protected void div(double v){}
    public String getName() {return name;}
}

public class ClassMethods {

    public static void main(String[] args){

        try {
            //showPublicMethod(MyThing.class);
            //showAnyMethod(MyThing.class);
            //showAllMethods(MyThing.class);
           // showPublicMethods(MyThing.class);
            showPublicMethodsInDetail(MyThing.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(System.err);
        }

    }

    static void showPublicMethod(Class<?>c) throws NoSuchMethodException {
        System.out.println(" showing public method for ::"+ c.getName());
        Method method1 = c.getMethod("getName");
        System.out.println(method1);

        Method method2 = c.getMethod("getData");
        System.out.println(method2);
    }

    static void showPublicMethods(Class<?>c) throws NoSuchMethodException {
        System.out.println(" showing public method for ::"+ c.getName());
        Method[] methods = c.getMethods();
        for(Method method: methods){
            System.out.println(method);
        }
    }

    static void showAnyMethod(Class<?>c) throws NoSuchMethodException {
        System.out.println(" showing public method for ::"+ c.getName());
        Method method1 = c.getDeclaredMethod("div",double.class);
        System.out.println(method1);

        Method method2 = c.getDeclaredMethod("mult",int.class);
        System.out.println(method2);
    }

    static void showAllMethods(Class<?>c) throws NoSuchMethodException {
        System.out.println(" showing public method for ::"+ c.getName());
        Method[] methods = c.getDeclaredMethods();
        for(Method method: methods){
            System.out.println(method);
        }
    }

    static void showPublicMethodsInDetail(Class<?> obj) throws NoSuchMethodException {
        System.out.println("\n\nPublic detail  methods for  "+ obj.getName());
        Method[] methods = obj.getMethods();
        for(Method method : methods){
            System.out.format("%s ", Modifier.toString(method.getModifiers()));

            String returnType = method.getReturnType().getName();
            System.out.format("%s, %s(", returnType, method.getName());

            Class<?>[] pTypes = method.getParameterTypes();
            for(Class<?> param: pTypes){
                System.out.format("%s ",param.getName());
            }
            System.out.format(" )");
            //System.out.println("\n\n 2");
            Class<?>[] exTypes = method.getExceptionTypes();
            if(exTypes.length >0 ){
                System.out.format(" throws ");
            }
            for(Class<?> ex: exTypes){
                System.out.format("%s ",ex.getName());
            }
            System.out.println();

        }

    }
}
