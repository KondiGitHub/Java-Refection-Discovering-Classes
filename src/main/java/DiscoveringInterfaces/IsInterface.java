package DiscoveringInterfaces;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class IsInterface {
    public static void main(String[] args){
        Class<?>[] names = { RowSet.class, RowSetEvent.class, RandomAccess.class, RandomAccessFile.class};
        showInterfacesClasses(names);
    }

    static void showInterfacesClasses(Class<?>[] names){
        for(Class<?> name: names){
            if (name.isInterface()){
                System.out.println(name.getName() + "  is an interface");
            } else {
                System.out.println(name.getName() + "  is a class");
            }
        }
    }
}
