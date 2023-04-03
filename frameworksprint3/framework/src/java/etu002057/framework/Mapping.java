/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu002057.framework;

/**
 *
 * @author mirlin
 */
public class Mapping {
    
    String className;
    String method;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClassName() {
        return className;
    }

    public String getMethod() {
        return method;
    }

    public Mapping(String className, String method) {
        this.className = className;
        this.method = method;
    }
    
    
}
