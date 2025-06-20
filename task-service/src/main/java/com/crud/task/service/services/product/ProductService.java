package com.crud.task.service.services.product;

import com.crud.task.domain.exception.FunctionalException;
import com.crud.task.domain.pojo.Product;
import com.crud.task.domain.port.IProductRepository;
import com.crud.task.service.config.MessageResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private static final String ERROR_PRODUt_NOT_FOUND = "error.product.notFound";
    private final IProductRepository productRepository;
    private final MessageResolver messageResolver;

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new FunctionalException(messageResolver.get(ERROR_PRODUt_NOT_FOUND, id)));
    }
}
