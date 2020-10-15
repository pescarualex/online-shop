package org.fasttrackit.onlineshop.integrationTest.product;

import org.fasttrackit.onlineshop.service.ProductService;
import org.fasttrackit.onlineshop.integrationTest.steps.ProductTestSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTestSteps productTestSteps;

    @Test
    public void createProduct_whenValidRequest_thanReturnCreatedProduct() {
        productTestSteps.createProduct();
    }

    // todo: add other scenario

}
