package edu.escuelaing.arep.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MicroServer {

    public static Map<String, Method> services = new HashMap();

    public static void main(String[] args) throws Exception {
        loadComponents(args);
        System.out.println(simulateRequests("/greeting"));
        System.out.println(simulateRequests("/pi"));
        System.out.println(simulateRequests("/e"));
    }

    /**
     * Loads the services reading the annotations from the service class
     * 
     * @param args
     * @throws ClassNotFoundException
     */
    public static void loadComponents(String[] args) throws Exception {
        for (int i = 0; i < args.length; i++) {
            Class c = Class.forName(args[i]);

            String[] arguments = Arrays.copyOfRange(args, 1, args.length);

            if (!c.isAnnotationPresent(RestController.class)) {
                System.exit(0);
            }

            for (Method m : c.getDeclaredMethods()) {
                if (m.isAnnotationPresent(GetMapping.class)) {
                    // a=anotacion jaja
                    GetMapping a = m.getAnnotation(GetMapping.class);
                    services.put(a.value(), m);
                }
            }
        }

    }

    public static String simulateRequests(String route) throws Exception {
        Method m = services.get(route);
        String response = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: application/json\r\n"
                + "\r\n"
                + "{\"name\": " + "\"" + m.invoke(null, "pedro") + "\"}";
        return response;
    }
}
