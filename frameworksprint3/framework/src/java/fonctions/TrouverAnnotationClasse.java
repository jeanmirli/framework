/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fonctions;

import etu002057.annotation.Annotation.MonAnnotation;
import etu002057.framework.Mapping;
import etu002057.framework.servlet.FrontServlet;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
/**
 *
 * @author mirlin
 */
public class TrouverAnnotationClasse {
    
    //FrontServlet frontservlet = new FrontServlet(); 
    /*mijery ny packages rehetra ao amin'ilay projet*/
    public List<String> findPackages(String path) throws Exception {
        List<String> listePackages = new ArrayList<>();
        File folder = new File(path);
        if(folder.exists()) {
            File packages[] = folder.listFiles();
            if (packages != null) {
                for (File pack : packages) {
                    if (!pack.getName().contains(".")) {
                        listePackages.add(pack.getName());
                    }
                }
            }
            
        }
        
        return listePackages;
    }
    
    /*maka ny classes rehetra isaky ny packages*/
    public List<Class<?>> findClasses(String packageName) throws Exception {
    List<Class<?>> classes = new ArrayList<>();
    File directory = new File(Thread.currentThread().getContextClassLoader().getResource(packageName).getFile());
    File folder = new File(directory.getPath());
    
    if (folder.isDirectory() && folder.exists()) {
        // Obtenez tous les fichiers du répertoire
        File[] files = directory.listFiles();
        // Parcourez tous les fichiers
        for (File file : files) {
            if (file.isDirectory()) {
                //classes.addAll(findClasses(packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                // Obtenir le nom de la classe en enlevant l'extension .class
                String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                Class<?> clazz = Class.forName(className);
                classes.add(clazz);
            }
        }
    }
    
    return classes;
}

 
    
    public HashMap<String, Mapping> findAnnotations(List<Class<?>> classes) {
        HashMap<String, Mapping> hashMap = new HashMap<>();
        Mapping mapping = null;
        for (Class<?> clazz : classes) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                Annotation[] annotations = method.getDeclaredAnnotations();
                if (annotations.length > 0 && annotations[0] instanceof MonAnnotation) {
                    MonAnnotation monAnnotation = (MonAnnotation) annotations[0];
                    mapping = new Mapping(clazz.getSimpleName(), method.getName());
                    hashMap.put(monAnnotation.url(), mapping);
                }
            }
        }
        return hashMap;
    }

    /*public TrouverAnnotationClasse(FrontServlet frontservlet) {
        this.frontservlet = frontservlet;
    }*/

}
