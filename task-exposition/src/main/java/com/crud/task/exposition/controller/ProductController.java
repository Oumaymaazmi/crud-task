package com.crud.task.exposition.controller;

import com.crud.task.domain.pojo.Product;
import com.crud.task.exposition.in.ProductIn;
import com.crud.task.exposition.mapper.IProductInMapper;
import com.crud.task.exposition.mapper.IProductOutMapper;
import com.crud.task.exposition.out.ProductOut;
import com.crud.task.service.services.product.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final IProductInMapper mapperIn;
    private final IProductOutMapper mapperOut;

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid ProductIn productIn) {
        Product product = mapperIn.inOutToDto(productIn);
        productService.create(product);
    }

    @PutMapping("/{id}/update")
    public void update(@PathVariable Long id, @RequestBody @Valid ProductIn productIn) {
        Product product = mapperIn.inOutToDto(productIn);
        productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Long id) {
        productService.delete(id);
    }

    @GetMapping()
    public Page<ProductOut> findAllPaginated(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        Page<Product> products = productService.findAllPaginated(page, size);
        return mapperOut.mapPage(products);
    }
}
