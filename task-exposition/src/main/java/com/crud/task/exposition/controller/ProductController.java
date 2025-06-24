package com.crud.task.exposition.controller;

import com.crud.task.domain.pojo.Product;
import com.crud.task.exposition.in.ProductIn;
import com.crud.task.exposition.mapper.product.IProductInMapper;
import com.crud.task.exposition.mapper.product.IProductOutMapper;
import com.crud.task.exposition.out.ProductOut;
import com.crud.task.service.services.product.IProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {

    private final IProductService IProductService;
    private final IProductInMapper mapperIn;
    private final IProductOutMapper mapperOut;

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        return IProductService.findById(id);
    }

    @PostMapping()
    public void create(@RequestBody @Valid ProductIn productIn) {
        Product product = mapperIn.inOutToDto(productIn);
        IProductService.create(product);
    }

    @PutMapping("/{id}/update")
    public void update(@PathVariable Long id, @RequestBody @Valid ProductIn productIn) {
        Product product = mapperIn.inOutToDto(productIn);
        IProductService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void update(@PathVariable Long id) {
        IProductService.delete(id);
    }

    @GetMapping()
    public Page<ProductOut> findAllPaginated(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        Page<Product> products = IProductService.findAllPaginated(page, size);
        return mapperOut.mapPage(products);
    }
}
