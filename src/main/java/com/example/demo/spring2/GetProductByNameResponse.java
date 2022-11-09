package com.example.demo.spring2;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "product"
})
@XmlRootElement(name = "getStudentByNameResponse")
public class GetProductByNameResponse {

    @XmlElement(required = true)
    protected ProductDTO productDTO;



    public void setProductDTO(ProductDTO value) {
        this.productDTO = value;
    }

}
