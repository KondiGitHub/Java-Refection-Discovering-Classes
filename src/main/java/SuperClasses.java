import javax.swing.*;

public class SuperClasses {
    public static void main(String[] args){
        showHierarchy(JTextField.class);
    }

    static void showHierarchy(Class<?> c){
        if(c.getSuperclass() == null) {
            System.out.println(c.getName());
            return;
        }
        showHierarchy(c.getSuperclass());
        System.out.println(c.getName());
    }
}
