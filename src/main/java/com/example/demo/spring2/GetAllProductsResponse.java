package com.example.demo.spring2;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "products"
})
@XmlRootElement(name = "getAllProductsResponse")

public class GetAllProductsResponse {

        @XmlElement(required = true)
        protected List<ProductDTO> products;


        public List<ProductDTO> getProducts() {
            if (products == null) {
                products = new ArrayList<ProductDTO>();
            }
            return this.products;
        }

    }

}
