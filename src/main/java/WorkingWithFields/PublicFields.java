package WorkingWithFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class Act {
    private int num;
    public Act(int num) {
        this.num = num;
    }

    public String getBrothers() {
        return brothers;
    }

    public String getGroup() {
        return group;
    }

    private String brothers = "Groucho Chico Harpo";
    private String group = "Bill BRUCE JIM";
    public final String guy = "Bob";
}
public class PublicFields {
    public static void main(String[] str) {
        try {
            Act act = new Act(3);
            //modifyPublicFields(act);
            modifyPrivateFields(act);
            System.out.println(act.getBrothers());
            System.out.println(act.getGroup());
            System.out.println(act.guy);

        } catch(Exception e){
            e.printStackTrace(System.err);
        }
    }

    static <T> void modifyPublicFields(T obj) throws IllegalAccessException {
        Class<?> c = obj.getClass();
        Field[] fields = c.getFields();
        for(Field field: fields){
            System.out.println("HELLO::"+field.getName());
            if(!Modifier.isFinal(field.getModifiers()) && field.getType() == String.class){
                String str = (String) field.get(obj);
                field.set(obj, str.toLowerCase());
            }
        }
    }

    static <T> void modifyPrivateFields(T obj) throws IllegalAccessException {
        Class<?> c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for(Field field: fields){
            System.out.println("HELLO::"+field.getName());
            if(!Modifier.isFinal(field.getModifiers()) && field.getType() == String.class){
                field.setAccessible(true);
                String str = (String) field.get(obj);
                field.set(obj, str.toLowerCase());
            }
        }
    }
}
