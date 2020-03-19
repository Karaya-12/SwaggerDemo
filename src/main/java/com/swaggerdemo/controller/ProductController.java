package com.swaggerdemo.controller;

import com.swaggerdemo.domain.Product;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")

// @Api Annotation to add basic Info to designated Method
@Api(value = "ProductController", tags = {"Product Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "Product Controller", description = "Product Management Simple Controller")
})
public class ProductController {

    List<Product> products = Arrays.asList(
            new Product("1", "AMD Ryzen™ 7 3800X", "AMD Ryzen™ 7 3800X | Ryzen™ Desktop Processors | AMD", 349.99, 250),
            new Product("2", "AORUS GeForce RTX™ 2080 Ti", " Gigabyte AORUS GeForce RTX 2080 Ti Xtreme 11G Graphics Card", 1148.15, 150),
            new Product("3", "WD SN750 SSD", "WD_Black SN750 500GB NVMe Internal Gaming SSD", 67.58, 120),
            new Product("4", "Dell XPS 13 7390 Laptop", "Dell XPS7390-7138SLV-PUS", 1459.90, 2000)
    );

    @ApiOperation(value = "Return designated Product by Product ID", response = Product.class,
            tags = "getProdcut")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved designated Product Info"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "404 Not Found")
    })
    @ApiParam(value = "Product unique ID", required = true)
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        return products.stream()
                .filter(item -> item.getId().equalsIgnoreCase(id))
                .collect(Collectors.toList()).get(0);
    }

    // Provide the Information about designated Method & Response
    @ApiOperation(value = "List of all Products", response = ArrayList.class, tags = "getProducts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved Products List"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "404 Not Found")
    })
    @GetMapping
    public List<Product> getProducts() {
        return products;
    }
}
