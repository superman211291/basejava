package com.urise.webapp;

/**
 * Created by superman on 11.10.17.
 */
import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        Class cl = r.getClass();
        Method method = cl.getMethod("toString");
        String s =(String) method.invoke(r);
        System.out.println(s);

        // TODO : invoke r.toString via reflection
        //System.out.println(r);
    }
}
