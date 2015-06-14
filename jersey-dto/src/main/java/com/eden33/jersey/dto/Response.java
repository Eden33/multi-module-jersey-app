package com.eden33.jersey.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author edi
 */
@XmlRootElement
public class Response {
    
    String bar;

    @XmlElement
    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }
}
