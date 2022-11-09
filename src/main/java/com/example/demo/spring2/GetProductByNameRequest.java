package com.example.demo.spring2;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name"
})
@XmlRootElement(name = "getProductByNameRequest")
public class GetProductByNameRequest {

    @XmlElement(required = true)
    protected String name;


    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

}

