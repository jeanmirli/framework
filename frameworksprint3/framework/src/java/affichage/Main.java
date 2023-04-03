/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mirlin
 */
public class Main {
    
    public static List<Class<?>> findClasses(String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        for (java.net.URL resource : java.util.Collections.list(classLoader.getResources(path))) {
            for (String file : new java.io.File(resource.getFile()).list()) {
                if (file.endsWith(".class")) {
                    String className = packageName + '.' + file.substring(0, file.length() - 6);
                    classes.add(Class.forName(className));
                }
            }
        }

        return classes;
    }
    
    public static void main(String[] args) {
        try {
            List<Class<?>> tousLesClasses = findClasses("etu002057.classes");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
