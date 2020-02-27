package DiscoveringConstructors;


import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.net.ServerSocket;

class Thing {
    public Thing() {};
    public Thing(boolean flag) {};
    public Thing(String s, int i){};
    public Thing(int i) throws IOException {};
    protected Thing(float f) {}
    private Thing(char c){}



}
public class Constructors1 {
    public static void main(String[] args)  {

        try {
            //showPublicConstructor(Thing.class);
           // showAnyConstructor(Thing.class);
           // showAllConstructors(Thing.class);
            //showPublicConstructors(Thing.class);
            showPublicConstructorsWithFull(ServerSocket.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(System.err);
        }

    }
    static void showPublicConstructor(Class<?> obj) throws NoSuchMethodException {
        System.out.println(" \n\nPublic constructor for  "+ obj.getName());
        Constructor<?> ctr1 = obj.getConstructor();
        System.out.println(ctr1);
        Constructor<?> ctr2 = obj.getConstructor(String.class, int.class);
        System.out.println(ctr2);

    }

    static void showAnyConstructor(Class<?> obj) throws NoSuchMethodException {
        System.out.println("\n\nAny  constructor for  "+ obj.getName());
        Constructor<?> ctr1 = obj.getDeclaredConstructor(float.class);
        System.out.println(ctr1);
    }

    static void showPublicConstructors(Class<?> obj) throws NoSuchMethodException {
        System.out.println("\n\nPublic  constructors for  "+ obj.getName());
        Constructor<?>[] ctrs = obj.getConstructors();
        for(Constructor<?> ctr : ctrs)
           System.out.println(ctr);
    }

    static void showAllConstructors(Class<?> obj) throws NoSuchMethodException {
        System.out.println("\n\nAll  constructors for  "+ obj.getName());
        Constructor<?>[] ctrs = obj.getDeclaredConstructors();
        for(Constructor<?> ctr : ctrs)
            System.out.println(ctr);
    }

    static void showPublicConstructorsWithFull(Class<?> obj) throws NoSuchMethodException {
        System.out.println("\n\nPublic detail  constructors for  "+ obj.getName());
        Constructor<?>[] ctrs = obj.getConstructors();
        for(Constructor<?> ctr : ctrs){
            System.out.format("%s ", Modifier.toString(ctr.getModifiers()));

            System.out.format(ctr.getDeclaringClass().getName());

            //System.out.println("\n\n 1");
            System.out.format("( ");
            Class<?>[] pTypes = ctr.getParameterTypes();
            for(Class<?> param: pTypes){
                System.out.format("%s ",param.getName());
            }
            System.out.format(" )");
            //System.out.println("\n\n 2");
            Class<?>[] exTypes = ctr.getExceptionTypes();
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
