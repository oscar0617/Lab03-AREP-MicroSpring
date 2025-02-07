package edu.escuelaing.arep.clasehoy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;

public class InvokeMembers{
    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);

            Class[] argTypes = new Class[] { Member[].class, String.class };

            Method m = c.getDeclaredMethod("printMembers", argTypes);
            
            Class otraclase = LinkedList.class;

            System.out.format("invoking %s.printMembers()%n", m.getName());
            m.invoke(null,  otraclase.getDeclaredFields(), "Fields");
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}
