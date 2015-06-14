package com.eden33.jersey.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author edi
 */
@XmlRootElement
public class Request {
    
    String foo;

    @XmlElement
    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    } 
}
