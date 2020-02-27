package DiscoveringMethods;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;

public class GettersSetters {
    public static void main(String[] args){

        Collection<Method> methods = retrieveAllGettersAndSetters(Person.class);
        for(Method method : methods){
            System.out.println(method);
        }
    }

    private static Collection<Method> retrieveAllGettersAndSetters(Class<Person> personClass) {
        ArrayList<Method> getterSetterMethodsList = new ArrayList<Method>();
        Method[] methods = personClass.getDeclaredMethods();
        for(Method method: methods){
            if(isGetter(method) || isSetter(method)){
                getterSetterMethodsList.add(method);
            }
        }

        return getterSetterMethodsList;
    }

    static boolean isGetter(Method method){
        if(Modifier.isPublic(method.getModifiers() ) && (!method.getReturnType().equals(void.class))
          && method.getName().matches("^get[A-z].*")
          && method.getParameterTypes().length == 0){
            return true;
        }
        if(Modifier.isPublic(method.getModifiers() ) && (method.getReturnType().equals(boolean.class))
                && method.getName().matches("^is[A-z].*")
                 && method.getParameterTypes().length == 0){
            return true;
        }
        return false;
    }

    static boolean isSetter(Method method){
        if(Modifier.isPublic(method.getModifiers() ) && (method.getReturnType().equals(void.class))
                && method.getName().matches("^set[A-z].*")
                && method.getParameterTypes().length == 1){
            return true;
        }
        return false;
    }
}
