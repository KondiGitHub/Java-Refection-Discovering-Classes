import java.lang.reflect.Modifier;

public class Modifiers {
    public static void main(String[] args){
        checkClass(String.class);
    }

    static void checkClass(Class<?> c){
        System.out.println(c);
        int mod = c.getModifiers();

        boolean isPublic = Modifier.isPublic(mod);

        System.out.println("isPublic:: "+ isPublic);

        boolean isFinal = Modifier.isFinal(mod);

        System.out.println("isFinal:: "+ isFinal);


        boolean isAbstract = Modifier.isAbstract(mod);

        System.out.println("isAbstract:: "+ isAbstract);

        boolean isNative = Modifier.isNative(mod);

        System.out.println("isNative:: "+ isNative);

        System.out.println(c.getSimpleName() + "  is  "+ Modifier.toString(c.getModifiers()));
    }
}
